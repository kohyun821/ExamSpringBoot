package com.example.examspringboot.web.dto;

import org.junit.Test;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class HelloResponseDtoTest {

    @Test
    public void lombok_Test(){
        String name = "Test";
        int amount = 100;

        HelloResponseDto dto = new HelloResponseDto(name,amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}