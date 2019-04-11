import unittest

from algorithms.strings.search import DirectSubStr


class TestStringSearch(unittest.TestCase):

    def test_one_substr(self):
        substr = DirectSubStr()
        original = "abcdefghijkab"
        res = substr.sub_str_index(original, "ab")
        self.assertEqual(res, [0])

    def test_no_substr(self):
        substr = DirectSubStr()
        original = "abcdefghijkab"
        res = substr.sub_str_index(original, "sk")
        self.assertEqual(res, None)

    def test_search_all_substrs(self):
        substr = DirectSubStr()
        original = "abababbababbcabab"
        indexes = substr.sub_str_indexes(original, "ab")
        self.assertEqual(indexes, [0, 2, 4, 7, 9, 13, 15])

    def test_count_all_substrs(self):
        substr = DirectSubStr()
        original = "abababbababbcabab"
        count = substr.sub_str_indexes(original, "ab")
        self.assertEqual(count, 7)
