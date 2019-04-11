from .sort import Sort, T
from ..lists.abstract_list import ListNode


class BubbleSort(Sort):

    def sort_array(self, arr: [T]) -> [T]:
        bottom = len(arr) - 1
        for i in range(0, bottom):
            for j in range(0, bottom - i):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
        return arr

    def sort_list(self, node: ListNode[T]) -> ListNode[T]:
        current: ListNode[T] = node

        while current and current.next:
            pass
