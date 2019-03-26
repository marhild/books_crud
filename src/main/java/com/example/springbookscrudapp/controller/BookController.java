package com.example.springbookscrudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping( path = "/")
    public String showIndex() {
        return "index";
    }
}
