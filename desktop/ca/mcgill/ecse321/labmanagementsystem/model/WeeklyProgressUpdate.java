/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-341e397-3616 modeling language!*/

package ca.mcgill.ecse321.labmanagementsystem.model;

// line 62 "../../../../../../../../ump/tmp287379/model.ump"
// line 113 "../../../../../../../../ump/tmp287379/model.ump"
public class WeeklyProgressUpdate
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WeeklyProgressUpdate Attributes
  private String label;
  private String dateMade;
  private String progressUpdate;

  //WeeklyProgressUpdate Associations
  private URLMS uRLMS;
  private Staff staff;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WeeklyProgressUpdate(String aLabel, String aDateMade, String aProgressUpdate, URLMS aURLMS, Staff aStaff)
  {
    label = aLabel;
    dateMade = aDateMade;
    progressUpdate = aProgressUpdate;
    boolean didAddURLMS = setURLMS(aURLMS);
    if (!didAddURLMS)
    {
      throw new RuntimeException("Unable to create weeklyProgressUpdate due to uRLMS");
    }
    boolean didAddStaff = setStaff(aStaff);
    if (!didAddStaff)
    {
      throw new RuntimeException("Unable to create weeklyProgressUpdate due to staff");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLabel(String aLabel)
  {
    boolean wasSet = false;
    label = aLabel;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateMade(String aDateMade)
  {
    boolean wasSet = false;
    dateMade = aDateMade;
    wasSet = true;
    return wasSet;
  }

  public boolean setProgressUpdate(String aProgressUpdate)
  {
    boolean wasSet = false;
    progressUpdate = aProgressUpdate;
    wasSet = true;
    return wasSet;
  }

  public String getLabel()
  {
    return label;
  }

  public String getDateMade()
  {
    return dateMade;
  }

  public String getProgressUpdate()
  {
    return progressUpdate;
  }

  public URLMS getURLMS()
  {
    return uRLMS;
  }

  public Staff getStaff()
  {
    return staff;
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
      existingURLMS.removeWeeklyProgressUpdate(this);
    }
    uRLMS.addWeeklyProgressUpdate(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setStaff(Staff aStaff)
  {
    boolean wasSet = false;
    if (aStaff == null)
    {
      return wasSet;
    }

    Staff existingStaff = staff;
    staff = aStaff;
    if (existingStaff != null && !existingStaff.equals(aStaff))
    {
      existingStaff.removeWeeklyProgressUpdate(this);
    }
    staff.addWeeklyProgressUpdate(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    URLMS placeholderURLMS = uRLMS;
    this.uRLMS = null;
    placeholderURLMS.removeWeeklyProgressUpdate(this);
    Staff placeholderStaff = staff;
    this.staff = null;
    placeholderStaff.removeWeeklyProgressUpdate(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "label" + ":" + getLabel()+ "," +
            "dateMade" + ":" + getDateMade()+ "," +
            "progressUpdate" + ":" + getProgressUpdate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "uRLMS = "+(getURLMS()!=null?Integer.toHexString(System.identityHashCode(getURLMS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "staff = "+(getStaff()!=null?Integer.toHexString(System.identityHashCode(getStaff())):"null");
  }
}