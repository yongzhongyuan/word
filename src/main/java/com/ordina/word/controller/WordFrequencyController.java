package com.ordina.word.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ordina.word.analyzer.WordFrequency;
import com.ordina.word.service.WordFrequencyService;

@RestController
public class WordFrequencyController {

	@Autowired
	WordFrequencyService wordFrequencyService;

	@GetMapping(value = "/calculateHighestFrequency/{text}", headers = "Accept=application/json", produces = "application/json;charset=utf-8")
	public int calculateHighestFrequency(@PathVariable("text") String text) {
		return wordFrequencyService.calculateHighestFrequency(text);
	}

	@GetMapping(value = "/calculateFrequencyForWord/{word}/{text}", headers = "Accept=application/json", produces = "application/json;charset=utf-8")
	public int calculateFrequencyForWord(@PathVariable("text") String text, @PathVariable("word") String word) {
		return wordFrequencyService.calculateFrequencyForWord(text, word);
	}

	@GetMapping(value = "/calculateMostFrequentNWords/{number}/{text}", headers = "Accept=application/json", produces = "application/json;charset=utf-8")
	public WordFrequency[] calculateMostFrequentNWords(@PathVariable("text") String text,
			@PathVariable("number") int number) {
		return wordFrequencyService.calculateMostFrequentNWords(text, number);
	}
}
