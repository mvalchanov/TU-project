package magazin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Available extends JFrame implements ActionListener{
    private static final long serialVersionUID = -4488922655429469581L;

    public Available() {
        super("Наличност");

        JButton exitButton = new JButton ("Изход");
        exitButton.addActionListener(this);
        exitButton.setActionCommand("izhod");

        Container cont = this.getContentPane();

		/*JPanel p1 = new JPanel ();
		p1.setLayout(new GridLayout(2,1));
		JLabel l1 = new JLabel("Наличност", JLabel.CENTER);
		p1.add(l1);

		cont.add(p1, BorderLayout.NORTH);
		*/

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1));
        p2.add(exitButton);
        cont.add(p2, BorderLayout.PAGE_END);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(11,1));

        JLabel l7 = new JLabel("Домати");
        JLabel l8 = new JLabel(""+Product_Order.itemAvailable[1]+"kg");
        JLabel l9 = new JLabel("Краставици");
        JLabel l10 = new JLabel(""+Product_Order.itemAvailable[2]+"kg");
        JLabel l11 = new JLabel("Чушки");
        JLabel l12 = new JLabel (""+Product_Order.itemAvailable[3]+"kg");
        JLabel l13 = new JLabel("Лук");
        JLabel l14 = new JLabel (""+Product_Order.itemAvailable[4]+"kg");
        JLabel l15 = new JLabel("Чесън");
        JLabel l16 = new JLabel(""+Product_Order.itemAvailable[5]+"kg");
        JLabel l17 = new JLabel("Череши");
        JLabel l18 = new JLabel(""+Product_Order.itemAvailable[6]+"kg");
        JLabel l19 = new JLabel("Ягоди");
        JLabel l20 = new JLabel(""+Product_Order.itemAvailable[7]+"kg");
        JLabel l21 = new JLabel("Праскови");
        JLabel l22 = new JLabel(""+Product_Order.itemAvailable[8]+"kg");
        JLabel l23 = new JLabel("Сливи");
        JLabel l24 = new JLabel(""+Product_Order.itemAvailable[9]+"kg");
        JLabel l25 = new JLabel("Пъпеши");
        JLabel l26 = new JLabel(""+Product_Order.itemAvailable[10]+"kg");
        JLabel l27 = new JLabel("Кайсии");
        JLabel l28 = new JLabel(""+Product_Order.itemAvailable[11]+"kg");

        p3.add(l7);
        p3.add(l8);
        p3.add(l9);
        p3.add(l10);
        p3.add(l11);
        p3.add(l12);
        p3.add(l13);
        p3.add(l14);
        p3.add(l15);
        p3.add(l16);
        p3.add(l17);
        p3.add(l18);
        p3.add(l19);
        p3.add(l20);
        p3.add(l21);
        p3.add(l22);
        p3.add(l23);
        p3.add(l24);
        p3.add(l25);
        p3.add(l26);
        p3.add(l27);
        p3.add(l28);

        cont.add(p3,BorderLayout.CENTER);
    }


    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        if (name.equals("izhod")) {
            Available.this.dispose();
        }
    }

}
