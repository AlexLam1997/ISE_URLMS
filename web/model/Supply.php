<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

class Supply
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Supply Attributes
  private $quantity;
  private $type;

  //Supply Associations
  private $uRLMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aQuantity, $aType, $aURLMS)
  {
    $this->quantity = $aQuantity;
    $this->type = $aType;
    $didAddURLMS = $this->setURLMS($aURLMS);
    if (!$didAddURLMS)
    {
      throw new Exception("Unable to create supply due to uRLMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setQuantity($aQuantity)
  {
    $wasSet = false;
    $this->quantity = $aQuantity;
    $wasSet = true;
    return $wasSet;
  }

  public function setType($aType)
  {
    $wasSet = false;
    $this->type = $aType;
    $wasSet = true;
    return $wasSet;
  }

  public function getQuantity()
  {
    return $this->quantity;
  }

  public function getType()
  {
    return $this->type;
  }

  public function getURLMS()
  {
    return $this->uRLMS;
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
      $existingURLMS->removeSupply($this);
    }
    $this->uRLMS->addSupply($this);
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
    $placeholderURLMS->removeSupply($this);
  }

}
?>