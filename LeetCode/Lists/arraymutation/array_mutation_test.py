import unittest

from arraymutation.array_mutation import ArrayMutation


class ArrayMutationTest(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual([4, 5, -1, 2, 1], ArrayMutation.solution(5, [4, 0, 1, -2, 3]))

    def test_case_two(self):
        self.assertEqual([9], ArrayMutation.solution(1, [9]))

if __name__ == '__main__':
    unittest.main()
