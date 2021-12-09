class CountTinyPairs:
    @staticmethod
    def solution(a, b, k):
        arrays_len = len(a)
        count = 0
        for i in range(0, arrays_len):
            concatenation = str(a[i]) + str(b[arrays_len - 1 - i])
            if int(concatenation) < k:
                count += 1
        return count
