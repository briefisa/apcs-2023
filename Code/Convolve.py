import math, cmath, random, time
import numpy as np

start = time.time()

def discrete_conv(a: list, b: list) -> list:
    output = []
    for i in range(0, len(a) + len(b) - 1):
        num = 0
        j = 0
        while j < len(b) and (i - j) >= 0:
            if (i - j) < len(a):
                num += a[i - j]*b[j]
            j += 1
        output.append(num)
    return output

#Credit: Reducible (https://youtu.be/h7apO7q16V0)
def recursive_fft(P: list) -> list:
    n = len(P)
    if n == 1:
        return P
    w = complex(math.cos((2*math.pi)/n), math.sin((2*math.pi)/n))
    Pe, Po = P[::2], P[1::2]
    ye, yo = fft(Pe), fft(Po)
    y = [0]*n
    for j in range(n//2):
        y[j] = ye[j] + (pow(w, j))*yo[j]
        y[j + n//2] = ye[j] - (pow(w, j))*yo[j]
    return y

#Credit: Reducible (https://youtu.be/h7apO7q16V0)
def recursive_ifft(P):
    n = len(P)
    if n == 1:
        return P
    w = (1/n)*complex(math.cos((2*math.pi)/n), math.sin((2*math.pi)/n))
    Pe, Po = P[::2], P[1::2]
    ye, yo = ifft(Pe), ifft(Po)
    y = [0]*n
    for j in range(n//2):
        y[j] = ye[j] + (pow(w, j))*yo[j]
        y[j + n//2] = ye[j] - (pow(w, j))*yo[j]
    return y
    
def iterative_fft(P: list) -> list:
    N, a = len(P), 1
    sets = [[0] for _ in range(N)]
    for i in range(N):
        sets[i][0] = P[i]
    while N > 1:
        n = 2**a
        for i in range(0, N//2):
            w = complex(math.cos((2*math.pi)/n), math.sin((2*math.pi)/n))
            temp = [0]*n
            for j in range(n//2):
                temp[j] = sets[i][j] + pow(w, j)*sets[i + N//2][j]
                temp[j + n//2] = sets[i][j] - (pow(w, j)*sets[i + N//2][j])
            sets[i] = temp
        for _ in range(N//2, N):
            sets.pop(N//2)
        a += 1
        N = len(sets)
    return sets[0]

def iterative_ifft(P: list) -> list:
    N, a = len(P), 1
    sets = [[0] for _ in range(N)]
    for i in range(N):
        sets[i][0] = P[i]
    while N > 1:
        n = 2**a
        for i in range(0, N//2):
            w = 1/(complex(math.cos((2*math.pi)/n), math.sin((2*math.pi)/n)))
            temp = [0]*n
            for j in range(n//2):
                temp[j] = sets[i][j] + pow(w, j)*sets[i + N//2][j]
                temp[j + n//2] = sets[i][j] - (pow(w, j)*sets[i + N//2][j])
            sets[i] = temp
        for _ in range(N//2, N):
            sets.pop(N//2)
        a += 1
        N = len(sets)
    length = len(sets[0])
    for a in range(length):
        sets[0][a] = sets[0][a]/length
    return sets[0]

def fft_conv(A, B):
    None

#def func1(x: float):
#    return x

#def func2(x: float):
#    return 0
vals = []
for _ in range(2**15):
    vals.append(random.randint(0,100))
valsF = iterative_fft(vals)
control = np.fft(vals)

end = time.time()

for a in range(25):
    print(vals[a], ' ', valsF[a])
    print (valsF[a], ' ', control[a])
#print(iterative_fft(a))
print("Done in ", (end - start) * 10**3, " ms")




