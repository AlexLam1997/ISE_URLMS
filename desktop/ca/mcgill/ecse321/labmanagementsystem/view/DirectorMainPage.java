package ca.mcgill.ecse321.labmanagementsystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.view.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DirectorMainPage implements Serializable {

	private JPanel contentPane;
	public static JFrame f = new JFrame("");
	private URLMS urlms;
	



	public DirectorMainPage(URLMS urlms) {
		this.urlms = urlms;
		initComponents();
	}
	
	private void initComponents() {
		f.setTitle("University Lab Management System");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 582, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome Director.");
		
		JButton btnHome = new JButton("Logout");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPage(urlms);
				MainPage.f.setVisible(true);
				DirectorMainPage.f.setVisible(false);
			}
		});
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StaffPage(urlms);
				StaffPage.f.setVisible(true);
				DirectorMainPage.f.setVisible(false);
			}
		});
		
		JButton btnEquipment = new JButton("Equipment");
		btnEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EquipmentPage(urlms);
				EquipmentPage.f.setVisible(true);
				DirectorMainPage.f.setVisible(false);
			}
		});
		
		JButton btnSupplies = new JButton("Supplies");
		btnSupplies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SupplyPage(urlms);
				SupplyPage.f.setVisible(true);
				DirectorMainPage.f.setVisible(false);
			}
		});
		
		JButton btnLabExpsenses = new JButton("Lab Expenses");
		btnLabExpsenses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LabExpensesPage(urlms);
				LabExpensesPage.f.setVisible(true);
				DirectorMainPage.f.setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnHome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnStaff)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEquipment)
							.addGap(12)
							.addComponent(btnSupplies)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLabExpsenses))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(215)
							.addComponent(lblWelcomeToThe)))
					.addContainerGap(9, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(lblWelcomeToThe)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSupplies)
						.addComponent(btnHome)
						.addComponent(btnStaff)
						.addComponent(btnLabExpsenses)
						.addComponent(btnEquipment))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}