import unittest

from meangroups.mean_groups import MeanGroups


class MeanGroupsTest(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual([[0, 4], [1], [2, 3]], MeanGroups.solution([[3, 3, 4, 2], [4, 4], [4, 0, 3, 3], [2, 3], [3, 3, 3]]))

    def test_case_two(self):
        self.assertEqual([[0, 1, 2, 3]], MeanGroups.solution([[-5, 2, 3], [0, 0], [0], [-100, 100]]))

if __name__ == '__main__':
    unittest.main()
