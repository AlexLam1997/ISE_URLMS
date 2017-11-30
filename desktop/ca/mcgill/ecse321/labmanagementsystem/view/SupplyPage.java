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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class SupplyPage implements Serializable {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static JFrame f = new JFrame("");
	private URLMS urlms;
	
	public SupplyPage(URLMS urlms){
		this.urlms = urlms;
		initComponents();
	}

	
	private void initComponents() {
		f.setTitle("Supplies");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setBounds(100, 100, 534, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);
		
		JLabel lblSupplyType = new JLabel("Type:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAddRemoveView = new JLabel("Add, Remove or View Supplies");
		
		JLabel lblQuantity = new JLabel("Quantity:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnAddSupplies = new JButton("Add Supplies");
		
		JButton btnRemoveSupplies = new JButton("Remove Supplies");
		
		JButton btnViewSupplies = new JButton("View Inventory");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSupplyType)
									.addGap(12)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblQuantity)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)))
							.addContainerGap())
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addComponent(btnAddSupplies)
							.addGap(76)
							.addComponent(btnRemoveSupplies)
							.addGap(66))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(186)
					.addComponent(btnViewSupplies)
					.addContainerGap(166, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddRemoveView)
					.addContainerGap(257, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(lblAddRemoveView)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSupplyType))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemoveSupplies)
						.addComponent(btnAddSupplies))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnViewSupplies)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}