import unittest

from algorithms.lists.abstract_list import ListNode
from algorithms.sorting.btreesort import BinaryTreeSort
from algorithms.timings.timers import timer


class TestBiTreeSorting(unittest.TestCase):

    def test_bitree_array_sort(self):
        arr = [5, 7, 0, 3, 1]
        sort = BinaryTreeSort()

        @timer
        def do_sort(sortable):
            return sort.sort_array(sortable)

        self.assertEqual(do_sort(arr), [0, 1, 3, 5, 7])

    def test_bitree_linkedlist_sort(self):
        head: ListNode[int] = ListNode(5, ListNode(7, ListNode(0, ListNode(3, ListNode(1)))))
        sort = BinaryTreeSort()

        @timer
        def do_sort(llist: ListNode[int]):
            return sort.sort_list(llist)

        result = do_sort(head)
        self.assertEqual(result, ListNode(0, ListNode(1, ListNode(3, ListNode(5, ListNode(7))))))


if __name__ == '__main__':
    unittest.main()
