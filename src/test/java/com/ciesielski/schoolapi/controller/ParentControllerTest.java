package com.ciesielski.schoolapi.controller;

import com.ciesielski.schoolapi.presentation.dto.ParentBillDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ParentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetParentBillForMonth() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/getParentBillForMonth")
                        .param("id", "1")
                        .param("month", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is(200))
                .andReturn();

        //then
        ParentBillDto parentBillDto = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ParentBillDto.class);

        Assertions.assertNotNull(parentBillDto);
        Assertions.assertNotNull(parentBillDto.getParent());
        Assertions.assertNotNull(parentBillDto.getFullCost());
        Assertions.assertNotNull(parentBillDto.getChildrenBills());

        Assertions.assertEquals(1, parentBillDto.getParent().getId());
    }
}
