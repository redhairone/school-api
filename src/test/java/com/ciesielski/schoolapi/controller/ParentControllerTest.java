package com.ciesielski.schoolapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@AutoConfigureMockMvc
@SpringBootTest
public class ParentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetParentBillForMonth() throws Exception {
        //given
        //when
        mockMvc.perform(
                MockMvcRequestBuilders.get("/getParentBillForMonth")
                        .param("id", "1")
                        .param("month", "1"))
                .andDo(MockMvcResultHandlers.print());
        //then
    }
}
