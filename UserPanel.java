package Scheduler;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel window = new UserPanel();
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
	public UserPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1037, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblScheduleViewer = new JLabel("Manage Booking(Coach Version)");
		lblScheduleViewer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblScheduleViewer.setBounds(374, 15, 264, 40);
		frame.getContentPane().add(lblScheduleViewer);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD, 18));
		list.setModel(new AbstractListModel() {
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
		list.setBounds(26, 211, 265, 198);
		frame.getContentPane().add(list);
		
		JLabel lblAvailableTimes = new JLabel("Available Times");
		lblAvailableTimes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvailableTimes.setBounds(78, 176, 147, 16);
		frame.getContentPane().add(lblAvailableTimes);
		
		JLabel lblSelectOneOr = new JLabel("Please select all the desired time slots(only a few will be accepted)");
		lblSelectOneOr.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectOneOr.setBounds(282, 56, 474, 30);
		frame.getContentPane().add(lblSelectOneOr);
		
		JButton btnBook = new JButton("Book");
		btnBook.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSpace.main(null);
			}
		});
		btnBook.setBounds(78, 464, 147, 25);
		frame.getContentPane().add(btnBook);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		btnLogout.setBounds(857, 15, 122, 35);
		frame.getContentPane().add(btnLogout);
		
		JList list_1 = new JList();
		list_1.setBounds(309, 211, 321, 198);
		frame.getContentPane().add(list_1);
		
		JList list_2 = new JList();
		list_2.setBounds(648, 211, 331, 198);
		frame.getContentPane().add(list_2);
		
		JLabel lblAcceptedRequests = new JLabel("Accepted Requests");
		lblAcceptedRequests.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAcceptedRequests.setBounds(379, 169, 160, 30);
		frame.getContentPane().add(lblAcceptedRequests);
		
		JLabel lblRejectedRequests = new JLabel("Rejected Requests");
		lblRejectedRequests.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRejectedRequests.setBounds(747, 168, 199, 33);
		frame.getContentPane().add(lblRejectedRequests);
	}
}
