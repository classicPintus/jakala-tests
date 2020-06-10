package com.jakala;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseIntegrationTest {
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected MockMvc mvc;

    protected ResultActions doRequest(MockHttpServletRequestBuilder requestWithUrl, Object body) throws Exception {

        MockHttpServletRequestBuilder requestBuilder = requestWithUrl.contentType(MediaType.APPLICATION_JSON);

        if (body != null) {
            if (body instanceof String) {
                requestBuilder = requestBuilder.content(body.toString());
            } else {
                requestBuilder = requestBuilder.content(objectMapper.writeValueAsString(body));
            }
        }

        return mvc.perform(requestBuilder);
    }

}
