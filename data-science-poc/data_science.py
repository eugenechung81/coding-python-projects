__author__ = 'Eugene'
things = ["First Name", "Last Name"]

def snakify(txt):
    "return string in snake_case"
    return txt.replace(" ","_").lower()

print([snakify(thing) for thing in things])

snakify( "My Name is Greg" )

from IPython.display import Image
Image("http://ipython.org/_static/IPy_header.png")

import numpy as np

def list_times(alist, scalar):
    for i, val in enumerate(alist):
        alist[i] = val * scalar
    return alist

arr = np.arange(1e7)
l   = arr.tolist()


import pylab as pl
import matplotlib.pyplot as plt
d = randn(100) * 100.
m = d.mean()
s = d.std()
m_y = 1.5

fig = figure(figsize=(12,6))
ax = subplot(111)
ax.hist(d, 15)
ax.plot(m, m_y, "ko")
ax.plot([m - s, m + s], [m_y] * 2, "k--");



import pandas as pd
df = pd.read_csv("./data/credit-training.csv")
df.head()


pd.value_counts(df.NumberOfDependents)
df.NumberOfDependents.value_counts()


