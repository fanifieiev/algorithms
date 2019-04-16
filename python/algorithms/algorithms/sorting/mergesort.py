from .sort import Sort, T
from ..lists.abstract_list import ListNode


class MergeSort(Sort):
    def sort_array(self, arr: [T]) -> [T]:
        if not arr or len(arr) < 2:
            return arr
        else:
            middle_idx = len(arr) // 2
            return self.__merge_arrays(self.sort_array(arr[:middle_idx]), self.sort_array(arr[middle_idx:]))

    def __merge_arrays(self, a: [T], b: [T]) -> [T]:
        if not a:
            return b
        if not b:
            return a

        i, j = 0, 0
        merged = []

        while i < len(a) and j < len(b):
            if a[i] <= b[j]:
                merged.append(a[i])
                i += 1
            else:
                merged.append(b[j])
                j += 1

        while i < len(a):
            merged.append(a[i])
            i += 1

        while j < len(b):
            merged.append(b[j])
            j += 1

        return merged

    def sort_list(self, list: ListNode) -> ListNode:
        if list is None or list.next is None:
            return list
        else:
            head = list
            middle_node = self.__split(head)
            return self.__merge_lists(self.sort_list(middle_node[0]), self.sort_list(middle_node[1]))

    def __split(self, head: ListNode) -> (ListNode, ListNode):
        if not head or not head.next:
            return head, None
        pre, slow, fast = None, head, head
        while fast and fast.next:
            pre = slow
            slow = slow.next
            fast = fast.next.next
        pre.next = None

        return head, slow

    def __merge_lists(self, a: ListNode, b: ListNode) -> ListNode:
        if a is None:
            return b

        if b is None:
            return a

        current: ListNode = None

        if a and b:
            if a.value <= b.value:
                current = a
                a = current.next
            else:
                current = b
                b = current.next

        head = current

        while a and b:
            if a.value <= b.value:
                current.next = a
                current = a
                a = current.next
            else:
                current.next = b
                current = b
                b = current.next

        if a is None:
            current.next = b
        if b is None:
            current.next = a

        return head
