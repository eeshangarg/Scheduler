package Scheduler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Font;

public class AddSpaces {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSpaces window = new AddSpaces();
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
	public AddSpaces() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(109, 62, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Location");
		lblNewLabel.setBounds(41, 65, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 AM", "2 AM", "3 AM", "4 AM", "5 AM", "6 AM", "7 AM", "8 AM", "9 AM", "10 AM", "11 AM", "12 AM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM", "6 PM", "7 PM", "8 PM", "9 PM", "10 PM", "11 PM", "12 PM"}));
		comboBox.setBounds(109, 153, 57, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(41, 100, 56, 16);
		frame.getContentPane().add(lblSemester);  
		
		JRadioButton rdbtnSpring = new JRadioButton("Spring");
		rdbtnSpring.setBounds(109, 96, 127, 25);
		frame.getContentPane().add(rdbtnSpring);
		
		JRadioButton rdbtnWinter = new JRadioButton("Winter");
		rdbtnWinter.setBounds(240, 96, 127, 25);
		frame.getContentPane().add(rdbtnWinter);
		
		JRadioButton rdbtnFall = new JRadioButton("Fall");
		rdbtnFall.setBounds(371, 96, 127, 25);
		frame.getContentPane().add(rdbtnFall);
		
		ButtonGroup rgroup = new ButtonGroup();
		rgroup.add(rdbtnFall);
		rgroup.add(rdbtnWinter);
		rgroup.add(rdbtnSpring);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(41, 156, 56, 16);
		frame.getContentPane().add(lblStart);
		
		JLabel label = new JLabel("End");
		label.setBounds(178, 156, 56, 16);
		frame.getContentPane().add(label);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1 AM", "2 AM", "3 AM", "4 AM", "5 AM", "6 AM", "7 AM", "8 AM", "9 AM", "10 AM", "11 AM", "12 AM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM", "6 PM", "7 PM", "8 PM", "9 PM", "10 PM", "11 PM", "12 PM"}));
		comboBox_2.setBounds(209, 153, 57, 22);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}));
		comboBox_1.setBounds(109, 204, 76, 22);
		frame.getContentPane().add(comboBox_1);
		
		JLabel dayName = new JLabel("Day");
		dayName.setBounds(41, 207, 56, 16);
		frame.getContentPane().add(dayName);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(41, 267, 97, 25);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String location = textField.getText();
				String start = comboBox.getSelectedItem().toString();
				String end = comboBox_2.getSelectedItem().toString();
				String semester = "";
				if (rdbtnWinter.isSelected()) { semester = "Winter"; }
				else if (rdbtnFall.isSelected()) { semester = "Fall"; }
				else if (rdbtnSpring.isSelected()){ semester = "Spring"; }
				String day = comboBox_1.getSelectedItem().toString();
				
				Interval time = new Interval(Day.getDayEnum(day), start, end);
				Space space = new Space(location, time, semester);
				Test.scheduler.addAvailableSpace(space);
				
				AdminPanel.main(null);
				
				frame.dispose();
			}
		});
		
		JLabel lblAddASpace = new JLabel("Add A Space");
		lblAddASpace.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblAddASpace.setBounds(159, 13, 208, 36);
		frame.getContentPane().add(lblAddASpace);
		
	}
}
