from random import*
import math

def merge_sort(list):
    if list.len() == 1:
        return list
    int:len = list.len()
    first = []
    second = []
    for x in range(math.floor(len/2)):
        first[x] = list[x]
    for x in range(math.floor(len/2) + 1, list.len() + 1):
        second[x] = list[x]
    first = merge_sort(first)
    second = merge_sort(second)
    output = []
    a = 0
    b = 0
    while a < first.len() and b < second.len():
        if first[a] <= second[b]:
            output.append(first[a])
            a + 1
        elif first[a] > second[b]:
            output.append(second[b])
            b + 1

array = []
for x in range(100):
    array.append(random.randint(0, 100))
merge_sort(list)
