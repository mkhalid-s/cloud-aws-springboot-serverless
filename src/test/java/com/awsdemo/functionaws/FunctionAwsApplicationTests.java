package com.awsdemo.functionaws;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class FunctionAwsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void checkReverseString() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/reverseString")
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content("SpringBoot")
        ).andReturn();

        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(result)).
                andExpect(MockMvcResultMatchers.content().string("tooBgnirpS"));

    }

    @Test
    public void failCheckReverseString() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/reverseString")
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content("SpringBoot")
        ).andReturn();

        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(result)).
                andExpect(MockMvcResultMatchers.content().string("tooBgnirpS"));

    }

}
