
package Scheduler;
import java.awt.EventQueue;
import java.util.LinkedList;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
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
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 755, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblScheduleViewer = new JLabel("Manager (Admin version)");
		lblScheduleViewer.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblScheduleViewer.setBounds(246, 46, 262, 40);
		frame.getContentPane().add(lblScheduleViewer);
		JList list = new JList();
		list.setFont(new Font("Times New Roman", Font.BOLD, 18));
		list.setModel(new AbstractListModel() {
			public int getSize() {
				return Test.scheduler.getPendingBookings().size();
			}
			public Object getElementAt(int index) {
				return Test.scheduler.getPendingBookings().get(index).toString();
			}
		});
		list.setBounds(69, 212, 313, 222);
		frame.getContentPane().add(list);
		
		JLabel lblBookings = new JLabel(" Pending Requests");
		lblBookings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookings.setBounds(69, 177, 226, 32);
		frame.getContentPane().add(lblBookings);
		
		JButton btnAdd = new JButton("Accept");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "This feature is yet to come");

			}
		});
		btnAdd.setBounds(69, 463, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Reject");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "This feature is yet to come");

			}
		});
		btnRemove.setBounds(192, 463, 97, 25);
		frame.getContentPane().add(btnRemove);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			public int getSize() {
				return Test.scheduler.getAvailableSpaces().size();
			}
			public Object getElementAt(int index) {
				if (Test.scheduler.getAvailableSpaces().size() != 0) {
				    return Test.scheduler.getAvailableSpaces().get(index).toString();
				}
				return null;
			}
		});
		list_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		list_1.setBounds(392, 212, 262, 222);
		frame.getContentPane().add(list_1);
		
		JLabel lblAvailability = new JLabel("Slots Available");
		lblAvailability.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvailability.setBounds(392, 185, 226, 16);
		frame.getContentPane().add(lblAvailability);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSpaces.main(null);
				frame.dispose();
			}
		});
		button.setBounds(398, 463, 97, 25);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Remove");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = list_1.getSelectedValue();
				
				LinkedList<Space> spaces = Test.scheduler.getAvailableSpaces();
				
				if (selected == null);
				else {
					for (Space space: spaces) {
				        if (space.toString().equals(selected.toString())) {
						    spaces.remove(space);
						    frame.repaint();
					    }
				    }
				}

			}
		});
		button_1.setBounds(521, 463, 97, 25);
		frame.getContentPane().add(button_1);
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		btnLogout.setBounds(599, 57, 100, 25);
		frame.getContentPane().add(btnLogout);
	}
}
