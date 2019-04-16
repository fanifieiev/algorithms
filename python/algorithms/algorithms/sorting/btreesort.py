from algorithms.lists.abstract_list import ListNode
from algorithms.trees.tree import BiTreeNode
from .sort import Sort, T


class BinaryTreeSort(Sort):
    def sort_array(self, arr: [T]) -> [T]:
        if arr is None or len(arr) == 1:
            return arr

        root = BiTreeNode(arr[0])

        for i in range(1, len(arr)):
            BiTreeNode.add_to_node(root, arr[i])

        collector = []
        self.__walk_sorted(root, lambda x: collector.append(x))

        return collector

    def sort_list(self, linked_list: ListNode[T]) -> ListNode[T]:
        if linked_list is None or linked_list.next is None:
            return linked_list

        root = BiTreeNode(linked_list.value)

        current = linked_list.next
        while current:
            BiTreeNode.add_to_node(root, current.value)
            current = current.next

        head: ListNode[int] = ListNode(-1)

        self.__walk_sorted(root, lambda x: head.add(x.value))

        return head.next

    def __walk_sorted(self, node: BiTreeNode[T], function):
        if node.left:
            self.__walk_sorted(node.left, function)

        function(node)

        if node.right:
            self.__walk_sorted(node.right, function)
