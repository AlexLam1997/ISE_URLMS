<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

class LabExpense
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LabExpense Attributes
  private $type;
  private $amount;

  //LabExpense Associations
  private $report;
  private $uRLMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aType, $aAmount, $aReport, $aURLMS)
  {
    $this->type = $aType;
    $this->amount = $aAmount;
    $didAddReport = $this->setReport($aReport);
    if (!$didAddReport)
    {
      throw new Exception("Unable to create labExpense due to report");
    }
    $didAddURLMS = $this->setURLMS($aURLMS);
    if (!$didAddURLMS)
    {
      throw new Exception("Unable to create labExpense due to uRLMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setType($aType)
  {
    $wasSet = false;
    $this->type = $aType;
    $wasSet = true;
    return $wasSet;
  }

  public function setAmount($aAmount)
  {
    $wasSet = false;
    $this->amount = $aAmount;
    $wasSet = true;
    return $wasSet;
  }

  public function getType()
  {
    return $this->type;
  }

  public function getAmount()
  {
    return $this->amount;
  }

  public function getReport()
  {
    return $this->report;
  }

  public function getURLMS()
  {
    return $this->uRLMS;
  }

  public function setReport($aReport)
  {
    $wasSet = false;
    if ($aReport == null)
    {
      return $wasSet;
    }
    
    $existingReport = $this->report;
    $this->report = $aReport;
    if ($existingReport != null && $existingReport != $aReport)
    {
      $existingReport->removeLabExpense($this);
    }
    $this->report->addLabExpense($this);
    $wasSet = true;
    return $wasSet;
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
      $existingURLMS->removeLabExpense($this);
    }
    $this->uRLMS->addLabExpense($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderReport = $this->report;
    $this->report = null;
    $placeholderReport->removeLabExpense($this);
    $placeholderURLMS = $this->uRLMS;
    $this->uRLMS = null;
    $placeholderURLMS->removeLabExpense($this);
  }

}
?>