class TwoSum:
    @staticmethod
    def solution(nums, target):
        element_indexes = {}

        # For each element, add its indexes in a dict
        for index in range(len(nums)):
            actual_element_indexes = element_indexes.get(nums[index], [])
            actual_element_indexes.append(index)
            element_indexes[nums[index]] = actual_element_indexes

        # For each element, check if its complement exists in the dict
        for index in range(len(nums)):
            complement = target - nums[index]
            actual_element_indexes = element_indexes.get(complement, [])

            value_without_actual_index = list(filter(lambda x: x != index, actual_element_indexes))
            if len(value_without_actual_index):
                return [index, actual_element_indexes[-1]]
