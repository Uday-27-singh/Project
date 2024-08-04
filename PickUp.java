import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {
    PickUp(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,790,590);
        panel.setLayout(null);
        add(panel);

        JLabel pus = new JLabel("Pick Up Service");
        pus.setBounds(90,11,160,25);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(pus);

        JLabel TOC = new JLabel("Type of Car");
        TOC.setBounds(32,97,89,14);
        TOC.setForeground(Color.WHITE);
        TOC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(TOC);

        Choice c = new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);

        try{
           Conn C = new Conn();
            ResultSet resultSet = C.statement.executeQuery("select * from driver");
            while (resultSet.next()){
                c.add(resultSet.getString("carname"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(10, 40, 700, 450);
        panel.add(layeredPane);
        JTable table = new JTable();
        table.setBounds(10, 250, 500, 250);
        table.setForeground(Color.red);
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        layeredPane.add(table, JLayeredPane.DEFAULT_LAYER);

        try{
           Conn C = new Conn();
            String q = "select * from driver";
            ResultSet resultSet = C.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(24, 208, 46, 14);
        name.setForeground(Color.yellow);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(86, 208, 46, 14);
        age.setForeground(Color.yellow);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(148, 208, 46, 14);
        gender.setForeground(Color.yellow);
        panel.add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(230, 208, 100, 14);
        company.setForeground(Color.yellow);
        panel.add(company);

        JLabel Carname = new JLabel("Car Name");
        Carname.setBounds(303, 208, 100, 14);
        Carname.setForeground(Color.yellow);
        panel.add(Carname);

        JLabel available = new JLabel("Available");
        available.setBounds(364, 208, 100, 14);
        available.setForeground(Color.yellow);
        panel.add(available);

        JLabel loacation = new JLabel("Loacation");
        loacation.setBounds(460, 208, 100, 14);
        loacation.setForeground(Color.yellow);
        panel.add(loacation);

        JButton display = new JButton("Display");
        display.setBounds(300,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where carname = '"+c.getSelectedItem()+"'";
                try{
                 Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        JButton Back = new JButton("Back");
        Back.setBounds(420,500,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/snow4.jpeg"));
        Image i1 = imageIcon.getImage().getScaledInstance(800, 600, 1);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 800, 600);
        panel.add(label);


        setLayout(null);
        setSize(800,600);
        setLocation(500,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PickUp();
    }
}
