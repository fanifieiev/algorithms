#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Tests for `binarytree` package."""

import pytest

from binarytree.binarytree.BinaryTree import BinaryTree


@pytest.fixture
def btree_should_insert():
    bst = BinaryTree(10)
    bst.insert(12)
    bst.insert(3)
    bst.insert(2)

    assert bst.root.right.value == 12
    assert bst.root.left.value == 3
