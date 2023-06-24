
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;

class Main {
    public static void downloadFile(URL url, String outputFileName) throws IOException {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    public static void main(String[] args) {
    }

    public void downloadTemplate() {
        try {
            downloadFile(new URL("https://libapps.s3.amazonaws.com/accounts/46633/images/March_Mammal_Madness_2023_Bracket_v1_0_English.png"), "Resources\\2023_Template.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void downloadPNG() {
        try {
            downloadFile(new URL("https://libguides.asu.edu/ld.php?content_id=70694104"), "Resources\\Official_2023_List.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void makeHelperSheets() {
        try {
            FileInputStream fis = new FileInputStream("Bracket.xlsx");
            Workbook wb = new XSSFWorkbook(fis);
            ArrayList<Sheet> sheetArrayList = new ArrayList<>();
            sheetArrayList.add(wb.createSheet("Helper"));
            sheetArrayList.add(wb.createSheet("Sample"));
            sheetArrayList.add(wb.createSheet("Bracket"));
            for (Sheet sheet: sheetArrayList) {
                for (int row = 0; row < 75; row++) {
                    sheet.createRow(row);
                    for (int col = 0; col < 25; col++) {
                        sheet.getRow(row).createCell(col);
                    }
                }
            }


            for (int i = 0; i < 64; i++) {
                XSSFRow row = (XSSFRow) sheetArrayList.get(0).getRow(3);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}