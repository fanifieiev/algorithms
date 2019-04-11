import unittest

from algorithms.sorting.quicksort import InPlaceRecursiveQuickSort, RecursiveQuickSort
from algorithms.timings.timers import timer


class TestSorting(unittest.TestCase):

    def test_inplace_recursive_quicksort(self):
        arr = [1, 2, 5, 7, 3]
        sort = InPlaceRecursiveQuickSort()

        @timer
        def inplace_recursive_quicksort(sortable):
            sort.sort_array(sortable)

        inplace_recursive_quicksort(arr)
        self.assertEqual(arr, [1, 2, 3, 5, 7])

    def test_recursive_quicksort(self):
        arr = [1, 2, 5, 7, 3]
        sort = RecursiveQuickSort()

        @timer
        def recursive_quicksort(sortable):
            return sort.sort_array(sortable)

        self.assertEqual(recursive_quicksort(arr), [1, 2, 3, 5, 7])


if __name__ == '__main__':
    unittest.main()
