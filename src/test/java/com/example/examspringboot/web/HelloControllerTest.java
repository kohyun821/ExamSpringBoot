package com.example.examspringboot.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.example.examspringboot.web.HelloController;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootConfiguration
//@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
@ContextConfiguration(classes = HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        String hello = "hello";
        mockMvc.perform(get("/hello"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(hello));

    }

    @Test
    void helloDtoReturn() throws Exception {
        String name = "hello";
        int amount = 500;

        mockMvc.perform(get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));

    }
}