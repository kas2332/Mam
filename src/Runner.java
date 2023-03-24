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
    XSSFSheet helper, sample, bracket, bracket1;
    Animal animal;
    Map<String, Animal> animalMap = new LinkedHashMap<>();

    public Runner() {
        animal = new Animal();
        try {
            //fis = new FileInputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");   //Hotel
            fis = new FileInputStream("C:\\Users\\ks4292\\IdeaProjects\\Mam\\Bracket.xlsx");   //School
            //fis = new FileInputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");   //Home
            wb = new XSSFWorkbook(fis);
            helper = wb.getSheetAt(0);
            sample = wb.getSheetAt(1);
            bracket1 = wb.getSheetAt(3);
            bracket = wb.getSheetAt(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.makeAnimalObjects();
        runner.compareWildcards();
        runner.compareMinorRounds();
        runner.compareChampionship();
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
            //fos = new FileOutputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");   //Home
            wb.write(fos);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void compareMinorRounds() {
        String name1, name2;
        int incrementFromEnds, nextAnimal = 4, distanceFromCenter = 6;
        for (int j = 0; j < 5; j++) {
            incrementFromEnds = (int) ((Math.pow(2, j)) - 1);
            for (int r = incrementFromEnds; r < (61 - incrementFromEnds); r += nextAnimal) {
                for (int c = -1; c < 2; c += 2) {
                    XSSFRow row1 = bracket.getRow(r);
                    Cell cell1 = row1.getCell((distanceFromCenter * c) + 8);
                    name1 = cell1.getStringCellValue();

                    XSSFRow row2 = bracket.getRow(r + (nextAnimal / 2));
                    Cell cell2 = row2.getCell((distanceFromCenter * c) + 8);
                    name2 = cell2.getStringCellValue();

                    Animal Winner = animal.winner(animalMap.get(name1), animalMap.get(name2));

                    XSSFRow rowWinner = bracket.getRow(r + (nextAnimal / 4));
                    Cell cellWinner = rowWinner.createCell(((distanceFromCenter - 1) * c) + 8);
                    cellWinner.setCellValue(Winner.getName());
                    try {
                        //fos = new FileOutputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");  //Hotel
                        fos = new FileOutputStream("C:\\Users\\ks4292\\IdeaProjects\\Mam\\Bracket.xlsx");   //School
                        //fos = new FileOutputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");   //Home
                        wb.write(fos);
                        fos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            nextAnimal *= 2;
            distanceFromCenter--;
        }
    }

    public void compareChampionship() {
        String name1, name2;

        XSSFRow row1 = bracket.getRow(31);
        Cell cell1 = row1.getCell(7);
        name1 = cell1.getStringCellValue();

        XSSFRow row2 = bracket.getRow(31);
        Cell cell2 = row2.getCell(9);
        name2 = cell2.getStringCellValue();

        Animal Winner = animal.winner(animalMap.get(name1), animalMap.get(name2));

        XSSFRow rowWinner = bracket.getRow(31);
        Cell cellWinner = rowWinner.createCell(8);
        cellWinner.setCellValue(Winner.getName());
        try {
            //fos = new FileOutputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");  //Hotel
            fos = new FileOutputStream("C:\\Users\\ks4292\\IdeaProjects\\Mam\\Bracket.xlsx");   //School
            //fos = new FileOutputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");   //Home
            wb.write(fos);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}