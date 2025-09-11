package boldyrev;

import javax.swing.*;

public class   Main {
    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mw.setSize(Config.width, Config.height);
        mw.setVisible(true);
    }
}
