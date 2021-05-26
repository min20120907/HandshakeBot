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
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<Drink> drinks = new ArrayList<>();
	private List<Topping> toppings1 = new ArrayList<>();
	private List<Topping> toppings2 = new ArrayList<>();
	private int buttonClicked = 0;
	List<Topping> available1, available2;

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
		setBounds(100, 100, 694, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 135, 661, 294);
		contentPane.add(scrollPane);

		Box horizontalBox_1 = Box.createHorizontalBox();
		scrollPane.setViewportView(horizontalBox_1);

		Box verticalBox_1 = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox_1);

		JLabel lblNewLabel_1 = new JLabel("Ching-Shin Fu-Chuan");
		lblNewLabel_1.setIcon(new ImageIcon("src/min20120907/chinsin.jpg"));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		verticalBox_1.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox_1.add(panel);

		Box verticalBox_5 = Box.createVerticalBox();
		panel.add(verticalBox_5);

		Box verticalBox_2 = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox_2);

		JLabel lblNewLabel_2 = new JLabel("Coco");
		lblNewLabel_2.setIcon(new ImageIcon("src/min20120907/coco.jpg"));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		verticalBox_2.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		verticalBox_2.add(panel_1);

		Box verticalBox_4 = Box.createVerticalBox();
		panel_1.add(verticalBox_4);

		Box verticalBox = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox);

		JLabel lblNewLabel_3 = new JLabel("Comebuy");
		verticalBox.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("src/min20120907/comebuy.jpg"));
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);

		JPanel panel_2 = new JPanel();
		verticalBox.add(panel_2);

		Box verticalBox_3 = Box.createVerticalBox();
		panel_2.add(verticalBox_3);

		textField = new JTextField();
		textField.setBounds(107, 12, 153, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Item: ");
		lblNewLabel.setBounds(19, 14, 70, 15);
		contentPane.add(lblNewLabel);
		Choice choice = new Choice();
		choice.setBounds(107, 39, 151, 25);
		choice.add("No Toppings");
		choice.add("珍珠");
		choice.add("小紫蘇");
		choice.add("迷你珍珠");
		choice.add("新雙q");
		choice.add("小芋圓");
		choice.add("遙果樂");
		choice.add("寒天晶球");
		choice.add("椰果愛玉");
		choice.add("荔枝凍");
		choice.add("紫米");
		choice.add("紅豆");
		choice.add("仙草凍");
		choice.add("布丁");
		choice.add("椰果");
		choice.add("西股米");
		choice.add("芋頭");
		choice.add("蜜香凍");
		choice.add("粉圓");
		choice.add("QQ");
		choice.add("暗黑水晶");
		choice.add("蘆薈");
		contentPane.add(choice);

		Choice choice_1 = new Choice();
		choice_1.setBounds(109, 74, 151, 25);
		choice_1.add("No Toppings");
		choice_1.add("珍珠");
		choice_1.add("小紫蘇");
		choice_1.add("迷你珍珠");
		choice_1.add("新雙q");
		choice_1.add("小芋圓");
		choice_1.add("遙果樂");
		choice_1.add("寒天晶球");
		choice_1.add("椰果愛玉");
		choice_1.add("荔枝凍");
		choice_1.add("紫米");
		choice_1.add("紅豆");
		choice_1.add("仙草凍");
		choice_1.add("布丁");
		choice_1.add("椰果");
		choice_1.add("西股米");
		choice_1.add("芋頭");
		choice_1.add("蜜香凍");
		choice_1.add("粉圓");
		choice_1.add("QQ");
		choice_1.add("暗黑水晶");
		choice_1.add("蘆薈");
		contentPane.add(choice_1);
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
					
					ResultSet rs3, rs2;
					if (!choice.getSelectedItem().equals("No Toppings")) {
						rs2 = stmt.executeQuery(
								"SELECT * FROM Extra WHERE INSTR(name, '" + choice.getSelectedItem() + "');");
						System.out.println("Entering rs2");
						// Iterates the results of first topping, storing into the list
						while (rs2.next()) {
							String n = rs2.getString("name"), c = rs2.getString("category"), b = rs2.getString("brand");
							int p = rs2.getInt("price");
							toppings1.add(new Topping(n, c, p, b));
						}

					}
					if (!choice_1.getSelectedItem().equals("No Toppings")) {
						System.out.println("Entering rs3");
						rs3 = stmt.executeQuery(
								"SELECT * FROM Extra WHERE INSTR(name, '" + choice_1.getSelectedItem() + "');");
						// Iterates the results of second topping, storing into the list
						while (rs3.next()) {
							String n = rs3.getString("name"), c = rs3.getString("category"), b = rs3.getString("brand");
							int p = rs3.getInt("price");
							toppings2.add(new Topping(n, c, p, b));
						}
					}
					System.out.println(toppings1);System.out.println(toppings2);
					// Iterates all the drinks, storing into the list
					ResultSet rs = stmt.executeQuery("SELECT * FROM MilkTea WHERE INSTR(name, '" + s + "');");
					while (rs.next()) {

						String n = rs.getString("name");
						String c = rs.getString("category");
						int p = rs.getInt("price");
						String b = rs.getString("brand");

						if (toppings1.size() > 0) {
							// Filter the toppings for the specific brand
							available1 = toppings1.stream().filter(a -> a.getBrand().equals(b))
									.collect(Collectors.toList());
						}
						if (toppings2.size() > 0) {
							// Filter the second topping
							available2 = toppings2.stream().filter(a -> a.getBrand().equals(b))
									.collect(Collectors.toList());
							
						}
						System.out.println(available1);
						System.out.println(available2);
						if(available1!=null)
						if (available1.size() > 0)
							p += available1.get(0).getPrice();
						if(available2!=null)
						if (available2.size() > 0)
							p += available2.get(0).getPrice();
						
						try{
						if(choice.getSelectedItem().equals("No Toppings")&&choice_1.getSelectedItem().equals("No Toppings"))
						drinks.add(new Drink(n, c, p, b));
						if(choice.getSelectedItem().equals("No Toppings")&&available2.size()>0)
						drinks.add(new Drink(n, c, p, b));
						if(choice_1.getSelectedItem().equals("No Toppings")&&available1.size()>0)
						drinks.add(new Drink(n, c, p, b));
						if(available2.size()>0&&available1.size()>0)
						drinks.add(new Drink(n, c, p, b));
						}catch(NullPointerException ne){
							ne.printStackTrace();
						}
					}
					System.out.println(drinks);
					// Sorting the drinks by ascending order
					drinks = drinks.stream().sorted(Comparator.comparingInt(Drink::getPrice))
							.collect(Collectors.toList());
					
					

					for (Drink a : drinks) {
						invalidate();
					validate();
						switch (a.getBrand()) {

							case "Ching-Shin Fu-Chuan":
								JRadioButton rdbtnNewRadioButton = new JRadioButton(
										a.getCategory() + " " + a.getName() + " " + a.getPrice());
								verticalBox_5.add(rdbtnNewRadioButton);
								break;
							case "Coco":

								JRadioButton rdbtnNewRadioButton2 = new JRadioButton(
										a.getCategory() + " " + a.getName() + " " + a.getPrice());
								verticalBox_4.add(rdbtnNewRadioButton2);
								break;
							case "Comebuy":

								JRadioButton rdbtnNewRadioButton3 = new JRadioButton(
										a.getCategory() + " " + a.getName() + " " + a.getPrice());
								verticalBox_3.add(rdbtnNewRadioButton3);
								break;
							default:
								break;
						}
					}

					stmt.close();
					conn.close();
				} catch (Exception eee) {
					System.err.println("Something bad happend... :(");
					eee.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(278, 36, 117, 25);
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

		JButton btnC = new JButton("clear");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invalidate();
				validate();
				drinks = new ArrayList<>();
				toppings1 = new ArrayList<>();
				toppings2 = new ArrayList<>();
				verticalBox_5.removeAll();
				verticalBox_4.removeAll();
				verticalBox_3.removeAll();
			}

		});
		btnC.setBounds(417, 36, 117, 25);
		contentPane.add(btnC);

	}
}
