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
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class billFrame extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public void NewWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billFrame frame = new billFrame();
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
	public billFrame() {
		super();
		connection = oracleConnection.dbConnector();
		setBounds(100, 100, 519, 514);
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
		panel.setBounds(10, 11, 483, 452);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer ID:");
		lblNewLabel.setBounds(10, 35, 96, 14);
		panel.add(lblNewLabel);
		
		JLabel lblProvince = new JLabel("Bill ID:");
		lblProvince.setBounds(10, 71, 96, 14);
		panel.add(lblProvince);
		
		textField = new JTextField();
		textField.setBounds(191, 68, 155, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(191, 32, 155, 20);
		panel.add(textField_3);
		
		table = new JTable();
		
		Button button_1 = new Button("Show All");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from bill";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_1.setBounds(352, 104, 121, 22);
		panel.add(button_1);
		
		Button button_2 = new Button("Show Customer's Bill");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id  = textField_3.getText();
					String query = "select * from bill where customer_id = " + id;
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_2.setBounds(352, 32, 121, 22);
		panel.add(button_2);
		
		Button button_3 = new Button("Show Bill");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id  = textField.getText();
					String query = "select * from bill where bill_id = " + id;
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}

			}
		});
		button_3.setBounds(352, 68, 121, 22);
		panel.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 463, 311);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
