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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LabExpensesPage implements Serializable {

	private JPanel contentPane;
	public static JFrame f = new JFrame("");
	private URLMS urlms;
	private JTextField textField;
	private JTextField textField_1;
	
	public LabExpensesPage(URLMS urlms){
		this.urlms = urlms;
		initComponents();
	}

	
	private void initComponents() {
		f.setTitle("Lab Expenses");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setBounds(100, 100, 503, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);
		
		JLabel lblAddOrView = new JLabel("Add or View Lab Expenses");
		
		JLabel lblType = new JLabel("Type:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnAddExpense = new JButton("Add Expense");
		
		JButton btnViewExpenses = new JButton("View Report");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddOrView)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblType)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAmount)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAddExpense)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))))
							.addContainerGap())
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(256)
							.addComponent(btnViewExpenses)
							.addGap(81))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddOrView)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnViewExpenses)
						.addComponent(btnAddExpense))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}