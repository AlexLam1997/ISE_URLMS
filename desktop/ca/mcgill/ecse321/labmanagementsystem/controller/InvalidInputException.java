package ca.mcgill.ecse321.labmanagementsystem.controller;

public class InvalidInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Check if the name is valid (does not have to be name of a person, but can be
	 * supply, equipment) by checking if it is not empty and consists of only
	 * letters (or spaces).
	 * 
	 * @param name
	 * @throws InvalidInputException
	 */
	public static void nameInputCheck(String name) throws InvalidInputException {
		emptyCheck(name);
		alphabetCheck(name);
	}

	/**
	 * Checks if inputed number is valid by checking if its not empty and if it only
	 * consists of numbers.
	 * 
	 * @param number
	 * @throws InvalidInputException
	 */
	public static void numberInputCheck(String number) throws InvalidInputException {
		emptyCheck(number);
		numberCheck(number);
	}

	/**
	 * Checks if the role matches the options. It also calls alphabetCheck.
	 * 
	 * @param role
	 * @throws InvalidInputException
	 */
	public static void checkRole(String role) throws InvalidInputException {
		alphabetCheck(role);
		if (!(role.equals("Research Associate") || role.equals("Research Assistant")
				|| role.equals("research associate") || role.equals("research assistant"))) {
			throw new InvalidInputException("Please enter a valid role"); // valid roles are research assistant and
			// research associate only
		}
	}

	/**
	 * Checks if the input is empty.
	 * 
	 * @param input
	 * @throws InvalidInputException
	 *             if the input is null, empty, or of length 0.
	 */
	public static void emptyCheck(String input) throws InvalidInputException {

		if (input == null || input.trim().length() == 0 || input.length() == 0) {
			throw new InvalidInputException("Input cannot be empty!");
		}
	}

	/**
	 * Check if input only contains numbers.
	 * 
	 * @param inputNumber
	 * @throws InvalidInputException
	 *             if the input contains anything else than numbers from 0-9.
	 */
	public static void numberCheck(String inputNumber) throws InvalidInputException {
		for (int i = 0; i < inputNumber.length(); i++) {
			if ((inputNumber.charAt(i) < 48 || inputNumber.charAt(i) > 57)) {
				throw new InvalidInputException("Invalid input");
			}
		}
	}

	/**
	 * Check if the input only contains alphabets.
	 * 
	 * @param input
	 * @throws InvalidInputException
	 */
	public static void alphabetCheck(String input) throws InvalidInputException {

		for (int i = 0; i < input.length(); i++) {
			if ((input.charAt(i) >= 65 && input.charAt(i) <= 90) || ((input.charAt(i) >= 97) && input.charAt(i) <= 122)
					|| input.charAt(i) == ' ') {
				// do nothing, its a valid character
			} else {
				throw new InvalidInputException("Invalid input");
			}
		}

	}

}
