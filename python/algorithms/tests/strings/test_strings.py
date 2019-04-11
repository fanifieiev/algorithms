import unittest

from algorithms.strings.reversing import Reverses
from algorithms.timings.timers import timer


class TestSorting(unittest.TestCase):

    def test_reverse_recursively(self):
        original = "abcdefghijklmnopqrstuvwxyz"

        @timer
        def reverse_recursively(s: str) -> str:
            """Test: Reversing a string recursively"""
            return Reverses.reverse_recursively(original)

        self.assertEqual(reverse_recursively(original), "zyxwvutsrqponmlkjihgfedcba")

    def test_reverse_iteratively(self):
        original = "abcdefghijklmnopqrstuvwxyz"

        @timer
        def reverse_iteratively(s: str) -> str:
            """Test: Reversing a string linearaly"""
            return Reverses.reverse_iteratively(original)

        self.assertEqual(reverse_iteratively(original), "zyxwvutsrqponmlkjihgfedcba")

