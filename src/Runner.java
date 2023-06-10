import javax.swing.*;
import java.awt.*;

public class Runner extends Container {
    final static Object LOCK = new Object();
    static int rounds;
    static JSpinner incrementer;
    static JButton confirmButton;
    static JFrame frame;
    Font font = new Font("Comic Sans MS", Font.PLAIN, 12), titleFont = new Font("Comic Sans MS", Font.PLAIN, 20);

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.displayGUI();
    }

    public void displayGUI() {
        //<editor-fold desc="Variable Declarations">
        JSpinner jSpinner1 = new JSpinner();
        JPanel jPanel1 = new JPanel();
        JLabel titleText = new JLabel();
        JLabel descriptionText = new JLabel();
        JPanel autoFillerPanel = new JPanel();
        incrementer = new JSpinner();
        confirmButton = new JButton();
        JLabel autoFillerDescriptionText = new JLabel();
        JPanel customizationPanel = new JPanel();
        JLabel weightText = new JLabel();
        JSlider weightSlider = new JSlider();
        JRadioButton randomRadioButton = new JRadioButton();
        JRadioButton seedRadioButton = new JRadioButton();
         frame = new JFrame();
        //</editor-fold>

        jSpinner1.setFont(font);

        titleText.setFont(titleFont);
        titleText.setHorizontalAlignment(SwingConstants.CENTER);
        titleText.setText("<html><body><div style = text-align: center>Welcome to <br>Mammal March Madness<br> Bracket Auto-Filler</div></body></html>");

        descriptionText.setFont(font);
        descriptionText.setText("Use this program to create filled out brackets which are ready to print");

        incrementer.setFont(font);

        confirmButton.setFont(font);
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(e -> {
            rounds = (int) incrementer.getValue();
            if (rounds < 1) {
                JOptionPane.showMessageDialog(null, "Error: invalid number detected.\nPlease enter only positive non-zero numbers", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                incrementer.setEnabled(false);
                confirmButton.setEnabled(false);
                frame.setVisible(false);
                ProgressGUI progressGUI = new ProgressGUI();
                progressGUI.displayGUI();

//                synchronized (LOCK) {
//                    while (!ProgressGUI.pressedOkay) {
//                        try {
//                            LOCK.wait();
//                        } catch (InterruptedException ex) {
//                            break;
//                        }
//                    }
//                }
                incrementer.setEnabled(true);
                confirmButton.setEnabled(true);
                frame.setVisible(true);


            }
        });

        autoFillerDescriptionText.setFont(font);
        autoFillerDescriptionText.setText("How many brackets do you want filled?");

        //<editor-fold desc="Auto Filler Panel">
        javax.swing.GroupLayout AutoFillerPanelLayout = new javax.swing.GroupLayout(autoFillerPanel);
        autoFillerPanel.setLayout(AutoFillerPanelLayout);
        AutoFillerPanelLayout.setHorizontalGroup(
                AutoFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AutoFillerPanelLayout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(AutoFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(AutoFillerPanelLayout.createSequentialGroup()
                                                .addComponent(incrementer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(confirmButton))
                                        .addComponent(autoFillerDescriptionText))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        AutoFillerPanelLayout.setVerticalGroup(
                AutoFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AutoFillerPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(autoFillerDescriptionText)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(AutoFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(confirmButton)
                                        .addComponent(incrementer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        customizationPanel.setBorder(BorderFactory.createTitledBorder("Customizations"));

        weightText.setFont(font);
        weightText.setText("Weight: 50 (random based on seed)");

        weightSlider.setFont(font);
        weightSlider.setMajorTickSpacing(10);
        weightSlider.setMinorTickSpacing(5);
        weightSlider.setPaintLabels(true);
        weightSlider.setPaintTicks(true);
        weightSlider.setToolTipText("0 = lower seed always\n< 50 = favors lower seed\n50 = random chance based on seed (i.e. seed of 1 vs 16 has a 16/17 and 1/17 chance of winning\n> 50 = favors higher seed\n100 = higher seed always");
        weightSlider.addChangeListener(e -> {
            int weight = weightSlider.getValue();
            weightText.setText("Weight: " + weight);
            if (weight == 0) {
                weightText.setText(weightText.getText() + " (lower seed only)");
            } else if (weight < 50) {
                weightText.setText(weightText.getText() + " (favors lower seed )");
            } else if (weight == 50) {
                weightText.setText(weightText.getText() + " (random based on seed)");
            } else if (weight < 100) {
                weightText.setText(weightText.getText() + " (favors higher seed )");
            } else {
                weightText.setText(weightText.getText() + " (higher seed only)");
            }
        });

        randomRadioButton.setFont(font);
        randomRadioButton.setText("Random");
        randomRadioButton.setToolTipText("Randomly chooses animal");
        randomRadioButton.setActionCommand("Random");
        randomRadioButton.addActionListener(e -> weightSlider.setEnabled(false));

        seedRadioButton.setFont(font);
        seedRadioButton.setSelected(true);
        seedRadioButton.setText("Seed");
        seedRadioButton.setToolTipText("Chooses winner based on animals seed value");
        seedRadioButton.addActionListener(e -> weightSlider.setEnabled(true));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(randomRadioButton);
        buttonGroup.add(seedRadioButton);

        //<editor-fold desc="Customization Panel">
        GroupLayout CustomizationPanelLayout = new GroupLayout(customizationPanel);
        customizationPanel.setLayout(CustomizationPanelLayout);
        CustomizationPanelLayout.setHorizontalGroup(
                CustomizationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(CustomizationPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(CustomizationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(weightText)
                                        .addComponent(weightSlider, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(CustomizationPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(CustomizationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(seedRadioButton)
                                        .addComponent(randomRadioButton))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CustomizationPanelLayout.setVerticalGroup(
                CustomizationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, CustomizationPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(seedRadioButton)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(randomRadioButton)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(weightText)
                                .addGap(18, 18, 18)
                                .addComponent(weightSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        //</editor-fold>

        //<editor-fold desc="JPanel1">
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(titleText, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(descriptionText))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(customizationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(autoFillerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(descriptionText)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(customizationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(autoFillerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        //</editor-fold>

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }// </editor-fold>
}
