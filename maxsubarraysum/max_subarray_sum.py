class MaxSubarraySum:
    @staticmethod
    def solution(input_list, n):
        """	Preconditions:
            * inputList can't be null
            * n can't be null
            * elements in list must be ints """

        list_len = len(input_list)
        if not input_list or list_len < n: return None

        initial_index = 0
        max_sum = 0
        for actual_index in range(n, list_len + 1):
            partial_sum = sum(input_list[initial_index:actual_index])
            if partial_sum > max_sum: max_sum = partial_sum
            initial_index += 1
        return max_sum
