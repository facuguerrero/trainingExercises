class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class AddTwoNumbers:
    @staticmethod
    def node_to_int(input_list: ListNode) -> int:
        result = ""
        current_node = input_list
        while current_node:
            result += str(current_node.val)
            current_node = current_node.next
        return int(result[::-1])

    @staticmethod
    def int_to_node(input_int: int) -> ListNode:
        str_integer = str(input_int)
        current_node = None
        previous_node = None

        for digit in str_integer:
            current_node = ListNode(int(digit), previous_node)
            previous_node = current_node

        return current_node

    @staticmethod
    def solution(l1: ListNode, l2: ListNode) -> ListNode:
        first_num = AddTwoNumbers.node_to_int(l1)
        second_num = AddTwoNumbers.node_to_int(l2)
        result = first_num + second_num

        return AddTwoNumbers.int_to_node(result)
