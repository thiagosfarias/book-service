package com.example.bookservice;

import com.example.bookservice.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
class BookServiceApplicationTests {

    @Test
    void contextLoads() {
        Book book = Book.builder()
                .title("Teste Book")
                .author("Thiago Farias")
                .launchDate(LocalDateTime.now())
                .id(1L)
                .build();

        log.info(book.toString());
    }

}
