package com.fevzi.algorithms.btree;

import org.junit.Test;

import com.fevzi.algorithms.tree.Node;
import com.fevzi.algorithms.tree.Tree;

import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryTreeTest {

	@Test
	public void shouldContain3Nodes() {
		final Tree<Integer> tree = new BinaryTree<>(10);
		tree.insert(5);
		tree.insert(3);

		assertThat("Left side of root node", tree.find(10).getLeft().getLeft().getValue().equals(3));
		assertThat("Right side of root node", tree.find(10).getRight() == null);
	}
	
	@Test
	public void shouldFindMinAndMaxValues() {
		final Tree<Integer> tree = new BinaryTree<>(10);
		tree.insert(5);
		tree.insert(3);

		final Node<Integer> minValue = tree.findMin();
		assertThat("Min Value", minValue.getValue().equals(3));
		
		final Node<Integer> maxValue = tree.findMax();
		assertThat("Max Value", maxValue.getValue().equals(10));
	}
	
	@Test
	public void shouldEvaluateDepth() {
		final Tree<Integer> tree = new BinaryTree<>(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(12);

		final int depth = tree.depth();
		assertThat("Depth", depth == 3);
	}
	
	@Test
	public void shouldWalkThruTree() {
		final Tree<Integer> tree = new BinaryTree<>(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(12);
		tree.insert(2);
		
		System.out.println(tree.list());
	}
}
