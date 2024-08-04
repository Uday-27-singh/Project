import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee extends JFrame {
    Employee(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        //panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);


        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(10, 40, 630, 450);
        panel.add(layeredPane);



        JTable table = new JTable();
        table.setBounds(10, 34, 500, 450);
        table.setForeground(Color.red);
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        layeredPane.add(table, JLayeredPane.DEFAULT_LAYER);
        try{
          Conn c = new Conn();
            String EmployeeSQL = "select * from Employee";
            ResultSet resultSet = c.statement.executeQuery(EmployeeSQL);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(350,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(31, 11, 70, 19);
        name.setForeground(Color.yellow);
        name.setFont(new Font("Tahoma", 1, 14));
        panel.add(name);

        JLabel Age = new JLabel("Age");
        Age.setBounds(93, 11, 70, 19);
        Age.setForeground(Color.yellow);
        Age.setFont(new Font("Tahoma", 1, 14));
        panel.add(Age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(155, 11, 70, 19);
        gender.setForeground(Color.yellow);
        gender.setFont(new Font("Tahoma", 1, 14));
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(217, 11, 70, 19);
        job.setForeground(Color.yellow);
        job.setFont(new Font("Tahoma", 1, 14));
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(279, 11, 70, 19);
        salary.setForeground(Color.yellow);
        salary.setFont(new Font("Tahoma", 1, 14));
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(341, 11, 70, 19);
        phone.setForeground(Color.yellow);
        phone.setFont(new Font("Tahoma", 1, 14));
        panel.add(phone);

        JLabel gmail = new JLabel("Gmail");
        gmail.setBounds(403, 11, 70, 19);
        gmail.setForeground(Color.yellow);
        gmail.setFont(new Font("Tahoma", 1, 14));
        panel.add(gmail);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(465, 11, 70, 19);
        aadhar.setForeground(Color.yellow);
        aadhar.setFont(new Font("Tahoma", 1, 14));
        panel.add(aadhar);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/mountain.jpg"));
        Image i1 = imageIcon.getImage().getScaledInstance(990, 590, 1);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 990, 590);
        panel.add(label);

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1000,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee();
    }
}
