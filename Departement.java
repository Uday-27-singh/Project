import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Departement extends JFrame {
    Departement(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(10, 40, 500, 450);
        panel.add(layeredPane);
        JTable table = new JTable();
        table.setBounds(0, 40, 300, 250);
        table.setForeground(Color.red);
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        layeredPane.add(table, JLayeredPane.DEFAULT_LAYER);

        try{
            Conn c = new  Conn();
            String departmentInfo = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(departmentInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(400,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel label1 = new JLabel("Department");
        label1.setBounds(41,11,105,20);
        label1.setForeground(Color.yellow);
        label1.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Budget");
        label2.setBounds(191,11,105,20);
        label2.setForeground(Color.yellow);
        label2.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(label2);


        ImageIcon imageIcon56 = new ImageIcon(ClassLoader.getSystemResource("icon/hotel6.gif"));
        Image i189 = imageIcon56.getImage().getScaledInstance(690, 490, 1);
        ImageIcon imageIcon156 = new ImageIcon(i189);
        JLabel label = new JLabel(imageIcon156);
        label.setBounds(0, 0, 690, 490);
        panel.add(label);


        setUndecorated(true);
        setLayout(null);
        setLocation(550,150);
        setSize(700,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Departement();
    }
}
