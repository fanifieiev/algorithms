from typing import TypeVar, Generic, List

K = TypeVar("T")
V = TypeVar("V")


class TreeNode(Generic[K, V]):
    def __init__(self, key: K, value: V):
        self.value: V = value
        self.key: K = key
        self.left: TreeNode[K, V] = None
        self.right: TreeNode[K, V] = None

    def __str__(self):
        return f"Node: ({self.key},{self.value})"


class BinaryTree(Generic[K, V]):
    def __init__(self):
        self.root: TreeNode[K, V] = None
        self.size = 0

    def isEmpty(self) -> bool:
        return self.root is None

    def height(self) -> int:
        return self._height(self.root)

    def _height(self, node: TreeNode[K, V]) -> int:
        if node:
            return max(self._height(node.left), self._height(node.right)) + 1
        else:
            return 0

    def size(self) -> int:
        return self.size

    def connections(self) -> int:
        counter = [0]
        self._connectionsOfSubTree(self.root, counter)
        print(counter)
        return counter[0]

    def _connectionsOfSubTree(self, node: TreeNode[K, V], counter) -> None:
        if node:
            if node.left:
                counter[0] += 1
                self._connectionsOfSubTree(node.left, counter)
            if node.right:
                counter[0] += 1
                self._connectionsOfSubTree(node.right, counter)

    def add(self, key: K, value: V) -> TreeNode[K, V]:
        if self.root is None:
            self.root = TreeNode(key, value)
            self.size += 1
            return self.root
        else:
            return self._addToNode(self.root, key, value)

    def _addToNode(self, node: TreeNode[K, V], key: K, value: V) -> TreeNode[K, V]:
        if key < node.key:
            if node.left is None:
                node.left = TreeNode(key, value)
                self.size += 1
                return node.left
            else:
                return self._addToNode(node.left, key, value)
        else:
            if node.right is None:
                node.right = TreeNode(key, value)
                self.size += 1
                return node.right
            else:
                return self._addToNode(node.right, key, value)

    def getNode(self, key: K) -> TreeNode[K, V]:
        return self._getNode(self.root, key)

    def _getNode(self, node: TreeNode[K, V], key: K) -> TreeNode[K, V]:
        if node.key == key:
            return node
        else:
            if key < node.key:
                return self._getNode(node.left, key)
            else:
                return self._getNode(node.right, key)

    def getValue(self, key: K) -> V:
        node = self.getNode(key)
        return node.value if node else None

    def remove(self, key: K) -> None:
        pass

    def min(self) -> TreeNode[K, V]:
        return self._min(self.root)

    def _min(self, node: TreeNode[K, V]) -> TreeNode[K, V]:
        if node.left is None:
            return node
        else:
            return self._min(node.left)

    def max(self) -> TreeNode[K, V]:
        return self._max(self.root)

    def _max(self, node: TreeNode[K, V]) -> TreeNode[K, V]:
        if node.right is None:
            return node
        else:
            return self._min(node.right)

    def sorted(self) -> List[TreeNode[K, V]]:
        list: List[TreeNode[K, V]] = []

        def add(node: TreeNode[K, V]):
            list.append(node)

        self._walkFromMinimum(self.root, add)

        return list

    def sortedKeys(self) -> List[K]:
        sorted_nodes = self.sorted()
        return [node.key for node in sorted_nodes]

    def _walkFromMinimum(self, node: TreeNode[K, V], function) -> None:
        if node.left:
            self._walkFromMinimum(node.left, function)

        if node:
            function(node)

        if node.right:
            self._walkFromMinimum(node.right, function)

    def _walkFromMaximum(self, node: TreeNode[K, V], function) -> None:
        if node.right:
            self._walkFromMaximum(node.right, function)

        if node:
            function(node)

        if node.left:
            self._walkFromMaximum(node.left, function)

    def remove(self, key: K) -> TreeNode[K, V]:
        pass

    def _removeNode(self, node: TreeNode[K, V]) -> TreeNode[K, V]:
        pass
