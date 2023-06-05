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

def iterative_fft(P: list) -> list:
    n = len(P)
    sets = []
    for a in P:
        



#def func1(x: float):
#    return x

#def func2(x: float):
#    return 0

a = [1, 1, 1, 1]
print(ifft(fft(a)))




