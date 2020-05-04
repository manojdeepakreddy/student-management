import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;

public class AttendanceTaking extends JFrame {

	private JPanel contentPane;
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
					AttendanceTaking frame = new AttendanceTaking();
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
	public AttendanceTaking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblAttendance.setBounds(486, 33, 239, 53);
		contentPane.add(lblAttendance);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblSubject.setBounds(205, 155, 104, 41);
		contentPane.add(lblSubject);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Computer Programming", "Physics", "Mathematics", "Chemistry", "Mechanics", "Graphics"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		comboBox.setBounds(324, 160, 260, 34);
		contentPane.add(comboBox);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblRollNo.setBounds(33, 253, 86, 28);
		contentPane.add(lblRollNo);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblStudentName.setBounds(251, 253, 161, 28);
		contentPane.add(lblStudentName);
		
		JLabel lblAttendanceStatus = new JLabel("Attendance Status");
		lblAttendanceStatus.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAttendanceStatus.setBounds(506, 253, 186, 28);
		contentPane.add(lblAttendanceStatus);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDate.setBounds(902, 253, 86, 28);
		contentPane.add(lblDate);
		
		JTextArea textArea = new JTextArea("1920A501");
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textArea.setBounds(33, 310, 132, 28);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea("1920A502");
		textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textArea_1.setBounds(33, 374, 132, 28);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea("1920A503");
		textArea_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textArea_2.setBounds(33, 436, 132, 28);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea("VickyReddy K");
		textArea_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textArea_3.setBounds(246, 310, 179, 28);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea("Mallikarjun");
		textArea_4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textArea_4.setBounds(246, 374, 179, 28);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea("VatsavReddy K");
		textArea_5.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textArea_5.setBounds(246, 436, 179, 28);
		contentPane.add(textArea_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"        Select", "Present", "Absent"}));
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		comboBox_1.setBounds(506, 307, 186, 28);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"        Select", "Present", "Absent"}));
		comboBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		comboBox_2.setBounds(506, 371, 186, 28);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"        Select", "Present", "Absent"}));
		comboBox_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		comboBox_3.setBounds(506, 433, 186, 28);
		contentPane.add(comboBox_3);
		java.util.Date now = new java.util.Date();
        System.out.println("Value of java.util.Date : " + now);
     
        //converting java.util.Date to java.sql.Date in Java
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
   
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Vatsav333");
					String query="insert into attendance(id,name,subject,status,dateval) values(?,?,?,?,?)";
					pst=con.prepareStatement(query);
					pst.setString(1, textArea.getText());
					pst.setString(2, textArea_3.getText());
					pst.setString(3, comboBox.getSelectedItem().toString());
					pst.setString(4, comboBox_1.getSelectedItem().toString());
					pst.setDate(5,sqlDate);
					rs=pst.executeQuery();
					
					String query1="insert into attendance(id,name,subject,status,dateval) values(?,?,?,?,?)";
					pst=con.prepareStatement(query1);
					pst.setString(1, textArea_1.getText());
					pst.setString(2, textArea_4.getText());
					pst.setString(3, comboBox.getSelectedItem().toString());
					pst.setString(4, comboBox_2.getSelectedItem().toString());
					pst.setDate(5,sqlDate);
					rs=pst.executeQuery();
					
					String query2="insert into attendance(id,name,subject,status,dateval) values(?,?,?,?,?)";
					pst=con.prepareStatement(query2);
					pst.setString(1, textArea_2.getText());
					pst.setString(2, textArea_5.getText());
					pst.setString(3, comboBox.getSelectedItem().toString());
					pst.setString(4, comboBox_3.getSelectedItem().toString());
					pst.setDate(5,sqlDate);
					rs=pst.executeQuery();
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/*String query="insert into teacher(id,name,gender,dob,branch, email,password) values("+at.textField
						+","+at.textField_1+","+at.rdbtn+","+at.date+","+at.textField_3+","+at.textField_4+","
						+at.passwordField+")";*/
				
				JOptionPane.showMessageDialog(contentPane, "Attendance saved Succesfully!!!");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnNewButton.setBounds(194, 529, 115, 41);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnExit.setBounds(399, 529, 115, 41);
		contentPane.add(btnExit);
		
		JButton button = new JButton("Back to Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		button.setBounds(621, 529, 211, 41);
		contentPane.add(button);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(772, 297, 334, 197);
		contentPane.add(calendar);
	}
}
