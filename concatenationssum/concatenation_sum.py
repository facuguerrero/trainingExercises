class ConcatenationsSum:
    @staticmethod
    def solution(a):
        len_a = len(a)
        concatenations = []
        for i in range(0, len_a):
            for j in range(i, len_a):
                concatenations.append(int(str(a[i]) + str(a[j])))
                if i != j:
                    concatenations.append(int(str(a[j]) + str(a[i])))
        return sum(concatenations)
