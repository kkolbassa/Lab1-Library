package org.example.excelProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;


public class ExcelReader {
    public static ArrayList<String> read(String path, Integer column) {
        ArrayList<String> result = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();
            for (Row row : sheet) {
                Cell cell = row.getCell(column);
                if (cell != null) {
                    String surname = formatter.formatCellValue(cell).trim();
                    result.add(surname);
                }
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}