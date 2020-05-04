import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PasswordChange extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordChange frame = new PasswordChange();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PasswordChange() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblChangePassword.setBounds(309, 46, 337, 47);
		contentPane.add(lblChangePassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		textField.setBounds(416, 186, 257, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		textField_1.setColumns(10);
		textField_1.setBounds(416, 273, 257, 40);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Password has been changed succesfully  !!!");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnNewButton.setBounds(226, 455, 150, 47);
		contentPane.add(btnNewButton);
		
		JButton btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnBackToLogin.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnBackToLogin.setBounds(493, 455, 234, 47);
		contentPane.add(btnBackToLogin);
		
		JLabel lblNewLabel = new JLabel("Mobile Number");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNewLabel.setBounds(186, 189, 201, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNewPassword.setBounds(186, 276, 201, 35);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfrimPassword = new JLabel("Confrim Password");
		lblConfrimPassword.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblConfrimPassword.setBounds(186, 355, 215, 35);
		contentPane.add(lblConfrimPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(416, 355, 257, 39);
		contentPane.add(passwordField);
	}

}
