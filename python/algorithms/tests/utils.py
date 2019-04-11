import unittest


class TestUtils(unittest.TestCase):

    def test_1(self):
        arr = map(int, (1, 2, 3, 4, 5, 6, 7))
        print(list(arr))