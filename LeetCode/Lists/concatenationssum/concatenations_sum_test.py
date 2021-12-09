import unittest

from concatenationssum.concatenation_sum import ConcatenationsSum


class ConcatenationsSumTest(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual(1344, ConcatenationsSum.solution([10, 2]))

    def test_case_two(self):
        self.assertEqual(88, ConcatenationsSum.solution([8]))

    def test_case_three(self):
        self.assertEqual(198, ConcatenationsSum.solution([1, 2, 3]))


if __name__ == '__main__':
    unittest.main()
