import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAttendanceManagementSystem = new JLabel("Attendance Management System");
		lblAttendanceManagementSystem.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblAttendanceManagementSystem.setBounds(284, 31, 515, 59);
		contentPane.add(lblAttendanceManagementSystem);
		
		JLabel lblName = new JLabel("User Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblName.setBounds(180, 224, 154, 28);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		textField.setBounds(348, 225, 249, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblPassword.setBounds(180, 302, 131, 28);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(348, 303, 249, 35);
		contentPane.add(passwordField);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblUserType.setBounds(180, 364, 154, 35);
		contentPane.add(lblUserType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Lecturer", "Student", "Admin"}));
		comboBox.setBounds(348, 371, 249, 28);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = textField.getText();
				String Pwd = passwordField.getText();
				String type = (String) comboBox.getSelectedItem();
				System.out.println("Username:"+uname+" lblUserType"+type);
				
				if(uname.equals("vicky") && type.equals("Admin")){
					AdminPanel ap = new AdminPanel();
					ap.setVisible(true);
					dispose();
					//contentPane.setVisible(false);
					//setDefalutCloseOperation(contentPane.EXIT_ON_CLOSE);
					//System.exit(0);
				}
				else if(uname.equals("vicky") && type.equals("Student")){
					StudentPanel sp = new StudentPanel();
					sp.setVisible(true);
					dispose();
				}
				else if(uname.equals("vicky") && type.equals("Lecturer")){
					LecturerPanel lp = new LecturerPanel();
					lp.setVisible(true);
					dispose();
				}

				else
				{
					JOptionPane.showMessageDialog(contentPane, "Incorrect Username and Password :)");
				}
			}
		});
		btnNewButton.setBounds(180, 457, 146, 45);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(348, 303, 249, 35);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(776, 183, 263, 286);
		contentPane.add(label);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordChange pc = new PasswordChange();
				pc.setVisible(true);
				dispose();
			}
		});
		btnForgotPassword.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnForgotPassword.setBounds(348, 457, 268, 45);
		contentPane.add(btnForgotPassword);
	}
}
