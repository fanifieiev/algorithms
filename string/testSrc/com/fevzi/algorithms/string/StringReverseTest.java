package com.fevzi.algorithms.string;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringReverseTest {

	@Test
	public void shouldReverseStringRecursively() {
		assertReversed(new RecursiveStringReverser(), "1234567890", "0987654321");
	}

	@Test
	public void shouldReverseStringWithSwapping() {
		assertReversed(new SwappingStringReverser(), "1234567890", "0987654321");
	}

	private void assertReversed(StringReverser stringReverser, String original, String expected) {
		String reverted = stringReverser.reverse(original);
		assertThat("Should be reversed", expected.equals(reverted));
	}
}
