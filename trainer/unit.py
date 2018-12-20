# -*- coding:utf-8 -*-

from tools import AttributeDisplay
unit_id = 0


class Unit(AttributeDisplay):
    def __init__(self):
        global unit_id
        self.id = unit_id
        unit_id += 1
        self.name = ''
        self.atk = 0
        self.hp = 0
        self.class_ = ''

    @staticmethod
    def max_id():
        return servant_id

    def class_coefficient(self):
        class_coefficient_dict = {
            'S': 1.0, 'A': 0.95, 'L': 1.05,
            'U': 1.1, 'B': 1.1, 'H': 1.0
        }
        if self.class_ in class_coefficient_dict:
            return class_coefficient_dict[self.class_]
        return 1.0

    def class_superiority_coefficient(self, target):
        # default: 1.0, this dict defines all non-1.0 values
        class_superiority_coefficient_dict = {
            'SA': 0.5, 'AS': 2.0,
            'SL': 2.0, 'LS': 0.5,
            'AL': 0.5, 'LA': 2.0,
            'SU': 0.5, 'AU': 0.5,
            'LU': 0.5,
            'BS': 1.5, 'BA': 1.5,
            'BL': 1.5,
            'BU': 1.5
        }
        if (self.class_+ target.class_) in class_superiority_coefficient_dict.keys():
            return class_superiority_coefficient_dict[self.class_+ target.class_]
        return 1.0

    def set_attribute_by_line(self, operation_line):
        # do some operation according to the line
        try:
            if operation_line[0] == 'NAME':
                self.name = operation_line[1]
            elif operation_line[0] == 'ATK':
                self.atk = int(operation_line[1])
            elif operation_line[0] == 'HP':
                self.hp = int(operation_line[1])
            elif operation_line[0] == 'CLASS':
                self.class_ = operation_line[1]
        except ValueError:
            print('Unit set attribute error: \n\t Operation line = %s' % str(operation_line))
        finally:
            pass
