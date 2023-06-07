import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if (!(new File("CompletedBoards").exists())) {    //checks to see if there is a directory to store account information
            boolean dirMade = (new File("CompletedBoards")).mkdir(); //creates a directory
            if (!dirMade) {
                System.out.println("Error: Directory could not be made. GoodBye");
                System.exit(-9);
            }
        } else {
            try {
                FileUtils.cleanDirectory(new File("CompletedBoards"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("How many boards do you want to fill?");
        int num = scan.nextInt();

        for (int i = 0; i < num; i++) {
            AutoFiller autoFiller = new AutoFiller(new File("CompletedBoards\\SampleBracket" + i + ".png"));
            autoFiller.makeAnimalObjects();
            autoFiller.makeEmptyImage();
            autoFiller.compareWildcards();
            autoFiller.compareMinorRounds();
            autoFiller.compareChampionship();
        }
    }
}
