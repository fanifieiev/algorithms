from typing import List


class RPNExpressionEvaluator:
    OPERANDS_PRIORITIES = {
        '(': 0,
        ')': 1,
        '+': 2,
        '-': 2,
        '*': 3,
        '/': 3
    }

    FUNACTIONS = {
        '+': (lambda a, b: a + b),
        '-': (lambda a, b: a - b),
        '*': (lambda a, b: a * b),
        '/': (lambda a, b: a / b)
    }

    def __calculate_by_postfix(self, expressions: List[str]) -> str:
        stack = []
        for ch in expressions:
            if self.OPERANDS_PRIORITIES.get(ch) is None:
                stack.append(ch)
            else:
                second = stack.pop()
                first = stack.pop()
                fun = self.FUNACTIONS[ch]
                result = fun(int(first), int(second))
                stack.append(str(result))

        return ''.join(stack)

    def calculate_by_postfix(self, postfix_notation: str) -> str:
        return self.__calculate_by_postfix(expressions=postfix_notation.split(sep=' '))

    def evaluate_postfix_by_infix(self, infix_expression: str) -> str:
        values: list = []
        operations: list = []

        def priority(ch: chr) -> int:
            return self.OPERANDS_PRIORITIES[ch] or -1

        for ch in infix_expression:
            if ch.isalnum():
                values.append(ch)
            elif ch == '(':
                operations.append(ch)
            elif ch == ')':
                op = operations.pop()
                while op != '(':
                    values.append(op)
                    op = operations.pop()
            else:
                stop = False
                while not stop:
                    if not operations or priority(operations[-1]) < priority(ch):
                        operations.append(ch)
                        stop = True
                    else:
                        op = operations.pop()
                        values.append(op)

        while operations:
            values.append(operations.pop())

        return ''.join(values)
