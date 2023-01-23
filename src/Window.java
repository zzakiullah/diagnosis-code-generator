import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Window extends JFrame implements ActionListener, KeyListener {

    int width, height;

    Timer timer;

    MenuBar menuBar;

    TitleScreen titleScreen;
    MenuScreen menuScreen;
    MainScreen mainScreen;

    JPanel cards;
    CardLayout cLayout;

    public Window() {
        super("Diagnosis Code Generator");
        // setIconImage(new ImageIcon(getClass().getResource("").getPath()).getImage());

        width = 800;
        height = 600;

        setSize(width, height);

        menuBar = new MenuBar();
        this.setJMenuBar(menuBar);

        titleScreen = new TitleScreen(this, width, height);
        menuScreen = new MenuScreen();
        mainScreen = new MainScreen();

        cLayout = new CardLayout();
        cards = new JPanel(cLayout);
        cards.add(titleScreen, "title");
        cards.add(menuScreen, "menu");
        cards.add(mainScreen, "main");
        add(cards);

        cLayout.show(cards, "title");

        timer = new Timer(10, this);
        timer.start();

        addKeyListener(this);
        requestFocus();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == timer) {

        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

}
