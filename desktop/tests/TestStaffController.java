package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse321.labmanagementsystem.controller.InvalidInputException;
import ca.mcgill.ecse321.labmanagementsystem.controller.StaffController;
import ca.mcgill.ecse321.labmanagementsystem.model.Staff;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.persistence.PersistenceXStream;

public class TestStaffController {

	private static URLMS urlms;
	static String fileName = "output" + File.separator + "test.xml";

	@Before
	public void setUp() throws Exception {
		PersistenceXStream.clearXML(fileName);
		urlms = PersistenceXStream.prepareToSave(fileName);
	}

	@After
	public void tearDown() {
		urlms.delete();
		PersistenceXStream.clearXML(fileName);
	}

	@Test
	public void testCreateStaff() throws InvalidInputException {
		assertEquals(0, this.urlms.getStaffs().size());

		String name = "Oscar";
		String idNumber = "260676008";
		String role = "Research Assistant";

		StaffController uc = new StaffController(urlms);
		try {
			uc.createStaff(name, idNumber, role);
		} catch (InvalidInputException e) {
			//check no error occured
			fail();
		}
		
		checkResultStaff(name, idNumber, role, urlms);

	}

	private void checkResultStaff(String name, String idNumber, String role, URLMS urlms) {
		assertEquals(1, urlms.getStaffs().size());
		assertEquals(name, urlms.getStaff(0).getName());
		assertEquals(idNumber, urlms.getStaff(0).getIdNumber());
		assertEquals(role, urlms.getStaff(0).getRole());
	}

	@Test
	public void testAddStaffEmpty() {
		assertEquals(0, urlms.getStaffs().size());
		String name = "";
		String idNumber = "";
		String role = "";
		String error = null;

		StaffController uc = new StaffController(urlms);
		try {
			uc.createStaff(name, idNumber, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Input cannot be empty!", error);

		// check no change in memory
		assertEquals(0, urlms.getStaffs().size());
	}

	@Test
	public void testCreateStaffEmpty() {
		assertEquals(0, urlms.getStaffs().size());

		String name = "";
		String idNumber = "";
		String role = "";

		String error = null;
		StaffController uc = new StaffController(urlms);
		try {
			uc.createStaff(name, idNumber, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Input cannot be empty!", error);

		// check no change in memory
		assertEquals(0, urlms.getStaffs().size());

	}

	@Test
	public void testCreateStaffSpaces() {
		assertEquals(0, urlms.getStaffs().size());

		String name = " ";
		String idNumber = " ";
		String role = "Research Asisstant";

		String error = null;
		StaffController uc = new StaffController(urlms);
		try {
			uc.createStaff(name, idNumber, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Input cannot be empty!", error);

		// check no change in memory
		assertEquals(0, urlms.getStaffs().size());
	}

	@Test
	public void testRemoveStaff() throws InvalidInputException {
		StaffController sc = new StaffController(urlms);
		sc.createStaff("alex", "1234", "Research Associate");
		try {
			sc.removeStaff("alex", "1234");
		}catch(InvalidInputException e) {
			System.out.print(e.getMessage());
			fail();
		}
		
		if(!urlms.getStaffs().isEmpty()) {
			fail();
		}
		
	}

}
