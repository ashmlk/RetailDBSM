package dbsm;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JTable;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.sql.*;

public class customerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_3;
	private JPanel contentPane;
	int xx,xy;
	Connection connection = null;
	ResultSet rs = null;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public void NewWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerFrame frame = new customerFrame();
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
	public customerFrame() {
		super();
		setBounds(100, 100, 674, 574);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		connection = oracleConnection.dbConnector();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				customerFrame.this.setLocation( x - xx, y - xy);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 638, 524);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer ID:");
		lblNewLabel.setBounds(10, 22, 96, 14);
		panel.add(lblNewLabel);
		
		JLabel lblProvince = new JLabel("State:");
		lblProvince.setBounds(10, 125, 96, 14);
		panel.add(lblProvince);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(10, 148, 96, 14);
		panel.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(275, 19, 155, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(275, 122, 155, 20);
		panel.add(textField_3);
		
		
		Button button = new Button("View");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = textField.getText();
					String query = "SELECT * FROM CUSTOMER_F WHERE ID = " + id;
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button.setBounds(455, 19, 173, 22);
		panel.add(button);
		
		Button button_1 = new Button("View All");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "SELECT * FROM CUSTOMER_F";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_1.setBounds(455, 178, 173, 22);
		panel.add(button_1);
		
		Button button_2 = new Button("View");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pr  = textField_3.getText();
					String query = "select * from customer_f where state = '" + pr + "'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_2.setBounds(455, 120, 173, 22);
		panel.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 206, 628, 299);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblCustomerName = new JLabel("Name:");
		lblCustomerName.setBounds(10, 45, 96, 14);
		panel.add(lblCustomerName);
		
		JLabel lblCustomerLastName = new JLabel("Last Name:");
		lblCustomerLastName.setBounds(10, 70, 107, 14);
		panel.add(lblCustomerLastName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(275, 42, 155, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(275, 67, 155, 20);
		panel.add(textField_2);
		
		JLabel lblCustomerTelephone = new JLabel("Telephone:");
		lblCustomerTelephone.setBounds(10, 94, 129, 14);
		panel.add(lblCustomerTelephone);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(275, 91, 155, 20);
		panel.add(textField_4);
		
		Button button_3 = new Button("View");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name  = textField_1.getText();
					String query = "select * from customer_f where first_name = '" + name + "'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_3.setBounds(455, 42, 173, 22);
		panel.add(button_3);
		
		Button button_4 = new Button("View");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String lname  = textField_2.getText();
					String query = "select * from customer_f where last_name = '" + lname + "'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_4.setBounds(455, 67, 173, 22);
		panel.add(button_4);
		
		Button button_5 = new Button("View");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String num  = textField_4.getText();
					String query = "select * from customer_f where phone like'" + num + "%'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_5.setBounds(455, 91, 173, 22);
		panel.add(button_5);
	}
}
