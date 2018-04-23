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
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Product_Sell extends JFrame implements ActionListener, ItemListener {
    private static final long serialVersionUID = -4912027139418548317L;

    private JMenu exitItem, clearItem;
    private JButton okButton;
    private JComboBox<String> product;
    private String[] productType = { "","Домати", "Краставици", "Чушки", "Лук", "Чесън","","Череши" ,"Ягоди" ,"Праскови" ,"Сливи" ,"Пъпеши" ,"Кайсии" };
    private float [] productPrice = {0, 2.40f, 3f, 2.30f, 1.5f, 5f,0,5f,3f,4.40f,5f, 5f,9f};
    float k, kg;
    private JTextField fKgM, fAvailable, fAmount, fSum;

    public Product_Sell() {

        super( "Продаване на продукти");

        JLabel lproduct = new JLabel("Избери Продукт", JLabel.RIGHT);
        JLabel lKgM = new JLabel("лв/kg", JLabel.RIGHT);
        JLabel lAvaiiabie = new JLabel("Наличност/kg ", JLabel.RIGHT);
        JLabel lAmount = new JLabel("Желано количество", JLabel.RIGHT);
        JLabel lSum = new JLabel("Сума", JLabel.RIGHT);

        fKgM = new JTextField(10);
        fAvailable = new JTextField(10);
        fAmount = new JTextField(10);
        fSum = new JTextField( 10);

        product = new JComboBox<String>();
        for (int i=0; i < productType.length; i++)
            product.addItem(productType[i]);
        product.addItemListener(this);

        JMenu file = new JMenu("File");
        exitItem = new JMenu("Изход");
        file.add(exitItem);
        exitItem.addActionListener(this);


        JMenu edit = new JMenu("Edit");
        clearItem = new JMenu("Изчисти");
        edit.add(clearItem);
        clearItem.addActionListener(this);


        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);


        JButton okButton = new JButton("Изписване");
        okButton.addActionListener(this);
        okButton.setActionCommand("izpisvane");


        JButton delButton = new JButton ("Изчисти");
        delButton.addActionListener(this);
        delButton.setActionCommand("iztrii");

        JButton exitButton = new JButton ("Отказ");
        exitButton.addActionListener(this);
        exitButton.setActionCommand("otkaz");

        JButton calButton = new JButton ("Сума");
        calButton.addActionListener(this);
        calButton.setActionCommand("suma");


        Container cont = this.getContentPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(6,2));
        panel1.add(lproduct);
        panel1.add(product);
        panel1.add(lKgM);
        panel1.add(fKgM);
        panel1.add(lAvaiiabie);
        panel1.add(fAvailable);
        panel1.add(lAmount);
        panel1.add(fAmount);
        panel1.add(lSum);
        panel1.add(fSum);

        cont.add(panel1, BorderLayout.NORTH);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2,2,2,2));

        panel3.add(calButton);
        panel3.add(delButton);
        panel3.add(okButton);
        panel3.add(exitButton);

        cont.add(panel3, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();


        if (name.equals("otkaz")) {
            Product_Sell.this.dispose();
        }
        else if (name.equals("izpisvane")) {
            int i =product.getSelectedIndex();
            String s = fAmount.getText();
            float k = Integer.parseInt(s);
            Product_Order.itemAvailable[i]=Product_Order.itemAvailable[i]-k;
            JOptionPane.showMessageDialog( okButton, "Поръчката е потвърдена и приета."+"\n"+"Дължима сума: "+k*kg+" лв");
        }
        else if (name.equals("suma")) {
            String s = fAmount.getText();
            k = Integer.parseInt(s);
            fSum.setText(""+k*kg);
        }
        else if (name.equals("iztrii")) {
            fAvailable.setText("");
            fAmount.setText("");
            fSum.setText("");
            fKgM.setText("");
        }
        else if (e.getSource() == exitItem) {
            Product_Sell.this.dispose();
        }
        else if (e.getSource() == clearItem) {
            fAvailable.setText("");
            fAmount.setText("");
            fSum.setText("");
            fKgM.setText("");
        }
    }

    public void itemStateChanged(ItemEvent argO) {
        int i = product.getSelectedIndex();
        kg = productPrice[i];
        fKgM.setText(kg+" лв");
        fAvailable.setText(""+Product_Order.itemAvailable[i]);
        fAmount.setText("");
    }
}
