package com.jakala.integration;

import com.jakala.BaseIntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class LocalDateRestControllerDifferenceInDaysIT extends BaseIntegrationTest {

    @Test
    public void shouldHaveNoDifference() throws Exception {

        ResultActions resultActions = doRequest(MockMvcRequestBuilders.get("/difference-in-days")
                        .param("from", "2020-01-01")
                        .param("to", "2020-01-01")
                , null);

        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$").value(0));
    }

    @Test
    public void shouldBeBadRequestBecauseTheFromParameterIsMissing() throws Exception {

        ResultActions resultActions = doRequest(MockMvcRequestBuilders.get("/difference-in-days")
                        .param("to", "2020-01-01")
                , null);

        resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldBeBadRequestBecauseTheToParameterIsMissing() throws Exception {

        ResultActions resultActions = doRequest(MockMvcRequestBuilders.get("/difference-in-days")
                        .param("from", "2020-01-01")
                , null);

        resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}