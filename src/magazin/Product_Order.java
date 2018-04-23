package magazin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Product_Order extends JFrame implements ActionListener, ItemListener{
    private static final long serialVersionUID = -2609804855142399606L;

    private JTextField fAmount;
    private JMenuItem clearItem, exitItem;
    private static JComboBox <String> product ;
    private String[] productType = {"","Домати", "Краставици", "Чушки", "Лук", "Чесън","Череши" ,"Ягоди" ,"Праскови" ,"Сливи" ,"Пъпеши" ,"Кайсии"};
    public static float[] itemAvailable = {0,100,100,100,100,100,100,100,100,100,100,100,100};


    public Product_Order() {

        super("Поръчка на продукти");

        JLabel lproduct = new JLabel("Изберете продукт", JLabel.RIGHT);
        JLabel lAmount = new JLabel("Количество", JLabel.RIGHT);
        fAmount = new JTextField(10);

        product = new JComboBox<String>(productType);
        for (int i=12;i < productType.length; i++)
            product.addItem(productType[i]);
        product.addItemListener(this);

        JMenu file = new JMenu("File");
        exitItem = new JMenuItem("Изход");
        file.add(exitItem);
        exitItem.addActionListener(this);

        JMenu edit = new JMenu ("Edit");
        clearItem = new JMenuItem("Изчисти");
        edit.add(clearItem);
        clearItem.addActionListener(this);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);

        JButton okButton = new JButton("Поръчай");
        okButton.addActionListener(this);
        okButton.setActionCommand("porychai");

        JButton delButton = new JButton("Изчисти");
        delButton.addActionListener(this);
        delButton.setActionCommand("izchisti");

        JButton exitButton = new JButton("Изход");
        exitButton.addActionListener(this);
        exitButton.setActionCommand("izhod");

        Container cont = this.getContentPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,2));
        panel1.add(lproduct);
        panel1.add(product);
        panel1.add(lAmount);
        panel1.add(fAmount);

        cont.add(panel1, BorderLayout.NORTH);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout( 1,3,2,2));
        panel3.add(okButton);
        panel3.add(delButton);
        panel3.add(exitButton);

        cont.add(panel3, BorderLayout.SOUTH);
    }

    public void itemStateChanged(ItemEvent argO) {

    }

    public void actionPerformed (ActionEvent e) {
        String name = e.getActionCommand();

        if(name.equals("porychai")) {
            int i =product.getSelectedIndex();
            String s = fAmount.getText();
            float k = Integer.parseInt(s);
            Product_Order.itemAvailable[i]=Product_Order.itemAvailable[i]+k;
            JOptionPane.showMessageDialog(null, "Поръчката е приета. ",s, JOptionPane.INFORMATION_MESSAGE);
        }
        else if(name.equals("izchisti")) {
            fAmount.setText("");
        }
        else if(name.equals("izhod")){
            Product_Order.this.dispose();
        }
        else if (e.getSource() == exitItem) {
            Product_Order.this.dispose();
        }
        else if (e.getSource() == clearItem) {
            fAmount.setText("");
        }
    }
}
