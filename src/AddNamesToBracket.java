import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class AddNamesToBracket {
    public static void main (String[] args) {
        AddNamesToBracket addNamesToBracket = new AddNamesToBracket();
        addNamesToBracket.Start(0,2);
    }

    public String ReadCellData (int vRow, int vColumn) {
        String value;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");
            wb = new XSSFWorkbook(fis);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        assert wb!= null;
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(vRow);
        Cell cell = row.getCell(vColumn);
        value = cell.getStringCellValue();
        return value;
    }
    public void Start (int vRow, int vColumn) {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Sample.xlsx");
            Workbook wb = new XSSFWorkbook(fis);
            assert wb != null;
            Sheet sheet = wb.getSheetAt(1);
            Row row = sheet.getRow(vRow);
            Cell cell = row.getCell(vColumn);
            String value = cell.getStringCellValue();
            System.out.println(value);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
