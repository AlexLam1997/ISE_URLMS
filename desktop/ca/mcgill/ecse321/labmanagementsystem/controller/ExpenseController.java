package ca.mcgill.ecse321.labmanagementsystem.controller;

import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;

public class ExpenseController {
	private URLMS urlms;
	private String report = "";
	
	public ExpenseController(URLMS urlms) {
		this.urlms = urlms;
	}
	
	public void addAccount() {
	}
	
	public void removeAccount() {
		
	}
	
	public void addExpense() {
		
		
	}
	
	public void addDeposit() {
		
	}
	
	public void makeReport() {
		System.out.println(getReport());
	
	}

	public String getReport() {
		return report;
	}

	public void setReport(String transaction) {
		report.concat(transaction + '\n');
	
	}

}
