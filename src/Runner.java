/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Pants
 */
public class Runner extends javax.swing.JPanel {

    /**
     * Creates new form WordleIntro
     */
    public Runner() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        TitleText = new javax.swing.JLabel();
        DescriptionText = new javax.swing.JLabel();
        AutoFillerPanel = new javax.swing.JPanel();
        ProgressBar = new javax.swing.JProgressBar();
        Incrimenter = new javax.swing.JSpinner();
        ConfirmButton = new javax.swing.JButton();
        AutoFillerDescriptionText = new javax.swing.JLabel();
        CustomizationPanel = new javax.swing.JPanel();
        WieghtText = new javax.swing.JLabel();
        WeightSlider = new javax.swing.JSlider();
        RandomRadioButton = new javax.swing.JRadioButton();
        SeedRadioButton = new javax.swing.JRadioButton();

        jSpinner1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        TitleText.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        TitleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleText.setText("<html><body><div style = text-align: center>Welcome to <br>Mammal March Madeness<br> Bracket Autofiller</div></body></html>");
        TitleText.setToolTipText("");

        DescriptionText.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        DescriptionText.setText("Use this program to create filled out brackets which are ready to print");

        ProgressBar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        Incrimenter.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        ConfirmButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        ConfirmButton.setText("Confirm");

        AutoFillerDescriptionText.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        AutoFillerDescriptionText.setText("How many brackets do you want filled?");

        javax.swing.GroupLayout AutoFillerPanelLayout = new javax.swing.GroupLayout(AutoFillerPanel);
        AutoFillerPanel.setLayout(AutoFillerPanelLayout);
        AutoFillerPanelLayout.setHorizontalGroup(
                AutoFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AutoFillerPanelLayout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(AutoFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(AutoFillerPanelLayout.createSequentialGroup()
                                                .addComponent(Incrimenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 79, Short.MAX_VALUE)
                                                .addComponent(ConfirmButton))
                                        .addComponent(AutoFillerDescriptionText))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        AutoFillerPanelLayout.setVerticalGroup(
                AutoFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AutoFillerPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AutoFillerDescriptionText)
                                .addGap(50, 50, 50)
                                .addGroup(AutoFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ConfirmButton)
                                        .addComponent(Incrimenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
        );

        CustomizationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Customizations"));

        WieghtText.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        WieghtText.setText("Weight");

        WeightSlider.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        WeightSlider.setMajorTickSpacing(10);
        WeightSlider.setMinorTickSpacing(5);
        WeightSlider.setPaintLabels(true);
        WeightSlider.setPaintTicks(true);
        WeightSlider.setToolTipText("0 = lower seed always\n< 50 = favors lower seed\n50 = random chance based on seed (i.e. seed of 1 vs 16 has a 16/17 and 1/17 chance of winning\n> 50 = favors higher seed\n100 = higher seed always");

        RandomRadioButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        RandomRadioButton.setText("Random");
        RandomRadioButton.setToolTipText("Randomly chooses animal");
        RandomRadioButton.setActionCommand("Random");

        SeedRadioButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        SeedRadioButton.setSelected(true);
        SeedRadioButton.setText("Seed");
        SeedRadioButton.setToolTipText("Chooses winner based on animals seed value");

        javax.swing.GroupLayout CustomizationPanelLayout = new javax.swing.GroupLayout(CustomizationPanel);
        CustomizationPanel.setLayout(CustomizationPanelLayout);
        CustomizationPanelLayout.setHorizontalGroup(
                CustomizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CustomizationPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(CustomizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(WieghtText)
                                        .addComponent(WeightSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(CustomizationPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(CustomizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(SeedRadioButton)
                                        .addComponent(RandomRadioButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CustomizationPanelLayout.setVerticalGroup(
                CustomizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomizationPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SeedRadioButton)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(RandomRadioButton)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(WieghtText)
                                .addGap(18, 18, 18)
                                .addComponent(WeightSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DescriptionText))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CustomizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AutoFillerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TitleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DescriptionText)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(CustomizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(AutoFillerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JLabel AutoFillerDescriptionText;
    private javax.swing.JPanel AutoFillerPanel;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JPanel CustomizationPanel;
    private javax.swing.JLabel DescriptionText;
    private javax.swing.JSpinner Incrimenter;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JRadioButton RandomRadioButton;
    private javax.swing.JRadioButton SeedRadioButton;
    private javax.swing.JLabel TitleText;
    private javax.swing.JSlider WeightSlider;
    private javax.swing.JLabel WieghtText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration
}
