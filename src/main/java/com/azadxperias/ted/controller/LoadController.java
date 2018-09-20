package com.azadxperias.ted.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadController {

    @GetMapping
    public String load() {
        return "Batch job completed on startup";
    }

}
