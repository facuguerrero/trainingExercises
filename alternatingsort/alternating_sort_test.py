import unittest

from alternatingsort.alternating_sort import AlternatingSort


class AlternatingSortTest(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual(True, AlternatingSort.solution([1, 3, 5, 6, 4, 2]))

    def test_case_two(self):
        self.assertEqual(False, AlternatingSort.solution([1, 4, 5, 6, 3]))


if __name__ == '__main__':
    unittest.main()
