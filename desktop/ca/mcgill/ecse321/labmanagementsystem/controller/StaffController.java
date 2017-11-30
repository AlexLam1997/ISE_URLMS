package ca.mcgill.ecse321.labmanagementsystem.controller;

import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.persistence.PersistenceXStream;
import java.util.List;
import ca.mcgill.ecse321.labmanagementsystem.model.Staff;

public class StaffController {
	private URLMS urlms;

	public StaffController(URLMS urlmsl) { // Staff controller Constructor
		this.urlms = urlmsl;
	}

	/**
	 * Create and add a staff. It checks the input to see if they are valid.
	 * @param name
	 * @param idNumber
	 * @param role
	 * @throws InvalidInputException
	 */
	public void createStaff(String name, String idNumber, String role) throws InvalidInputException {
		try {
			name = name.trim();
			idNumber = idNumber.trim();
			role = role.trim();

			InvalidInputException.nameInputCheck(name);
			InvalidInputException.numberInputCheck(idNumber);
			InvalidInputException.checkRole(role);
			if (checkDuplicate(idNumber)>=0) { // already added
				throw new InvalidInputException("An employee with this number already exists!");
			} else {
				new Staff(name, idNumber, role, urlms);
				//this.urlms.addStaff(s); dont need to do urlms.add(staff) because desired functionality
				//ie adding a staff member to the list of staffs in the urlms, is done by the new Staff()
				//method
				PersistenceXStream.saveToXMLwithXStream(urlms);
			}
		} catch (InvalidInputException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

	/**
	 * Removes a staff from the system. It checks if the inputs are valid.
	 * @param name
	 * @param idNumber
	 * @throws InvalidInputException
	 */
	public void removeStaff(String name, String idNumber) throws InvalidInputException {
		try {
			name = name.trim();
			idNumber = idNumber.trim();
			// Check if the staff exists then remove
			// if D.N.E, throw exception ("Staff name, with idNumber does not exist)"
			InvalidInputException.nameInputCheck(name);
			InvalidInputException.numberInputCheck(idNumber);
			boolean found = false;

			// URLMS urlmsSaved = (URLMS) PersistenceXStream.loadFromXMLwithXStream(); //
			// Access the current system from xml file

			List<Staff> staffList = urlms.getStaffs();
			// Iterate through each staff
			for (int i = 0; i < staffList.size(); i++) {
				Staff staff = urlms.getStaff(i);
				// Check if this i-th staff's employee number is the same as idNumber
				if (staff.getIdNumber().equals(idNumber)) {
					if (staff.getName().equals(name)) {
						urlms.removeStaff(staff);
						PersistenceXStream.saveToXMLwithXStream(urlms);
						found = true;
						break; // No need to iterate through the staff list anymore
					}

				}
			}
			if (!found) {
				throw new InvalidInputException("The staff does not exsits");
			}

		} catch (InvalidInputException e) {
			throw new InvalidInputException(e.getMessage());
		}

	}

	/**
	 * Edits the staff's role by first removing then re-adding.
	 * (Calls removeStaff then createStaff)
	 * @param name
	 * @param idNumber
	 * @param role
	 * @param newRole
	 * @throws InvalidInputException
	 */
	public void editStaff(String name, String idNumber, String role, String newRole) throws InvalidInputException {
		removeStaff(name, idNumber);
		createStaff(name, idNumber, newRole);
	}

	
	
		/**
		 * Display the current staff list.
		 * @return data - a 2D array of staff member info to be displayed by the view
		 */
		public Object[][] listStaff() {
			
			List<Staff>stafflist=urlms.getStaffs();
			int column = stafflist.size();
			int rows = 3; //name, id, role
			Object data [][]=new Object[column][rows];
			for(int i =0; i<stafflist.size();i++) {
				Staff staff = stafflist.get(i);
				String name = staff.getName();
				String ID=staff.getIdNumber();
				String role = staff.getRole();
				
				data[i][0] = name; 
				data[i][1]=ID;
				data[i][2]=role;
			}
			
			return data;
		}
	
	/**
	 * Checks if a staff member with same id number is already in the list, if yes,
	 * returns the index where it is in the list. 
	 * 
	 * @param idNumber
	 * @return atIndex - The index of the duplicate name, or -1 if not found.
	 * @throws InvalidInputException
	 */
	public int checkDuplicate(String idNumber) throws InvalidInputException {
		URLMS current = (URLMS) PersistenceXStream.loadFromXMLwithXStream(); // Access the current system from xml file
		int atIndex = -1;

		if (current != null) {
			List<Staff> staffList = current.getStaffs();
			for (int i = 0; i < staffList.size(); i++) {
				Staff staff = staffList.get(i);
				if (staff.getIdNumber().equals(idNumber)) {
					atIndex = i;
				}
			}
		}
		return atIndex;
	}

}
