class LexicographicallySmallestMerge:
    @staticmethod
    def solution(s1, s2):
        s1_occurrences = LexicographicallySmallestMerge.get_character_ocurrences(s1)
        s2_occurrences = LexicographicallySmallestMerge.get_character_ocurrences(s2)
        skip_occurrence_comparing = (max(s1_occurrences.values()) == 1 and max(s2_occurrences.values()) == 1)
        return LexicographicallySmallestMerge.merge_strings_rec("", s1, s2, s1_occurrences, s2_occurrences, skip_occurrence_comparing)

    @staticmethod
    def get_character_ocurrences(s):
        occurrences = {}
        for character in s:
            occurrences[character] = occurrences.get(character, 0) + 1
        return occurrences

    @staticmethod
    def merge_strings_rec(sol, s1, s2, s1_occurrences, s2_occurrences, skip_occurence_comparing):
        if not s1 or not s2:
            return sol + s1 + s2
        if LexicographicallySmallestMerge.compare_strings(s1, s2, s1_occurrences, s2_occurrences, skip_occurence_comparing):
            return LexicographicallySmallestMerge.merge_strings_rec(sol + s2[0], s1, s2[1:], s1_occurrences, s2_occurrences, skip_occurence_comparing)
        return LexicographicallySmallestMerge.merge_strings_rec(sol + s1[0], s1[1:], s2, s1_occurrences, s2_occurrences, skip_occurence_comparing)

    @staticmethod
    def compare_strings(s1, s2, s1_occurrences, s2_occurrences, skip_occurrence_comparing):
        if not skip_occurrence_comparing:
            min_len = min(len(s1), len(s2))
            for i in range(0, min_len):
                if not s1[i] or s1_occurrences.get(s1[i]) < s2_occurrences.get(s2[i]):
                    return False
                if not s2[i] or s1_occurrences.get(s1[i]) > s2_occurrences.get(s2[i]):
                    return True
        # strings are equals
        return s1[0] > s2[0]