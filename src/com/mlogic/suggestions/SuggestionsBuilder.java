
package com.mlogic.suggestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author amarnath pant
 * SuggestionBuilder is a class which takes stopWords (ignored strings) and tokens (sentences)
 * To filter out the suggestion from the sentences by ignoring the stopWords as well as punctuations.
 */
public class SuggestionsBuilder {
	
	//List to hold the stop words
	private List<String>	stopWords		= new ArrayList<String>();
	
	//List to hold the tokens
	private List<String>	tokensS			= new ArrayList<String>();
	
	//pre defined punctuations
	private List<String>	punctuations	= new ArrayList<String>();
	
	//Constructor to initialize the punctuations
	//we can have resourced punctuations
	public SuggestionsBuilder() {
		punctuations.addAll(Arrays.asList(".", ":", "?", "I"));
	}
	
	
	/**
	 * Add words to stop words list
	 * @param words
	 * @return
	 */
	public boolean addStopWords(String... words) {
		return stopWords.addAll(Arrays.asList(words).stream().map(String::toLowerCase)
		        .collect(Collectors.toList()));
	}
	
	/**
	 * Add words to Token list 
	 * @param words
	 * @return boolean
	 */
	public boolean addTokens(String... words) {
		return tokensS.addAll(Arrays.asList(words));
	}
	
	/**
	 * 
	 * @return list of suggestions by eliminating the stopwords and punctuations
	 */
	public List<String> getSuggestions() {
		List<String> suggetions = new ArrayList<>();
		String currSuggetion = "";
		for(String token : tokensS) {
			boolean isStopWord = stopWords.contains(token.toLowerCase());
			boolean isPunctuation = punctuations.contains(token);
			if (!isStopWord && !isPunctuation) {
				if (!currSuggetion.isEmpty()) {
					currSuggetion = currSuggetion + " " + token;
				} else {
					currSuggetion = token;
				}
				suggetions.add(currSuggetion);
			} else {
				currSuggetion = "";
			}
		}
		return suggetions;
	}
}