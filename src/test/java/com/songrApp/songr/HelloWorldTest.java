package com.songrApp.songr;

import com.songrApp.songr.controller.RoutesController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class HelloWorldTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    RoutesController helloTest;
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

    @Test
    public void testLoading() throws Exception{
        assertThat(helloTest).isNotNull();
    }

    @Test
    public void testGreetingReturnData() throws Exception{
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/hello",
                String.class)).contains("hello, world!");
    }

    @Test
    public void testRequestStatusAndReturn() throws Exception{
        this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello, world!")));
    }
}
