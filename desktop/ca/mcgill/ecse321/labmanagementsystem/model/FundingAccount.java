/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-341e397-3616 modeling language!*/

package ca.mcgill.ecse321.labmanagementsystem.model;
import java.util.*;

// line 30 "../../../../../../../../ump/tmp287379/model.ump"
// line 85 "../../../../../../../../ump/tmp287379/model.ump"
public class FundingAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FundingAccount Attributes
  private String name;
  private int balance;

  //FundingAccount Associations
  private List<LabExpense> labExpenses;
  private URLMS uRLMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FundingAccount(String aName, int aBalance, URLMS aURLMS)
  {
    name = aName;
    balance = aBalance;
    labExpenses = new ArrayList<LabExpense>();
    if (aURLMS == null || aURLMS.getFundingAccount() != null)
    {
      throw new RuntimeException("Unable to create FundingAccount due to aURLMS");
    }
    uRLMS = aURLMS;
  }

  public FundingAccount(String aName, int aBalance)
  {
    name = aName;
    balance = aBalance;
    labExpenses = new ArrayList<LabExpense>();
    uRLMS = new URLMS(this);
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

  public boolean setBalance(int aBalance)
  {
    boolean wasSet = false;
    balance = aBalance;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getBalance()
  {
    return balance;
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

  public URLMS getURLMS()
  {
    return uRLMS;
  }

  public static int minimumNumberOfLabExpenses()
  {
    return 0;
  }

  public LabExpense addLabExpense(String aType, String aDateMade, int aAmount, Report aReport, URLMS aURLMS)
  {
    return new LabExpense(aType, aDateMade, aAmount, aReport, aURLMS, this);
  }

  public boolean addLabExpense(LabExpense aLabExpense)
  {
    boolean wasAdded = false;
    if (labExpenses.contains(aLabExpense)) { return false; }
    FundingAccount existingFundingAccount = aLabExpense.getFundingAccount();
    boolean isNewFundingAccount = existingFundingAccount != null && !this.equals(existingFundingAccount);
    if (isNewFundingAccount)
    {
      aLabExpense.setFundingAccount(this);
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
    //Unable to remove aLabExpense, as it must always have a fundingAccount
    if (!this.equals(aLabExpense.getFundingAccount()))
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

  public void delete() {
	  
    for(int i=labExpenses.size(); i > 0; i--)
    {
      LabExpense aLabExpense = labExpenses.get(i - 1);
      aLabExpense.delete();
    }
    URLMS existingURLMS = uRLMS;
    uRLMS = null;
    if (existingURLMS != null)
    {
      existingURLMS.delete();
    }
  }

  // line 36 "../../../../../../../../ump/tmp287379/model.ump"
   public  FundingAccount(URLMS urlms){
    this.uRLMS = urlms;
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "balance" + ":" + getBalance()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "uRLMS = "+(getURLMS()!=null?Integer.toHexString(System.identityHashCode(getURLMS())):"null");
  }
}