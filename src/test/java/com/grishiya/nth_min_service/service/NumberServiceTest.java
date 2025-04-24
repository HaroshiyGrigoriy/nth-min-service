package com.grishiya.nth_min_service.service;

import com.grishiya.nth_min_service.exception.InvalidNAppException;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {
    NumberService service = new NumberService();
    Path file = Path.of("src/test/resources/testtask.xlsx");

    @Test
    void returnsCorrectNthMin() throws Exception {
        assertAll(
                () -> assertEquals(1, service.findNthMin(file, 1)),
                () -> assertEquals(4, service.findNthMin(file, 2)),
                () -> assertEquals(4, service.findNthMin(file, 3)),
                () -> assertEquals(6, service.findNthMin(file, 4)),
                () -> assertEquals(7, service.findNthMin(file, 5))
        );
    }
    @Test
    void throwsWhenNOutOfRange() {
        InvalidNAppException ex = assertThrows(
                InvalidNAppException.class,
                () -> service.findNthMin(file, 99)   // 99 > 9 элементов
        );
        assertTrue(ex.getMessage().contains("диапазоне"));
    }
}