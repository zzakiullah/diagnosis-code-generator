import javax.swing.*;
import java.awt.*;
import java.io.File;

class TitleScreen extends JLayeredPane {

    Window window;

    JLabel titleLabel;
    JButton newBtn;
    JButton openBtn;

    float titleFontSize;
    float btnFontSize;

    Font titleFont;
    Font btnFont;

    FontMetrics titleFontMetrics;
    FontMetrics btnFontMetrics;

    public TitleScreen(Window window, int width, int height) {
        super();

        this.window = window;

        this.setLayout(null);
        this.setSize(width, height);
        this.setLocation(0, 0);

        titleFontSize = 28f;
        btnFontSize = 16f;

        try {
            titleFont = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getResource("Proxima_Nova.ttf").getPath())).deriveFont(titleFontSize);
            btnFont = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getResource("Proxima_Nova.ttf").getPath())).deriveFont(btnFontSize);
        }
        catch (Exception e) {
            titleFont = new Font("Arial", Font.PLAIN, (int)titleFontSize);
            btnFont = new Font("Arial", Font.PLAIN, (int)btnFontSize);
            System.out.println(e);
        }
        titleFontMetrics = getFontMetrics(titleFont);
        btnFontMetrics = getFontMetrics(btnFont);

        titleLabel = new JLabel("Diagnosis Code Generator", SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setSize(width/2, titleFontMetrics.getHeight());
        titleLabel.setLocation(width/2 - width/4, height/4);

        newBtn = new JButton("New Project");
        newBtn.setFont(btnFont);
        newBtn.addActionListener(this.window);
        newBtn.setSize(160, btnFontMetrics.getHeight() + 14);
        newBtn.setLocation(width/2 - newBtn.getWidth()/2, 200);
        newBtn.setFocusPainted(false);

        openBtn = new JButton("Open Project");
        openBtn.setFont(btnFont);
        openBtn.addActionListener(this.window);
        openBtn.setSize(160, btnFontMetrics.getHeight() + 14);
        openBtn.setLocation(width/2 - newBtn.getWidth()/2, newBtn.getY() + newBtn.getHeight() + 10);
        openBtn.setFocusPainted(false);

        this.add(titleLabel, JLayeredPane.PALETTE_LAYER);
        this.add(newBtn, JLayeredPane.DRAG_LAYER);
        this.add(openBtn, JLayeredPane.DRAG_LAYER);
    }
}
