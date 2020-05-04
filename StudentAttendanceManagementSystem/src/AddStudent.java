import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_3;
	public JTextField textField_4;
	public JPasswordField passwordField;
	public String rdbtn;
	public String date="21-05-1990";
	public String strtextField;
	public String strtextField_1;
	public String strtextField_3;
	public String strtextField_4;
	Connection con=null;
	PreparedStatement pst = null;
	ResultSet rs=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 100, 1112, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblAddStudent.setBounds(379, 36, 236, 42);
		contentPane.add(lblAddStudent);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblStudentId.setBounds(150, 139, 138, 34);
		contentPane.add(lblStudentId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblName.setBounds(150, 204, 138, 34);
		contentPane.add(lblName);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblDob.setBounds(150, 271, 138, 34);
		contentPane.add(lblDob);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblGender.setBounds(150, 336, 138, 34);
		contentPane.add(lblGender);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblBranch.setBounds(150, 402, 138, 34);
		contentPane.add(lblBranch);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblEmail.setBounds(150, 468, 138, 34);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblPassword.setBounds(150, 533, 138, 34);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField.setBounds(340, 139, 203, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField_1.setColumns(10);
		textField_1.setBounds(340, 204, 203, 34);
		contentPane.add(textField_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnNewRadioButton.setBounds(343, 343, 76, 29);
		contentPane.add(rdbtnNewRadioButton);
		rdbtn=rdbtnNewRadioButton.getText();
		System.out.println(rdbtn);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnFemale.setBounds(441, 343, 102, 29);
		contentPane.add(rdbtnFemale);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField_3.setColumns(10);
		textField_3.setBounds(340, 402, 203, 34);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField_4.setColumns(10);
		textField_4.setBounds(340, 476, 203, 34);
		contentPane.add(textField_4);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		passwordField.setBounds(340, 539, 203, 28);
		contentPane.add(passwordField);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(340, 285, 203, 34);
		contentPane.add(dateChooser);
		


		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().equals("") && !textField_1.getText().equals("")
						&& !textField_3.getText().equals("") && !textField_4.getText().equals(""))
				{
					try {
						
						strtextField=textField.getText();
						strtextField_1=textField_1.getText();
						strtextField_3=textField_3.getText();
						strtextField_4=textField_4.getText();
						rdbtn=rdbtnNewRadioButton.getText();
						System.out.println(strtextField);
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Vatsav333");
						/*String query="insert into teacher(id,name,gender,dob,branch, email,password) values("+at.textField
								+","+at.textField_1+","+at.rdbtn+","+at.date+","+at.textField_3+","+at.textField_4+","
								+at.passwordField+")";*/
						String query="insert into student(id,name,dob,branch,email,pass) values(?,?,?,?,?,?)";
						System.out.println("Id: "+strtextField);
						pst=con.prepareStatement(query);
						pst.setString(1, strtextField);
						pst.setString(2, strtextField_1);
						//pst.setString(3, rdbtn);
						pst.setString(3, date);
						pst.setString(4, strtextField_3);
						pst.setString(5, strtextField_4);
						pst.setString(6, "zfs");
						
						rs=pst.executeQuery();
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(contentPane, "Student has been added succesfully");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Pls enter all the fields");
				}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		btnAdd.setBounds(241, 620, 115, 42);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel ap = new AdminPanel();
				ap.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		btnBack.setBounds(428, 620, 115, 42);
		contentPane.add(btnBack);
		
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Add2.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(693, 155, 277, 412);
		contentPane.add(label);
	}
}
