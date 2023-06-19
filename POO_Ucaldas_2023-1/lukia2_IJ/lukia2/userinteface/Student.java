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

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField last_Name;
	private JTextField email;
	private JTextField phone_Number;
	private JTextField address;
	private JTextField password;
	
	
	Connection con = null;
	PreparedStatement pst = null;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 620);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel studentDetails = new JLabel("¿Quién eres?");
		studentDetails.setForeground(Color.BLACK);
		studentDetails.setFont(new Font("Cocogoose", Font.BOLD, 22));
		
		JLabel clientName = new JLabel("Nombre");
		clientName.setForeground(Color.BLACK);
		clientName.setFont(new Font("Cocogoose", Font.BOLD, 14));
		
		JLabel entryNumber = new JLabel("Apellido");
		entryNumber.setForeground(Color.BLACK);
		entryNumber.setFont(new Font("Cocogoose", Font.BOLD, 14));
		
		JLabel emailAddress = new JLabel("Correo electrónico");
		emailAddress.setForeground(Color.BLACK);
		emailAddress.setFont(new Font("Cocogoose", Font.BOLD, 14));
		
		JLabel contactNumber = new JLabel("Celular");
		contactNumber.setForeground(Color.BLACK);
		contactNumber.setFont(new Font("Cocogoose", Font.BOLD, 14));

		JLabel sPassword = new JLabel("Contraseña");
		sPassword.setForeground(Color.BLACK);
		sPassword.setFont(new Font("Cocogoose", Font.BOLD, 14));

		JLabel homeCity = new JLabel("Dirección");
		homeCity.setForeground(Color.BLACK);
		homeCity.setFont(new Font("Cocogoose", Font.BOLD, 14));

		name = new JTextField();
		name.setColumns(10);
		
		last_Name = new JTextField();
		last_Name.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		
		phone_Number = new JTextField();
		phone_Number.setColumns(10);

		address = new JTextField();
		address.setColumns(10);

		password = new JTextField();
		password.setColumns(10);

		
		JButton submit = new JButton("Registrar");
		submit.setForeground(Color.BLACK);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "INSERT INTO `user`(`name`, `last_Name`, `email`, `phone_Number`, `address`) VALUES (?, ?, ?, ?, ?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schema_1", "root", "");
					pst=con.prepareStatement(query);
					pst.setString(1, name.getText());
					pst.setString(2, last_Name.getText());
					pst.setString(3, email.getText());
					pst.setString(4, phone_Number.getText());
					pst.setString(5, address.getText());
					if(name.getText().equals("") || last_Name.getText().equals("") || email.getText().equals("") || phone_Number.getText().equals("") || address.getText().equals("")) {
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
								.addComponent(clientName, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
								.addComponent(emailAddress)
								.addComponent(contactNumber)
								.addComponent(homeCity))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(phone_Number, 242, 242, 242)
								.addComponent(address, 247, 247, 247)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(email)
									.addComponent(name)
									.addComponent(last_Name, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
							.addGap(34))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
							.addComponent(studentDetails)
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
							.addComponent(studentDetails)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(clientName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(last_Name, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
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
