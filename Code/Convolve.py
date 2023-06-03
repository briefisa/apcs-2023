import sympy as sp

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

one = [1,2,3,4]
two = [1,2]
print(discrete_conv(two, one))