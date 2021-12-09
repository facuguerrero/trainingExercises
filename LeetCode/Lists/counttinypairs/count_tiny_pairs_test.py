import unittest
from counttinypairs.count_tiny_pairs import CountTinyPairs


class CountTinyPairsTest(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual(2, CountTinyPairs.solution([1, 2, 3], [1, 2, 3], 31))

    def test_case_two(self):
        self.assertEqual(4, CountTinyPairs.solution([16, 1, 4, 2, 14], [7, 11, 2, 0, 15], 743))

if __name__ == '__main__':
    unittest.main()
