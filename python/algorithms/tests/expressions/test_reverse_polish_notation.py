import unittest

from algorithms.expr.evaluations import RPNExpressionEvaluator


class TestReversePolishNotation(unittest.TestCase):

    def test_postfix_expr_from_infix(self):
        expr = "1+(2-1)*9"
        evaluator = RPNExpressionEvaluator()
        notation = evaluator.evaluate_postfix_by_infix(expr)
        self.assertEqual(notation, "121-9*+")

    def test_evaluate_expr_by_postfix(self):
        expr = ' '.join(["10","6","9","3","+","-11","*","/","*","17","+","5","+"])
        evaluator = RPNExpressionEvaluator()
        value = evaluator.calculate_by_postfix(expr)
        self.assertEqual(value, "6")

    def test_evaluate_expr_by_postfix_2(self):
        expr = "495/+"
        evaluator = RPNExpressionEvaluator()
        value = evaluator.calculate_by_postfix(expr)
        self.assertEqual(value, "10")

