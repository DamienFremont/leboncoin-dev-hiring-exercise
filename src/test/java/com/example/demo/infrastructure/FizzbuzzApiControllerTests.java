package com.example.demo.infrastructure;

import com.example.demo.core.application.ComputeFizzbuzzInboundPort;
import com.example.demo.core.domain.FizzbuzzRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.demo.helpers.TestDatas.buildCase1Request;
import static com.example.demo.helpers.TestDatas.buildCase1Response;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FizzbuzzApiController.class)
class FizzbuzzApiControllerTests {

    @MockBean
    ComputeFizzbuzzInboundPort fizzbuzzUseCase;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test_writeFizzBuzz_exerciceUseCase_HTTP200() throws Exception {
        // GIVEN
        var response = buildCase1Response();
        var request = buildCase1Request() ;
        when(fizzbuzzUseCase.writefizzbuzz(any())).thenReturn(response);
        // WHEN
        mockMvc.perform(post("/api/v1/fizzbuzz")
                        .content(asJsonString(request))
                        .contentType(APPLICATION_JSON))
                // THEN
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.list", hasSize(16)))
                .andExpect(jsonPath("$.list[0]", is(response.getList()[0])))
                .andExpect(jsonPath("$.list[1]", is(response.getList()[1])))
                .andExpect(jsonPath("$.list[2]", is(response.getList()[2])));
    }

    @Test
    public void test_Given_NoRequest_Then_error_HTTP400() throws Exception {
        // WHEN
        mockMvc.perform(post("/api/v1/fizzbuzz"))
                // THEN
                .andExpect(status().isBadRequest());
    }

    @Test
    public void test_Given_EmptyRequest_Then_error_HTTP400() throws Exception {
        // GIVEN
        var request = new FizzbuzzRequest();
        // WHEN
        mockMvc.perform(post("/api/v1/fizzbuzz")
                        .content(asJsonString(request))
                        .contentType(APPLICATION_JSON))
                // THEN
                .andExpect(status().isBadRequest());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}