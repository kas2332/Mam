import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
public class AddNamesToBracket {
    public static void main (String[] args) {
        AddNamesToBracket addNamesToBracket = new AddNamesToBracket();
        String vOutput = addNamesToBracket.ReadCellData(2,2);
        System.out.println(vOutput);
    }

    public String ReadCellData (int vRow, int vColumn) {
        String value;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Sample.xlsx");
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
}
