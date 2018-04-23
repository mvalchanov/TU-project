package magazin;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class Menu extends JFrame implements ActionListener {

    public static void main(String[] args) {
        JFrame app = new Menu();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(800,800);
        app.setLocation(300,150);
        app.setVisible(true);
        app.setResizable(true);
    }
    private static final long serialVersionUID = 8199306177481192715L;

    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem inItem, outItem, exitItem, availableItem;
    private JLabel label1;
    public Menu()  {
        super("Хранителен магазин");

        file = new JMenu("File");

        exitItem = new JMenuItem("Изход");
        exitItem.addActionListener(this);

        inItem = new JMenuItem("Продаване на стоки");
        inItem.addActionListener(this);

        outItem = new JMenuItem("Поръчване на стоки");
        outItem.addActionListener(this);

        availableItem = new JMenuItem("Наличност");
        availableItem.addActionListener(this);

        file.add(inItem);
        file.add(outItem);
        file.add(availableItem);
        file.addSeparator();
        file.add(exitItem);



        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(file);

        Container cont = this.getContentPane();

        JPanel panel1 = new JPanel ();
        JPanel panel2 = new JPanel ();

        cont.setLayout(new BoxLayout(cont, BoxLayout.X_AXIS));
        cont.add(panel1);
        cont.add(panel2);


        panel1.setLayout(new GridLayout(4,1,0,10));

        JButton inButton = new JButton("Продаване на стоки");
        inButton.addActionListener(this);
        inButton.setActionCommand("prodavane");

        JButton outButton = new JButton("Поръчване на стоки");
        outButton.addActionListener(this);
        outButton.setActionCommand("porychvane");

        JButton availableButton = new JButton("Наличност");
        availableButton.addActionListener(this);
        availableButton.setActionCommand("nalichnost");

        JButton exitButton = new JButton("Изход");
        exitButton.addActionListener(this);
        exitButton.setActionCommand("izhod");

        panel1.add(inButton);
        panel1.add(Box.createRigidArea(new Dimension(0,20)));
        panel1.add(outButton);
        panel1.add(Box.createRigidArea(new Dimension(0,7)));
        panel1.add(availableButton);
        panel1.add(Box.createRigidArea(new Dimension(0,7)));
        panel1.add(exitButton);

        label1 = new JLabel(new ImageIcon("resources/vegetables4.jpg"));
        panel2.add(label1);

        Menu.this.getContentPane().add( panel1 );
    }
    public void actionPerformed (ActionEvent e) {
        String name = e.getActionCommand();

        if(name.equals("prodavane")) {
            JFrame f1 = new Product_Sell();
            f1.setSize(700,300);
            f1.setLocation( 650,400);
            f1.setVisible(true);
            f1.setResizable(false);
        }
        else if(name.equals("porychvane")) {
            JFrame f1 = new Product_Order();
            f1.setSize(350, 150);
            f1.setLocation(650,400);
            f1.setVisible(true);
            f1.setResizable(false);

        }
        else if(name.equals("nalichnost")) {
            JFrame f1 = new Available();

            f1.setSize(250,300);
            f1.setLocation(650,400);
            f1.setVisible(true);
            f1.setResizable(false);
        }
        else if(name.equals("izhod")){
            System.exit(0);
        }
        else if (e.getSource() == exitItem) {
            System.exit(0);
        }
        else if (e.getSource() == inItem) {
            JFrame f1 = new Product_Sell();
            f1.setSize(350,300);
            f1.setLocation( 650,400);
            f1.setVisible(true);
            f1.setResizable(false);
        }
        else if (e.getSource() == outItem) {
            JFrame f1 = new Product_Order();
            f1.setSize(350, 150);
            f1.setLocation(650,400);
            f1.setVisible(true);
            f1.setResizable(false);
        }
        else if (e.getSource()== availableItem) {
            JFrame f1 = new Available();
            f1.setSize(250,300);
            f1.setLocation(650,400);
            f1.setVisible(true);
            f1.setResizable(false);
        }
    }






}
