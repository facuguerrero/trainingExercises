class ArrayMutation:
    @staticmethod
    def solution(n, a):
        solution = []
        for i in range(0, n):
            first_term = a[i - 1] if (i > 0) else 0
            second_term = a[i]
            third_term = a[i + 1] if (i < n - 1) else 0
            solution.append(first_term + second_term + third_term)
        return solution
