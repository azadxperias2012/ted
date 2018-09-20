package com.azadxperias.ted.util;

import com.azadxperias.ted.model.Rating;
import com.azadxperias.ted.model.RelatedTalk;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ConversionUtil {
    public static List<Rating> convertToRatings(String jsonString) {
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

    public static List<RelatedTalk> convertToRelatedTalks(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        List<RelatedTalk> relatedTalks = new ArrayList<>();
        try {
            relatedTalks = objectMapper.readValue(jsonString.replaceAll("\\\\xa0", "&#xA0;"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, RelatedTalk.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return relatedTalks;
    }

    public static List<String> convertToStringList(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        List<String> stringList = new ArrayList<>();
        try {
            stringList = objectMapper.readValue(jsonString,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, String.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
