package dbsm;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JTable;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class billFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	private JPanel contentPane;
	int xx,xy;
	Connection connection = null;
	ResultSet rs = null;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void NewWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerFrame frame = new customerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public billFrame() {
		super();
		connection = oracleConnection.dbConnector();
		setBounds(100, 100, 519, 472);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				billFrame.this.setLocation( x - xx, y - xy);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 483, 545);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer ID:");
		lblNewLabel.setBounds(10, 35, 96, 14);
		panel.add(lblNewLabel);
		
		JLabel lblProvince = new JLabel("Bill ID:");
		lblProvince.setBounds(10, 71, 96, 14);
		panel.add(lblProvince);
		
		textField = new JTextField();
		textField.setBounds(278, 68, 155, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(278, 32, 155, 20);
		panel.add(textField_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 209, 463, 325);
		panel.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 176, 483, 32);
		frame.getContentPane().add(panel_1);
		
		
		Button button = new Button("Show Bill's Detail");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = textField.getText();
					String id2 = textField_1.getText();
					String query = ""; //Join the tables query goes here
					PreparedStatement pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button.setBounds(360, 168, 91, 22);
		panel.add(button);
		
		Button button_1 = new Button("Show All");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from bill";
					PreparedStatement pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_1.setBounds(263, 168, 91, 22);
		panel.add(button_1);
		
		Button button_2 = new Button("Show Customer's Bill");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pr  = textField_3.getText();
					String query = "select * from customers where customer_id = " + pr;
					PreparedStatement pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_2.setBounds(102, 168, 155, 22);
		panel.add(button_2);
		
		JLabel lblBillDetailId = new JLabel("Bill Detail ID:");
		lblBillDetailId.setBounds(10, 109, 96, 14);
		panel.add(lblBillDetailId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(278, 109, 155, 20);
		panel.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 401, 483, -175);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		table.setBackground(Color.WHITE);
	}
}
