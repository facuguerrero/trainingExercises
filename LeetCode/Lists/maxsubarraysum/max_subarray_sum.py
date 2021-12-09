class MaxSubarraySum:
    @staticmethod
    def solution(input_list, n):
        """	Preconditions:
            * inputList can't be null
            * n can't be null
            * elements in list must be ints """

        list_len = len(input_list)
        if not input_list or list_len < n: return None

        current_sum = sum(input_list[0:n])
        max_sum = current_sum
        initial_index = 1
        for actual_index in range(n, list_len):
            # Substract the previous element to window of size n
            current_sum -= input_list[actual_index - n]
            # Add the new element to be included
            current_sum += input_list[actual_index]
            if current_sum > max_sum: max_sum = current_sum
            initial_index += 1
        return max_sum
