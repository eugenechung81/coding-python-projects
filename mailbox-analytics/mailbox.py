__author__ = 'Eugene'
'''
Created on May 29, 2014

@author: Eugene
'''

#import pandas as pd
#print('test')
from _hashlib import new

import sys
sys.path = ['C:\\opt\\pycharm-3.4\\helpers\\pydev', 'C:\\Windows\\system32\\python34.zip', 'C:\\Python34\\DLLs', 'C:\\Python34\\lib', 'C:\\Python34', 'C:\\Python34\\lib\\site-packages', 'C:\\projects-python\\TestPython']

import mailbox
import csv

def exportCSV():
    mbox = mailbox.mbox('d:/tmp/gmail.mbox')
    with open('test.csv', 'w', newline='\n') as csv_file:
        writer = csv.writer(csv_file, delimiter=',' ,quotechar="'", quoting=csv.QUOTE_ALL)
        c = 0
        for m in mbox:
            #print(m['from'] + ", " + m['to'] + ", " + m['subject'])
            line = [m['Date'], m['from'], m['subject']]
            writer.writerow(line)
            c=c+1
            if(c > 200):
                #csv_file.close()
                #return
                break
            print('.', end='',flush=True)

# READING
# with open('test.csv', 'r', newline='\n') as csvfile:
#     spamreader = csv.reader(csvfile, delimiter=',', quotechar="'", quoting=csv.QUOTE_ALL)
#     for row in spamreader:
#         print(', '.join(row))

#exportCSV()

import pandas as pd
import numpy as np

#df = pd.DataFrame(np.random.randn(6,4),index=dates,columns=list('ABCD'))
#df.to_csv('test.csv')
df = pd.DataFrame(columns=['a','b','c','d'])
df
df.append('t2','t3','t4')


df = pd.read_csv("test.csv")


res = pd.DataFrame(columns=('lib', 'qty1', 'qty2'))
row = pd.DataFrame([dict(lib='hello', qty1=4.0, qty2=100.0), ])
res = res.append(row, ignore_index=True)

print('Done')

