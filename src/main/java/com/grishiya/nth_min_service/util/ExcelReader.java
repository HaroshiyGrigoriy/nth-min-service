package com.grishiya.nth_min_service.util;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public List<Integer> readIntegers(Path path) throws IOException {
        List<Integer> result = new ArrayList<>();

        try(Workbook wb = WorkbookFactory.create(Files.newInputStream(path))){
            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    result.add((int) cell.getNumericCellValue());
                }
            }
        }
        return result;
    }

}
