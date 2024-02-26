import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AutoFiller {
    private static int count = 0;
    private FileOutputStream fos;
    private static final Map<String, Animal> animalMap = new LinkedHashMap<>();
    private final File destination;
    private final XSSFWorkbook wb;
    private static XSSFSheet helper, sample, bracket;
    private final Animal animal;
    private final int[][] yPosition = {
            {1520},
            {465, 570, 677, 779, 884, 988, 1093, 1197, 1628, 1731, 1836, 1940, 2045, 2149, 2254, 2359},
            {518, 727, 936, 1145, 1679, 1888, 2097, 2306},
            {622, 1040, 1783, 2202},
            {831, 1993},
            {940},
            {1195},
            {1369},
            {831, 1993},
            {622, 1040, 1783, 2202},
            {518, 727, 936, 1145, 1679, 1888, 2097, 2306},
            {465, 570, 677, 779, 884, 988, 1093, 1197, 1628, 1731, 1836, 1940, 2045, 2149, 2254, 2359}
    };
    private final int[] xPosition = {404, 631, 826, 1028, 1228, 1428, 1497, 1686, 1895, 2101, 2295, 2495};

    public AutoFiller(File destination) {
        this.destination = destination;
        animal = new Animal();
        try {
            FileInputStream fis = new FileInputStream("Resources\\Bracket.xlsx");
            wb = new XSSFWorkbook(fis);
            helper = wb.getSheetAt(0);
            sample = wb.getSheetAt(1);
            bracket = wb.getSheetAt(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        makeDirectory();
        makeAnimalObjects();
        AutoFiller autoFiller = new AutoFiller(new File("CompletedBoards\\SampleBracket.png"));
        autoFiller.makeEmptyImage();
        autoFiller.compareWildcards();
        autoFiller.compareMinorRounds();
        autoFiller.compareChampionship();
    }

    public static void makeDirectory() {
        if (!(new File("CompletedBoards").exists())) {
            boolean dirMade = (new File("CompletedBoards")).mkdir();
            if (!dirMade) {
                JOptionPane.showMessageDialog(null, "Error: Something went wrong. Please try again later", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-999);
            }
        }
    }

    public static void makeAnimalObjects() {
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
//        for (int r = 1; r < 3; r++) {
//            XSSFRow row = helper.getRow(r);
//            rank = 16;
//            Cell cellAnimal = row.getCell(0);
//            name = cellAnimal.getStringCellValue();
//            animalMap.put(name, new Animal(name, rank));
//        }
    }

    public void makeEmptyImage() {
        try {
            File file = new File("Resources\\2024_Template.png");
            BufferedImage bufferedImage = ImageIO.read(file);
            file = new File(String.valueOf(destination));
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            fos = new FileOutputStream("Resources\\Bracket.xlsx");
            wb.write(fos);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printToImage(xPosition[0], yPosition[0][0], Winner.getName(), 135, 59);
    }

    public void compareMinorRounds() {
        String name1, name2;
        int incrementFromEnds, nextAnimal = 4, distanceFromCenter = 6;
        for (int j = 0; j < 5; j++) {
            incrementFromEnds = (int) ((Math.pow(2, j)) - 1);
            for (int c = -1; c < 2; c += 2) {
                for (int r = incrementFromEnds; r < (61 - incrementFromEnds); r += nextAnimal) {
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
                        fos = new FileOutputStream("Resources\\Bracket.xlsx");
                        wb.write(fos);
                        fos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    int LENGTH = 200;
                    int HEIGHT = 50;
                    printToImage(xPosition[(((distanceFromCenter - 1) * c) + 6)], yPosition[(((distanceFromCenter - 1) * c) + 6)][((r - incrementFromEnds) / nextAnimal)], Winner.getName(), LENGTH, HEIGHT);
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
            fos = new FileOutputStream("Resources\\Bracket.xlsx");
            wb.write(fos);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printToImage(xPosition[6], yPosition[6][0], Winner.getName(), 320, 85);

    }

    private void printToImage(int x, int y, String name, int length, int heightP) {
        count++;
        if (!ProgressGUI.progressBarIsNull()) {
            ProgressGUI.updateProgressBar(count);
        }
        String[] nameList = name.split(" ");
        for (int i = 0; i < nameList.length; i++) {
            try {
                int width, height, fontSize = 0;
                File file = new File(String.valueOf(destination));
                BufferedImage bufferedImage = ImageIO.read(file);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                g2d.setColor(Color.black);
                do {
                    fontSize++;
                    g2d.setFont(new Font("Comic Sans MS", Font.BOLD, fontSize));
                    width = g2d.getFontMetrics().stringWidth(nameList[i]);
                    height = g2d.getFontMetrics().getHeight();
                } while ((width < length - 10) && (height < heightP - 10) && (fontSize < 30));
                g2d.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize - 1));
                width = g2d.getFontMetrics().stringWidth(nameList[i]);
                height = g2d.getFontMetrics().getHeight();
                int xOffset = (((length - width) + g2d.getFontMetrics().getDescent()) / 2), yOffset = (heightP - (((i + 1) * (height + fontSize - 9))) / 2) + g2d.getFontMetrics().getDescent();
                g2d.drawString(nameList[i], x + xOffset, (y - yOffset));
                g2d.dispose();
                file = new File(String.valueOf(destination));
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public File getDestination() {
        return destination;
    }

    public static void resetCount() {
        count = 0;
    }
}