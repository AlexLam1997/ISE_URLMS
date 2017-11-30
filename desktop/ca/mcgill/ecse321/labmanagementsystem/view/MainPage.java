package ca.mcgill.ecse321.labmanagementsystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse321.labmanagementsystem.controller.MainPageController;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.view.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainPage implements Serializable {

	
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField idNumField;
	private URLMS urlms;
	private MainPageController mpc = new MainPageController(urlms);
	public static JFrame f = new JFrame("");

	public MainPage(URLMS urlms) {
		this.urlms = urlms;
		initComponents();
	}

	private void initComponents() {
		f.setTitle("Welcome to the University Lab Management System");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 630, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);

		JLabel lblAreYouA = new JLabel("Please Log In");
		lblAreYouA.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblUsername = new JLabel("Name:");

		nameField = new JTextField();
		nameField.setColumns(10);

		JLabel lblPassword = new JLabel("Employee Number");

		idNumField = new JTextField();
		idNumField.setColumns(10);

		JButton btnLogin = new JButton("Log In");
		btnLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int login = mpc.logIn(nameField.getText(), idNumField.getText());
				if(login==0){ 
					new DirectorMainPage(urlms);
					DirectorMainPage.f.setVisible(true);
					MainPage.f.setVisible(false);

				}else if(login==1) {
					new StaffMainPage(urlms);
					StaffMainPage.f.setVisible(true);
					MainPage.f.setVisible(false);
				}else if(login==-1){
					
					JDialog notdiretor = new JDialog(MainPage.f, "Cannot access as Director", false);
					notdiretor.setSize(350, 20);
					notdiretor.setLocationRelativeTo(MainPage.f);
					notdiretor.setVisible(true);
				}else if(login==-2) {
					JDialog mismatch = new JDialog(MainPage.f, "Name or Employee Number does not match", false);
					mismatch.setSize(475, 20);
					mismatch.setLocationRelativeTo(MainPage.f);
					mismatch.setVisible(true);
				}
				
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPassword)
									.addComponent(lblUsername))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
									.addComponent(idNumField, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
								.addContainerGap())
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblAreYouA)
								.addGap(243)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(256)
							.addComponent(btnLogin)
							.addGap(248))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblAreYouA)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(idNumField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogin)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
