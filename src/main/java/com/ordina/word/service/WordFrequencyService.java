package com.ordina.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordina.word.analyzer.WordFrequency;
import com.ordina.word.dao.WordFrequencyDAO;

@Service("wordFrequencyService")
public class WordFrequencyService {

	@Autowired
	WordFrequencyDAO wordFrequencyDao;

	public int calculateHighestFrequency(String text) {
		return wordFrequencyDao.calculateHighestFrequency(text);
	}

	public int calculateFrequencyForWord(String text, String word) {
		return wordFrequencyDao.calculateFrequencyForWord(text, word);
	}

	public WordFrequency[] calculateMostFrequentNWords(String text, int n) {
		return wordFrequencyDao.calculateMostFrequentNWords(text, n);
	}

}
