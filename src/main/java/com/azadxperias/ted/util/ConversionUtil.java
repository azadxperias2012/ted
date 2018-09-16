package com.azadxperias.ted.util;

import com.azadxperias.ted.model.Rating;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ConversionUtil {
    public static List<Rating> convert(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        List<Rating> ratings = new ArrayList<>();
        try {
            ratings = objectMapper.readValue(jsonString,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Rating.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ratings;
    }
}
