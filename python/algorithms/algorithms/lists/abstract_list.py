from typing import TypeVar, Generic

T = TypeVar("T")


class ListNode(Generic[T]):
    def __init__(self, value: T):
        self.value = value
        self.next = None


