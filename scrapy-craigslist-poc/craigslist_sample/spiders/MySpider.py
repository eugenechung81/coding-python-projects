# from scrapy.spider import BaseSpider
# from scrapy.selector import HtmlXPathSelector
# from craigslist_sample.items import CraigslistSampleItem
#
# class MySpider(BaseSpider):
#     name = "craig"
#     allowed_domains = ["craigslist.org"]
#     # start_urls = ["http://sfbay.craigslist.org/npo/"]
#     start_urls = ["http://newyork.craigslist.org/fua/"]
#
#
#     def parse(self, response):
#         hxs = HtmlXPathSelector(response)
#         titles = hxs.select("//span[@class='pl']")
#         for titles in titles:
#             title = titles.select("a/text()").extract()
#             link = titles.select("a/@href").extract()
#             print title, link

from scrapy.spider import BaseSpider
from scrapy.selector import HtmlXPathSelector
from craigslist_sample.items import CraigslistSampleItem

class MySpider(BaseSpider):
  name = "craig"
  allowed_domains = ["craigslist.org"]
  #start_urls = ["http://sfbay.craigslist.org/npo/"]
  start_urls = ["http://newyork.craigslist.org/fua/"]

  def parse(self, response):
      hxs = HtmlXPathSelector(response)
      titles = hxs.select("//span[@class='pl']")
      items = []
      for titles in titles:
          item = CraigslistSampleItem()
          item ["title"] = titles.select("a/text()").extract()
          item ["link"] = titles.select("a/@href").extract()
          items.append(item)
      return items