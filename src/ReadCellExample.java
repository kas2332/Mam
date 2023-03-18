//reading value of a particular cell  

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadCellExample {
    public static void main(String[] args) {
        ReadCellExample rc = new ReadCellExample();   //object of the class
//reading the value of 2nd row and 2nd column  
        String vOutput = rc.ReadCellData(2, 2);
        System.out.println(vOutput);
    }

    //method defined for reading a cell
    public String ReadCellData(int vRow, int vColumn) {
        String value;          //variable for storing the cell value
        Workbook wb = null;           //initialize Workbook null
        try {
//reading data from a file in the form of bytes  
            FileInputStream fis = new FileInputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Sample.xlsx");
//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert wb != null;
        Sheet sheet = wb.getSheetAt(0);   //getting the XSSFSheet object at given index
        Row row = sheet.getRow(vRow); //returns the logical row
        Cell cell = row.getCell(vColumn); //getting the cell representing the given column
        value = cell.getStringCellValue();    //getting cell value
        return value;               //returns the cell value
    }
}