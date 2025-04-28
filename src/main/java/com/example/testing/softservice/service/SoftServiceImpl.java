package com.example.testing.softservice.service;

import com.example.testing.softservice.model.RequestData;
import com.example.testing.softservice.utils.ListSort;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SoftServiceImpl implements SoftService {

    @Override
    public Long findMinimumElement(RequestData requestBody) {
        List<Long> numbers = new ArrayList<>();

        try (FileInputStream inputStream = new FileInputStream(requestBody.getPathFile())) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            int numberOfSheets = workbook.getNumberOfSheets();

            for(int i = 0; i < numberOfSheets; i++){
                Sheet sheet  = workbook.getSheetAt(i);
                fillQueueWithSheet(numbers, sheet);
            }

            sortList(numbers);

            return findMinElementByN(requestBody.getN(), numbers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void fillQueueWithSheet(List<Long> list, Sheet sheet) {
        for (Row row : sheet) {
            Cell cell = row.getCell(0);

            if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                Long numericValue = (long) cell.getNumericCellValue();
                list.add(numericValue);
            }
        }
    }

    private void sortList(List<Long> list) {
        ListSort.mergeSort(list);
    }

    private Long findMinElementByN(int n, List<Long> list) {
        if (n < 1 || list.size() < n) {
            throw new RuntimeException("Некорректное значение N");
        }

        return list.get(n - 1);
    }
}
