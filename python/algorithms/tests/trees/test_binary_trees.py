import unittest

from algorithms.timings.timers import timer
from algorithms.trees.tree import BinaryTree


class TestBinaryTree(unittest.TestCase):
    def test_binary_insertion(self):
        tree: BinaryTree[int, str] = BinaryTree[int, str]()

        @timer
        def binary_insert(key, value):
            tree.add(key, value)

        binary_insert(36, "Fevzi")
        binary_insert(32, "Milia")
        binary_insert(6, "Melek")
        binary_insert(3, "Amira")
        binary_insert(100, "GrandDad")

        self.assertEqual(tree.getValue(36), "Fevzi")
        self.assertEqual(tree.getValue(32), "Milia")
        self.assertEqual(tree.getValue(6), "Melek")
        self.assertEqual(tree.getValue(3), "Amira")
        self.assertEqual(tree.getValue(100), "GrandDad")

    def test_minimum_maximum(self):
        tree: BinaryTree[int, str] = BinaryTree[int, str]()
        tree.add(36, "Fevzi")
        tree.add(32, "Milia")
        tree.add(6, "Melek")
        tree.add(3, "Amira")

        self.assertEqual(tree.min().key, 3)
        self.assertEqual(tree.max().key, 36)

    def test_sorted(self):
        tree: BinaryTree[int, str] = BinaryTree[int, str]()
        tree.add(36, "Fevzi")
        tree.add(32, "Milia")
        tree.add(6, "Melek")
        tree.add(3, "Amira")

        self.assertEqual(tree.sortedKeys(), [3, 6, 32, 36])

    def test_connections(self):
        tree: BinaryTree[int, str] = BinaryTree[int, str]()
        tree.add(36, "Fevzi")
        tree.add(32, "Milia")
        tree.add(6, "Melek")
        tree.add(3, "Amira")
        tree.add(100, "Dad")

        connections = tree.connections()
        self.assertEqual(connections, 4)

    def test_height(self):
        tree: BinaryTree[int, str] = BinaryTree[int, str]()
        tree.add(36, "Fevzi")
        tree.add(32, "Milia")
        tree.add(6, "Melek")
        tree.add(100, "Dad")
        tree.add(3, "Amira")

        height = tree.height()
        self.assertEqual(height, 4)

    def test_size(self):
        tree: BinaryTree[int, str] = BinaryTree[int, str]()
        tree.add(36, "Fevzi")
        tree.add(32, "Milia")
        tree.add(6, "Melek")
        tree.add(100, "Dad")
        tree.add(3, "Amira")

        size = tree.size
        self.assertEqual(size, 5)
