package com.example.bookservice.controllers;

import com.example.bookservice.entities.Book;
import com.example.bookservice.repositories.BookRepository;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;
    @Autowired
    private BookRepository repository;

    @GetMapping("/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id,
                         @PathVariable("currency") String currency){

        Optional<Book> book = repository.findById(id);

        book.ifPresent(b -> {
            b.setCurrency(currency);
            b.setEnvironment(environment.getProperty("local.server.port"));
            log.info(b.toString());
        });

        return book.orElseThrow(() -> new RuntimeException("Book not found"));
    }
}
