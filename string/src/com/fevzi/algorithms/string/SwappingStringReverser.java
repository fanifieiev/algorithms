package com.fevzi.algorithms.string;

public final class SwappingStringReverser implements StringReverser {

	@Override
	public String reverse(String s) {
		char[] chars = s.toCharArray();
		int head = 0;
		int tail = s.length() - 1;

		while (head < tail) {
			if (chars[head] != chars[tail]) {
				char tmp = chars[head];
				chars[head] = chars[tail];
				chars[tail] = tmp;
			}
			head++;
			tail--;
		}
		return String.valueOf(chars);
	}

}
