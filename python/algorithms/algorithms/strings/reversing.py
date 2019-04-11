from builtins import staticmethod


class Reverses:

    @staticmethod
    def reverse_recursively(s: str) -> str:
        def rev(s: str) -> str:
            size = len(s)
            if size <= 1:
                return s
            else:
                return rev(s[1:]) + s[0]

        return rev(s)

    @staticmethod
    def reverse_iteratively(s: str) -> str:
        start, end = 0, len(s) - 1
        arr = list(s)
        while start < end:
            if arr[start] != arr[end]:
                arr[end], arr[start] = arr[start], arr[end]
            start = start + 1
            end = end - 1
        return ''.join(arr)
