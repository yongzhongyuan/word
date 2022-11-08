package com.ordina.word.analyzer;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {
	private static final Logger logger = Logger.getLogger(WordFrequencyAnalyzerImpl.class);
	private int highestFrequence = 0;

	@Override
	public int calculateHighestFrequency(String text) {
		try {
			getWordWithFrequency(text).forEach((k, v) -> {
				if (v > highestFrequence) {
					highestFrequence = v;
				}
			});
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return highestFrequence;
	}

	@Override
	public int calculateFrequencyForWord(String text, String word) {
		try {
			return getWordWithFrequency(text).get(word.trim().toLowerCase());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return 0;
		}
	}

	@Override
	public WordFrequency[] calculateMostFrequentNWords(String text, int n) {
		try {
			List<Map.Entry<String, Integer>> result = getWordWithFrequency(text).entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(n)
					.collect(Collectors.toList());
			WordFrequency[] wordFrquency = new WordFrequency[result.size()];
			int i = 0;
			for (Map.Entry<String, Integer> entry : result) {
				wordFrquency[i] = new WordFrequency() {

					@Override
					public String getWord() {
						return entry.getKey();
					}

					@Override
					public int getFrequency() {
						return entry.getValue();
					}

				};
				i++;
			}
			return wordFrquency;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}
	}

	public Map<String, Integer> getWordWithFrequency(String text) throws Exception {
		Map<String, Integer> wordMap = new TreeMap<>();
		if (text != null) {
			// remove all punctuation and line break, then splitting text by word
			String arr[] = text.replaceAll("\\p{Punct}", "").replace("\n", "").replace("\r", "").split(" ");

			// Loop to iterate over the words
			for (int i = 0; i < arr.length; i++) {
				// check if array element in hash-map
				String currentWord = arr[i].toLowerCase();
				if (wordMap.containsKey(currentWord)) {
					wordMap.put(currentWord, wordMap.get(currentWord) + 1);
				} else {
					wordMap.put(currentWord, 1);
				}
			}
		}
		return wordMap;
	}
}
