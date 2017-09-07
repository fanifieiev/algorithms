package com.fevzi.algorithms.string;

public final class RecursiveStringReverser implements StringReverser {

	@Override
	public String reverse(String s) {
		if (s.length() == 1) {
			return s;
		} else {
			return reverse(s.substring(1)) + s.charAt(0);
		}
	}

}
