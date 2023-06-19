package lukia2.userinteface;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUser extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewUser frame = new ViewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 753, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(423, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Lista de usuarios");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Cocogoose", Font.BOLD, 28));
		lblNewLabel.setBounds(243, 27, 270, 52);
		desktopPane.add(lblNewLabel);
		
		
		
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Cocogoose", Font.BOLD, 14));
		btnNewButton.setBounds(228, 91, 113, 32);
		desktopPane.add(btnNewButton);
		
		JButton viewU = new JButton("viwe");
		viewU.setForeground(Color.BLACK);
		viewU.setFont(new Font("Cocogoose", Font.BOLD, 14));
		viewU.setBounds(412, 91, 113, 32);
		desktopPane.add(viewU);
		contentPane.setLayout(gl_contentPane);
		
		viewU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.show();
				dispose();
			}
		});
	}
}	

