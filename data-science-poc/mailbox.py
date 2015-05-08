'''
Created on May 29, 2014

@author: Eugene
'''

#import pandas as pd
#print('test')
from _hashlib import new

# initialize
import sys
sys.path = ['C:\\opt\\pycharm-3.4\\helpers\\pydev', 'C:\\Windows\\system32\\python34.zip', 'C:\\Python34\\DLLs', 'C:\\Python34\\lib', 'C:\\Python34', 'C:\\Python34\\lib\\site-packages', 'C:\\projects-python\\TestPython']

# create truncate mbox
import mailbox
import csv
dest = mailbox.mbox('d:/tmp/gmail-short.mbox')
dest.lock()
c = 0
for m in mailbox.mbox('d:/tmp/gmail.mbox'):
    c = c+1
    dest.add(m)
    if(c > 200):
        break
dest.flush()
dest.unlock()

# running pandas
import pandas as pd
import numpy as np

# Increase column width
pd.set_option('display.height', 1000)
pd.set_option('display.max_rows', 500)
pd.set_option('display.max_columns', 500)
pd.set_option('display.width', 1000)


#df = pd.DataFrame(np.random.randn(6,4),index=dates,columns=list('ABCD'))
#df.to_csv('test.csv')
df = pd.DataFrame(columns=['a','b','c','d'])
df
df.append('t2','t3','t4')


df = pd.read_csv("test.csv")


res = pd.DataFrame(columns=('lib', 'qty1', 'qty2'))
row = pd.DataFrame([dict(lib='hello', qty1=4.0, qty2=100.0), ])
res = res.append(row, ignore_index=True)


import matplotlib.pyplot as plt

ts = pd.Series(1, index=df['Date'])
ts
ts = ts.sort_index()
ts = ts.cumsum()

ts.plot()
plt.show()


s2 = ts.groupby([lambda x: x.year, lambda x: x.month, lambda x: x.day]).sum()
s2


table = []
for m in mailbox.mbox('d:/tmp/gmail-short.mbox'):
    line = [m['Date'], m['from'], m['subject']]
    print(line)
    table.append(line)

df = pd.DataFrame(table, columns=['Date','From','Subject'])


rng = pd.date_range('3/6/2012 00:00', periods=5, freq='D')
rng


pd.to_datetime('Wed, 23 Apr 2014 10:12:46 -0400')

df = pd.DataFrame(table, columns=['Date','From','Subject'])
df['Date'] = pd.to_datetime(df['Date'])

df.sort_index()

df.index = df['Date']

t = pd.pivot_table(df, values='count', index='Date', columns=['From'], aggfunc=np.sum)
t2 = pd.DataFrame(t, columns=['"Chung, Eugene" <eugene.chung@mezocliq.com>'])
t2.asfreq('D')
t3 = t2.resample('5D', how='sum')
t3

# t3 = t3.dropna()
# t3
t3.plot(kind='bar')
plt.show()


print('Done')


