import unittest

from lexicographicallysmallestmerge.lexicographically_smallest_merge import LexicographicallySmallestMerge


class LexicographicallySmallestMergeTest(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual("stouperwer", LexicographicallySmallestMerge.solution("super", "tower"))

    def test_case_two(self):
        self.assertEqual("dcecccbd", LexicographicallySmallestMerge.solution("dce", "cccbd"))

if __name__ == '__main__':
    unittest.main()
