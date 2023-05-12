class Object:
    def __init__(self, a):
        self.a = a

    def __str__(self):
        return str(self.a)
    
class Object2(Object):
    def __init__(self, a, b):
        super().__init__(a)
        self.b = b
    
    def __str__(self):
        return super().__str__() + ' ' + str(self.b)

thing = Object2('hello', 'world')
print(thing)