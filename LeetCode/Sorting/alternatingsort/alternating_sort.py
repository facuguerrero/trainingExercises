import math


class AlternatingSort:
    @staticmethod
    def solution(a):
        array_len = len(a)
        solution = []

        for i in range(0, math.ceil(array_len / 2)):
            solution.append(a[i])
            solution.append(a[array_len - 1 - i])

        for i in range(array_len - 1):
            if solution[i] >= solution[i + 1]:
                return False
        return True
