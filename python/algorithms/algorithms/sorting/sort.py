""""
class MyClass:
 def __lt__(self, other):
      # return comparison
 def __le__(self, other):
      # return comparison
 def __eq__(self, other):
      # return comparison
 def __ne__(self, other):
      # return comparison
 def __gt__(self, other):
      # return comparison
 def __ge__(self, other):
      # return comparison
"""
from abc import ABCMeta, abstractmethod
from typing import TypeVar

from algorithms.lists.abstract_list import ListNode

T = TypeVar("T")


class Sort(metaclass=ABCMeta):

    @abstractmethod
    def sort_array(self, arr: [T]) -> [T]:
        pass

    @abstractmethod
    def sort_list(self, list: ListNode[T]) -> ListNode[T]:
        pass
