package it.unibo.view.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.controller.GameController;
import it.unibo.view.window.GameWindow;
import it.unibo.view.window.GameWindow.PanelType;


public class SelectionPanel extends JPanel {


    public static final long serialVersionUID = 1;
    private static final int ROWS = 4;
    private static final int COLS = 1;

    public SelectionPanel(final GameController controller, final GameWindow window) {
        this.setLayout(new GridLayout(ROWS, COLS, 0, GameMenu.VERTICAL_GAP));
        final JLabel title = new JLabel("SELEZIONE LIVELLO");

        final JButton startLevel1 = createButton("LIVELLO 1", e -> {
            
        });

        final JButton startLevel2 = createButton("LIVELLO 2", e -> {
                
        });

        final JButton backButton = createButton("BACK", e -> window.switchPanel(PanelType.MENU));

        this.setBackground(Color.BLACK);
        this.add(title);
        setupButton(startLevel1);
        setupButton(startLevel2);
        setupButton(backButton);
    }

    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        return button;
    }

    private void setupButton(final JButton button) {
        button.setFont(GameMenu.TEXT_FONT);
        button.setBackground(GameMenu.BUTTON_COLOR);
        button.setForeground(Color.BLACK);
        this.add(button);
    }
}
