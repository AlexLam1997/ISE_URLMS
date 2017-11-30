<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

class WeeklyProgressUpdate
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WeeklyProgressUpdate Associations
  private $uRLMS;
  private $staff;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aURLMS, $aStaff)
  {
    $didAddURLMS = $this->setURLMS($aURLMS);
    if (!$didAddURLMS)
    {
      throw new Exception("Unable to create weeklyProgressUpdate due to uRLMS");
    }
    $didAddStaff = $this->setStaff($aStaff);
    if (!$didAddStaff)
    {
      throw new Exception("Unable to create weeklyProgressUpdate due to staff");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getURLMS()
  {
    return $this->uRLMS;
  }

  public function getStaff()
  {
    return $this->staff;
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
      $existingURLMS->removeWeeklyProgressUpdate($this);
    }
    $this->uRLMS->addWeeklyProgressUpdate($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setStaff($aStaff)
  {
    $wasSet = false;
    if ($aStaff == null)
    {
      return $wasSet;
    }
    
    $existingStaff = $this->staff;
    $this->staff = $aStaff;
    if ($existingStaff != null && $existingStaff != $aStaff)
    {
      $existingStaff->removeWeeklyProgressUpdate($this);
    }
    $this->staff->addWeeklyProgressUpdate($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderURLMS = $this->uRLMS;
    $this->uRLMS = null;
    $placeholderURLMS->removeWeeklyProgressUpdate($this);
    $placeholderStaff = $this->staff;
    $this->staff = null;
    $placeholderStaff->removeWeeklyProgressUpdate($this);
  }

}
?>