/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-341e397-3616 modeling language!*/

package ca.mcgill.ecse321.labmanagementsystem.model;
import java.util.*;

// line 54 "../../../../../../../../ump/tmp287379/model.ump"
// line 103 "../../../../../../../../ump/tmp287379/model.ump"
public class Report
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Report Associations
  private URLMS uRLMS;
  private List<LabExpense> labExpenses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Report(URLMS aURLMS)
  {
    boolean didAddURLMS = setURLMS(aURLMS);
    if (!didAddURLMS)
    {
      throw new RuntimeException("Unable to create report due to uRLMS");
    }
    labExpenses = new ArrayList<LabExpense>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public URLMS getURLMS()
  {
    return uRLMS;
  }

  public LabExpense getLabExpense(int index)
  {
    LabExpense aLabExpense = labExpenses.get(index);
    return aLabExpense;
  }

  public List<LabExpense> getLabExpenses()
  {
    List<LabExpense> newLabExpenses = Collections.unmodifiableList(labExpenses);
    return newLabExpenses;
  }

  public int numberOfLabExpenses()
  {
    int number = labExpenses.size();
    return number;
  }

  public boolean hasLabExpenses()
  {
    boolean has = labExpenses.size() > 0;
    return has;
  }

  public int indexOfLabExpense(LabExpense aLabExpense)
  {
    int index = labExpenses.indexOf(aLabExpense);
    return index;
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
      existingURLMS.removeReport(this);
    }
    uRLMS.addReport(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfLabExpenses()
  {
    return 0;
  }

  public LabExpense addLabExpense(String aType, String aDateMade, int aAmount, URLMS aURLMS, FundingAccount aFundingAccount)
  {
    return new LabExpense(aType, aDateMade, aAmount, this, aURLMS, aFundingAccount);
  }

  public boolean addLabExpense(LabExpense aLabExpense)
  {
    boolean wasAdded = false;
    if (labExpenses.contains(aLabExpense)) { return false; }
    Report existingReport = aLabExpense.getReport();
    boolean isNewReport = existingReport != null && !this.equals(existingReport);
    if (isNewReport)
    {
      aLabExpense.setReport(this);
    }
    else
    {
      labExpenses.add(aLabExpense);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLabExpense(LabExpense aLabExpense)
  {
    boolean wasRemoved = false;
    //Unable to remove aLabExpense, as it must always have a report
    if (!this.equals(aLabExpense.getReport()))
    {
      labExpenses.remove(aLabExpense);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addLabExpenseAt(LabExpense aLabExpense, int index)
  {  
    boolean wasAdded = false;
    if(addLabExpense(aLabExpense))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLabExpenses()) { index = numberOfLabExpenses() - 1; }
      labExpenses.remove(aLabExpense);
      labExpenses.add(index, aLabExpense);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLabExpenseAt(LabExpense aLabExpense, int index)
  {
    boolean wasAdded = false;
    if(labExpenses.contains(aLabExpense))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLabExpenses()) { index = numberOfLabExpenses() - 1; }
      labExpenses.remove(aLabExpense);
      labExpenses.add(index, aLabExpense);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLabExpenseAt(aLabExpense, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    URLMS placeholderURLMS = uRLMS;
    this.uRLMS = null;
    placeholderURLMS.removeReport(this);
    for(int i=labExpenses.size(); i > 0; i--)
    {
      LabExpense aLabExpense = labExpenses.get(i - 1);
      aLabExpense.delete();
    }
  }

}