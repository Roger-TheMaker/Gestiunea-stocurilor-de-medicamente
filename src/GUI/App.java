package GUI;

import javax.swing.*;

public class App extends JDialog {
    private JPanel contentPane;
    private JTextPane recordspanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton metoda1;
    private JButton metoda2;
    private JButton metoda3;

    public App() {
        setContentPane(contentPane);
        setModal(true);
    }

    public static void App() {
        App p = new  App();
        p.pack();
        p.setSize(800, 600);
        p.setLocation(600, 0);
        p.setVisible(true);
        System.exit(1);
    }
}
