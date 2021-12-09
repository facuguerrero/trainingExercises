import unittest

from addtwonumbers.add_two_numbers import AddTwoNumbers


class TestAddTwoNumbers(unittest.TestCase):
    def test_case_one(self):
        # TODO improve the test cases
        l1 = AddTwoNumbers.int_to_node(342)
        l2 = AddTwoNumbers.int_to_node(465)

        result = AddTwoNumbers.solution(l1, l2)

        self.assertEqual(807, AddTwoNumbers.node_to_int(result))

    def test_case_two(self):
        l1 = AddTwoNumbers.int_to_node(0)
        l2 = AddTwoNumbers.int_to_node(0)

        result = AddTwoNumbers.solution(l1, l2)

        self.assertEqual(0, AddTwoNumbers.node_to_int(result))

    def test_case_three(self):
        l1 = AddTwoNumbers.int_to_node(9999999)
        l2 = AddTwoNumbers.int_to_node(9999)

        result = AddTwoNumbers.solution(l1, l2)

        self.assertEqual(10009998, AddTwoNumbers.node_to_int(result))


if __name__ == '__main__':
    unittest.main()
