class AveragePair:
    @staticmethod
    def solution(input_list, target_average):
        """	Preconditions:
             * inputList can't be null
             * averageTarget can't be null
             * elements in list must be ints """

        # We have to create a hash to reduce the search to O(1)
        element_counts = {}
        for element in input_list:
            element_counts[element] = element_counts.get(element, 0) + 1

        for element in input_list:
            # targetAverage = (a + b)/2 => (2*targetAverage) - b = a
            a = (2 * target_average) - element
            # TODO check if the element is equal to a, then should be repeated in list.
            if a in element_counts: return True
        return False
