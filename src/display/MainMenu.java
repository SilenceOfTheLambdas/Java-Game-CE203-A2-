package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    MainMenu() {
        JPanel menu = new JPanel();
        //    This will hold the main menu, this menu will show first and then, when the user clicks on start; the game will begin
        JButton startBtn = new JButton("Start game");
        JButton exitBtn = new JButton("Exit");

        menu.setLayout(new BorderLayout());
        menu.add(startBtn, BorderLayout.CENTER);
        menu.add(exitBtn, BorderLayout.SOUTH);
        add(menu, BorderLayout.WEST);

        startBtn.addActionListener(this);
        exitBtn.addActionListener(e -> System.exit(1));

        setSize(new Dimension(900, 900));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        menu.setBackground(Color.BLACK);
        menu.setForeground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        This should destroy this object, and then start a new game
        try {
            createGame();
        } catch (Exception ex) {
            System.out.println("An error occurred while creating a new Game");
            ex.printStackTrace();
        }
    }

    public void createGame() throws Exception {
//        Create a new game
        this.dispose();
        new Game();
    }
}
