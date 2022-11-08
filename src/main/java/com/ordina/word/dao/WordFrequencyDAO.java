package com.ordina.word.dao;

import org.springframework.stereotype.Repository;

import com.ordina.word.analyzer.WordFrequency;
import com.ordina.word.analyzer.WordFrequencyAnalyzerImpl;

@Repository
public class WordFrequencyDAO {

  public int calculateHighestFrequency(String text) {
	  return new WordFrequencyAnalyzerImpl().calculateHighestFrequency(text);
  }
  
  public int calculateFrequencyForWord(String text, String word) {
	  return new WordFrequencyAnalyzerImpl().calculateFrequencyForWord(text, word);
  }
  
  public WordFrequency[] calculateMostFrequentNWords(String text, int n) {
	  return new WordFrequencyAnalyzerImpl().calculateMostFrequentNWords(text, n);
  }
}
