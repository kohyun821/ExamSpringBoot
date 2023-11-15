package com.example.examspringboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public  interface PostRepository extends JpaRepository<Posts,Long> {
}
