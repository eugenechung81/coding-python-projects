
__author__ = 'eugene'

from scrapy.item import BaseItem, Field, Item
from scrapy.spider import BaseSpider
from scrapy.selector import HtmlXPathSelector

from scrapy.contrib.loader import ItemLoader


class FlexibleItem(Item):
    #pass
    def __setitem__(self, key, value):
        if key not in self.fields:
            self.fields[key] = Field()
        self._values[key] = value


def create_urls(symbols):
    urls = []
    for s in symbols:
        urls.append('https://finance.yahoo.com/q/ae?s=' + s)
    return urls

class YahooFinance(BaseSpider):
    name = "yahoo"
    allowed_domains = ["finance.yahoo.com"]
    # start_urls = ["https://finance.yahoo.com/q/ae?s=JCP"]
    # ["https://finance.yahoo.com/q/ae?s=JCP", "https://finance.yahoo.com/q/ae?s=MSFT"]
    start_urls = create_urls(['MSFT','JCP','AAPL','INTC','COH','YELP','MCD'])

    def parse(self, response):
        hxs = HtmlXPathSelector(response)

        symbol = response.url[33:]
        tables = hxs.select("//table[@id='yfncsumtab']//table//table")
        items = []
        for tbl in tables:
            rows = tbl.xpath('.//tr')
            section = rows[0].select('.//th[1]//text()').extract()
            headers = rows[0].select('.//th')

            for i in xrange(1,len(rows)):
                r = rows[i]
                r_datas = r.select('.//td//text()').extract()
                for j in xrange(1,len(r_datas)):
                    r_d = r_datas[j]
                    header = ' '.join(headers[j].select('.//text()').extract())

                    item = FlexibleItem()
                    # loader = ItemLoader(item)
                    item['symbol']= symbol
                    item['section']= section
                    item['header']= header
                    item[r_datas[0]]=r_d
                    # print loader.load_item()
                    items.append(item)
        return (items)
