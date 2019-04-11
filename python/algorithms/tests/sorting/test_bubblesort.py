import unittest

from algorithms.sorting.bubblesort import BubbleSort
from algorithms.timings.timers import timer


class TestSorting(unittest.TestCase):

    def test_bubblesort(self):
        arr = [1, 2, 5, 7, 3, 2, 5, 7, 21, 4, 6, 8]
        sort = BubbleSort()

        @timer
        def bubble_sort(sortable):
            return sort.sort_array(sortable)

        self.assertEqual(bubble_sort(arr), [1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8, 21])
