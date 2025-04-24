package com.grishiya.nth_min_service.controller;

import com.grishiya.nth_min_service.exception.InvalidNAppException;
import com.grishiya.nth_min_service.service.NumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Path;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MinController.class)
class MinControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    NumberService service;

    Path path = Path.of("C:/dummy/file.xlsx");
@BeforeEach
    void setUp() throws Exception {
        Mockito.when(service.findNthMin(path, 3)).thenReturn(4);
        Mockito.when(service.findNthMin(path, 0))
                .thenThrow(new InvalidNAppException(0, 1));
    }

    @Test
    void okRequest_returnsJson() throws Exception {
        mockMvc.perform(get("/api/nth-min")
                        .param("path", path.toString())
                        .param("n", "3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(4));
    }
    @Test
    void badRequest_whenNWrong() throws Exception {
        mockMvc.perform(get("/api/nth-min")
                        .param("path", path.toString())
                        .param("n", "0"))
                .andExpect(status().isBadRequest());
    }
}