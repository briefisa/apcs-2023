import random, resource, math, sys

resource.setrlimit(resource.RLIMIT_STACK, (2**29, -1))
sys.setrecursionlimit(10**6)
                      
def merge_sort(wordList):
    if len(wordList) <= 1:
        return wordList
    length = len(wordList)
    first = []
    second = []
    for x in range(length//2):
        first.append(wordList[x])
    for x in range(length//2, length):
        second.append(wordList[x])
    first = merge_sort(first)
    second = merge_sort(second)
    output = []
    a = 0
    b = 0
    while a < len(first) and b < len(second):
        if first[a] <= second[b]:
            output.append(first[a])
            a += 1
        elif first[a] > second[b]:
            output.append(second[b])
            b += 1
    while a < len(first):
        output.append(first[a])
        a += 1
    while b < len(second):
        output.append(second[b])
        b += 1
    return output

array = []
for x in range(100):
    array.append(random.randint(0, 100))
array = merge_sort(array)
for a in array:
    print(a, end = ' ')