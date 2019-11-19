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
import javax.swing.JRadioButton;

public class itemFrame extends JFrame {

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itemFrame frame = new itemFrame();
					frame.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	};

	/**
	 * Initialize the contents of the frame.
	 */
	public itemFrame() {
		frame = new JFrame();
		connection = oracleConnection.dbConnector();
		frame.setBounds(100, 100, 519, 472);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
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
				itemFrame.this.setLocation( x - xx, y - xy);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 483, 545);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product ID:");
		lblNewLabel.setBounds(10, 35, 96, 14);
		panel.add(lblNewLabel);
		
		JLabel lblProvince = new JLabel("Category:");
		lblProvince.setBounds(10, 66, 96, 14);
		panel.add(lblProvince);
		
		textField = new JTextField();
		textField.setBounds(128, 63, 155, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 32, 155, 20);
		panel.add(textField_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 209, 463, 325);
		panel.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 176, 483, 32);
		frame.getContentPane().add(panel_1);
		
		Button button_1 = new Button("Show All");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from items";
					PreparedStatement pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_1.setBounds(355, 167, 91, 22);
		panel.add(button_1);
		
		JLabel lblBillDetailId = new JLabel("Color:");
		lblBillDetailId.setBounds(10, 97, 96, 14);
		panel.add(lblBillDetailId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 94, 155, 20);
		panel.add(textField_1);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 122, 96, 14);
		panel.add(lblGender);
		
		JRadioButton rdbtnMen = new JRadioButton("Men");
		rdbtnMen.setBounds(128, 121, 51, 23);
		panel.add(rdbtnMen);
		
		JRadioButton rdbtnFemale = new JRadioButton("Women");
		rdbtnFemale.setBounds(185, 121, 109, 23);
		panel.add(rdbtnFemale);
		
		Button button = new Button("Load Item");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = textField_3.getText();
					String query = "select * from items where product_id = " + id;
					PreparedStatement pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}			
		});
		button.setBounds(355, 35, 91, 22);
		panel.add(button);
		
		Button button_2 = new Button("Show Products");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String c = textField.getText();
					String query = "select * from items where category = " + c;
					PreparedStatement pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_2.setBounds(355, 63, 91, 22);
		panel.add(button_2);
		
		Button button_3 = new Button("Show Products");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String color = textField_1.getText();
					String query = "select * from items where color = " + color;
					PreparedStatement pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_3.setBounds(355, 89, 91, 22);
		panel.add(button_3);
		
		Button button_4 = new Button("Show Products");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "";
					if(rdbtnFemale.isSelected()) {
						query = "select * from customers where gender = female";
					}
					else if(rdbtnMen.isSelected()) {
						query = "select * from customers where gender = male";
					}
					PreparedStatement pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
 				}catch(Exception exception) {
 					exception.printStackTrace();
 				}
			}
		});
		button_4.setBounds(355, 114, 91, 22);
		panel.add(button_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 401, 483, -175);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		table.setBackground(Color.WHITE);
	}
}

