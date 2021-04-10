package com.awsdemo.functionaws;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

//@SpringBootTest
@FunctionalSpringBootTest
//@AutoConfigureMockMvc
@AutoConfigureWebClient
class FunctionAwsApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void contextLoads() {
    }

    @Test
    public void checkReverseString() {
        webTestClient.post().uri("/reverseString")
                .body(Mono.justOrEmpty("SpringBoot"), String.class)
                .exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("tooBgnirpS");
        /*MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/reverseString")
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content("SpringBoot")
        ).andReturn();*/

        /*mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(result)).
                andExpect(MockMvcResultMatchers.content().string("tooBgnirpS"));*/

    }

/*    @Test
    public void failCheckReverseString() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/reverseString")
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content("SpringBoot")
        ).andReturn();

        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(result)).
                andExpect(MockMvcResultMatchers.content().string("tooBgnirpS"));

    }*/

}
