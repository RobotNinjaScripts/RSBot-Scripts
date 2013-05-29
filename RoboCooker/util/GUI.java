package RoboCooker.util;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import RoboCooker.RoboCooker;

/**
 * RoboCooker
 * Developed by RobotNinja
 */

public class GUI extends JFrame {

    public static boolean isRunning = true;
    public static boolean disposeGUI = false;

    public GUI() {

        initComponents();
    }

    private void startButtonActionPerformed(ActionEvent e) {

        if(radioButtonFood.isSelected()) {

            if (foodComboBox.getSelectedItem().equals("Shrimp")) {
                RoboCooker.FOOD_ID = Constants.IDS_SHRIMP;

            } else if (foodComboBox.getSelectedItem().equals("Anchovies")) {
                RoboCooker.FOOD_ID = Constants.IDS_ANCHOVIES;

            } else if (foodComboBox.getSelectedItem().equals("Trout")) {
                RoboCooker.FOOD_ID = Constants.IDS_TROUT;

            } else if (foodComboBox.getSelectedItem().equals("Salmon")) {
                RoboCooker.FOOD_ID = Constants.IDS_SALMON;

            } else if (foodComboBox.getSelectedItem().equals("Tuna")) {
                RoboCooker.FOOD_ID = Constants.IDS_TUNA;

            } else if (foodComboBox.getSelectedItem().equals("Lobster")) {
                RoboCooker.FOOD_ID = Constants.IDS_LOBSTER;

            } else if (foodComboBox.getSelectedItem().equals("Swordfish")) {
                RoboCooker.FOOD_ID = Constants.IDS_SWORDFISH;

            } else if (foodComboBox.getSelectedItem().equals("Monkfish")) {
                RoboCooker.FOOD_ID = Constants.IDS_MONKFISH;

            } else if (foodComboBox.getSelectedItem().equals("Shark")) {
                RoboCooker.FOOD_ID = Constants.IDS_SHARK;

            } else if (foodComboBox.getSelectedItem().equals("Cavefish")) {
                RoboCooker.FOOD_ID = Constants.IDS_CAVEFISH;

            } else if (foodComboBox.getSelectedItem().equals("Rocktail")) {
                RoboCooker.FOOD_ID = Constants.IDS_ROCKTAIL;

            }
            disposeGUI = true;
        }

        else if (radioButtonCustom.isSelected()) {
            RoboCooker.FOOD_ID = Integer.parseInt(foodTextField.getText());
            disposeGUI = true;
        }

        else {
            System.out.println("Please select what food to cook.");
            disposeGUI = false;
        }

        if (disposeGUI) {
            System.out.println("Selected food ID: " + RoboCooker.FOOD_ID);
            isRunning = false;
            dispose();
        }

    }

    private void initComponents() {

        mainPanel = new JPanel();
        selectFoodLabel = new JLabel();
        radioButtonFood = new JRadioButton();
        radioButtonCustom = new JRadioButton();
        foodComboBox = new JComboBox<>();
        foodTextField = new JTextField();
        titlePanel = new JPanel();
        titleLabel = new JLabel();
        startButton = new JButton();

        //======== this ========
        setTitle("RoboCooker - GUI");
        setResizable(false);
        Container contentPane = getContentPane();

        //======== mainPanel ========
        {
            mainPanel.setBorder(new EtchedBorder());

            //---- selectFoodLabel ----
            selectFoodLabel.setText("Select the food to cook or enter an ID:");
            selectFoodLabel.setFont(selectFoodLabel.getFont().deriveFont(selectFoodLabel.getFont().getStyle() | Font.BOLD, selectFoodLabel.getFont().getSize() - 3f));

            //---- radioButtonFood ----
            radioButtonFood.setText("Food to cook:");
            radioButtonFood.setFont(radioButtonFood.getFont().deriveFont(radioButtonFood.getFont().getStyle() | Font.BOLD, radioButtonFood.getFont().getSize() - 3f));

            //---- radioButtonCustom ----
            radioButtonCustom.setText("Custom food ID:");
            radioButtonCustom.setFont(radioButtonCustom.getFont().deriveFont(radioButtonCustom.getFont().getStyle() | Font.BOLD, radioButtonCustom.getFont().getSize() - 3f));

            //---- foodComboBox ----
            foodComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Shrimp",
                    "Anchovies",
                    "Trout",
                    "Salmon",
                    "Tuna",
                    "Lobster",
                    "Swordfish",
                    "Monkfish",
                    "Shark",
                    "Cavefish",
                    "Rocktail"
            }));

            GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
            mainPanel.setLayout(mainPanelLayout);
            mainPanelLayout.setHorizontalGroup(
                    mainPanelLayout.createParallelGroup()
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(mainPanelLayout.createParallelGroup()
                                            .addComponent(selectFoodLabel)
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                    .addGroup(mainPanelLayout.createParallelGroup()
                                                            .addComponent(radioButtonCustom)
                                                            .addComponent(radioButtonFood))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(foodComboBox, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                                            .addComponent(foodTextField, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            mainPanelLayout.setVerticalGroup(
                    mainPanelLayout.createParallelGroup()
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(selectFoodLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(radioButtonFood)
                                            .addComponent(foodComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(radioButtonCustom)
                                            .addComponent(foodTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== titlePanel ========
        {
            titlePanel.setBorder(new EtchedBorder());

            //---- titleLabel ----
            titleLabel.setText("RoboCooker");
            titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));

            GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
            titlePanel.setLayout(titlePanelLayout);
            titlePanelLayout.setHorizontalGroup(
                    titlePanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                                    .addContainerGap(103, Short.MAX_VALUE)
                                    .addComponent(titleLabel)
                                    .addGap(98, 98, 98))
            );
            titlePanelLayout.setVerticalGroup(
                    titlePanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(titleLabel))
            );
        }

        //---- startButton ----
        startButton.setText("Start Script");
        startButton.setFont(startButton.getFont().deriveFont(startButton.getFont().getStyle() | Font.BOLD, startButton.getFont().getSize() - 1f));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                        .addComponent(startButton, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                        .addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(startButton)
                                .addContainerGap(6, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup ----
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonFood);
        buttonGroup.add(radioButtonCustom);
    }

    private JPanel mainPanel;
    private JLabel selectFoodLabel;
    private JRadioButton radioButtonFood;
    private JRadioButton radioButtonCustom;
    private JComboBox<String> foodComboBox;
    private JTextField foodTextField;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JButton startButton;
}
