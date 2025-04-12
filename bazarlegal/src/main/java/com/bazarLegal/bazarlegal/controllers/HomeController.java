package com.bazarLegal.bazarlegal.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String principal(Model m) throws SQLException {

        return "home/home";

    }

}
