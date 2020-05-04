import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StuAttendance extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuAttendance frame = new StuAttendance();
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
	public StuAttendance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAttendanceDetails = new JLabel("Attendance Details");
		lblAttendanceDetails.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblAttendanceDetails.setBounds(266, 37, 392, 52);
		contentPane.add(lblAttendanceDetails);
		
		JLabel lblNewLabel = new JLabel("Subject");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblNewLabel.setBounds(452, 188, 132, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblStatus = new JLabel("Attendance %");
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblStatus.setBounds(707, 188, 205, 34);
		contentPane.add(lblStatus);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 33));
		textField.setBounds(722, 268, 146, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String subject = (String) comboBox.getSelectedItem();
				System.out.println(subject);
				if(subject.equals("Chemistry"))
					textField.setText("60%");
				else if(subject.equals("Computer Programming"))
					textField.setText("70%");
				else if(subject.equals("Physics"))
					textField.setText("80%");
				else if(subject.equals("Mathematics"))
					textField.setText("90%");
				else if(subject.equals("Mechanics"))
					textField.setText("75%");
				else if(subject.equals("Graphics"))
					textField.setText("85%");
			}
		});
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Computer Programming", "Physics", "Mathematics", "Chemistry", "Mechanics", "Graphics"}));
		comboBox.setBounds(404, 266, 226, 34);
		contentPane.add(comboBox);
		
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/attendance.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(15, 124, 374, 418);
		contentPane.add(label);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentPanel sp = new StudentPanel();
				sp.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		btnBack.setBounds(420, 399, 115, 42);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		btnExit.setBounds(569, 399, 115, 42);
		contentPane.add(btnExit);
		
		JButton btnBackToLogin = new JButton("Back to login");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnBackToLogin.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		btnBackToLogin.setBounds(722, 399, 223, 42);
		contentPane.add(btnBackToLogin);
	}
}
