<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

class FundingAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FundingAccount Associations
  private $uRLMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aURLMS)
  {
    $didAddURLMS = $this->setURLMS($aURLMS);
    if (!$didAddURLMS)
    {
      throw new Exception("Unable to create fundingAccount due to uRLMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

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
      $existingURLMS->removeFundingAccount($this);
    }
    $this->uRLMS->addFundingAccount($this);
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
    $placeholderURLMS->removeFundingAccount($this);
  }

}
?>