package org.example.statistics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.statistics.model.TextStatistics;

public class TextStatisticsService {
    public TextStatistics getStatistics(String text) {
        TextStatistics textStatistics = new TextStatistics();
        // This section is for longest word
        int longestWordSoFar = 0;
        List <String> words = Arrays.asList(text.split("[^\\w']+"));
        longestWordSoFar = words.stream().max(Comparator.comparingInt(String::length)).get().length();
        // return textStatistics;
        // This section is average word length
        double averageWordLength = 0;
        averageWordLength = words.stream().mapToInt(word -> word.length()).average().getAsDouble();
        // This section is for most common word 
        Map<String,Integer> map = new HashMap<>();
         for(int i=0; i< words.size(); i++) {
                map.put(words.get(i), map.getOrDefault(words.get(i), -1)+1);
         }
         System.out.println(map.size());
         int numberOfOccurances = 0;
         String mostCommonWord = null;
         for( String word : map.keySet()) {
            if(map.get(word) > numberOfOccurances) {
                mostCommonWord = word;
                numberOfOccurances = map.get(word);
            }
         }
         textStatistics.setAverageWordLength(averageWordLength);
         textStatistics.setLongestWordLength(longestWordSoFar);
         textStatistics.setMostCommonWord(mostCommonWord);
         return textStatistics;
    }
}
