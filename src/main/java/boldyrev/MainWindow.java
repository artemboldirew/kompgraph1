package boldyrev;

import javax.swing.*;

public class MainWindow extends JFrame {
    private final DrawPanel dp;

    public MainWindow() {
        dp = new DrawPanel();
        this.add(dp);
    }
}
