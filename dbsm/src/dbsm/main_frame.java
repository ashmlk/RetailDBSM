package dbsm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main_frame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_frame window = new main_frame();
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
	public main_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 141, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Button buttonCustomer = new Button("Customers");
		buttonCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new itemFrame().setVisible(true);
			}
		});
		buttonCustomer.setBounds(10, 10, 104, 47);
		frame.getContentPane().add(buttonCustomer);
		
		Button buttonItems = new Button("Items");
		buttonItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new itemFrame().setVisible(true);
			}
		});
		buttonItems.setBounds(10, 69, 104, 47);
		frame.getContentPane().add(buttonItems);
		
		Button buttonBills = new Button("Bills");
		buttonBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new billFrame().setVisible(true);
			}
		});
		buttonBills.setBounds(10, 122, 104, 47);
		frame.getContentPane().add(buttonBills);
	}
}
