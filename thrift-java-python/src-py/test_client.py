import sys
import glob
import json

sys.path.append('gen-py')
sys.path.insert(0, glob.glob('/opt/thrift-0.9.1/lib/py/build/lib.*')[0])

from pprint import pprint
from tutorial import Calculator
from tutorial.ttypes import *
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from prettytable import PrettyTable

class thrift_utils:
    transport = TSocket.TSocket('192.168.56.1', 9090)
    transport = TTransport.TBufferedTransport(transport)
    protocol = TBinaryProtocol.TBinaryProtocol(transport)
    transport.open()

client = Calculator.Client(thrift_utils.protocol)

def print_rpt_grp(row, grp_name):
    rpt_vars = get_repeat_vars_map(row)
    maps_of_maps = rpt_vars.get(grp_name)
    headers = get_unique_headers(rpt_vars,grp_name)
    print_maps_of_maps(maps_of_maps, headers)

def convert_key_to_int(headers_map):
    new_map = {}
    for k,v in headers_map.iteritems():
        new_map[int(k)] = v
    return new_map

def print_maps_of_maps(maps_of_maps, headers):
    headers_map = {}
    new_headers = []
    for i in xrange(len(headers)):
        new_headers.append(str(i))
        headers_map[str(i)] = headers[i]
    new_headers.insert(0, 'key')
    pprint(convert_key_to_int(headers_map))

    x = PrettyTable(new_headers)
    for h in new_headers:
        x.align[h] = 'l'
    x.padding_width = 1
    for k,v in maps_of_maps.iteritems():
        row_list = []
        for h_num in new_headers:
            h = ''
            if(h_num == 'key'):
                h = h_num
            else:
                h = headers_map[h_num]
            # print h
            if(h == 'key'):
                row_list.append(k)
            elif(h in v):
                row_list.append(v[h])
            else:
                row_list.append('')
        x.add_row(row_list)
    # x.sortby = new_headers[4]
    # x.sortby = new_headers[0]
    x.sortby = new_headers[1]
    print x

def json_print(row):
    print json.dumps(row.__dict__, sort_keys=True, indent=4)

def get_single_vars_map(row):
    single_vars = {}
    for group in row.groups.values():
        if(len(group.values()) == 1):
            for vars in group.values():
                single_vars.update(vars)
    return single_vars

def get_repeat_vars_map(row):
    repeat_vars = {}
    # for group in row.groups.values():
    for key, group in row.groups.iteritems():
        if(len(group.values()) > 1):
            repeat_vars[key] = group
    return repeat_vars

def get_unique_headers_from_maps(rpt):
    unique_headers = set()
    for vars in rpt.values():
        unique_headers.update(set(vars.keys()))
    return list(unique_headers)

def get_unique_headers(rpt_vars, grp_name):
    rpt = rpt_vars.get(grp_name)
    unique_headers = set()
    for vars in rpt.values():
        unique_headers.update(set(vars.keys()))
    return list(unique_headers)

rows_map = {}

def print_tbl(tbl):
    global rows_map
    rows = client.getRows(tbl)
    rows_map = {}
    for r in rows:
        k = r.rowKey
        v = get_single_vars_map(r)
        rows_map[k] = v
    # pprint(maps_of_maps)
    # headers = get_unique_headers_from_maps(maps_of_maps)
    headers = []
    if(tbl == 'CANDIDATE'):
        headers = [tbl + '.REFERENCES.CAPTION.DISPLAY','CANDIDATE.AUTHORIZATION.LOGIN.USERNAME']
    else:
        headers = [tbl + '.REFERENCES.CAPTION.DISPLAY']
    print_maps_of_maps(rows_map, headers)

def print_row(tbl, key):
    row = client.getRow(tbl,key)
    pprint(row.__dict__)
    pprint(get_single_vars_map(row))
    for k in get_repeat_vars_map(row).iterkeys():
        print_rpt_grp(row,k)

#############################################

# get data
print_tbl('SCREENS')
print_tbl('CANDIDATE')

print_tbl('SECURITIES')
# pprint(rows_map)

print_row('CANDIDATE','37f69030-1683-11e4-a3f9-002590c0b6c6')


rows = client.getRows('CANDIDATE')
row = client.getRow('CANDIDATE','e5af7810-23f1-11e4-a305-002590c0b6c6')


rows = client.getRows('SECURITIES')

rows = client.getRows('SCREENS')
row = rows[0]

x = [i.__dict__ for i in rows]
print json.dumps(x, sort_keys=True, indent=4)

# print_row(row)
# print_rpt(row)
# print_sgl(row)

pprint(row.__dict__)
pprint(get_single_vars_map(row))
pprint(get_repeat_vars_map(row))
print_rpt_grp(row,'AFFILIATE')
print_rpt_grp(row,'ATTACHMENT')


# row print info

# transport.close()

###############

# construct json tree for links

class TreeNode(dict):
    def __init__(self, name, children=None):
        # super().__init__()
        self.__dict__ = self
        self.name = name
        # self.children = [] if not children else children
        self.children = None

# class Node(object):
#     def __init__(self, name):
#         self.name = name
#         self.children = []


# row = client.getRow('CANDIDATE','5478c6c0-1281-11e4-a18e-843a4b12e938')

# pprint(row.groups['AFFILIATE'])
# root.test = 'test'

def generate_node(tbl, parent_node, row, curr_depth):
    if(curr_depth > 5):
        return
    if('AFFILIATE' not in row.groups.keys()):
        return
    for aff_map in row.groups['AFFILIATE'].values():
        # print aff_map
        varId = tbl + '.RELATIONSHIPS.AFFILIATE.CAPTION'
        if(varId not in aff_map.keys()):
            print varId
            print aff_map.keys()
            continue
        aff_caption = aff_map[tbl + '.RELATIONSHIPS.AFFILIATE.CAPTION']
        aff_tbl = aff_map[tbl + '.RELATIONSHIPS.AFFILIATE.PARTY']
        aff_dbid = aff_map[tbl + '.RELATIONSHIPS.AFFILIATE.DBID']

        name = aff_map[tbl + '.RELATIONSHIPS.AFFILIATE.ROLE']
        name = name + ' (' + aff_map[tbl + '.RELATIONSHIPS.AFFILIATE.PARTY'] + ')'
        name = name + ' ' + aff_caption

        aff_row = client.getRow(aff_tbl, aff_dbid)
        node = TreeNode(name)
        if(parent_node.children == None):
            parent_node.children = []
        parent_node.children.append(node)
        curr_depth = curr_depth + 1
        generate_node(aff_tbl,node,aff_row, curr_depth)

# print_tbl('ACCOUNT')

def generate_tree(tbl,key):
    row = client.getRow(tbl,key)
    root = TreeNode(tbl)
    generate_node(tbl, root, row, 0)
    json_print(root)


# node = TreeNode('TEST')
# node1 = TreeNode('TEST2')
# root.children.append(node)
# root.children.append(node1)
# pprint(root.__dict__)

rows = client.getRows('TRADE')
row = rows[0]
# pprint(row.__dict__)
# 'd0df85b0-38a0-11e4-8d15-002590c0b6c6'

generate_tree('TRADE','5409c9d0-38f8-11e4-9034-002590c0b6c6')