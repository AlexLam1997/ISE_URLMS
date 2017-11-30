package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.mcgill.ecse321.labmanagementsystem.model.Equipment;
import ca.mcgill.ecse321.labmanagementsystem.model.Staff;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.persistence.PersistenceXStream;

//pre-lim test for only equipment and staff classes. 
//This test is designed to test the functionality of the persistence layer of our application
//It verifies if what we want to be saved is actually written to the xml file
public class TestPersistence {
private URLMS lm;

	@Before
	public void setUp() throws Exception {
		lm = new URLMS();		
		
		//Create lab participants
		Equipment eq1 = new Equipment(1,"computor", lm);
		Equipment eq2 = new Equipment(2,"table", lm);
		
		Staff s1 = new Staff("Alex", "260746239", "research associate", lm);
		Staff s2 = new Staff("Chris", "242563542", "reasearch assitant",lm);
		
		//add stuff to URLMS
		lm.addEquipment(eq1);
		lm.addEquipment(eq2);
		lm.addStaff(s1);
		lm.addStaff(s2);
		
		//create new configured file to save to
		PersistenceXStream.prepareToSave("output"+File.separator+"test.xml");
	}

	@After
	public void tearDown() throws Exception {
		lm.delete();
		PersistenceXStream.clearXML("output"+File.separator+"test.xml");
	}

	@Test
	public void test() {
		
		//save the model that is loaded during the test setup
		if(!PersistenceXStream.saveToXMLwithXStream(lm)) {
			fail("Could not save file.");	
		}
		
		//clear the model in memory
		lm.delete();
		//make sure memory is cleared
		assertEquals(0, lm.getEquipment().size());
		assertEquals(0, lm.getStaffs().size());
		
		//load model from the file and compare to what we think we saved
		lm = (URLMS) PersistenceXStream.loadFromXMLwithXStream();
		if(lm==null)
			fail("Could not load file");
		
		//check if entries match model entries set up previously
		assertEquals(2, lm.getEquipment().size());
		assertEquals("computor", lm.getEquipment(0).getType());
		assertEquals("table", lm.getEquipment(1).getType());
		assertEquals(2, lm.getStaffs().size());
		assertEquals("Alex", lm.getStaff(0).getName());
		assertEquals("Chris", lm.getStaff(1).getName());
		assertEquals("260746239", lm.getStaff(0).getIdNumber());
		assertEquals("242563542", lm.getStaff(1).getIdNumber());
		assertEquals("research associate", lm.getStaff(0).getRole());
		assertEquals("reasearch assitant", lm.getStaff(1).getRole());
	}

}
