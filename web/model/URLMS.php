<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

class URLMS
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //URLMS Associations
  private $staffs;
  private $supplies;
  private $equipment;
  private $weeklyProgressUpdates;
  private $reports;
  private $labExpenses;
  private $fundingAccounts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->staffs = array();
    $this->supplies = array();
    $this->equipment = array();
    $this->weeklyProgressUpdates = array();
    $this->reports = array();
    $this->labExpenses = array();
    $this->fundingAccounts = array();
  }

  public static function getInstance()
  {
    if(self::$theInstance == null)
    {
      self::$theInstance = new URLMS();
    }
    return self::$theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getStaff_index($index)
  {
    $aStaff = $this->staffs[$index];
    return $aStaff;
  }

  public function getStaffs()
  {
    $newStaffs = $this->staffs;
    return $newStaffs;
  }

  public function numberOfStaffs()
  {
    $number = count($this->staffs);
    return $number;
  }

  public function hasStaffs()
  {
    $has = $this->numberOfStaffs() > 0;
    return $has;
  }

  public function indexOfStaff($aStaff)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->staffs as $staff)
    {
      if ($staff->equals($aStaff))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getSupply_index($index)
  {
    $aSupply = $this->supplies[$index];
    return $aSupply;
  }

  public function getSupplies()
  {
    $newSupplies = $this->supplies;
    return $newSupplies;
  }

  public function numberOfSupplies()
  {
    $number = count($this->supplies);
    return $number;
  }

  public function hasSupplies()
  {
    $has = $this->numberOfSupplies() > 0;
    return $has;
  }

  public function indexOfSupply($aSupply)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->supplies as $supply)
    {
      if ($supply->equals($aSupply))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getEquipment_index($index)
  {
    $aEquipment = $this->equipment[$index];
    return $aEquipment;
  }

  public function getEquipment()
  {
    $newEquipment = $this->equipment;
    return $newEquipment;
  }

  public function numberOfEquipment()
  {
    $number = count($this->equipment);
    return $number;
  }

  public function hasEquipment()
  {
    $has = $this->numberOfEquipment() > 0;
    return $has;
  }

  public function indexOfEquipment($aEquipment)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->equipment as $equipment)
    {
      if ($equipment->equals($aEquipment))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getWeeklyProgressUpdate_index($index)
  {
    $aWeeklyProgressUpdate = $this->weeklyProgressUpdates[$index];
    return $aWeeklyProgressUpdate;
  }

  public function getWeeklyProgressUpdates()
  {
    $newWeeklyProgressUpdates = $this->weeklyProgressUpdates;
    return $newWeeklyProgressUpdates;
  }

  public function numberOfWeeklyProgressUpdates()
  {
    $number = count($this->weeklyProgressUpdates);
    return $number;
  }

  public function hasWeeklyProgressUpdates()
  {
    $has = $this->numberOfWeeklyProgressUpdates() > 0;
    return $has;
  }

  public function indexOfWeeklyProgressUpdate($aWeeklyProgressUpdate)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->weeklyProgressUpdates as $weeklyProgressUpdate)
    {
      if ($weeklyProgressUpdate->equals($aWeeklyProgressUpdate))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getReport_index($index)
  {
    $aReport = $this->reports[$index];
    return $aReport;
  }

  public function getReports()
  {
    $newReports = $this->reports;
    return $newReports;
  }

  public function numberOfReports()
  {
    $number = count($this->reports);
    return $number;
  }

  public function hasReports()
  {
    $has = $this->numberOfReports() > 0;
    return $has;
  }

  public function indexOfReport($aReport)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->reports as $report)
    {
      if ($report->equals($aReport))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getLabExpense_index($index)
  {
    $aLabExpense = $this->labExpenses[$index];
    return $aLabExpense;
  }

  public function getLabExpenses()
  {
    $newLabExpenses = $this->labExpenses;
    return $newLabExpenses;
  }

  public function numberOfLabExpenses()
  {
    $number = count($this->labExpenses);
    return $number;
  }

  public function hasLabExpenses()
  {
    $has = $this->numberOfLabExpenses() > 0;
    return $has;
  }

  public function indexOfLabExpense($aLabExpense)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->labExpenses as $labExpense)
    {
      if ($labExpense->equals($aLabExpense))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getFundingAccount_index($index)
  {
    $aFundingAccount = $this->fundingAccounts[$index];
    return $aFundingAccount;
  }

  public function getFundingAccounts()
  {
    $newFundingAccounts = $this->fundingAccounts;
    return $newFundingAccounts;
  }

  public function numberOfFundingAccounts()
  {
    $number = count($this->fundingAccounts);
    return $number;
  }

  public function hasFundingAccounts()
  {
    $has = $this->numberOfFundingAccounts() > 0;
    return $has;
  }

  public function indexOfFundingAccount($aFundingAccount)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->fundingAccounts as $fundingAccount)
    {
      if ($fundingAccount->equals($aFundingAccount))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfStaffs()
  {
    return 0;
  }

  public function addStaffVia($aName, $aIdNumber, $aRole)
  {
    return new Staff($aName, $aIdNumber, $aRole, $this);
  }

  public function addStaff($aStaff)
  {
    $wasAdded = false;
    if ($this->indexOfStaff($aStaff) !== -1) { return false; }
    $existingURLMS = $aStaff->getURLMS();
    $isNewURLMS = $existingURLMS != null && $this !== $existingURLMS;
    if ($isNewURLMS)
    {
      $aStaff->setURLMS($this);
    }
    else
    {
      $this->staffs[] = $aStaff;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStaff($aStaff)
  {
    $wasRemoved = false;
    //Unable to remove aStaff, as it must always have a uRLMS
    if ($this !== $aStaff->getURLMS())
    {
      unset($this->staffs[$this->indexOfStaff($aStaff)]);
      $this->staffs = array_values($this->staffs);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStaffAt($aStaff, $index)
  {  
    $wasAdded = false;
    if($this->addStaff($aStaff))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStaffs()) { $index = $this->numberOfStaffs() - 1; }
      array_splice($this->staffs, $this->indexOfStaff($aStaff), 1);
      array_splice($this->staffs, $index, 0, array($aStaff));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStaffAt($aStaff, $index)
  {
    $wasAdded = false;
    if($this->indexOfStaff($aStaff) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStaffs()) { $index = $this->numberOfStaffs() - 1; }
      array_splice($this->staffs, $this->indexOfStaff($aStaff), 1);
      array_splice($this->staffs, $index, 0, array($aStaff));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStaffAt($aStaff, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfSupplies()
  {
    return 0;
  }

  public function addSupplyVia($aQuantity, $aType)
  {
    return new Supply($aQuantity, $aType, $this);
  }

  public function addSupply($aSupply)
  {
    $wasAdded = false;
    if ($this->indexOfSupply($aSupply) !== -1) { return false; }
    $existingURLMS = $aSupply->getURLMS();
    $isNewURLMS = $existingURLMS != null && $this !== $existingURLMS;
    if ($isNewURLMS)
    {
      $aSupply->setURLMS($this);
    }
    else
    {
      $this->supplies[] = $aSupply;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeSupply($aSupply)
  {
    $wasRemoved = false;
    //Unable to remove aSupply, as it must always have a uRLMS
    if ($this !== $aSupply->getURLMS())
    {
      unset($this->supplies[$this->indexOfSupply($aSupply)]);
      $this->supplies = array_values($this->supplies);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addSupplyAt($aSupply, $index)
  {  
    $wasAdded = false;
    if($this->addSupply($aSupply))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfSupplies()) { $index = $this->numberOfSupplies() - 1; }
      array_splice($this->supplies, $this->indexOfSupply($aSupply), 1);
      array_splice($this->supplies, $index, 0, array($aSupply));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveSupplyAt($aSupply, $index)
  {
    $wasAdded = false;
    if($this->indexOfSupply($aSupply) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfSupplies()) { $index = $this->numberOfSupplies() - 1; }
      array_splice($this->supplies, $this->indexOfSupply($aSupply), 1);
      array_splice($this->supplies, $index, 0, array($aSupply));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addSupplyAt($aSupply, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfEquipment()
  {
    return 0;
  }

  public function addEquipmentVia($aQuantity, $aType)
  {
    return new Equipment($aQuantity, $aType, $this);
  }

  public function addEquipment($aEquipment)
  {
    $wasAdded = false;
    if ($this->indexOfEquipment($aEquipment) !== -1) { return false; }
    $existingURLMS = $aEquipment->getURLMS();
    $isNewURLMS = $existingURLMS != null && $this !== $existingURLMS;
    if ($isNewURLMS)
    {
      $aEquipment->setURLMS($this);
    }
    else
    {
      $this->equipment[] = $aEquipment;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeEquipment($aEquipment)
  {
    $wasRemoved = false;
    //Unable to remove aEquipment, as it must always have a uRLMS
    if ($this !== $aEquipment->getURLMS())
    {
      unset($this->equipment[$this->indexOfEquipment($aEquipment)]);
      $this->equipment = array_values($this->equipment);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addEquipmentAt($aEquipment, $index)
  {  
    $wasAdded = false;
    if($this->addEquipment($aEquipment))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfEquipment()) { $index = $this->numberOfEquipment() - 1; }
      array_splice($this->equipment, $this->indexOfEquipment($aEquipment), 1);
      array_splice($this->equipment, $index, 0, array($aEquipment));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveEquipmentAt($aEquipment, $index)
  {
    $wasAdded = false;
    if($this->indexOfEquipment($aEquipment) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfEquipment()) { $index = $this->numberOfEquipment() - 1; }
      array_splice($this->equipment, $this->indexOfEquipment($aEquipment), 1);
      array_splice($this->equipment, $index, 0, array($aEquipment));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addEquipmentAt($aEquipment, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfWeeklyProgressUpdates()
  {
    return 0;
  }

  public function addWeeklyProgressUpdateVia($aStaff)
  {
    return new WeeklyProgressUpdate($this, $aStaff);
  }

  public function addWeeklyProgressUpdate($aWeeklyProgressUpdate)
  {
    $wasAdded = false;
    if ($this->indexOfWeeklyProgressUpdate($aWeeklyProgressUpdate) !== -1) { return false; }
    $existingURLMS = $aWeeklyProgressUpdate->getURLMS();
    $isNewURLMS = $existingURLMS != null && $this !== $existingURLMS;
    if ($isNewURLMS)
    {
      $aWeeklyProgressUpdate->setURLMS($this);
    }
    else
    {
      $this->weeklyProgressUpdates[] = $aWeeklyProgressUpdate;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeWeeklyProgressUpdate($aWeeklyProgressUpdate)
  {
    $wasRemoved = false;
    //Unable to remove aWeeklyProgressUpdate, as it must always have a uRLMS
    if ($this !== $aWeeklyProgressUpdate->getURLMS())
    {
      unset($this->weeklyProgressUpdates[$this->indexOfWeeklyProgressUpdate($aWeeklyProgressUpdate)]);
      $this->weeklyProgressUpdates = array_values($this->weeklyProgressUpdates);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addWeeklyProgressUpdateAt($aWeeklyProgressUpdate, $index)
  {  
    $wasAdded = false;
    if($this->addWeeklyProgressUpdate($aWeeklyProgressUpdate))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfWeeklyProgressUpdates()) { $index = $this->numberOfWeeklyProgressUpdates() - 1; }
      array_splice($this->weeklyProgressUpdates, $this->indexOfWeeklyProgressUpdate($aWeeklyProgressUpdate), 1);
      array_splice($this->weeklyProgressUpdates, $index, 0, array($aWeeklyProgressUpdate));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveWeeklyProgressUpdateAt($aWeeklyProgressUpdate, $index)
  {
    $wasAdded = false;
    if($this->indexOfWeeklyProgressUpdate($aWeeklyProgressUpdate) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfWeeklyProgressUpdates()) { $index = $this->numberOfWeeklyProgressUpdates() - 1; }
      array_splice($this->weeklyProgressUpdates, $this->indexOfWeeklyProgressUpdate($aWeeklyProgressUpdate), 1);
      array_splice($this->weeklyProgressUpdates, $index, 0, array($aWeeklyProgressUpdate));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addWeeklyProgressUpdateAt($aWeeklyProgressUpdate, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfReports()
  {
    return 0;
  }

  public function addReportVia()
  {
    return new Report($this);
  }

  public function addReport($aReport)
  {
    $wasAdded = false;
    if ($this->indexOfReport($aReport) !== -1) { return false; }
    $existingURLMS = $aReport->getURLMS();
    $isNewURLMS = $existingURLMS != null && $this !== $existingURLMS;
    if ($isNewURLMS)
    {
      $aReport->setURLMS($this);
    }
    else
    {
      $this->reports[] = $aReport;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeReport($aReport)
  {
    $wasRemoved = false;
    //Unable to remove aReport, as it must always have a uRLMS
    if ($this !== $aReport->getURLMS())
    {
      unset($this->reports[$this->indexOfReport($aReport)]);
      $this->reports = array_values($this->reports);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addReportAt($aReport, $index)
  {  
    $wasAdded = false;
    if($this->addReport($aReport))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfReports()) { $index = $this->numberOfReports() - 1; }
      array_splice($this->reports, $this->indexOfReport($aReport), 1);
      array_splice($this->reports, $index, 0, array($aReport));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveReportAt($aReport, $index)
  {
    $wasAdded = false;
    if($this->indexOfReport($aReport) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfReports()) { $index = $this->numberOfReports() - 1; }
      array_splice($this->reports, $this->indexOfReport($aReport), 1);
      array_splice($this->reports, $index, 0, array($aReport));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addReportAt($aReport, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfLabExpenses()
  {
    return 0;
  }

  public function addLabExpenseVia($aType, $aAmount, $aReport)
  {
    return new LabExpense($aType, $aAmount, $aReport, $this);
  }

  public function addLabExpense($aLabExpense)
  {
    $wasAdded = false;
    if ($this->indexOfLabExpense($aLabExpense) !== -1) { return false; }
    $existingURLMS = $aLabExpense->getURLMS();
    $isNewURLMS = $existingURLMS != null && $this !== $existingURLMS;
    if ($isNewURLMS)
    {
      $aLabExpense->setURLMS($this);
    }
    else
    {
      $this->labExpenses[] = $aLabExpense;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeLabExpense($aLabExpense)
  {
    $wasRemoved = false;
    //Unable to remove aLabExpense, as it must always have a uRLMS
    if ($this !== $aLabExpense->getURLMS())
    {
      unset($this->labExpenses[$this->indexOfLabExpense($aLabExpense)]);
      $this->labExpenses = array_values($this->labExpenses);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addLabExpenseAt($aLabExpense, $index)
  {  
    $wasAdded = false;
    if($this->addLabExpense($aLabExpense))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfLabExpenses()) { $index = $this->numberOfLabExpenses() - 1; }
      array_splice($this->labExpenses, $this->indexOfLabExpense($aLabExpense), 1);
      array_splice($this->labExpenses, $index, 0, array($aLabExpense));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveLabExpenseAt($aLabExpense, $index)
  {
    $wasAdded = false;
    if($this->indexOfLabExpense($aLabExpense) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfLabExpenses()) { $index = $this->numberOfLabExpenses() - 1; }
      array_splice($this->labExpenses, $this->indexOfLabExpense($aLabExpense), 1);
      array_splice($this->labExpenses, $index, 0, array($aLabExpense));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addLabExpenseAt($aLabExpense, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfFundingAccounts()
  {
    return 0;
  }

  public function addFundingAccountVia()
  {
    return new FundingAccount($this);
  }

  public function addFundingAccount($aFundingAccount)
  {
    $wasAdded = false;
    if ($this->indexOfFundingAccount($aFundingAccount) !== -1) { return false; }
    $existingURLMS = $aFundingAccount->getURLMS();
    $isNewURLMS = $existingURLMS != null && $this !== $existingURLMS;
    if ($isNewURLMS)
    {
      $aFundingAccount->setURLMS($this);
    }
    else
    {
      $this->fundingAccounts[] = $aFundingAccount;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeFundingAccount($aFundingAccount)
  {
    $wasRemoved = false;
    //Unable to remove aFundingAccount, as it must always have a uRLMS
    if ($this !== $aFundingAccount->getURLMS())
    {
      unset($this->fundingAccounts[$this->indexOfFundingAccount($aFundingAccount)]);
      $this->fundingAccounts = array_values($this->fundingAccounts);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addFundingAccountAt($aFundingAccount, $index)
  {  
    $wasAdded = false;
    if($this->addFundingAccount($aFundingAccount))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfFundingAccounts()) { $index = $this->numberOfFundingAccounts() - 1; }
      array_splice($this->fundingAccounts, $this->indexOfFundingAccount($aFundingAccount), 1);
      array_splice($this->fundingAccounts, $index, 0, array($aFundingAccount));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveFundingAccountAt($aFundingAccount, $index)
  {
    $wasAdded = false;
    if($this->indexOfFundingAccount($aFundingAccount) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfFundingAccounts()) { $index = $this->numberOfFundingAccounts() - 1; }
      array_splice($this->fundingAccounts, $this->indexOfFundingAccount($aFundingAccount), 1);
      array_splice($this->fundingAccounts, $index, 0, array($aFundingAccount));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addFundingAccountAt($aFundingAccount, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    while (count($this->staffs) > 0)
    {
      $aStaff = $this->staffs[count($this->staffs) - 1];
      $aStaff->delete();
      unset($this->staffs[$this->indexOfStaff($aStaff)]);
      $this->staffs = array_values($this->staffs);
    }
    
    while (count($this->supplies) > 0)
    {
      $aSupply = $this->supplies[count($this->supplies) - 1];
      $aSupply->delete();
      unset($this->supplies[$this->indexOfSupply($aSupply)]);
      $this->supplies = array_values($this->supplies);
    }
    
    while (count($this->equipment) > 0)
    {
      $aEquipment = $this->equipment[count($this->equipment) - 1];
      $aEquipment->delete();
      unset($this->equipment[$this->indexOfEquipment($aEquipment)]);
      $this->equipment = array_values($this->equipment);
    }
    
    while (count($this->weeklyProgressUpdates) > 0)
    {
      $aWeeklyProgressUpdate = $this->weeklyProgressUpdates[count($this->weeklyProgressUpdates) - 1];
      $aWeeklyProgressUpdate->delete();
      unset($this->weeklyProgressUpdates[$this->indexOfWeeklyProgressUpdate($aWeeklyProgressUpdate)]);
      $this->weeklyProgressUpdates = array_values($this->weeklyProgressUpdates);
    }
    
    while (count($this->reports) > 0)
    {
      $aReport = $this->reports[count($this->reports) - 1];
      $aReport->delete();
      unset($this->reports[$this->indexOfReport($aReport)]);
      $this->reports = array_values($this->reports);
    }
    
    while (count($this->labExpenses) > 0)
    {
      $aLabExpense = $this->labExpenses[count($this->labExpenses) - 1];
      $aLabExpense->delete();
      unset($this->labExpenses[$this->indexOfLabExpense($aLabExpense)]);
      $this->labExpenses = array_values($this->labExpenses);
    }
    
    while (count($this->fundingAccounts) > 0)
    {
      $aFundingAccount = $this->fundingAccounts[count($this->fundingAccounts) - 1];
      $aFundingAccount->delete();
      unset($this->fundingAccounts[$this->indexOfFundingAccount($aFundingAccount)]);
      $this->fundingAccounts = array_values($this->fundingAccounts);
    }
    
  }

}
?>