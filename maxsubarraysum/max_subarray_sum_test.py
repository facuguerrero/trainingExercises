import unittest

from maxsubarraysum.max_subarray_sum import MaxSubarraySum


class TestMaxSubarraySum(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual(17, MaxSubarraySum.solution([1, 2, 5, 2, 8, 1, 5], 4))

    def test_case_two(self):
        self.assertEqual(10, MaxSubarraySum.solution([1, 2, 5, 2, 8, 1, 5], 2))

    def test_case_three(self):
        self.assertEqual(6, MaxSubarraySum.solution([4, 2, 1, 6], 1))

    def test_case_four(self):
        self.assertEqual(13, MaxSubarraySum.solution([4, 2, 1, 6, 2], 4))

    def test_case_five(self):
        self.assertEqual(None, MaxSubarraySum.solution([], 4))


if __name__ == '__main__':
    unittest.main()
