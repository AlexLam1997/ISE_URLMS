<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

class Report
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Report Associations
  private $uRLMS;
  private $labExpenses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aURLMS)
  {
    $didAddURLMS = $this->setURLMS($aURLMS);
    if (!$didAddURLMS)
    {
      throw new Exception("Unable to create report due to uRLMS");
    }
    $this->labExpenses = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getURLMS()
  {
    return $this->uRLMS;
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

  public function setURLMS($aURLMS)
  {
    $wasSet = false;
    if ($aURLMS == null)
    {
      return $wasSet;
    }
    
    $existingURLMS = $this->uRLMS;
    $this->uRLMS = $aURLMS;
    if ($existingURLMS != null && $existingURLMS != $aURLMS)
    {
      $existingURLMS->removeReport($this);
    }
    $this->uRLMS->addReport($this);
    $wasSet = true;
    return $wasSet;
  }

  public static function minimumNumberOfLabExpenses()
  {
    return 0;
  }

  public function addLabExpenseVia($aType, $aAmount, $aURLMS)
  {
    return new LabExpense($aType, $aAmount, $this, $aURLMS);
  }

  public function addLabExpense($aLabExpense)
  {
    $wasAdded = false;
    if ($this->indexOfLabExpense($aLabExpense) !== -1) { return false; }
    $existingReport = $aLabExpense->getReport();
    $isNewReport = $existingReport != null && $this !== $existingReport;
    if ($isNewReport)
    {
      $aLabExpense->setReport($this);
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
    //Unable to remove aLabExpense, as it must always have a report
    if ($this !== $aLabExpense->getReport())
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

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderURLMS = $this->uRLMS;
    $this->uRLMS = null;
    $placeholderURLMS->removeReport($this);
    foreach ($this->labExpenses as $aLabExpense)
    {
      $aLabExpense->delete();
    }
  }

}
?>