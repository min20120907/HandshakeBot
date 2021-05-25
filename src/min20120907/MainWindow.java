package min20120907;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.Choice;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<Drink> drinks = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 135, 409, 291);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		panel.add(verticalBox, "name_8644159212799");

        	
        
		textField = new JTextField();
		textField.setBounds(107, 12, 153, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Item: ");
		lblNewLabel.setBounds(19, 14, 70, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// On-click action performs here
				String s = textField.getText();
				try {
				Class.forName("org.sqlite.JDBC");
	            Connection conn = DriverManager.getConnection("jdbc:sqlite:HandshakeBot.db");
	            Statement stmt = conn.createStatement();
	            // FileReader fr = new FileReader("MilkTea.sql");
	            // BufferedReader br = new BufferedReader(fr);
	            // stmt.execute(br.readLine());
	            ResultSet rs = stmt.executeQuery( "SELECT * FROM MilkTea WHERE INSTR(name, '"+s+"');" );
	            
	            while (rs.next()) {
	                String n = rs.getString("name");
	                String c = rs.getString("category");
	                int p = rs.getInt("price");
	                String b = rs.getString("brand");
	                drinks.add(new Drink(n,c,p,b));
	            }
	            
	      		
	            invalidate();
	            validate();
	            for(Drink a : drinks) {
	            	 JPanel panel_1 = new JPanel();
	 	      		verticalBox.add(panel_1);
	 	      		String brandPic ="";
	 	      		switch(a.getBrand()) {
	 	      		
	 	      		}
	 	      		Box horizontalBox = Box.createHorizontalBox();
	 	      		panel_1.add(horizontalBox);
	 	      		JRadioButton rdbtnNewRadioButton = new JRadioButton(a.getCategory()+" "+a.getName()+ " " + a.getPrice());
	 	      		horizontalBox.add(rdbtnNewRadioButton);
	            }
	      		
	            stmt.close();
	            conn.close();
				}catch(Exception eee) {
					eee.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(272, 9, 117, 25);
		contentPane.add(btnSubmit);
		 
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(19, 108, 70, 15);
		contentPane.add(lblResult);
		
		JLabel lblTopping = new JLabel("Topping 1: ");
		lblTopping.setBounds(12, 41, 90, 15);
		contentPane.add(lblTopping);
		
		JLabel lblTopping_2 = new JLabel("Topping 2: ");
		lblTopping_2.setBounds(19, 75, 90, 15);
		contentPane.add(lblTopping_2);
		
		Choice choice = new Choice();
		choice.setBounds(107, 39, 151, 25);
		choice.add("");
		contentPane.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(109, 74, 151, 25);
		contentPane.add(choice_1);
	}
}
