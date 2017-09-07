from binarytree.binarytree.TreeNode import TreeNode

class BinaryTree:
    def __init__(self, value):
        self.root = TreeNode(value)

    def insert(self, value) -> TreeNode:
        return self.insertInternal(self.root, value)

    def find(self, value) -> TreeNode:
        return self.findInternal(self.root, value)

    def min(self) -> TreeNode:
        return self.minInternal(self.root)

    def max(self) -> TreeNode:
        return self.maxInternal(self.root)

    def isEmpty(self) -> bool:
        return self.root is None

    def depth(self) -> int:
        return self.depthInternal(self.root)

    def walk(self) -> list:
        container = list()
        self.walkInternal(self.root, lambda x: container.append(x))
        return container

    def remove(self, value) -> bool:
        return self.removeInternal(self.root, value) is not None

    def removeInternal(self, node: TreeNode, value) -> TreeNode:
        if node is None:
            return node
        if value < node.value:
            node.setLeft(self.removeIternal(node.left, value))
        elif value > node.value:
            node.setRight(self.removeInternal(node.right, value))
        elif node.left is not None and node.left is not None:
            node.setValue(self.minInternal(node.right).value)
            node.setRight(self.removeInternal(node.right, node.value))
        else:
            node = node.left if node.left is not None else node.right
        return node

    def walkInternal(self, node: TreeNode, action):
        if node.left is not None:
            self.walkInternal(node.left, action)
        if node is not None:
            action(node)
        if node.right is not None:
            self.walkInternal(node.right, action)

    def depthInternal(self, node: TreeNode) -> int:
        if node is not None:
            return max(self.depthInternal(node.left), self.depthInternal(node.right)) + 1
        else:
            return 0

    def insertInternal(self, node: TreeNode, value) -> TreeNode:
        if node is None:
            return TreeNode(value)
        if (value < node.value):
            node.setLeft(self.insertInternal(node.left, value))
        else:
            node.setRight(self.insertInternal(node.right, value))
        return node

    def findInternal(self, node: TreeNode, value: object) -> TreeNode:
        if node is None or node.value == value:
            return node
        else:
            if (value < node.value):
                return self.findInternal(node.left, value)
            else:
                return self.findInternal(node.right, value)

        return node

    def minInternal(self, node) -> TreeNode:
        if node.left is None:
            return node
        else:
            return self.minInternal(node.left)

    def maxInternal(self, node) -> TreeNode:
        if node.right is None:
            return node
        else:
            return self.maxInternal(node.right)


def main():
    bst = BinaryTree(10)
    bst.insert(12)
    bst.insert(3)
    bst.insert(2)

    print(bst.find(3).value)
    print("Min value:", bst.min().value)
    print("Max value", bst.max().value)

    for entry in bst.walk():
        print(entry.value)


if __name__ == '__main__':
    main()
