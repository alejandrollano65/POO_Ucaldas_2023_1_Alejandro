package lukia2.userinteface;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Client extends JFrame {

    private JPanel contentPane;
    private JTextField last_Name;
    private JTextField last_name;
    private JTextField email;
    private JTextField phone_Number;
    private JTextField address;

    Connection con = null;
    PreparedStatement pst = null;
    public JPanel panel1;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Client frame = new Client();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Client() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 620);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel ClientDetails = new JLabel("Student Details");
        ClientDetails.setForeground(Color.BLACK);
        ClientDetails.setFont(new Font("Cocogoose", Font.BOLD, 22));

        JLabel studentName = new JLabel("Student Name");
        studentName.setForeground(Color.BLACK);
        studentName.setFont(new Font("Cocogoose", Font.BOLD, 14));

        JLabel entryNumber = new JLabel("Apellido");
        entryNumber.setForeground(Color.BLACK);
        entryNumber.setFont(new Font("Cocogoose", Font.BOLD, 14));

        JLabel emailAddress = new JLabel("Email Address");
        emailAddress.setForeground(Color.BLACK);
        emailAddress.setFont(new Font("Cocogoose", Font.BOLD, 14));

        JLabel contactNumber = new JLabel("Contact Number");
        contactNumber.setForeground(Color.BLACK);
        contactNumber.setFont(new Font("Cocogoose", Font.BOLD, 14));

        last_Name = new JTextField();
        last_Name.setColumns(10);

        last_name = new JTextField();
        last_name.setColumns(10);

        email = new JTextField();
        email.setColumns(10);

        phone_Number = new JTextField();
        phone_Number.setColumns(10);

        JLabel homeCity = new JLabel("Home City");
        homeCity.setForeground(Color.BLACK);
        homeCity.setFont(new Font("Cocogoose", Font.BOLD, 14));

        JButton submit = new JButton("Submit");
        submit.setForeground(Color.BLACK);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String query = "INSERT INTO `student`(`name`, `entrynumber`, `email`, `contactnumber`, `homecity`) VALUES (?, ?, ?, ?, ?)";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "");
                    pst=con.prepareStatement(query);
                    pst.setString(1, last_Name.getText());
                    pst.setString(2, last_name.getText());
                    pst.setString(3, email.getText());
                    pst.setString(4, phone_Number.getText());
                    pst.setString(5, address.getText());
                    if(last_Name.getText().equals("") || last_name.getText().equals("") || email.getText().equals("") || phone_Number.getText().equals("") || address.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Fill all the details :(");
                    }
                    else {
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Student added Successfully :)");
                        dispose();
                        Menu menu = new Menu();
                        menu.show();
                    }
                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        });
        submit.setFont(new Font("Cocogoose", Font.BOLD, 14));

        address = new JTextField();
        address.setColumns(10);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.GRAY);

        JButton btnNewButton = new JButton("Cancel");
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.show();
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Cocogoose", Font.BOLD, 14));

        JDesktopPane desktopPane_1 = new JDesktopPane();
        desktopPane_1.setBackground(Color.GRAY);

        JDesktopPane desktopPane_2 = new JDesktopPane();
        desktopPane_2.setBackground(Color.GRAY);

        JDesktopPane desktopPane_3 = new JDesktopPane();
        desktopPane_3.setBackground(Color.GRAY);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(desktopPane_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(43)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(entryNumber)
                                                        .addComponent(studentName, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                                        .addComponent(emailAddress)
                                                        .addComponent(contactNumber)
                                                        .addComponent(homeCity))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(phone_Number, 242, 242, 242)
                                                        .addComponent(address, 247, 247, 247)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                .addComponent(email)
                                                                .addComponent(last_Name)
                                                                .addComponent(last_name, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                                                .addGap(34))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                                .addComponent(ClientDetails)
                                                .addGap(137))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(119)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(submit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                                                .addGap(128)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(desktopPane_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                .addGap(18))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                .addGap(11)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(ClientDetails)
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(studentName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(last_Name, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                                .addGap(28)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(last_name, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(entryNumber))
                                                .addGap(41)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(emailAddress))
                                                .addGap(37)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(contactNumber)
                                                        .addComponent(phone_Number, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                                .addGap(41)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(address, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(homeCity))
                                                .addGap(43)
                                                .addComponent(submit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(desktopPane_2, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(desktopPane_3, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                .addGap(13)
                                .addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(6))
        );
        contentPane.setLayout(gl_contentPane);
    }

}
