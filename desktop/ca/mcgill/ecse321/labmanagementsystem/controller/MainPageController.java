package ca.mcgill.ecse321.labmanagementsystem.controller;

import java.time.Period;
import java.util.List;

import ca.mcgill.ecse321.labmanagementsystem.model.Staff;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.persistence.PersistenceXStream;

public class MainPageController {

	private URLMS urlms;
	private StaffController sc = new StaffController(urlms);

	public MainPageController(URLMS urlmsl) { // Main page Constructor
		this.urlms = urlmsl;
	}

	/**
	 * After getting the user information, determine whether the user is the
	 * director or a regular staff member. The name and employee number would
	 * obviously have to match what is in the system to gain access. The director
	 * logs in by inputing both name as "admin" and employee number as "0000".
	 * 
	 * @param name
	 * @param idNumber
	 * @return role - an integer. 0 for director, 1 for staff, -1 for trying to
	 *         access as director (fail) and -2 for name and number mismatch.
	 */
	public int logIn(String name, String idNumber) {
		int role = 0;

		name = name.trim();
		idNumber = idNumber.trim();

		try {
			InvalidInputException.numberInputCheck(idNumber);
			InvalidInputException.nameInputCheck(name);

			
			int existsAt = sc.checkDuplicate(idNumber);
			URLMS current = (URLMS)PersistenceXStream.loadFromXMLwithXStream();
			String staffName = null;
			if(existsAt >=0) {
				staffName =current.getStaffs().get(existsAt).getName();
			}
			
			if (name.equalsIgnoreCase("admin") && idNumber.equals("0000")) {
				role = 0;
			} else if (name.equalsIgnoreCase("admin") && !idNumber.equals("0000")) {
				role = -1;
			}else if (existsAt >= 0 && staffName.equals(name)) {
				role = 1;
			} else {
				role = -2;
			}

		} catch (InvalidInputException e) {
			e.printStackTrace();
		}

		return role;

	}

}
