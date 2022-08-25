package com.example.bookservice.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "launch_date", nullable = false)
    private LocalDateTime launchDate;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Transient
    private String currency;
    @Transient
    private String environment;



}
