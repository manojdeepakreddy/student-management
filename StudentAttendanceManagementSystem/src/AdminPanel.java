import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblAdminPanel.setBounds(355, 30, 244, 61);
		contentPane.add(lblAdminPanel);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent as = new AddStudent();
				as.setVisible(true);
				dispose();
			}
		});
		btnAddStudent.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnAddStudent.setBounds(149, 170, 255, 43);
		contentPane.add(btnAddStudent);
		
		JButton btnAddTeacher = new JButton("Add Lecturer");
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacher at = new AddTeacher();
				at.setVisible(true);
				dispose();
			}
		});
		btnAddTeacher.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnAddTeacher.setBounds(149, 271, 255, 43);
		contentPane.add(btnAddTeacher);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnExit.setBounds(223, 447, 115, 43);
		contentPane.add(btnExit);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblAdmin.setBounds(678, 418, 93, 28);
		contentPane.add(lblAdmin);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Admin-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(607, 152, 255, 253);
		contentPane.add(lblNewLabel);
		
		JButton btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnBackToLogin.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnBackToLogin.setBounds(149, 362, 255, 43);
		contentPane.add(btnBackToLogin);
	}

}
