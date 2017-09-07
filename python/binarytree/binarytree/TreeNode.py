class TreeNode:
    def __init__(self, value):
        self.left: TreeNode = None
        self.right: TreeNode = None
        self.value = value

    def left(self):
        return self.left

    def right(self):
        return self.right

    def value(self):
        return self.value

    def setLeft(self, left):
        self.left = left

    def setRight(self, right):
        self.right = right

    def setValue(self, value):
        self.value = value