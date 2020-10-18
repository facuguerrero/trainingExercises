import unittest

from highestoccurrence.highest_ocurrence import HighestOccurrence


class TestHighestOccurrence(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual([2], HighestOccurrence().solution([2, 3, 2, 2, 2, 4, 2]))

    def test_case_two(self):
        self.assertEqual([2, 3], HighestOccurrence().solution([2, 3, 2, 3, 2, 3, 4]))

    def test_case_three(self):
        self.assertEqual(['a'], HighestOccurrence().solution(['a', 'b', 'c', 'a', 'a', 'a', 'a']))

    def test_case_four(self):
        self.assertEqual(['a', 2], HighestOccurrence().solution(['a', 'a', 2, 2, 2, 'a', 4]))


if __name__ == '__main__':
    unittest.main()