from typing import TypeVar, Generic

T = TypeVar("T")


class ListNode(Generic[T]):
    def __init__(self, value: T, next_node=None):
        self.value: T = value
        self.next: ListNode[T] = next_node

    def add(self, value: T):
        p = self
        while p.next:
            p = p.next

        p.next = ListNode(value)
        return p.next

    @staticmethod
    def add_to_head(head, value: T):
        if not head:
            return ListNode(value)
        else:
            p = head
            while p.next:
                p = p.next
            p.next = ListNode(value)
            return head

    def __eq__(self, other):
        if isinstance(other, self.__class__):
            head1 = self
            head2 = other

            while head1 and head2:
                if head1.value != head2.value:
                    return False
                head1 = head1.next
                head2 = head2.next

            if head1 or head2:
                return False

            return True
        else:
            return False


    def __str__(self):
        return f"Node(value={self.value}, next={self.next})"