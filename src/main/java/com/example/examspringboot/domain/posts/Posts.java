package com.example.examspringboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Posts {
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
    public Posts(String title, String content, String author){
        this.title = title;
        this.author = author;
        this.content = content;
    }
}
