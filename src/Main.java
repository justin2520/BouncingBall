import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);

        MyPanel panel = new MyPanel();
//        MyPanel.setBackground(new Color(150,255,150));

        frame.add(panel);

        frame.setVisible(true);
    }
}