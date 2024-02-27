import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.makeHelperSheets();
    }

    public void makeHelperSheets() {
        try {
            FileInputStream fis = new FileInputStream("Bracket.xlsx");
            Workbook wb = new XSSFWorkbook(fis);
            ArrayList<Sheet> sheetArrayList = new ArrayList<>();
            Sheet helper = wb.createSheet("Helper");
            Sheet sample = wb.createSheet("Sample");
            Sheet bracket = wb.createSheet("Bracket");
            sheetArrayList.add(helper);
            sheetArrayList.add(sample);
            sheetArrayList.add(bracket);
            for (Sheet sheet : sheetArrayList) {
                for (int row = 0; row < 66; row++) {
                    sheet.createRow(row);
                    for (int col = 0; col < 15; col++) {
                        sheet.getRow(row).createCell(col);
                    }
                }
            }

            int count = 0;
            for (int i = 1; i < 65; i++, count++) {
                switch (i) {
                    case (1) -> count = 19;
                    case (17) -> count = 2;
                    case (34) -> count = 51;
                    case (50) -> count = 35;
                }
                Row row = helper.getRow(i);
                Cell cell = row.getCell(3);
                cell.setCellFormula("=[Official_2024_List.xlsx]Sheet1!C" + count);
                cell = row.getCell(2);
                if (i == 33) {
                    i--;
                }
                cell.setCellValue((i % 16) + 1);
            }
            for (int i = 1; i < 3; i++) {
                Row row = helper.getRow(i);
                Cell cell = row.getCell(0);
                cell.setCellFormula("=[Official_2024_List.xlsx]Sheet1!C" + (17 + i - 1));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}