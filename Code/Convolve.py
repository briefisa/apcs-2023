import math, cmath

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
def fft(P: list) -> list:
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

def iterative_fft(P: list) -> list:
    N, a = len(P), 1
    sets = [[0]]*N
    for i in range(N):
        sets[i][0] = (P[i])
    while N > 1:
        N = len(sets)
        n = 2**a
        for i in range(0, N//2):
            w = complex(math.cos((2*math.pi)/n), math.sin((2*math.pi)/n))
            for j in range(n//2):
                temp = [0]*n
                temp[j] = sets[i][j] + pow(w, j)*sets[i + 1][j]
                temp[j + n//2] = sets[i][j] - pow(w, j)*sets[i + 1][j]
                sets[i] = temp
            sets.pop(i + 1)
        a += 1
    return sets
    





#Credit: Reducible (https://youtu.be/h7apO7q16V0)
def ifft(P):
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



#def func1(x: float):
#    return x

#def func2(x: float):
#    return 0

a = [1, 0, 0, 0]
b = [1, 2, 3, 4]
print(b[::2])
print(iterative_fft(a))




