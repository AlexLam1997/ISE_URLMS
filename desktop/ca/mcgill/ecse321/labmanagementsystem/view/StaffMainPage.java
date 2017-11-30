package ca.mcgill.ecse321.labmanagementsystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffMainPage implements Serializable {

	private JPanel contentPane;
	public static JFrame f = new JFrame("");
	private URLMS urlms;
	



	public StaffMainPage(URLMS urlms) {
		this.urlms = urlms;
		initComponents();
	}
	
	private void initComponents() {
		f.setTitle("University Lab Management System");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 502, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);
		
		JLabel lblWelcomeStaffMember = new JLabel("Welcome Staff Member.");
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPage(urlms);
				MainPage.f.setVisible(true);
				StaffMainPage.f.setVisible(false);
			}
		});
		
		JButton btnNewButton = new JButton("Equipment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EquipmentPage(urlms);
				EquipmentPage.f.setVisible(true);
				StaffMainPage.f.setVisible(false);
			}
		});
		
		JButton btnSupplies = new JButton("Supplies");
		btnSupplies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SupplyPage(urlms);
				SupplyPage.f.setVisible(true);
				StaffMainPage.f.setVisible(false);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Weekly Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WeeklyUpdatePage(urlms);
				WeeklyUpdatePage.f.setVisible(true);
				StaffMainPage.f.setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(145)
							.addComponent(lblWelcomeStaffMember))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnLogout)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSupplies)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addGap(0, 0, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeStaffMember)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogout)
						.addComponent(btnNewButton)
						.addComponent(btnSupplies)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}