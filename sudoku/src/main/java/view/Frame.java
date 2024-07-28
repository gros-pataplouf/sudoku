package view;

import javax.swing.*;

public class Frame extends JFrame {
    Frame() {
        setTitle("Sukoku");
        setSize(540, 540);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // main method
    public static void main(String argvs[]) {
        new Frame();
    }
}