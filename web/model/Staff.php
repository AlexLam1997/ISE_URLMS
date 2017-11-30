<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

class Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Staff Attributes
  private $name;
  private $idNumber;
  private $role;

  //Staff Associations
  private $weeklyProgressUpdates;
  private $uRLMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aIdNumber, $aRole, $aURLMS)
  {
    $this->name = $aName;
    $this->idNumber = $aIdNumber;
    $this->role = $aRole;
    $this->weeklyProgressUpdates = array();
    $didAddURLMS = $this->setURLMS($aURLMS);
    if (!$didAddURLMS)
    {
      throw new Exception("Unable to create staff due to uRLMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function setIdNumber($aIdNumber)
  {
    $wasSet = false;
    $this->idNumber = $aIdNumber;
    $wasSet = true;
    return $wasSet;
  }

  public function setRole($aRole)
  {
    $wasSet = false;
    $this->role = $aRole;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getIdNumber()
  {
    return $this->idNumber;
  }

  public function getRole()
  {
    return $this->role;
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

  public function getURLMS()
  {
    return $this->uRLMS;
  }

  public static function minimumNumberOfWeeklyProgressUpdates()
  {
    return 0;
  }

  public function addWeeklyProgressUpdateVia($aURLMS)
  {
    return new WeeklyProgressUpdate($aURLMS, $this);
  }

  public function addWeeklyProgressUpdate($aWeeklyProgressUpdate)
  {
    $wasAdded = false;
    if ($this->indexOfWeeklyProgressUpdate($aWeeklyProgressUpdate) !== -1) { return false; }
    $existingStaff = $aWeeklyProgressUpdate->getStaff();
    $isNewStaff = $existingStaff != null && $this !== $existingStaff;
    if ($isNewStaff)
    {
      $aWeeklyProgressUpdate->setStaff($this);
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
    //Unable to remove aWeeklyProgressUpdate, as it must always have a staff
    if ($this !== $aWeeklyProgressUpdate->getStaff())
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
      $existingURLMS->removeStaff($this);
    }
    $this->uRLMS->addStaff($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->weeklyProgressUpdates as $aWeeklyProgressUpdate)
    {
      $aWeeklyProgressUpdate->delete();
    }
    $placeholderURLMS = $this->uRLMS;
    $this->uRLMS = null;
    $placeholderURLMS->removeStaff($this);
  }

}
?>