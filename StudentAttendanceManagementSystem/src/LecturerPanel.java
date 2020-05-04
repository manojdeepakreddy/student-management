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

public class LecturerPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LecturerPanel frame = new LecturerPanel();
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
	public LecturerPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLecturerPanel = new JLabel("Lecturer Panel");
		lblLecturerPanel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblLecturerPanel.setBounds(338, 72, 270, 47);
		contentPane.add(lblLecturerPanel);
		
		JButton btnTakeAttendace = new JButton("Take Attendance");
		btnTakeAttendace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttendanceTaking at = new AttendanceTaking();
				at.setVisible(true);
				dispose();
			}
		});
		btnTakeAttendace.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnTakeAttendace.setBounds(104, 250, 361, 37);
		contentPane.add(btnTakeAttendace);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		btnExit.setBounds(223, 361, 115, 37);
		contentPane.add(btnExit);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/lecattendance.jpeg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(564, 162, 347, 333);
		contentPane.add(label);
	}

}
