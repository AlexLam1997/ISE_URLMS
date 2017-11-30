package ca.mcgill.ecse321.labmanagementsystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ca.mcgill.ecse321.labmanagementsystem.controller.*;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.view.GroupButtonUtils;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import java.io.*;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;		
import java.awt.event.MouseEvent;

public class StaffPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame f = new JFrame("Add Staff");
	private JPanel contentPane;
	private JTextField addNameField;
	private JTextField addIDField;
	private URLMS urlms;
	private GroupButtonUtils gbUtils = new GroupButtonUtils();
	private String error = null;
	private JLabel errorMessage;
	private JLabel lblAddorEditAStaff;
	private JLabel lblRemoveAStaff;
	private JLabel lblName_1;
	private JTextField removeNameField;
	private JButton btnRemoveStaff;
	private JLabel label;
	private JTextField removeIDField;
	private ButtonGroup button_group;
	private JButton btnListStaff;
	// TODO private JButton btnListStaff;

	public StaffPage(URLMS urlms) {
		this.urlms = urlms;
		initComponents();
	}

	private void initComponents() {
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setTitle("Staff");
		f.setBounds(100, 100, 583, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);

		JButton btnAddStaff = new JButton("Add Staff");

		JLabel lblName = new JLabel("Name:");

		JLabel lblId = new JLabel("Employee Number:");

		JLabel lblRole = new JLabel("Role:");

		addNameField = new JTextField();
		addNameField.setColumns(10);

		addIDField = new JTextField();
		addIDField.setColumns(10);
		
		lblAddorEditAStaff = new JLabel("Add or Edit a Staff Member");
		
		lblRemoveAStaff = new JLabel("Remove a Staff Member");
		
		lblName_1 = new JLabel("Name:");
		
		removeNameField = new JTextField();
		removeNameField.setColumns(10);
		
		btnRemoveStaff = new JButton("Remove Staff");
		
		label = new JLabel("Employee Number:");
		
		removeIDField = new JTextField();
		removeIDField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Research Associate");
		
		JRadioButton rdbtnLabAssistant = new JRadioButton("Research Assistant");
		
		//TODObtnListStaff = new JButton("List Staff");
		JButton btnEditRole = new JButton("Edit Role");
		
		btnListStaff = new JButton("List Staff");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblName)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(addNameField, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblName_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(removeNameField, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblId)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(addIDField, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
								.addComponent(lblAddorEditAStaff)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRole)
									.addGap(18)
									.addComponent(rdbtnNewRadioButton)
									.addGap(18)
									.addComponent(rdbtnLabAssistant))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(removeIDField, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblRemoveAStaff)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(168)
							.addComponent(btnAddStaff)
							.addGap(48)
							.addComponent(btnEditRole))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(221)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnListStaff, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRemoveStaff, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(lblAddorEditAStaff)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(addNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(addIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRole)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnLabAssistant))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddStaff)
						.addComponent(btnEditRole))
					.addGap(25)
					.addComponent(lblRemoveAStaff)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_1)
						.addComponent(removeNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(removeIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRemoveStaff)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListStaff)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		button_group = new ButtonGroup();
		button_group.add(rdbtnNewRadioButton);
		button_group.add(rdbtnLabAssistant);
		contentPane.setLayout(gl_contentPane);

		btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addStaffButtonActionPerformed();
			}
		});
		
		btnEditRole.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editStaffButtonActionPerformed();
			}
		});
		
		btnRemoveStaff.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeStaffButtonActionPerformed();
			}
		});
		
		btnListStaff.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				listStaffButtonActionPerformed();
			}
		});
		
	}
	
	private void addStaffButtonActionPerformed() {
		// create and call the controller
		StaffController uc = new StaffController(urlms);
		
		try {
			uc.createStaff(addNameField.getText(), addIDField.getText(), gbUtils.getSelectedButtonText(button_group));
			successfullAddStaff(); // TODO: make update() in model to update views
		} catch (InvalidInputException e) {
			error = e.getMessage();
			JDialog er = new JDialog(StaffPage.f, error, false);
			er.setSize(500, 20);
			er.setLocationRelativeTo(StaffPage.f);
			er.setVisible(true);
		}
		refreshData();
	}
	private void listStaffButtonActionPerformed() {		
					StaffController sc = new StaffController(urlms);		
					Object [][] data = sc.listStaff();		
					String [] columnInfo = {"Name","ID number", "Role"};		
					displayTable(columnInfo,data,false);		
				}
	
	private void editStaffButtonActionPerformed() {
		// create and call the controller
				StaffController uc = new StaffController(urlms);
				
				try {
					uc.removeStaff(addNameField.getText(), addIDField.getText());
					uc.createStaff(addNameField.getText(), addIDField.getText(), gbUtils.getSelectedButtonText(button_group));
					successfullEditStaff(); // TODO: make update() in model to update views
				} catch (InvalidInputException e) {
					error = e.getMessage();
					JDialog er = new JDialog(StaffPage.f, error, false);
					er.setSize(350, 20);
					er.setLocationRelativeTo(StaffPage.f);
					er.setVisible(true);
				}
				refreshData();
		
	}
	
	private void removeStaffButtonActionPerformed() {
		// create and call the controller
		StaffController uc = new StaffController(urlms);
		
		try {
			uc.removeStaff(removeNameField.getText(), removeIDField.getText());
			successfullRemoveStaff(); // TODO: make update() in model to update views
		} catch (InvalidInputException e) {
			error = e.getMessage();
			JDialog er = new JDialog(StaffPage.f, error, false);
			er.setSize(325, 20);
			er.setLocationRelativeTo(StaffPage.f);
			er.setVisible(true);
		}
		refreshData();
	}

	public void refreshData() {
		addNameField.setText("");
		addIDField.setText("");
		removeNameField.setText("");
		removeIDField.setText("");
		button_group.clearSelection();

		errorMessage.setText(error);
		if (error == null || error.length() == 0) {
			addNameField.setText("");
			addIDField.setText("");

		}
		f.pack();
	}

	public void successfullAddStaff() {
		JDialog d = new JDialog(StaffPage.f,
				"Success! " + addNameField.getText() + " added as a "  +gbUtils.getSelectedButtonText(button_group), false);
		d.setSize(500, 20);
		d.setLocationRelativeTo(StaffPage.f);
		d.setVisible(true);
	}
	public void successfullEditStaff() {
		JDialog d = new JDialog(StaffPage.f,
				"Success! " + addNameField.getText() + " changed to "  + gbUtils.getSelectedButtonText(button_group), false);
		d.setSize(500, 20);
		d.setLocationRelativeTo(StaffPage.f);
		d.setVisible(true);

	}
	
	public void successfullRemoveStaff() {
		JDialog d = new JDialog(StaffPage.f,
				"Success! " +" Removed "+ removeNameField.getText(), false);
		d.setSize(500, 20);
		d.setLocationRelativeTo(StaffPage.f);
		d.setVisible(true);
	}
	 private static void printDebugData(JTable table) {		
		 	        int numRows = table.getRowCount();		
			        int numCols = table.getColumnCount();		
			        javax.swing.table.TableModel model = table.getModel();		
					
			        System.out.println("Value of data: ");		
			        for (int i=0; i < numRows; i++) {		
			            System.out.print("    row " + i + ":");		
		            for (int j=0; j < numCols; j++) {		
		                System.out.print("  " + model.getValueAt(i, j));		
		            }		
		            System.out.println();		
			        }		
		        System.out.println("--------------------------");		
			    }		
					
			    /**		
			     * Create the GUI and show it.  For thread safety,		
			     * this method should be invoked from the		
			     * event-dispatching thread.		
			     */		
			    public static void displayTable(String[] columnNames,Object[][] data, boolean debug) {		
			        //Create and set up the window.		
			        JFrame frame = new JFrame("Staff List");		
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			        		
					
			        //get and set up the content pane.		
			        Container container = frame.getContentPane();		
			        final JTable table = new JTable(data, columnNames);		
		        table.setPreferredScrollableViewportSize(new Dimension(500, 200));		
		        table.setFillsViewportHeight(true);		
					
			        if (debug) {		
			            table.addMouseListener(new MouseAdapter() {		
			                public void mouseClicked(MouseEvent e) {		
		                    printDebugData(table);		
		                }		
		            });		
			        }		
					
			        //Create the scroll pane and add the table to it.		
			        JScrollPane scrollPane = new JScrollPane(table);		
			        //Add the scroll pane to this panel.		
		        container.add(scrollPane);		
					
			        frame.setContentPane(container);		
					
			        //Display the window.		
			        frame.pack();		
			        frame.setVisible(true);		
			    }
}
