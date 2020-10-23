class LongestSubstringWithoutRepeatingCharacters:
    @staticmethod
    def solution(input_string: str) -> int:
        character_index = {}
        initial_index = 0
        max_count = 0
        for j in range(0, len(input_string)):
            if input_string[j] in character_index:
                initial_index = max(character_index[input_string[j]], initial_index)
            max_count = max(max_count, j - initial_index + 1)
            character_index[input_string[j]] = j + 1
        return max_count
