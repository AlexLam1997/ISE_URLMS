package ca.mcgill.ecse321.labmanagementsystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import ca.mcgill.ecse321.labmanagementsystem.controller.*;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;

public class EquipmentPage implements Serializable {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static JFrame f = new JFrame("");
	private URLMS urlms;
	
	public EquipmentPage(URLMS urlms){
		this.urlms = urlms;
		initComponents();
	}

	
	private void initComponents() {
		f.setTitle("Equipment");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setBounds(100, 100, 537, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);
		
		JLabel lblType = new JLabel("Add, Remove or View Equipment(s)");
		
		JLabel lblType_1 = new JLabel("Type:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblEquipmentQuantity = new JLabel("Quantity:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnAddEquipment = new JButton("Add Equipment");
		
		JButton btnRemoveEquipment = new JButton("Remove Equipment");
		
		JButton btnViewEquipmens = new JButton("VIew Inventory");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblType)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblType_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEquipmentQuantity)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAddEquipment)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(270)
							.addComponent(btnRemoveEquipment))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(189)
							.addComponent(btnViewEquipmens)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(lblType)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEquipmentQuantity)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemoveEquipment)
						.addComponent(btnAddEquipment))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnViewEquipmens)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
