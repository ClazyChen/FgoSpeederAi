# -*- coding:utf-8 -*-

from servant_box import ServantBox
from stage import Stage


servant_box = ServantBox().read_from_file('../static/servants.txt')
stage = Stage().read_from_file('../static/enemies.txt')

print(servant_box)
print(stage)
