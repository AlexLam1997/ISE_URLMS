package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.TestStaffController;
import tests.TestPersistence;

@RunWith(Suite.class)
@SuiteClasses({ TestStaffController.class, TestPersistence.class,TestEquipmentController.class, TestExpenseController.class,TestSupplyController.class})
public class AllTests { 

}
