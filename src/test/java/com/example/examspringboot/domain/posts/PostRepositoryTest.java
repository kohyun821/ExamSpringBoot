package com.example.examspringboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//@RunWith(SpringRunner.class)
@SpringBootTest()
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;
    @After
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void load_content(){
        //given
        String title="테스트 게시글";
        String content="테스트 본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("asdf@naver.com")
                .build());

        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}