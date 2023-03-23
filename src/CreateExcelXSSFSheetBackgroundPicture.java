import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import org.apache.poi.util.IOUtils;

public class CreateExcelXSSFSheetBackgroundPicture {

    public static void main(String[] args) throws Exception {

        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream out = new FileOutputStream("C:\\Users\\ks4292\\IdeaProjects\\Mam\\Bracket.xlsx")) {

            XSSFSheet sheet = workbook.createSheet("Sheet1");

            //add picture data to this workbook.
            FileInputStream is = new FileInputStream("C:\\Users\\ks4292\\IdeaProjects\\Mam\\img\\2023MMMBracket_v1_0_English.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();

            //add relation from sheet to the picture data
            String rID = sheet.addRelation(null, XSSFRelation.IMAGES, workbook.getAllPictures().get(pictureIdx))
                    .getRelationship().getId();
            //set background picture to sheet
            sheet.getCTWorksheet().addNewPicture().setId(rID);

            workbook.write(out);

        }

    }
}