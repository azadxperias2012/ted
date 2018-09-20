package com.azadxperias.ted.controller;

import com.azadxperias.ted.model.TedEvent;
import com.azadxperias.ted.repository.TedEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("tedevent")
@CrossOrigin
public class TedEventController {

    @Autowired
    TedEventRepository tedEventRepository;

    @GetMapping("/all")
    public List<TedEvent> findAll() {
        //Long pages = tedEventRepository.count() % 100;
        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        return tedEventRepository.findAllById(Arrays.asList(ids));
    }

    @GetMapping("/page/{number}")
    public Page<TedEvent> findAllByPage(@PathVariable("number") int number) {
        System.out.println(tedEventRepository.count());
        PageRequest pageRequest = PageRequest.of(number, 5);
        return tedEventRepository.findAll(pageRequest);
    }

}
