/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-341e397-3616 modeling language!*/

package ca.mcgill.ecse321.labmanagementsystem.model;
import java.util.*;

// line 40 "../../../../../../../../ump/tmp287379/model.ump"
// line 91 "../../../../../../../../ump/tmp287379/model.ump"
public class Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Staff Attributes
  private String name;
  private String idNumber;
  private String role;

  //Staff Associations
  private List<WeeklyProgressUpdate> weeklyProgressUpdates;
  private URLMS uRLMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Staff(String aName, String aIdNumber, String aRole, URLMS aURLMS)
  {
    name = aName;
    idNumber = aIdNumber;
    role = aRole;
    weeklyProgressUpdates = new ArrayList<WeeklyProgressUpdate>();
    boolean didAddURLMS = setURLMS(aURLMS);
    if (!didAddURLMS)
    {
      throw new RuntimeException("Unable to create staff due to uRLMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setIdNumber(String aIdNumber)
  {
    boolean wasSet = false;
    idNumber = aIdNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setRole(String aRole)
  {
    boolean wasSet = false;
    role = aRole;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getIdNumber()
  {
    return idNumber;
  }

  public String getRole()
  {
    return role;
  }

  public WeeklyProgressUpdate getWeeklyProgressUpdate(int index)
  {
    WeeklyProgressUpdate aWeeklyProgressUpdate = weeklyProgressUpdates.get(index);
    return aWeeklyProgressUpdate;
  }

  public List<WeeklyProgressUpdate> getWeeklyProgressUpdates()
  {
    List<WeeklyProgressUpdate> newWeeklyProgressUpdates = Collections.unmodifiableList(weeklyProgressUpdates);
    return newWeeklyProgressUpdates;
  }

  public int numberOfWeeklyProgressUpdates()
  {
    int number = weeklyProgressUpdates.size();
    return number;
  }

  public boolean hasWeeklyProgressUpdates()
  {
    boolean has = weeklyProgressUpdates.size() > 0;
    return has;
  }

  public int indexOfWeeklyProgressUpdate(WeeklyProgressUpdate aWeeklyProgressUpdate)
  {
    int index = weeklyProgressUpdates.indexOf(aWeeklyProgressUpdate);
    return index;
  }

  public URLMS getURLMS()
  {
    return uRLMS;
  }

  public static int minimumNumberOfWeeklyProgressUpdates()
  {
    return 0;
  }

  public WeeklyProgressUpdate addWeeklyProgressUpdate(String aLabel, String aDateMade, String aProgressUpdate, URLMS aURLMS)
  {
    return new WeeklyProgressUpdate(aLabel, aDateMade, aProgressUpdate, aURLMS, this);
  }

  public boolean addWeeklyProgressUpdate(WeeklyProgressUpdate aWeeklyProgressUpdate)
  {
    boolean wasAdded = false;
    if (weeklyProgressUpdates.contains(aWeeklyProgressUpdate)) { return false; }
    Staff existingStaff = aWeeklyProgressUpdate.getStaff();
    boolean isNewStaff = existingStaff != null && !this.equals(existingStaff);
    if (isNewStaff)
    {
      aWeeklyProgressUpdate.setStaff(this);
    }
    else
    {
      weeklyProgressUpdates.add(aWeeklyProgressUpdate);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWeeklyProgressUpdate(WeeklyProgressUpdate aWeeklyProgressUpdate)
  {
    boolean wasRemoved = false;
    //Unable to remove aWeeklyProgressUpdate, as it must always have a staff
    if (!this.equals(aWeeklyProgressUpdate.getStaff()))
    {
      weeklyProgressUpdates.remove(aWeeklyProgressUpdate);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addWeeklyProgressUpdateAt(WeeklyProgressUpdate aWeeklyProgressUpdate, int index)
  {  
    boolean wasAdded = false;
    if(addWeeklyProgressUpdate(aWeeklyProgressUpdate))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWeeklyProgressUpdates()) { index = numberOfWeeklyProgressUpdates() - 1; }
      weeklyProgressUpdates.remove(aWeeklyProgressUpdate);
      weeklyProgressUpdates.add(index, aWeeklyProgressUpdate);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWeeklyProgressUpdateAt(WeeklyProgressUpdate aWeeklyProgressUpdate, int index)
  {
    boolean wasAdded = false;
    if(weeklyProgressUpdates.contains(aWeeklyProgressUpdate))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWeeklyProgressUpdates()) { index = numberOfWeeklyProgressUpdates() - 1; }
      weeklyProgressUpdates.remove(aWeeklyProgressUpdate);
      weeklyProgressUpdates.add(index, aWeeklyProgressUpdate);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWeeklyProgressUpdateAt(aWeeklyProgressUpdate, index);
    }
    return wasAdded;
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
      existingURLMS.removeStaff(this);
    }
    uRLMS.addStaff(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=weeklyProgressUpdates.size(); i > 0; i--)
    {
      WeeklyProgressUpdate aWeeklyProgressUpdate = weeklyProgressUpdates.get(i - 1);
      aWeeklyProgressUpdate.delete();
    }
    URLMS placeholderURLMS = uRLMS;
    this.uRLMS = null;
    placeholderURLMS.removeStaff(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "idNumber" + ":" + getIdNumber()+ "," +
            "role" + ":" + getRole()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "uRLMS = "+(getURLMS()!=null?Integer.toHexString(System.identityHashCode(getURLMS())):"null");
  }
}