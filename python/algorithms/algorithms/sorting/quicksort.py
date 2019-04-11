from ..lists.abstract_list import ListNode
from .sort import Sort, T


class InPlaceRecursiveQuickSort(Sort):

    def sort_array(self, arr: [T]) -> [T]:
        def quick_sort(a: [T], left: int, right: int) -> None:
            if left < right:
                i = left
                j = right
                pivot = a[int((right / 2 + left / 2))]

                while i <= j:
                    while a[i] < pivot: i += 1
                    while a[j] > pivot: j -= 1
                    if i <= j:
                        a[i], a[j] = a[j], a[i]
                        i += 1
                        j -= 1
                quick_sort(a, left, j)
                quick_sort(a, i, right)

        quick_sort(arr, 0, len(arr) - 1)
        return arr

    def sort_list(self, list: ListNode[T]):
        pass


class RecursiveQuickSort(Sort):
    def sort_array(self, arr: [T]) -> [T]:
        def do_quick_sort(arr: [T]) -> [T]:
            length = len(arr)
            if length < 2:
                return arr
            else:
                pivot = arr[int(length / 2)]
                less, greater, equal = [], [], []

                for x in arr[0:]:
                    (less if x < pivot else (greater if x > pivot else equal)).append(x)
                return do_quick_sort(less) + equal + do_quick_sort(greater)

        return do_quick_sort(arr)

    def sort_list(self, list: ListNode[T]):
        pass
