# -*- coding:utf-8 -*-
# written by Clazy Chen


# ----------- ONLY FOR DEBUG -----------
# This class is used to display all attributes in the class
class AttributeDisplay(object):
    @staticmethod
    def __tabbed_output(object_instance, tab_number):
        if isinstance(object_instance, list):
            if len(object_instance) == 0:
                return '[]'
            return "[\n{}\n{}]".format(',\n'.join([
                ' ' * (tab_number + 2) + AttributeDisplay.__tabbed_output(item, tab_number + 2)
                for item in object_instance
            ]), ' ' * tab_number)
        if isinstance(object_instance, dict):
            if len(object_instance) == 0:
                return '{}'
            return "{{\n{}\n{}}}".format(',\n'.join([
                ' ' * (tab_number + 2) + AttributeDisplay.__tabbed_output(item, tab_number + 2)
                + ' : ' + AttributeDisplay.__tabbed_output(object_instance[item], tab_number + 4)
                for item in object_instance
            ]), ' ' * tab_number)
        if isinstance(object_instance, AttributeDisplay):
            return object_instance.__tabbed_str(tab_number)
        return str(object_instance)

    def __gather_attributes(self, tab_number):
        return '\n'.join([
            '%s{} := {}'.format(attr, self.__tabbed_output(getattr(self, attr), tab_number + 4))
            % (' ' * (tab_number + 2), )
            for attr in self.__dict__.keys()
        ])

    def __tabbed_str(self, tab_number):
        return '< {} :\n{}\n{}>'.format(self.__class__.__name__,
                                        self.__gather_attributes(tab_number), ' ' * tab_number)

    def __str__(self):
        return self.__tabbed_output(self, 0)
