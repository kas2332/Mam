import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class ProgressGUI {
    static int numBrackets, count;
    static JProgressBar progressBar;
    static JLabel loadingText;
    static JButton okayButton;
    static AutoFiller autoFiller;
    JFrame frame;
    static Instant start, end;
    Duration duration;

    public static void updateProgressBar(int countP) {
        count = countP;
        if (count == (Runner.rounds * 64)) {
            loadingText.setText("Completed!");
            okayButton.setEnabled(true);
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
        okayButton = new JButton();
        loadingText = new JLabel();
        progressBar = new JProgressBar() {
            @Override
            public Point getToolTipLocation(MouseEvent event) {
                return new Point(0, 10);
            }
        };
        frame = new JFrame();

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (loadingText.getText().equals("Completed!")) {
                    frame.dispose();
                    Runner.frame.setVisible(true);
                } else if ((JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit this program?", "Close Window?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) && !(loadingText.getText().equals("Completed!"))) {
                    frame.setEnabled(false);
                    File file;
                    if (autoFiller.getDestination() == null) {
                        System.exit(0);
                    } else {
                        file = autoFiller.getDestination();
                        boolean deleted;
                        for (int i = 0; i < 10; i++) {
                            deleted = file.delete();

                            if (deleted) {
                                System.exit(0);
                            } else {
                                try {
                                    sleep(500);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Error: Unfinished file could not be deleted", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        okayButton.setText("Okay");
        okayButton.setEnabled(false);
        okayButton.addActionListener(e -> {
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
        frame.setResizable(false);
        frame.setVisible(true);

        Timer t = new Timer(1000, e -> {
            if (!(count == Runner.rounds * 64)) {
                end = Instant.now();
            }
            if (!(start == null)) {
                duration = Duration.between(start, end);
            } else {
                duration = Duration.ofDays(0);
            }
            progressBar.setValue((int) Math.floor(((double) count / (Runner.rounds * 64)) * 100));
            progressBar.setToolTipText("<html><body>Brackets Completed: " + (count / (64)) + "<br>Time Elapsed: " + formatTime(Math.toIntExact(duration.toSeconds())) + "<br>Estimated Time Remaining: " + formatTime(((Runner.rounds * 64) - count) / 2));
            Point locationOnScreen = MouseInfo.getPointerInfo().getLocation();
            Point locationOnComponent = new Point(locationOnScreen);
            SwingUtilities.convertPointFromScreen(locationOnComponent, progressBar);
            if (progressBar.contains(locationOnComponent)) {
                ToolTipManager.sharedInstance().mouseMoved(
                        new MouseEvent(progressBar, -1, System.currentTimeMillis(), 0, locationOnComponent.x, locationOnComponent.y,
                                locationOnScreen.x, locationOnScreen.y, 0, false, 0));
            }
        });
        t.start();
    }

    public void makeBrackets() {
        var ref = new Object() {
            int i = 0;
        };
        try (Stream<Path> fileStream = Files.walk(Paths.get("CompletedBoards"))) {
            fileStream.forEach(path -> {
                if (!(path.toFile()).isDirectory()) {
                    String fullName = path.toFile().getName();
                    int num = Integer.parseInt(fullName.replace(".png", "").replace("SampleBracket", ""));
                    if (num > ref.i) {
                        ref.i = num;
                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        autoFiller = new AutoFiller(null);
        ref.i++;
        start = Instant.now();
        autoFiller.makeAnimalObjects();
        for (numBrackets = ref.i; numBrackets < (ref.i + Runner.rounds); numBrackets++) {
            autoFiller = new AutoFiller(new File("CompletedBoards\\SampleBracket" + numBrackets + ".png"));
            autoFiller.makeEmptyImage();
            autoFiller.compareWildcards();
            autoFiller.compareMinorRounds();
            autoFiller.compareChampionship();
        }
        AutoFiller.count = 0;
    }

    public static String formatTime(int sec) {
        int seconds = sec % 60;
        int minutes = sec / 60;
        int hours = minutes / 60;
        minutes %= 60;
        int days = hours / 24;
        hours %= 24;
        int years = days / 365;
        days %= 365;
        String text = "";

        if (years > 0) {
            text += "Y: " + years + ", ";
        }
        if (days > 0) {
            text += "D: " + days + ", ";
        }
        if (hours > 0) {
            text += "H: " + hours + ", ";
        }
        if (minutes > 0) {
            text += "M: " + minutes + ", ";
        }
        text += "S: " + seconds;
        return text;
    }
}