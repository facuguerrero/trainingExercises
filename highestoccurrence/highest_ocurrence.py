class HighestOccurrence:
    @staticmethod
    def solution(input_list):
        """ Preconditions:
            * inputList can't be null """
        elements_occurrence = {}
        for element in input_list:
            count = elements_occurrence.get(element, 0)
            elements_occurrence[element] = count + 1

        highest_occurrence = max(elements_occurrence.values())
        solution = []
        for key, value in elements_occurrence.items():
            if value == highest_occurrence: solution.append(key)

        return solution
