# word
count word frequency

Framework:
  Maven Spring Boot

Endpoints:
1)Calculate highest frequency:
  Example: http://localhost:8080/calculateHighestFrequency/test%20the%20highest%20frequency%20word
     
2)Calculate frequency for word: /calculateFrequencyForWord/{word}/{text}
  Example: http://localhost:8080/calculateFrequencyForWord/word/test%20the%20highest%20frequency%20word,%20find%20the%20frequent%20word

3)Calculate most frequent words: /calculateMostFrequentNWords/{number}/{text}
 Example: http://localhost:8080/calculateMostFrequentNWords/2/test%20the%20highest%20frequency%20word,%20find%20the%20frequent%20word
