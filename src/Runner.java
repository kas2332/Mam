import javax.swing.*;
import java.awt.*;

public class Runner extends Container {
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
        JProgressBar progressBar = new JProgressBar();
        JSpinner incrementer = new JSpinner();
        JButton confirmButton = new JButton();
        JLabel autoFillerDescriptionText = new JLabel();
        JPanel customizationPanel = new JPanel();
        JLabel weightText = new JLabel();
        JSlider weightSlider = new JSlider();
        JRadioButton randomRadioButton = new JRadioButton();
        JRadioButton seedRadioButton = new JRadioButton();
        JFrame frame = new JFrame();
        //</editor-fold>

        jSpinner1.setFont(font);

        titleText.setFont(titleFont);
        titleText.setHorizontalAlignment(SwingConstants.CENTER);
        titleText.setText("<html><body><div style = text-align: center>Welcome to <br>Mammal March Madness<br> Bracket Auto-Filler</div></body></html>");

        descriptionText.setFont(font);
        descriptionText.setText("Use this program to create filled out brackets which are ready to print");

        progressBar.setFont(font);

        incrementer.setFont(font);

        confirmButton.setFont(font);
        confirmButton.setText("Confirm");

        autoFillerDescriptionText.setFont(font);
        autoFillerDescriptionText.setText("How many brackets do you want filled?");

        GroupLayout AutoFillerPanelLayout = new GroupLayout(autoFillerPanel);
        autoFillerPanel.setLayout(AutoFillerPanelLayout);
        AutoFillerPanelLayout.setHorizontalGroup(
                AutoFillerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(AutoFillerPanelLayout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(AutoFillerPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(AutoFillerPanelLayout.createSequentialGroup()
                                                .addComponent(incrementer, 25, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 50, 50)
                                                .addComponent(confirmButton))
                                        .addComponent(autoFillerDescriptionText))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        AutoFillerPanelLayout.setVerticalGroup(
                AutoFillerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(AutoFillerPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(autoFillerDescriptionText)
                                .addGap(50, 50, 50)
                                .addGroup(AutoFillerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(confirmButton)
                                        .addComponent(incrementer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
        );

        customizationPanel.setBorder(BorderFactory.createTitledBorder("Customizations"));

        weightText.setFont(font);
        weightText.setText("Weight");

        weightSlider.setFont(font);
        weightSlider.setMajorTickSpacing(10);
        weightSlider.setMinorTickSpacing(5);
        weightSlider.setPaintLabels(true);
        weightSlider.setPaintTicks(true);
        weightSlider.setToolTipText("0 = lower seed always\n< 50 = favors lower seed\n50 = random chance based on seed (i.e. seed of 1 vs 16 has a 16/17 and 1/17 chance of winning\n> 50 = favors higher seed\n100 = higher seed always");

        randomRadioButton.setFont(font);
        randomRadioButton.setText("Random");
        randomRadioButton.setToolTipText("Randomly chooses animal");
        randomRadioButton.setActionCommand("Random");

        seedRadioButton.setFont(font);
        seedRadioButton.setSelected(true);
        seedRadioButton.setText("Seed");
        seedRadioButton.setToolTipText("Chooses winner based on animals seed value");

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

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }// </editor-fold>


    // End of variables declaration
}
