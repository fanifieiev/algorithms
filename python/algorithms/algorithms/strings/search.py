import sys
from abc import ABCMeta, abstractmethod
from typing import Optional


class SubStr(metaclass=ABCMeta):

    @abstractmethod
    def sub_str_index(self, original: str, pattern: str) -> Optional[int]:
        pass

    @abstractmethod
    def sub_str_indexes(self, original: str, pattern: str) -> list:
        pass

    @abstractmethod
    def count_substrs(self, original: str, pattern: str) -> int:
        pass


class DirectSubStr(SubStr):

    def sub_str_index(self, original: str, pattern: str) -> Optional[int]:
        return self.__sub_str_indexes(original, pattern, 1)

    def sub_str_indexes(self, original: str, pattern: str) -> Optional[list]:
        return self.__sub_str_indexes(original, pattern, sys.maxsize)

    def count_substrs(self, original: str, pattern: str) -> int:
        indexes = self.sub_str_indexes(original, pattern)
        return len(indexes) if indexes else 0

    def __sub_str_indexes(self, original, pattern, count) -> Optional[list]:
        original_length = len(original)
        pattern_length = len(pattern)
        shift = 0
        indexes = []
        while shift < original_length and len(indexes) < count:
            part = original[shift:shift + pattern_length]
            if part == pattern:
                indexes.append(shift)
                shift += pattern_length
            else:
                shift += 1
        return indexes if len(indexes) > 0 else None


class KMPSubStr(SubStr):
    def sub_str_index(self, original: str, pattern: str) -> Optional[int]:
        pass

    def sub_str_indexes(self, original: str, pattern: str) -> Optional[list]:
        pass

    def count_substrs(self, original: str, pattern: str) -> int:
        pass
