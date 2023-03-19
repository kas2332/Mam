// Java program to write data in excel sheet using java code

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteDataToExcel {

    // any exceptions need to be caught
    public static void main(String[] args) throws Exception {
        // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();

        // spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");

        // creating a row object
        XSSFRow row;

        // This data needs to be written (Object[])
        Map<String, Object[]> studentData = new TreeMap<>();

        studentData.put("1", new Object[]{"Roll No", "NAME", "Year"});

        studentData.put("2", new Object[]{"654654", "Aditya", "2nd year"});

        studentData.put("3", new Object[]{"128", "Aditya", "2nd year"});

        studentData.put("4", new Object[]{"130", "Mohan", "2nd year"});

        studentData.put("5", new Object[]{"131", "Radha", "2nd year"});

        studentData.put("6", new Object[]{"132", "Gopal", "2nd year"});

        Set<String> keyID = studentData.keySet();

        int rowID = 0;

        // writing the data into the sheets...

        for (String key : keyID) {
            row = spreadsheet.createRow(rowID++);
            Object[] objectArr = studentData.get(key);
            int cellID = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellID++);
                cell.setCellValue((String) obj);
            }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        //School
        //FileOutputStream out = new FileOutputStream("");
        //Hotel
        FileOutputStream out = new FileOutputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Sample.xlsx");
        //Home
        //FileOutputStream out = new FileOutputStream("");

        workbook.write(out);
        out.close();
    }
}
