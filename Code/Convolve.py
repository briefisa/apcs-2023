import math, cmath, random, time
import numpy as np
import matplotlib.pyplot as plt

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
    ye, yo = recursive_fft(Pe), recursive_fft(Po)
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
    ye, yo = recursive_ifft(Pe), recursive_ifft(Po)
    y = [0]*n
    for j in range(n//2):
        y[j] = ye[j] + (pow(w, j))*yo[j]
        y[j + n//2] = ye[j] - (pow(w, j))*yo[j]
    return y
    
def fft(P: list) -> list:
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

def ifft(P: list) -> list:
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

class Kernel:
    def __init__(self, function, sampleRate: int, start: float, end: float):
        self.function = function
        self.sampleRate = sampleRate
        self.start = start
        self.end = end
        self.kernelSample = []
        t = start
        while t < end:
            self.kernelSample.append(self.function(t))
            t += 1/sampleRate

    def getKernel(self):
        return self.kernelSample
        
# sampleRate(Hz) and packetSize(# of samples) must be powers of 2
def convolve(kernelFunction, signalFunction, start, end, duration, sampleRate, packetSize):
    kern = Kernel(kernelFunction, sampleRate, start, end)
    kernelSample = kern.getKernel()

    # ensures kernel and packet are of same size and adds filler terms
    while len(kernelSample) < packetSize*2:
        kernelSample.append(0.0)
    kernelSample = fft(kernelSample)

    output = []
    # adjusts t so that initial tail falls before 0
    t = 0.0 - (packetSize*(1/sampleRate))
    # sampling input signal
    count = 0
    while t < duration:
        packet = []
        while len(packet) < packetSize:
            packet.append(signalFunction(t))
            t += 1/sampleRate
        # adds filler terms so that polynomial degree can double
        while len(packet) < 2*packetSize:
            packet.append(0.0)
            t += 1/sampleRate
        packet = fft(packet)

        # multiplying transformed terms
        for a in range(len(packet)):
            packet[a] = packet[a]*kernelSample[a]
        packet = ifft(packet)

        # removing tails
        for a in range(packetSize):
            packet.pop(0)
            t -= (1/sampleRate)
        for a in range(packetSize - len(kern.getKernel())):
            packet.pop(-1)
            t -= (1/sampleRate)

        for a in packet:
            output.append(np.real(a))

    return output

def signal(t):
    return 500000000000.0

def kernel(t):
    return 1.0

a = convolve(kernel, signal, 0.0, (1/2**5),1,2**5,2**10)
print(a)


    

