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
            complement_element_indexes = element_indexes.get(complement, [])

            if (len(complement_element_indexes) == 0):
                continue

            # checking if complement is distinct to current number
            # or if complement is equal, then must appear at least twice in the list
            if (complement != nums[index] or len(complement_element_indexes) > 1):
                return [index, complement_element_indexes[-1]]
