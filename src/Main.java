import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

class Main {
//    public static void downloadFile(URL url, String outputFileName) throws IOException {
//        try (InputStream in = url.openStream();
//             ReadableByteChannel rbc = Channels.newChannel(in);
//             FileOutputStream fos = new FileOutputStream(outputFileName)) {
//            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//        }
//    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.downloadTemplate();
//        main.downloadPNG();
        main.makeHelperSheets();
    }

//    public void downloadTemplate() {
//        try {
//            downloadFile(new URL("https://libapps.s3.amazonaws.com/accounts/46633/images/March_Mammal_Madness_2023_Bracket_v1_0_English.png"), "2024_Template.png");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public void downloadPNG() {
//        try {
//            downloadFile(new URL("https://libguides.asu.edu/ld.php?content_id=70694104"), "Official_2023_List.xlsx");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

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