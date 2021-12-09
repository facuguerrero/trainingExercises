import unittest

from hashmap.hash_map import HashMap


class HashMapTest(unittest.TestCase):
    def test_case_one(self):
        self.assertEqual(6, HashMap.solution(["insert", "addToValue", "get", "insert", "addToKey", "addToValue", "get"], [[1, 2], [2], [1], [2, 3], [1], [-1], [3]]))

    def test_case_two(self):
        self.assertEqual(6, HashMap.solution(["insert", "addToValue", "get", "insert", "addToKey", "addToValue", "get"], [[1, 2], [2], [1], [2, 3], [1], [-1], [3]]))


if __name__ == '__main__':
    unittest.main()
