package com.example.examspringboot.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
public class posts {
    //PK 구분자
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //제목
    @Column(length = 500, nullable = false)
    private String title;

    //내용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    //작성자
    private String author;

    @Builder
    public posts(String title, String content, String author){
        this.title = title;
        this.author = author;
        this.content = content;
    }
}
