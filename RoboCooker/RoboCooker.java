package RoboCooker;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;

import RoboCooker.tasks.Banking;
import RoboCooker.tasks.Cooking;
import RoboCooker.util.Paint;
import RoboCooker.util.Resources;

@Manifest(authors = { "RobotNinja" }, name = "RoboCooker", description = "RoboCooker will cook all raw food at your selected destination. Read the forum thread for more details.", version = 0.4, website = "http://www.powerbot.org/community/topic/912964-sdn-robocooker-aio-cooking-script-efficient-fantastic-paint-most-locations-free/")
public class RoboCooker extends ActiveScript implements PaintListener, MouseListener, MessageListener {

	private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
	private Tree jobContainer = null;

	public final void provide(final Node... jobs) {
		for (final Node job : jobs) {
			jobsCollection.add(job);
		}
		jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));

	}

	@Override
	public void onStart() {

        GUI roboCookerGUI = new RoboCooker.GUI();
        roboCookerGUI.setVisible(true);

        while (roboCookerGUI.isVisible() && isActive()) {
            Paint.status = "Waiting for user...";
            Task.sleep(500);
        }

        roboCookerGUI.dispose();

		Paint.startExp = Skills.getExperience(Skills.COOKING);
		provide(new Banking(), new Cooking());
	}

	@Override
	public int loop() {
		if (jobContainer != null) {
			final Node job = jobContainer.state();
			if (job != null) {
				jobContainer.set(job);
				getContainer().submit(job);
				job.join();
			}
		}
		return Random.nextInt(10, 50);
	}

	@Override
	public void onRepaint(Graphics render) {
		Paint.drawPaintAndCursor(render);
	}

    @Override
    public void mouseClicked(MouseEvent e) {
        if(Paint.bounds.contains(e.getPoint())) {
            Paint.showPaint = !Paint.showPaint;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void messageReceived(MessageEvent messageEvent) {
        if (messageEvent.getMessage().contains("You successfully cook") || messageEvent.getMessage().contains("You manage to") || messageEvent.getMessage().contains("You roast")) {
            Paint.foodCooked++;
        }
    }

    public class GUI extends JFrame {
        public GUI() {
            initComponents();
        }

        private void startButtonActionPerformed(ActionEvent e) {

            if (foodBox.getSelectedItem().equals("Shrimp")) {
                Resources.rawFoodID = Resources.rawShrimpID;
            } else if (foodBox.getSelectedItem().equals("Anchovies")) {
                Resources.rawFoodID = Resources.rawAnchoviesID;
            } else if (foodBox.getSelectedItem().equals("Trout")) {
                Resources.rawFoodID = Resources.rawTroutID;
            } else if (foodBox.getSelectedItem().equals("Salmon")) {
                Resources.rawFoodID = Resources.rawSalmonID;
            } else if (foodBox.getSelectedItem().equals("Tuna")) {
                Resources.rawFoodID = Resources.rawTunaID;
            } else if (foodBox.getSelectedItem().equals("Lobster")) {
                Resources.rawFoodID = Resources.rawLobsterID;
            } else if (foodBox.getSelectedItem().equals("Swordfish")) {
                Resources.rawFoodID = Resources.rawSwordfishID;
            } else if (foodBox.getSelectedItem().equals("Monkfish")) {
                Resources.rawFoodID = Resources.rawMonkfishID;
            } else if (foodBox.getSelectedItem().equals("Shark")) {
                Resources.rawFoodID = Resources.rawSharkID;
            } else if (foodBox.getSelectedItem().equals("Cavefish")) {
                Resources.rawFoodID = Resources.rawCavefishID;
            } else if (foodBox.getSelectedItem().equals("Rocktail")) {
                Resources.rawFoodID = Resources.rawRocktailID;
            }
            if (locationBox.getSelectedItem().equals("Rogues' Den")) {
                Resources.rangeID = Resources.rogueFireID;
                Resources.bankID = Resources.rogueBankID;
                Resources.denMode = true;
                Resources.cookingObjectType = "fire...";
            } else if (locationBox.getSelectedItem().equals("Nardah")) {
                Resources.rangeID = Resources.nardahRangeID;
                Resources.bankID = Resources.nardahBankID;
                Resources.nardahMode = true;
                Resources.cookOption = "Cook-at";
                Resources.cookingObjectType = "oven...";
            } else if (locationBox.getSelectedItem().equals("Al Kharid")) {
                Resources.rangeID = Resources.alKharidRangeID;
                Resources.bankID = Resources.alKharidBankID;
                Resources.useFoodMode = true;
                Resources.alKharidMode = true;
                Resources.cookOption = "Cook-at";
                Resources.cookingObjectType = "range...";
            } else if (locationBox.getSelectedItem().equals("Catherby")) {
                Resources.rangeID = Resources.catherbyRangeID;
                Resources.bankID = Resources.catherbyBankID;
                Resources.useFoodMode = true;
                Resources.catherbyMode = true;
                Resources.cookOption = "Cook-at";
                Resources.cookingObjectType = "range...";
            } else if (locationBox.getSelectedItem().equals("Shantay Pass Bonfires")) {
                Resources.rangeID = Resources.bonfireIDs;
                Resources.bonfireMode = true;
                Resources.cookOption = "Use";
                Resources.cookingObjectType = "fire...";
            }
            if (developerMode.isSelected()){
                Resources.developerMode = true;
            } else {
                Resources.developerMode = false;
            }
            setVisible(false);
        }

        private void initComponents() {
            setTitle("RoboCooker GUI");
            setAlwaysOnTop(true);
            setResizable(false);
            titlePanel = new JPanel();
            mainTitle = new JLabel();
            subTitle = new JLabel();
            mainPanel = new JPanel();
            startPanel = new JPanel();
            startButton = new JButton();
            developerMode = new JCheckBox();
            optionsPanel = new JPanel();
            foodLabel = new JLabel();
            foodBox = new JComboBox<>();
            locationLabel = new JLabel();
            locationBox = new JComboBox<>();

            //======== this ========
            Container contentPane = getContentPane();

            //======== titlePanel ========
            {
                titlePanel.setBorder(new EtchedBorder());

                //---- mainTitle ----
                mainTitle.setText("RoboCooker");
                mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
                mainTitle.setHorizontalAlignment(SwingConstants.CENTER);

                //---- subTitle ----
                subTitle.setText("Made by RobotNinja");
                subTitle.setFont(new Font("Arial", Font.PLAIN, 14));
                subTitle.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
                titlePanel.setLayout(titlePanelLayout);
                titlePanelLayout.setHorizontalGroup(
                        titlePanelLayout.createParallelGroup()
                                .addComponent(subTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(titlePanelLayout.createSequentialGroup()
                                        .addComponent(mainTitle, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                );
                titlePanelLayout.setVerticalGroup(
                        titlePanelLayout.createParallelGroup()
                                .addGroup(titlePanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(mainTitle)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(subTitle)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            //======== mainPanel ========
            {
                mainPanel.setBorder(new EtchedBorder());

                //======== startPanel ========
                {
                    startPanel.setBorder(LineBorder.createBlackLineBorder());

                    //---- startButton ----
                    startButton.setText("Start");
                    startButton.setFont(new Font("Arial", Font.BOLD, 20));
                    startButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            startButtonActionPerformed(e);
                        }
                    });

                    //---- developerMode ----
                    developerMode.setText("Developer Mode");

                    GroupLayout startPanelLayout = new GroupLayout(startPanel);
                    startPanel.setLayout(startPanelLayout);
                    startPanelLayout.setHorizontalGroup(
                            startPanelLayout.createParallelGroup()
                                    .addGroup(startPanelLayout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(developerMode)
                                            .addContainerGap())
                                    .addGroup(GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28))
                    );
                    startPanelLayout.setVerticalGroup(
                            startPanelLayout.createParallelGroup()
                                    .addGroup(startPanelLayout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(developerMode, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }

                //======== optionsPanel ========
                {
                    optionsPanel.setBorder(LineBorder.createBlackLineBorder());

                    //---- foodLabel ----
                    foodLabel.setText("Food:");
                    foodLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    foodLabel.setFont(foodLabel.getFont().deriveFont(foodLabel.getFont().getSize() + 5f));

                    //---- foodBox ----
                    foodBox.setModel(new DefaultComboBoxModel<>(new String[] {
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
                    foodBox.setFont(foodBox.getFont().deriveFont(foodBox.getFont().getStyle() | Font.BOLD, foodBox.getFont().getSize() + 3f));

                    //---- locationLabel ----
                    locationLabel.setText("Location:");
                    locationLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    locationLabel.setFont(locationLabel.getFont().deriveFont(locationLabel.getFont().getSize() + 5f));

                    //---- locationBox ----
                    locationBox.setModel(new DefaultComboBoxModel<>(new String[] {
                            "Nardah",
                            "Al Kharid",
                            "Catherby",
                            "More locations soon..."
                    }));
                    locationBox.setFont(locationBox.getFont().deriveFont(locationBox.getFont().getStyle() | Font.BOLD, locationBox.getFont().getSize() + 3f));

                    GroupLayout optionsPanelLayout = new GroupLayout(optionsPanel);
                    optionsPanel.setLayout(optionsPanelLayout);
                    optionsPanelLayout.setHorizontalGroup(
                            optionsPanelLayout.createParallelGroup()
                                    .addGroup(optionsPanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(optionsPanelLayout.createParallelGroup()
                                                    .addComponent(foodLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(foodBox)
                                                    .addComponent(locationLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(locationBox))
                                            .addContainerGap())
                    );
                    optionsPanelLayout.setVerticalGroup(
                            optionsPanelLayout.createParallelGroup()
                                    .addGroup(optionsPanelLayout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(foodLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(foodBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(locationLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(locationBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap())
                    );
                }

                GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
                mainPanel.setLayout(mainPanelLayout);
                mainPanelLayout.setHorizontalGroup(
                        mainPanelLayout.createParallelGroup()
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(mainPanelLayout.createParallelGroup()
                                                .addComponent(optionsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(startPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(8, 8, 8))
                );
                mainPanelLayout.setVerticalGroup(
                        mainPanelLayout.createParallelGroup()
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(startPanel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                    contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                            .addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            contentPaneLayout.setVerticalGroup(
                    contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(11, Short.MAX_VALUE))
            );
            pack();
            setLocationRelativeTo(getOwner());
        }
        private JPanel titlePanel;
        private JLabel mainTitle;
        private JLabel subTitle;
        private JPanel mainPanel;
        private JPanel startPanel;
        private JButton startButton;
        private JCheckBox developerMode;
        private JPanel optionsPanel;
        private JLabel foodLabel;
        private JComboBox<String> foodBox;
        private JLabel locationLabel;
        private JComboBox<String> locationBox;
    }
}
