import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Runner {
    FileInputStream fis;
    Workbook wb;
    Sheet helper, sample, bracket;
    Animal animal;
    Map<String, Animal> animalMap = new LinkedHashMap<>();

    public Runner() {
        animal = new Animal();
        try {
            fis = new FileInputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");
            wb = new XSSFWorkbook(fis);
            helper = wb.getSheetAt(0);
            sample = wb.getSheetAt(1);
            bracket = wb.getSheetAt(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.makeAnimalObjects();
        runner.compareFirstTwoAnimals();
        runner.compareFirstRound();
    }

    /*public void Start(int vRow, int vColumn) {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Pants\\IdeaProjects\\Mam\\Bracket.xlsx");
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(1);
            Row row = sheet.getRow(vRow);
            Cell cell = row.getCell(vColumn);
            String value = cell.getStringCellValue();
            System.out.println(cell.getStringCellValue() + "" + cell.getCellFormula());
            String[] arr = cell.getCellFormula().split("[=Helper!]");
            System.out.println(arr[7]);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    public void makeAnimalObjects() {
        String name;
        int rank;
        for (int r = 1; r < 66; r++) {
            Row row = helper.getRow(r);
            Cell cellRank = row.getCell(2);
            rank = (int) cellRank.getNumericCellValue();
            Cell cellAnimal = row.getCell(3);
            name = cellAnimal.getStringCellValue();
            animalMap.put(name, new Animal(name, rank));
        }
    }

    public void compareFirstTwoAnimals() {
        String name1, name2;
        Row row1 = sample.getRow(0);
        Cell cell1 = row1.getCell(2);
        name1 = cell1.getStringCellValue();
        Row row2 = sample.getRow(2);
        Cell cell2 = row2.getCell(2);
        name2 = cell2.getStringCellValue();
        System.out.println(animal.winner(animalMap.get(name1), animalMap.get(name2)));
    }
    public void compareFirstRound () {
        String name1, name2, winner;
        for (int r = 0; r < 63; r += 4) {
            Row row1 = sample.getRow(r);
            Cell cell1 = row1.getCell(2);
            name1 = cell1.getStringCellValue();

            Row row2 = sample.getRow(r+2);
            Cell cell2 = row2.getCell(2);
            name2 = cell2.getStringCellValue();

            winner = animal.winner(animalMap.get(name1), animalMap.get(name2)).getName();

            Row rowWinner = bracket.getRow(r+1);
            Cell cellWinner = rowWinner.getCell(3);
            cellWinner.setCellValue(winner);
        }
    }
}