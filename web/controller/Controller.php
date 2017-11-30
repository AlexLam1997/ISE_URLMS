<?php
$my_dir = dirname(__FILE__);
require_once $my_dir . '/../persistence/PersistenceLabManagementSystem.php';
require_once $my_dir . '/../model/Staff.php';
require_once $my_dir . '/../model/URLMS.php';

class Controller
{
	public function __construct()
	{
	}

	public function createStaff($staff_name, $staff_idNumber, $staff_role) {
		// 1. Validate input
		$name = $staff_name;
		$idNumber = $staff_idNumber;
		$role = $staff_role;
		if ($name == null || strlen($name) == 0 || $idNumber == null || strlen($idNumber) == 0 || $role == null || strlen($role) == 0) {
			throw new Exception("Input cannot be empty!");
		} else {
			// 2. Load all of the data
			$pm = new PersistenceLabManagementSystem();
			$urlms = $pm->loadDataFromStore();
			
			// 3. Add the new Student
			$staff = new Staff($name, $idNumber, $role, $urlms);
			$urlms->addStaff($staff);
		
			// 4. Write all of the data
			$pm->writeDataToStore($urlms);
		}
	}
	
}
?>