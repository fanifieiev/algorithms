"""
https://leetcode.com/problems/add-two-numbers/
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class LinkedList:
    def __init__(self):
        self.root = None

    def add_all(self, values:[]) -> ListNode:
        for i in values:
            self.add(i)
        return self.root

    def add(self, value) -> ListNode:
        if self.root is None:
            self.root = ListNode(value)
            return self.root
        else:
            return self._addToNode(self.root, value)

    def _addToNode(self, node: ListNode, value) -> ListNode:
        if node.next is None:
            node.next = ListNode(value)
            return node.next
        else:
            return self._addToNode(node.next, value)

    def list_to_number(self, node: ListNode) -> int:
        index = 1
        result = 0
        while node:
            result += index * node.val
            node = node.next
            index *= 10
        return result

    def num_to_list(self, num) -> ListNode:
        value = num

        while value >= 10:
            self.add(value % 10)
            value = value // 10

        self.add(value)
        return self.root


class Solution:

    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        linked_list = LinkedList()
        value1 = linked_list.list_to_number(l1)
        value2 = linked_list.list_to_number(l2)
        return linked_list.num_to_list(value1 + value2)



if __name__ == '__main__':
        solution = Solution()
        linked_list1 = LinkedList()
        l1 = linked_list1.add_all([5])

        linked_list2 = LinkedList()
        l2 = linked_list2.add_all([5])

        l = solution.addTwoNumbers(l1, l2)
        print(l)


