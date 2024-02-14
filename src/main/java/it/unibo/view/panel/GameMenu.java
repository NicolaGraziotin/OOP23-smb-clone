package it.unibo.view.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.controller.GameController;
import it.unibo.view.window.GameWindow.PanelType;

/**
 * The GameMenu class represents the panel of the main menu of the game.
 * It extends JPanel and provides buttons to switch to the GamePanel, check the scoreboard after a level and quit the application.
 */
public class GameMenu extends JPanel {

    public static final long serialVersionUID = 1;
    public static final int ROWS = 3;
    public static final int COLS = 1;

    /**
     * Constructs a new instance of GameMenu with the specified GameController and GameWindowSwing.
     * 
     * @param controller the GameController associated with the window.
     * @param window the GameWindowSwing that can switch to change panel.
     */
    public GameMenu(final GameController controller) {
        this.setLayout(new GridLayout(ROWS, COLS));
        final JButton startButton = new JButton("START");
        final JButton scoreboardButton = new JButton("SCOREBOARD");
        final JButton quitButton = new JButton("QUIT");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.start();
                controller.getGameWindow().switchPanel(PanelType.GAME);
            }
        });

        scoreboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.getGameWindow().switchPanel(PanelType.SCOREBOARD);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Sei sicuro di volere uscire?", 
            "Esci dal gioco", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
                }
            }
        });

        this.add(startButton);
        this.add(scoreboardButton);
        this.add(quitButton);
    }
}
