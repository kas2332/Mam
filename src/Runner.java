import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Runner {
    FileInputStream fis;
    FileOutputStream fos;
    XSSFWorkbook wb;
    XSSFSheet helper, sample, bracket;
    Animal animal;
    Map<String, Animal> animalMap = new LinkedHashMap<>();

    public Runner() {
        animal = new Animal();
        try {
            //fis = new FileInputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");   //Hotel
            fis = new FileInputStream("C:\\Users\\ks4292\\IdeaProjects\\Mam\\Bracket.xlsx");   //School
            wb = new XSSFWorkbook(fis);
            helper = wb.getSheetAt(0);
            sample = wb.getSheetAt(1);
            //bracket = wb.createSheet("Bracket1");
            bracket = wb.getSheetAt(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.makeAnimalObjects();
        runner.compareWildcards();
        runner.compareFirstRound();
    }

    public void makeAnimalObjects() {
        String name;
        int rank;
        for (int r = 1; r < 66; r++) {
            XSSFRow row = helper.getRow(r);
            Cell cellRank = row.getCell(2);
            rank = (int) cellRank.getNumericCellValue();
            Cell cellAnimal = row.getCell(3);
            name = cellAnimal.getStringCellValue();
            animalMap.put(name, new Animal(name, rank));
        }
        for (int r = 1; r < 3; r++) {
            XSSFRow row = helper.getRow(r);
            rank = 16;
            Cell cellAnimal = row.getCell(0);
            name = cellAnimal.getStringCellValue();
            animalMap.put(name, new Animal(name, rank));
        }
    }

    public void compareWildcards() {
        String name1, name2;

        XSSFRow row1 = sample.getRow(33);
        Cell cell1 = row1.getCell(1);
        name1 = cell1.getStringCellValue();

        XSSFRow row2 = sample.getRow(35);
        Cell cell2 = row2.getCell(1);
        name2 = cell2.getStringCellValue();

        Animal Winner = animal.winner(animalMap.get(name1), animalMap.get(name2));

        XSSFRow rowWinner = bracket.getRow(34);
        Cell cellWinner = rowWinner.createCell(2);
        cellWinner.setCellValue(Winner.getName());
        try {
            //fos = new FileOutputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");  //Hotel
            fos = new FileOutputStream("C:\\Users\\ks4292\\IdeaProjects\\Mam\\Bracket.xlsx");   //School
            wb.write(fos);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void compareFirstRound() {
        String name1, name2;
        for (int r = 0; r < 61; r += 4) {
            for (int c = -1; c < 2; c += 2) {
                XSSFRow row1 = bracket.getRow(r);
                Cell cell1 = row1.getCell((6 * c) + 8);
                name1 = cell1.getStringCellValue();

                XSSFRow row2 = bracket.getRow(r + 2);
                Cell cell2 = row2.getCell((6 * c) + 8);
                name2 = cell2.getStringCellValue();

                Animal Winner = animal.winner(animalMap.get(name1), animalMap.get(name2));

                XSSFRow rowWinner = bracket.getRow(r + 1);
                Cell cellWinner = rowWinner.createCell((5 * c) + 8);
                cellWinner.setCellValue(Winner.getName());
                try {
                    //fos = new FileOutputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");  //Hotel
                    fos = new FileOutputStream("C:\\Users\\ks4292\\IdeaProjects\\Mam\\Bracket.xlsx");   //School
                    wb.write(fos);
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}