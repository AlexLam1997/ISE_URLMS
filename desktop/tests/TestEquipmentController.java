package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse321.labmanagementsystem.controller.EquipmentController;
import ca.mcgill.ecse321.labmanagementsystem.controller.InvalidInputException;
import ca.mcgill.ecse321.labmanagementsystem.controller.StaffController;
import ca.mcgill.ecse321.labmanagementsystem.model.Equipment;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.persistence.PersistenceXStream;

public class TestEquipmentController {

	private URLMS urlms;
	private static EquipmentController ec;
	static String fileName = "output" + File.separator + "test.xml";

	@Before
	public void setUp() throws Exception {
		PersistenceXStream.clearXML(fileName);
		urlms = PersistenceXStream.prepareToSave(fileName); //creates a new URLMS object and xml file to save to
		ec = new EquipmentController(urlms); //create new controller associated with urlms
	}

	@After
	public void tearDown() throws Exception {
		urlms.delete();
		PersistenceXStream.clearXML(fileName);
	}

	@Test
	public void testAddEquipment() {
		String quantity1 = "1";
		String type1 = "Computor";
		String quantity2 = "10";
		String type2 = "Printer";

		try {
			ec.addEquipment(type1, quantity1);
			ec.addEquipment(type2, quantity2);
		} catch (InvalidInputException e) {
			fail();
		}

		String[] expected = { "1", "Computor", "10", "Printer" };
		String[] actual = { String.valueOf(urlms.getEquipment(0).getQuantity()), urlms.getEquipment(0).getType(),
				String.valueOf(urlms.getEquipment(1).getQuantity()), urlms.getEquipment(1).getType() };
		assertArrayEquals(expected, actual);

	}
	
	@Test
	public void testAddEquipmentDuplicate() {
		String quantity1 = "1";
		String type1 = "Computor";
		String quantity2 = "10";
		String type2 = "Printer";
		String quantity3 = "1";
		String type3 = "computor"; //test for lower case to upper case comparaison

		try {
			ec.addEquipment(type1, quantity1);
			ec.addEquipment(type2, quantity2);
			ec.addEquipment(type3, quantity3);
		} catch (InvalidInputException e) {
			fail();
		}

		String[] expected = { "2", "Computor", "10", "Printer" };
		String[] actual = { String.valueOf(urlms.getEquipment(0).getQuantity()), urlms.getEquipment(0).getType(),
				String.valueOf(urlms.getEquipment(1).getQuantity()), urlms.getEquipment(1).getType() };
		
		assertArrayEquals(expected, actual);

	}

	@Test(expected = InvalidInputException.class)
	public void testAddEquipmentEmptyInput() throws InvalidInputException {
		String quantity2=""; 
		String type2 = "";
		ec.addEquipment(type2, quantity2);
	}

	@Test(expected = InvalidInputException.class)
	public void testAddEquipmentAlphabeticalInput() throws InvalidInputException {
		String quantity2="alphabet"; //should throw error
		String type2 = "Keyboard";
		ec.addEquipment(type2, quantity2);
	}

	@Test
	public void testRemoveEquipment() throws InvalidInputException {
		ec.addEquipment("Potato", "1");
		ec.removeEquipment("potato", "1"); //should be ok even with lower case

		if (!urlms.getEquipment().isEmpty()) {
			fail();
		}
	}
	
	@Test
	public void testRemoveMoreThanContainsEquip() throws InvalidInputException {
		ec.addEquipment("Potato", "1");
		ec.removeEquipment("potato", "2"); 

		if (!urlms.getEquipment().isEmpty()) {
			fail();
		}
	}

	@Test(expected = InvalidInputException.class)
	public void testRemoveNonExistingEquip() throws InvalidInputException {
		ec.removeEquipment("Potato", "1");
	}
	
	@Test(expected = InvalidInputException.class)
	public void testRemoveEquipNonNumericaInput() throws InvalidInputException {
		ec.addEquipment("Potato", "1");
		ec.removeEquipment("Potato", "one");
	}

	@Test
	public void testListEquip() {
		fail("Not yet implemented");
	}

}
