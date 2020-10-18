import unittest

from twosum.two_sum import TwoSum


class TestTwoSum(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual([0, 1], TwoSum.solution([2, 7, 11, 15], 9))

    def test_case_two(self):
        self.assertEqual([1, 2], TwoSum.solution([3, 2, 4], 6))

    def test_case_three(self):
        self.assertEqual([0, 1], TwoSum.solution([3, 3], 6))


if __name__ == '__main__':
    unittest.main()
