package com.mlogic.suggestions;

public class SuggesstionBuilderTest {
	
	public static void main(String[] args) {
		SuggestionsBuilder sb = new SuggestionsBuilder();
		sb.addTokens("The", "beautiful", "girl", "from", "the", "farmers", "market", ".", "I", "like",
				"chewing", "gum", ".");
		sb.addStopWords("is", "a", "can", "the");
		System.out.println(sb.getSuggestions());
	}
}