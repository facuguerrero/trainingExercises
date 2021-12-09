import unittest

from averagepair.average_pair import AveragePair


class TestAveragePair(unittest.TestCase):
    def test_case_one(self):
        self.assertTrue(AveragePair().solution([1, 2, 3], 2.5))

    def test_case_two(self):
        self.assertTrue(AveragePair().solution([1, 3, 3, 5, 6, 7, 10, 12, 19], 8))

    def test_case_three(self):
        self.assertFalse(AveragePair().solution([-1, 0, 3, 4, 5, 6], 4.1))

    def test_case_four(self):
        self.assertFalse(AveragePair().solution([], 4))


if __name__ == '__main__':
    unittest.main()