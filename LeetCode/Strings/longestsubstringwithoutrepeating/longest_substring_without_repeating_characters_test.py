import unittest

from longestsubstringwithoutrepeating.longest_substring_without_repeating_characters import \
    LongestSubstringWithoutRepeatingCharacters


class TestLongestSubstringWithoutRepeatingCharacters(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual(3, LongestSubstringWithoutRepeatingCharacters.solution("abcabcbb"))

    def test_case_two(self):
        self.assertEqual(1, LongestSubstringWithoutRepeatingCharacters.solution("bbbbb"))

    def test_case_three(self):
        self.assertEqual(3, LongestSubstringWithoutRepeatingCharacters.solution("pwwkew"))

if __name__ == '__main__':
    unittest.main()
