import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {
    CustomerInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(10, 40, 700, 450);
        panel.add(layeredPane);


        JTable table = new JTable();
        table.setBounds(0, 0, 650, 400);
        table.setForeground(Color.red);
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        layeredPane.add(table, JLayeredPane.DEFAULT_LAYER);

        try {

            Conn c = new   Conn();
            String q = "select * from Customer";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e ){
            e.printStackTrace();
        }

        JLabel id = new JLabel("ID");
        id.setBounds(21, 11, 80, 14);
        id.setForeground(Color.red);
        id.setFont(new Font("Tahoma", 1, 14));
        panel.add(id);


        JLabel number = new JLabel("Number");
        number.setBounds(96, 11, 60, 12);
        number.setForeground(Color.red);
        number.setFont(new Font("Tahoma", 1, 14));
        panel.add(number);


        JLabel name = new JLabel("Name");
        name.setBounds(191, 11, 80, 14);
        name.setForeground(Color.red);
        name.setFont(new Font("Tahoma", 1, 14));
        panel.add(name);



        JLabel gender = new JLabel("Gender");
        gender.setBounds(276, 11, 80, 14);
        gender.setForeground(Color.red);
        gender.setFont(new Font("Tahoma", 1, 14));
        panel.add(gender);



        JLabel country = new JLabel("Country");
        country.setBounds(371, 11, 80, 14);
        country.setForeground(Color.red);
        country.setFont(new Font("Tahoma", 1, 14));
        panel.add(country);



        JLabel room = new JLabel("Room");
        room.setBounds(445, 11, 80, 14);
        room.setForeground(Color.red);
        room.setFont(new Font("Tahoma", 1, 14));
        panel.add(room);



        JLabel Time = new JLabel("CI Time");
        Time.setBounds(523, 11, 80, 14);
        Time.setForeground(Color.red);
        Time.setFont(new Font("Tahoma", 1, 14));
        panel.add(Time);



        JLabel Deposit = new JLabel("Deposit");
        Deposit.setBounds(601, 11, 80, 14);
        Deposit.setForeground(Color.red);
        Deposit.setFont(new Font("Tahoma", 1, 14));
        panel.add(Deposit);

        JButton back = new JButton("Back");
        back.setBounds(672,510,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/dark2.jpeg"));
        Image i1 = imageIcon.getImage().getScaledInstance(890, 590, 1);
        ImageIcon imageIcon1234 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1234);
        label.setBounds(0, 0, 890, 590);
        panel.add(label);


        setUndecorated(true);
        setLayout(null);
        setSize(900,600);
        setLocation(500,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
