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

def fft(P: list) -> list:
    n = len(P)
    if n == 1:
        return n
    w = complex(math.cos((2*math.pi)/n), math.sin((2*math.pi)/n))
    Pe, Po = P[::2], P[1::2]
    ye, yo = fft(Pe), fft(Po)
    y = [0]*n
    if type(ye) == int:
        for j in range(n//2):
            y[j] = ye + (pow(w, j))*yo
            y[j + n//2] = ye - (pow(w, j))*yo
    else:
        for j in range(n//2):
            y[j] = ye[j] + (pow(w, j))*yo[j]
            y[j + 1] = ye[j] - (pow(w, j))*yo[j]
    return y

def ifft(P):
    n = len(P)
    if n == 1:
        return n
    w = (1/n)*complex(math.cos((2*math.pi)/n), math.sin((2*math.pi)/n))
    Pe, Po = P[::2], P[1::2]
    ye, yo = ifft(Pe), ifft(Po)
    y = [0]*n
    if type(ye) == int:
        for j in range(n//2):
            y[j] = ye + (pow(w, j))*yo
            y[j + n//2] = ye - (pow(w, j))*yo
    else:
        for j in range(n//2):
            y[j] = ye[j] + (pow(w, j))*yo[j]
            y[j + n//2] = ye[j] - (pow(w, j))*yo[j]
    return y


#def func1(x: float):
#    return x

#def func2(x: float):
#    return 0

a = [5, 1, 3, 2]
print(fft(a))




