package com.fevzi.algorithms.string;

public interface SubStringFinder {

	/**
	 * Returns true if the sub string found otherwise false 
	 * @param originalString
	 * @param subString
	 * @return boolean
	 */
	boolean hasAtLeastOne(String originalString, String subString);
	
	/**
	 * Returns the number of occurrences a substring is met in the original string 
	 * @param originalString
	 * @param subString
	 * @return int
	 */
	int findOccurrences(String originalString, String subString);
}
