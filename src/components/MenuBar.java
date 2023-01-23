import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

class MenuBar extends JMenuBar {

    float menuFontSize;
    Font menuFont;
    FontMetrics menuFontMetrics;

    JMenu fileMenu, editMenu;

    JMenuItem newProjectItem, openProjectItem;
    JMenuItem undoItem, redoItem;

    public MenuBar() {
        super();

        menuFontSize = 12f;

        try {
            menuFont = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getResource("Proxima_Nova.ttf").getPath())).deriveFont(menuFontSize);
        }
        catch (Exception e) {
            menuFont = new Font("Arial", Font.PLAIN, (int)menuFontSize);
            System.out.println(e);
        }

        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.setFont(menuFont);

        newProjectItem = new JMenuItem("New Project");
        newProjectItem.getAccessibleContext().setAccessibleDescription("Create a new project");
        newProjectItem.setFont(menuFont);

        openProjectItem = new JMenuItem("Open Project");
        openProjectItem.getAccessibleContext().setAccessibleDescription("Open an existing project");
        openProjectItem.setFont(menuFont);

        fileMenu.add(newProjectItem);
        fileMenu.add(openProjectItem);

        // ************************************************************

        editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        editMenu.setFont(menuFont);

        undoItem = new JMenuItem("Undo");
        undoItem.getAccessibleContext().setAccessibleDescription("Undo last action");
        undoItem.setFont(menuFont);

        redoItem = new JMenuItem("Redo");
        redoItem.getAccessibleContext().setAccessibleDescription("Redo next action");
        redoItem.setFont(menuFont);

        editMenu.add(undoItem);
        editMenu.add(redoItem);

        // ************************************************************

        this.add(fileMenu);
        this.add(editMenu);
    }
}
