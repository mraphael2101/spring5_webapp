package com.example.spring5webapp.controllers;

import com.example.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Tells Spring our intent is to make this a Spring specific controller
@Controller
public class BookController {

    private final BookRepository bookRepository;

    // Using Spring dependency injection to inject an instance of our book repository into the controller via the constructor
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Run getBooks method when we perform an action by the URL books
    @RequestMapping("/books")
    public String getBooks(Model model){

        // Add the attribute books to our model
        model.addAttribute("books", bookRepository.findAll());

        return "books/list"; // tells spring to apply a view under the directory of 'books/list.html'
    }
}
