# -*- coding:utf-8 -*-

from enemy import Enemy
from tools import AttributeDisplay


class Stage(AttributeDisplay):
    def __init__(self):
        self.phase_list = []

    def read_from_file(self, file_name):
        last_phase = []
        last_enemy = None
        with open(file_name, 'r', encoding='utf-8') as f:
            for line in f.readlines():
                line_split = line.strip().split(' ')
                if line_split[0] == 'NEW':
                    if line_split[1] == 'Enemy':
                        if last_enemy is not None:
                            last_phase.append(last_enemy)
                        last_enemy = Enemy()
                    elif line_split[1] == 'Phase':
                        if last_enemy is not None:
                            last_phase.append(last_enemy)
                            last_enemy = None
                        if len(last_phase) > 0:
                            self.phase_list.append(last_phase)
                        last_phase = []
                else:
                    last_enemy.set_attribute_by_line(line_split)
        if last_enemy is not None:
            last_phase.append(last_enemy)
        if len(last_phase) > 0:
            self.phase_list.append(last_phase)
        return self
