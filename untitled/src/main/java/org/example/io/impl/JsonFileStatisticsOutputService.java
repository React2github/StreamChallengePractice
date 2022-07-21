package org.example.io.impl;

import java.io.FileWriter;

import org.example.io.StatisticsOutputService;
import org.example.statistics.model.TextStatistics;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileStatisticsOutputService implements StatisticsOutputService {
    private final static String OUTPUT_FILE_NAME = "statistics.json";

    @Override
    public void save(TextStatistics statistics) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(OUTPUT_FILE_NAME, true);
            String json = new ObjectMapper().writeValueAsString(statistics);
            fileWriter.write(json);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
