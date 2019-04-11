"""
https://leetcode.com/problems/multiply-strings/
"""


class Solution:
    char_digit = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
    digit_char = {0: '0', 1: '1', 2: '2', 3: '3', 4: '4', 5: '5', 6: '6', 7: '7', 8: '8', 9: '9'}

    def multiply(self, num1: str, num2: str) -> str:
        v1 = self.str_2_int(num1)
        v2 = self.str_2_int(num2)

        return self.int_2_str(v1*v2)


    def str_2_int(self, num: str) -> int:
        number = 0
        for ch in num:
            number = 10 * number + self.char_digit[ch]
        return number

    def int_2_str(self, num:int) -> str:
        if num < 10:
            return self.digit_char[num]
        else:
            return self.int_2_str(num // 10) + self.digit_char[num % 10]




if __name__ == '__main__':
    solution = Solution()
    num:int = solution.str_2_int("125634872348726347")
    print(num)
    print(solution.int_2_str(num))
