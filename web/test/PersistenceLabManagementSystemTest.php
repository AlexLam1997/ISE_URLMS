<?php

require_once __DIR__ . '../../persistence/PersistenceLabManagementSystem.php';
require_once __DIR__ . '../../model/Staff.php';
require_once __DIR__ . '../../model/URLMS.php';

class PersistenceLabManagementSystemTest extends PHPUnit_Framework_TestCase {
	protected $pm;
	protected function setUp() {
		$this->pm = new PersistenceLabManagementSystem ();
	}
	protected function tearDown() {
	}
	public function testPersistence() {

		// 1. Create test data
		$urlms = URLMS::getInstance ();
		$s = new Staff ( "Derek", "260676007" , "Research Assistant" );
		$urlms->addStaff ( $s );

		// 2. Write all of the data
		$this->pm->writeDataToStore ( $urlms );

		// 3. Clear the data from memory
		$urlms->delete ();

		$this->assertEquals ( 0, count ( $urlms->getStaffs () ) );

		// 4. Load it back in
		$urlms = $this->pm->loadDataFromStore ();

		// 5. Check that we got it back
		$this->assertEquals ( 1, count ( $urlms->getStaffs () ) );
		$myStaff = $urlms->getStaff_index ( 0 );
		$this->assertEquals ( "Derek", $myStaff->getName () );
		$this->assertEquals ( "260676007", $myStaff->getIdNumber () );
		$this->assertEquals ( "Research Assistant", $myStaff->getRole () );
	}
}