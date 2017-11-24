package Scheduler;

import java.awt.BorderLayout;

import java.util.LinkedList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class BookSpace {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSpace window = new BookSpace();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookSpace() { 
		initialize();
    }
	
	private void initialize() {
		LinkedList<Space> spaces = Test.scheduler.getAvailableSpaces();
		LinkedList<Space> available_slots = new LinkedList<>();
		for (Space space: spaces) { available_slots.add(space); }
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 811, 585);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setFont(new Font("Times New Roman", Font.BOLD, 18));
		list.setBounds(26, 97, 345, 275);
		DefaultListModel slot_model = new DefaultListModel();
		list.setModel(slot_model);
		frame.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		list_1.setBounds(397, 97, 345, 275);
		list_1.setModel(new AbstractListModel() {
			public int getSize() {
				return available_slots.size();
			}
			public Object getElementAt(int index) {
				if (available_slots.size() != 0) {
				    return available_slots.get(index).toString();
				}
				return null;
			}
		});
		frame.getContentPane().add(list_1);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAvailability.setBounds(506, 60, 155, 33);
		frame.getContentPane().add(lblAvailability);
				
		JLabel lblMakeABooking = new JLabel("Make a booking");
		lblMakeABooking.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMakeABooking.setBounds(306, 28, 198, 33);
		frame.getContentPane().add(lblMakeABooking);
		
		JLabel lblSlotsmax = new JLabel("Slots (max. 5)");
		lblSlotsmax.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSlotsmax.setBounds(135, 60, 155, 33);
		frame.getContentPane().add(lblSlotsmax);
		
		ButtonGroup rgroup = new ButtonGroup();
		
		JButton btnButton = new JButton("Add");
		btnButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                Object selected = list_1.getSelectedValue();
				
				if (selected == null);
				else {
					for (Space space: available_slots) {
				        if (space.toString().equals(selected.toString())) {
						    slot_model.addElement(space);
						    available_slots.remove(space);
					    }
				    }
				}
				frame.repaint();
			}
		});
		btnButton.setBounds(119, 417, 171, 41);
		frame.getContentPane().add(btnButton);
		
		JButton btnSubmitRequest = new JButton("Submit Request");
		btnSubmitRequest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmitRequest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                LinkedList<Space> spaces = new LinkedList<>();
          
                for (int i=0; i < slot_model.size(); i++) {
                	spaces.add((Space)slot_model.get(i)); 
                }
                
                Booking booking = new Booking();
                booking.setSpaces(spaces);
                
                Test.scheduler.submitBookingForReview(booking);
                frame.dispose();
			}
		});
		btnSubmitRequest.setBounds(491, 417, 171, 41);
		frame.getContentPane().add(btnSubmitRequest);
		
	}
}
