package com.grishiya.nth_min_service.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExcelReaderTest {
    @Test
    void readIntegers_ok() throws IOException {

        Path path = Path.of("src/test/resources/testtask.xlsx");

            ExcelReader reader = new ExcelReader();

            List<Integer> result = reader.readIntegers(path);
            assertEquals(List.of(11,
                    23,
                    4,
                    53,
                    4,
                    7,
                    1,
                    32,
                    6), result);
            System.out.println("прочитано: " + result);

        }
    }
