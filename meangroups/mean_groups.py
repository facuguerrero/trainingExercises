import statistics


class MeanGroups:
    @staticmethod
    def solution(a):
        grouped_arrays_by_mean = {}
        for i in range(len(a)):
            mean = statistics.mean(a[i])
            mean_group = grouped_arrays_by_mean.get(mean, [])
            mean_group.append(i)
            grouped_arrays_by_mean[mean] = mean_group

        solution = []
        for mean in grouped_arrays_by_mean.keys():
            solution.append(grouped_arrays_by_mean[mean])
        return sorted(solution, key=lambda x: x[0])
