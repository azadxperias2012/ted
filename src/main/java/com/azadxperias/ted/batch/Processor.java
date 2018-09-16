package com.azadxperias.ted.batch;

import com.azadxperias.ted.model.Rating;
import com.azadxperias.ted.model.TedEvent;
import com.azadxperias.ted.util.ConversionUtil;
import org.codehaus.jettison.json.JSONArray;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Processor implements ItemProcessor<TedEvent, TedEvent> {

    public Processor() {
    }

    @Override
    public TedEvent process(TedEvent tedEvent) throws Exception {
        //1151367060
        String publishedDate = tedEvent.getPublishedDate();
//        String ratings = tedEvent.getRatings();
//        List<Rating> ratingList = ConversionUtil.convert(ratings);
//        tedEvent.setTedEventRatings(ratingList);
        String views = tedEvent.getViews();
        views = views.replaceAll("\",", "");
        tedEvent.setViews(views);
        return tedEvent;
    }
}
