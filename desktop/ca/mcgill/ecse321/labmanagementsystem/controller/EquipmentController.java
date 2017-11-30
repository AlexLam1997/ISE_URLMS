package ca.mcgill.ecse321.labmanagementsystem.controller;

import java.util.List;

import ca.mcgill.ecse321.labmanagementsystem.model.Equipment;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.persistence.PersistenceXStream;

public class EquipmentController {
	private URLMS urlms;

	public EquipmentController(URLMS urlms) {
		this.urlms = urlms;
	}

	public void addEquipment(String equipment, String quantity) throws InvalidInputException {
		// if equipment has already been added, increment quantity by specified amount
		// else, add new equipment
		
		//setURLMS ((URLMS) PersistenceXStream.loadFromXMLwithXStream());
		equipment = equipment.trim();
		quantity = quantity.trim();
		
		try {
			InvalidInputException.nameInputCheck(equipment);
			InvalidInputException.numberInputCheck(String.valueOf(quantity));

			int index = this.hasEquipment(equipment);// check method hasEquipment for details
			if (index == -1) {// no equipment with this type exists in the list
				new Equipment(Integer.parseInt(quantity), equipment, urlms);
				//this.urlms.addEquipment(newEquipment); //dont need to add, new equip does automatically

			} else { // there exists a previous equipment of this type in the list
				int oldQuantity = this.urlms.getEquipment(index).getQuantity();
				this.urlms.getEquipment(index).setQuantity(oldQuantity + Integer.parseInt(quantity));
			}
			PersistenceXStream.saveToXMLwithXStream(urlms);
		} catch (InvalidInputException e) {
			throw new InvalidInputException(e.getMessage());
		}

	}

	public void removeEquipment(String type, String quantity) throws InvalidInputException {
		try {
//			type=type.trim();
//			quantity=quantity.trim();
			// Check if the staff exists then remove
			// if D.N.E, throw exception ("Staff name, with idNumber does not exist)"
			InvalidInputException.nameInputCheck(type);
			InvalidInputException.numberInputCheck(quantity);
			boolean found = false;

			// URLMS urlmsSaved = (URLMS) PersistenceXStream.loadFromXMLwithXStream(); //
			// Access the current system from xml file

			List<Equipment> equipList = urlms.getEquipment();
			// Iterate through each staff
			for (int i = 0; i < equipList.size(); i++) {
				Equipment equipment = urlms.getEquipment(i);
				// Check if this i-th staff's employee number is the same as idNumber
				if (equipment.getType().equalsIgnoreCase(type)) {
					found = true;
					int oldQuantity = equipment.getQuantity();
					int newQuantity = oldQuantity - Integer.parseInt(quantity);

					if (newQuantity > 0) {
						equipment.setQuantity(newQuantity);
					} else {
						urlms.removeEquipment(equipment);
					}
					
					break; // No need to iterate through the staff list anymore
				}
				
			}
			if (!found) {
				throw new InvalidInputException(type + " does not exist!");
			}
PersistenceXStream.saveToXMLwithXStream(urlms);
		} catch (InvalidInputException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

	/**
	 * Prints the current list of supplies and their quantity.
	 */
	public void listEquipment() {

		// Load from the current system
		URLMS current = (URLMS) PersistenceXStream.loadFromXMLwithXStream();
		List<Equipment> equipmentList = current.getEquipment();
		String list = "";

		for (int i = 0; i < equipmentList.size(); i++) {
			list = list + '\n' + equipmentList.get(i).toString();
		}
		System.out.println(list); // TODO probably isnt the way to do it

	}

	private int hasEquipment(String equipment) {
		int duplicate = -1;
		if (urlms != null) {
			List<Equipment> equipList = this.urlms.getEquipment();
			for (int i = 0; i < equipList.size(); i++) {
				Equipment equip = equipList.get(i);
				if (equip.getType().equalsIgnoreCase(equipment)) { // if a duplicate is found, return the index of the
																	// item
					duplicate = i;
				}
			}
		}

		return duplicate;

	}

	public void setURLMS(URLMS urlms) {
		this.urlms = urlms;
	}
}
