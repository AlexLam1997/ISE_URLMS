package ca.mcgill.ecse321.labmanagementsystem.controller;

import java.util.List;

import ca.mcgill.ecse321.labmanagementsystem.model.Supply;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.persistence.PersistenceXStream;

public class SupplyController {
	private URLMS urlms;

	public SupplyController(URLMS urlms) {
		this.urlms = urlms;
	}

	/**
	 * Adds supplies to the current inventory.
	 * 
	 * @param type
	 *            of supply to add.
	 * @param number
	 *            of supply to add (quantity).
	 * @throws InvalidInputException
	 */
	public void addSupply(String type, String number) throws InvalidInputException {
		boolean added = false; // Keep track if the supply was added after iterating through the list of
								// supplies

		type = type.trim();
		number = number.trim();
		
		// Check for invalid inputs
		InvalidInputException.nameInputCheck(type);
		InvalidInputException.numberInputCheck(number);

		// Load from the current system
		URLMS current = (URLMS) PersistenceXStream.loadFromXMLwithXStream();
		List<Supply> supplyList = current.getSupplies();

		Supply oldSupply = null; // Initialize to null, but should never be added as null
		Supply newSupply = null; // Initialize to null, but should never be added as null
		/*
		 * Iterate through the list and look if the supply type already exist. No need
		 * to create a new Supply if it does, but simply add to its quantity. If it
		 * doesn't exist, after iterating through the list, create a new Supply.
		 */
		for (int i = 0; i < supplyList.size(); i++) {
			Supply currentSupply = supplyList.get(i); // i-th supply that we are currently on

			if (currentSupply.getType().equalsIgnoreCase(type)) { // if this type of supply already exists, ignoring
																	// cases
				// Add to the current quantity, keeping the the name of the type that already
				// existed.
				oldSupply = currentSupply;				
				newSupply = new Supply(currentSupply.getQuantity() + Integer.parseInt(number), currentSupply.getType(), urlms);
				added = true;
				urlms.removeSupply(oldSupply);  // remove what was already in the xml
				break;
			}
		}
		if (!added) {
			// if this type of supply was not added, therefore does not already exist.
			newSupply = new Supply(Integer.parseInt(number), type, urlms);
		}

		
		urlms.addSupply(newSupply); // add the new/updated supply
		PersistenceXStream.saveToXMLwithXStream(urlms);

	}

	/**
	 * Remove supplies from the current inventory.
	 * 
	 * @param type
	 *            of supply to remove.
	 * @param number
	 *            of supply to remove (quantity).
	 * @throws InvalidInputException
	 */
	public void removeSupply(String type, String number) throws InvalidInputException {
		boolean removed = false;
		type = type.trim();
		number = number.trim();

		// Check for invalid inputs
		InvalidInputException.nameInputCheck(type);
		InvalidInputException.numberInputCheck(number);

		// Load from the current system
		URLMS current = (URLMS) PersistenceXStream.loadFromXMLwithXStream();
		List<Supply> supplyList = current.getSupplies();

		Supply newSupply = null; // Initialize to null, but should never end as null.
		Supply oldSupply = null;
		/*
		 * Iterate through the list and look for the supply type. Remove from its
		 * quantity if found. If it cannot find, it does not exist, thus cannot be removed.
		 */
		for (int i = 0; i < supplyList.size(); i++) {
			Supply currentSupply = supplyList.get(i); // i-th supply that we are currently on

			if (currentSupply.getType().equalsIgnoreCase(type)) { // Check if the supply exsits.
				// Remove from current quantity.
				
				if (currentSupply.getQuantity()>Integer.parseInt(number)) { // Quantity > number
					oldSupply = currentSupply;
					newSupply = new Supply(currentSupply.getQuantity() - Integer.parseInt(number), currentSupply.getType(), urlms);
					
					urlms.removeSupply(oldSupply); // remove what was already in the xml.
					urlms.addSupply(newSupply); // add the updated supply in the xml.
					removed = true;
					break;
				}else if (currentSupply.getQuantity() < Integer.parseInt(number)) { //Quantity < number
					throw new InvalidInputException("Only " + currentSupply.getQuantity()+". Cannot remove " + number);
				}else { // Quantity == number
					//TODO would be nice to remove the supply from the xml file completely when quantity is 0 ...
					
				}
				
			}
		}
		if(!removed) {
			throw new InvalidInputException(type + " does not exist!");
		}
		
		PersistenceXStream.saveToXMLwithXStream(urlms);


	}
	
	/**
	 * Prints the current list of supplies and their quantity.
	 */
	public void listSupply () {
		
		// Load from the current system
		URLMS current = (URLMS) PersistenceXStream.loadFromXMLwithXStream();
		List<Supply> supplyList = current.getSupplies();
		String list = "";
		
		for(int i=0; i < supplyList.size();i++) {
			list = list +'\n'+supplyList.get(i).toString();
		}
		System.out.println(list); // TODO prob not the way to do it
		
		
	}

}
