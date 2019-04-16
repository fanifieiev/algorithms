import unittest

from algorithms.lists.abstract_list import ListNode
from algorithms.sorting.mergesort import MergeSort
from algorithms.timings.timers import timer


class TestMergeSorting(unittest.TestCase):

    def test_linked_list_merge_sort(self):
        head: ListNode[int] = ListNode(4, ListNode(2, ListNode(0, ListNode(5, ListNode(7, ListNode(10))))))

        sort = MergeSort()

        @timer
        def _sort_linked_list(head):
            return sort.sort_list(head)

        sorted_list = _sort_linked_list(head)
        self.assertEqual(sorted_list, ListNode(0, ListNode(2, ListNode(4, ListNode(5, ListNode(7, ListNode(10)))))))

    def test_array_merge_sort(self):
        arr = [4, 2, 0, 5, 7, 10]
        sort = MergeSort()

        times = 1000

        @timer
        def _sort_array(arr):
            return sort.sort_array(arr)

        sorted_array = _sort_array(arr)
        self.assertEqual(sorted_array, [0, 2, 4, 5, 7, 10])


if __name__ == '__main__':
    unittest.main()
