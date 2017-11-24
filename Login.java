package Scheduler;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import Scheduler.AdminPanel;
import Scheduler.UserPanel;

public class Login {

	private JFrame frame;
	private JTextField stdField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		stdField = new JTextField();
		stdField.setBounds(233, 153, 116, 22);
		frame.getContentPane().add(stdField);
		stdField.setColumns(10);
		
		JLabel lblStudentNumber = new JLabel("Student Number");
		lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentNumber.setBounds(75, 156, 156, 16);
		frame.getContentPane().add(lblStudentNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(75, 200, 156, 16);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(233, 197, 116, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserPanel.main(null);
				frame.dispose();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(233, 254, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 311, 671, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblSchedulingSystem = new JLabel("Scheduling System ");
		lblSchedulingSystem.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblSchedulingSystem.setBounds(197, 18, 347, 56);
		frame.getContentPane().add(lblSchedulingSystem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 87, 671, 9);
		frame.getContentPane().add(separator_1);
		
		JLabel lblLoginAsAdministrator = new JLabel("Login as Administrator");
		lblLoginAsAdministrator.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLoginAsAdministrator.setBounds(75, 326, 289, 16);
		frame.getContentPane().add(lblLoginAsAdministrator);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(233, 367, 116, 22);
		frame.getContentPane().add(passwordField_1);
		
		JButton adminLoginbutton = new JButton("Login");
		adminLoginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPanel.main(null);
				frame.dispose();
				
			}
		});
		adminLoginbutton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		adminLoginbutton.setBounds(384, 366, 97, 25);
		frame.getContentPane().add(adminLoginbutton);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword_1.setBounds(75, 370, 116, 19);
		frame.getContentPane().add(lblPassword_1);
	}
}
