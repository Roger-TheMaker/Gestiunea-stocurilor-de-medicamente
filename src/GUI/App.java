package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        metoda1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        metoda2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        metoda3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
