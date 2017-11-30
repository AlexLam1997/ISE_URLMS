package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse321.labmanagementsystem.controller.EquipmentController;
import ca.mcgill.ecse321.labmanagementsystem.controller.ExpenseController;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.persistence.PersistenceXStream;

public class TestExpenseController {
	
	private static URLMS urlms;
	private static ExpenseController exc;
	static String fileName = "output" + File.separator + "test.xml";

	@Before
	public void setUp() throws Exception {
		PersistenceXStream.clearXML(fileName);
		urlms = PersistenceXStream.prepareToSave(fileName); //creates a new URLMS object and xml file to save to
		exc = new ExpenseController(urlms); //create new controller associated with urlms
	}

	@After
	public void tearDown() throws Exception {
		urlms.delete();
		PersistenceXStream.clearXML(fileName);
	}
	
	@Test
	public void testaddAccount() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testremoveAccount() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testaddExpense() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testaddDeposit() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testmakeReport() {
		fail("Not yet implemented");
	
	}
	
	@Test
	public void testgetReport() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testsetReport() {
		fail("Not yet implemented");
	}

}
