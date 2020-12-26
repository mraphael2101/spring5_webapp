package com.example.spring5webapp.controllers;

import com.example.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/templates/authors/authors")
    public String getAuthors(Model model){

        model.addAttribute("templates/authors/authors", authorRepository.findAll());

        return "templates/authors/authors/list";
    }
}
