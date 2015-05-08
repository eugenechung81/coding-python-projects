
import pandas

print('test')

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

df = pd.DataFrame({'A' : ['one', 'one', 'two', 'three'] * 3,
                    'B' : ['A', 'B', 'C'] * 4,
                    'C' : ['foo', 'foo', 'foo', 'bar', 'bar', 'bar'] * 2,
                    'D' : np.random.randn(12),
                    'E' : np.random.randn(12)})



s = pd.Series([1,3,5,np.nan,6,8])


# print('test')

