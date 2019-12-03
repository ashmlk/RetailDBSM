package dbsm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;



public class main_frame extends JFrame {
	
	private static final long serialVersionUID = -2953167667584804870L;
	private JTable table;
	Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_frame frame = new main_frame();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public main_frame() {
		connection = oracleConnection.dbConnector();
		setBounds(100, 100, 373, 521);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Button buttonCustomer = new Button("Customers");
		buttonCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 customerFrame cframe = new customerFrame();
				 cframe.NewWindow();
			}
		});
		buttonCustomer.setBounds(0, 82, 179, 64);
		getContentPane().add(buttonCustomer);
		
		Button buttonItems = new Button("Items");
		buttonItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemFrame iframe = new itemFrame();
				iframe.NewWindow();
			}
		});
		buttonItems.setBounds(0, 152, 179, 64);
		getContentPane().add(buttonItems);
		
		Button buttonBills = new Button("Bills");
		buttonBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billFrame bframe =  new billFrame();
				bframe.NewWindow();
			}
		});
		buttonBills.setBounds(185, 82, 172, 64);
		getContentPane().add(buttonBills);
		
		Button button = new Button("View Stores");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from store";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button.setBounds(185, 152, 172, 64);
		getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 337, 249);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Retail Database Management System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 11, 357, 65);
		getContentPane().add(lblNewLabel);
	}
}
