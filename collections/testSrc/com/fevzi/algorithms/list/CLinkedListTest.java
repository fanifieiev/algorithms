package com.fevzi.algorithms.list;

import org.junit.Test;

import com.fevzi.algorithms.list.CLinkedList;
import static org.hamcrest.MatcherAssert.assertThat;

public class CLinkedListTest {

	@Test
	public void shouldCreateLinkedListWithValues() {
		CLinkedList<Integer> list = new CLinkedList<>();
		list.add(1);
		list.add(2);
		assertThat("List should contain 2 integers", list.size() == 2);
	}
	
	@Test
	public void shouldGetCorrectly() {
		CLinkedList<Integer> list = new CLinkedList<>();
		list.add(1);
		list.add(2);
		assertThat("Should get 1", list.get(0).equals(1));
		assertThat("Should get 2", list.get(1).equals(2));
	}
	
	@Test
	public void shouldRevertLinkedList() {
		CLinkedList<Integer> list = new CLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		CLinkedList<Integer> revertedList = list.reverse();
		assertThat("Should get 3", revertedList.get(0).equals(3));
		assertThat("Should get 2", revertedList.get(1).equals(2));
		assertThat("Should get 1", revertedList.get(2).equals(1));
	}
	
	@Test
	public void shouldAddAndRemoveElements() {
		CLinkedList<Integer> list = new CLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(1);
		
		assertThat("Size should be siezed", list.size() == 2);
		assertThat("Should get 1", list.get(0).equals(1));
		assertThat("Should get 3", list.get(1).equals(3));
	}
}
