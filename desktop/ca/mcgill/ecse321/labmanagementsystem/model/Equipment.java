/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-341e397-3616 modeling language!*/

package ca.mcgill.ecse321.labmanagementsystem.model;

// line 25 "../../../../../../../../ump/tmp287379/model.ump"
// line 80 "../../../../../../../../ump/tmp287379/model.ump"
public class Equipment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Equipment Attributes
  private int quantity;
  private String type;

  //Equipment Associations
  private URLMS uRLMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Equipment(int aQuantity, String aType, URLMS aURLMS)
  {
    quantity = aQuantity;
    type = aType;
    boolean didAddURLMS = setURLMS(aURLMS);
    if (!didAddURLMS)
    {
      throw new RuntimeException("Unable to create equipment due to uRLMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public String getType()
  {
    return type;
  }

  public URLMS getURLMS()
  {
    return uRLMS;
  }

  public boolean setURLMS(URLMS aURLMS)
  {
    boolean wasSet = false;
    if (aURLMS == null)
    {
      return wasSet;
    }

    URLMS existingURLMS = uRLMS;
    uRLMS = aURLMS;
    if (existingURLMS != null && !existingURLMS.equals(aURLMS))
    {
      existingURLMS.removeEquipment(this);
    }
    uRLMS.addEquipment(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    URLMS placeholderURLMS = uRLMS;
    this.uRLMS = null;
    placeholderURLMS.removeEquipment(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "quantity" + ":" + getQuantity()+ "," +
            "type" + ":" + getType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "uRLMS = "+(getURLMS()!=null?Integer.toHexString(System.identityHashCode(getURLMS())):"null");
  }
}