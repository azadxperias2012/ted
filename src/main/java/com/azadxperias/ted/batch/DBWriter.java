package com.azadxperias.ted.batch;

import com.azadxperias.ted.model.TedEvent;
import com.azadxperias.ted.repository.TedEventRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<TedEvent> {
    @Autowired
    private TedEventRepository tedEventRepository;

    @Override
    public void write(List<? extends TedEvent> tedEvents) throws Exception {
        tedEventRepository.saveAll(tedEvents);
    }
}
