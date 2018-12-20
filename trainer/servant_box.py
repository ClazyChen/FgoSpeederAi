# -*- coding:utf-8 -*-

from servant import Servant
from tools import AttributeDisplay


class ServantBox(AttributeDisplay):
    def __init__(self):
        self.servant_list = []

    def read_from_file(self, file_name):
        # read servant information from file
        last_servant = None
        with open(file_name, 'r', encoding='utf-8') as f:
            for line in f.readlines():
                line_split = line.strip().split(' ')
                if line_split[0] == 'NEW':
                    if line_split[1] == 'Servant':
                        if last_servant is not None:
                            self.servant_list.append(last_servant)
                        last_servant = Servant()
                else:
                    last_servant.set_attribute_by_line(line_split)
        # last servant
        if last_servant is not None:
            self.servant_list.append(last_servant)
        return self





