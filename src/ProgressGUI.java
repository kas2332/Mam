import javax.swing.*;
import java.io.File;

public class ProgressGUI {
    static Boolean pressedOkay = false;
    static JProgressBar progressBar;
    static JLabel loadingText;
    AutoFiller autoFiller;

    public static void main(String[] args) {
        ProgressGUI progressGUI = new ProgressGUI();
        progressGUI.displayGUI();
    }

    public static void updateProgressBar(int count) {
        progressBar.setValue((int) Math.floor(((double) count / (Runner.rounds * 64)) * 100));
        if (count == (Runner.rounds * 64)) {
            loadingText.setText("Completed!");
        } else if ((count % 3) == 0) {
            loadingText.setText("Loading.");
        } else if ((count % 3) == 1) {
            loadingText.setText("Loading..");
        } else if ((count % 3) == 2) {
            loadingText.setText("Loading...");
        }
    }

    public void displayGUI() {
        JPanel jPanel1 = new JPanel();
        JButton okayButton = new JButton();
        loadingText = new JLabel();
        progressBar = new JProgressBar();
        JFrame frame = new JFrame();

        okayButton.setText("Okay");
        okayButton.addActionListener(e -> pressedOkay = true);

        loadingText.setText("Loading.");

        //<editor-fold desc="Layout">
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadingText)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(okayButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadingText)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(okayButton)
                                .addContainerGap(8, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        makeBrackets();
    }

    public void makeBrackets() {
        for (int i = 0; i < Runner.rounds; i++) {
            autoFiller = new AutoFiller(new File("CompletedBoards\\SampleBracket" + (i + 1) + ".png"));
            autoFiller.makeAnimalObjects();
            autoFiller.makeEmptyImage();
            autoFiller.compareWildcards();
            autoFiller.compareMinorRounds();
            autoFiller.compareChampionship();
        }
        autoFiller.setCount(0);
    }
}
