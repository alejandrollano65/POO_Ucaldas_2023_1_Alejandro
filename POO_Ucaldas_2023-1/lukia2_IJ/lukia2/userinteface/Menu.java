package lukia2.userinteface;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 623);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(desktopPane_1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("Regístrate");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Cocogoose", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Student studentDetails = new Student();
				studentDetails.show();
				dispose();
				
			}
		});
		btnNewButton.setBounds(32, 37, 287, 47);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Desactivar Usuario");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RemoveStudent remove = new RemoveStudent();
				remove.show();
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Cocogoose", Font.BOLD, 16));
		btnNewButton_1.setBounds(32, 113, 287, 52);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Students");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewStudent viewStudent = new ViewStudent();
				viewStudent.show();
				dispose();
				
			}
		});
		btnNewButton_2.setFont(new Font("Cocogoose", Font.BOLD, 16));
		btnNewButton_2.setBounds(32, 195, 287, 52);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Existing Student");
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateStudent updateStudent = new UpdateStudent();
				updateStudent.show();
				dispose();
				
			}
		});
		btnNewButton_3.setFont(new Font("Cocogoose", Font.BOLD, 16));
		btnNewButton_3.setBounds(32, 272, 287, 52);
		desktopPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login logout = new Login();
				logout.show();
				dispose();
				JOptionPane.showMessageDialog(null, "Successfully logged out :)");
			}
		});
		btnNewButton_4.setFont(new Font("Cocogoose", Font.BOLD, 16));
		btnNewButton_4.setBounds(32, 348, 287, 47);
		desktopPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a Lukia2");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(20, 17, 402, 27);
		desktopPane_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Cocogoose", Font.BOLD, 22));
		contentPane.setLayout(gl_contentPane);
	}
}
