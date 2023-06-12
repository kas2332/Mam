import javax.swing.*;
import java.io.File;

import static java.lang.Thread.sleep;

public class ProgressGUI {
    static Boolean pressedOkay = false;
    static JProgressBar progressBar;
    static JLabel loadingText;
    AutoFiller autoFiller;
    JFrame frame;

    public static void main(String[] args) {
        ProgressGUI progressGUI = new ProgressGUI();
        progressGUI.displayGUI();
    }

    public static void updateProgressBar(int count) {
        progressBar.setValue((int) Math.floor(((double) count / (1 * 64)) * 100));
        if (count == (1 * 64)) {
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
        frame = new JFrame();

        okayButton.setText("Okay");
        okayButton.addActionListener(e -> {
            pressedOkay = true;
            frame.dispose();
            Runner.frame.setVisible(true);
        });

        loadingText.setText("Loading.");

        //<editor-fold desc="Layout">
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadingText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(okayButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadingText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(okayButton)
                                .addContainerGap(8, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //frame.setResizable(false);
        frame.setVisible(true);
        makeBrackets();
    }

    public void makeBrackets() {
        for (int i = 0; i < 1; i++) {
            AutoFiller autoFiller = new AutoFiller(new File("CompletedBoards\\SampleBracket" + (i + 1) + ".png"));
            autoFiller.makeAnimalObjects();
            autoFiller.makeEmptyImage();
            autoFiller.compareWildcards();
            autoFiller.compareMinorRounds();
            autoFiller.compareChampionship();
        }
        autoFiller.setCount(0);
    }
}
