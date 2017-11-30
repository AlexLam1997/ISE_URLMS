/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-341e397-3616 modeling language!*/

package ca.mcgill.ecse321.labmanagementsystem.model;
import java.util.*;

// line 4 "../../../../../../../../ump/tmp287379/model.ump"
// line 68 "../../../../../../../../ump/tmp287379/model.ump"
public class URLMS
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //URLMS Associations
  private List<Staff> staffs;
  private List<Supply> supplies;
  private List<Equipment> equipment;
  private List<WeeklyProgressUpdate> weeklyProgressUpdates;
  private List<Report> reports;
  private List<LabExpense> labExpenses;
  private FundingAccount fundingAccount;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public URLMS(FundingAccount aFundingAccount)
  {
    staffs = new ArrayList<Staff>();
    supplies = new ArrayList<Supply>();
    equipment = new ArrayList<Equipment>();
    weeklyProgressUpdates = new ArrayList<WeeklyProgressUpdate>();
    reports = new ArrayList<Report>();
    labExpenses = new ArrayList<LabExpense>();
    if (aFundingAccount == null || aFundingAccount.getURLMS() != null)
    {
      throw new RuntimeException("Unable to create URLMS due to aFundingAccount");
    }
    fundingAccount = aFundingAccount;
  }

  public URLMS(String aNameForFundingAccount, int aBalanceForFundingAccount)
  {
    staffs = new ArrayList<Staff>();
    supplies = new ArrayList<Supply>();
    equipment = new ArrayList<Equipment>();
    weeklyProgressUpdates = new ArrayList<WeeklyProgressUpdate>();
    reports = new ArrayList<Report>();
    labExpenses = new ArrayList<LabExpense>();
    fundingAccount = new FundingAccount(aNameForFundingAccount, aBalanceForFundingAccount, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Staff getStaff(int index)
  {
    Staff aStaff = staffs.get(index);
    return aStaff;
  }

  public List<Staff> getStaffs()
  {
    List<Staff> newStaffs = Collections.unmodifiableList(staffs);
    return newStaffs;
  }

  public int numberOfStaffs()
  {
    int number = staffs.size();
    return number;
  }

  public boolean hasStaffs()
  {
    boolean has = staffs.size() > 0;
    return has;
  }

  public int indexOfStaff(Staff aStaff)
  {
    int index = staffs.indexOf(aStaff);
    return index;
  }

  public Supply getSupply(int index)
  {
    Supply aSupply = supplies.get(index);
    return aSupply;
  }

  public List<Supply> getSupplies()
  {
    List<Supply> newSupplies = Collections.unmodifiableList(supplies);
    return newSupplies;
  }

  public int numberOfSupplies()
  {
    int number = supplies.size();
    return number;
  }

  public boolean hasSupplies()
  {
    boolean has = supplies.size() > 0;
    return has;
  }

  public int indexOfSupply(Supply aSupply)
  {
    int index = supplies.indexOf(aSupply);
    return index;
  }

  public Equipment getEquipment(int index)
  {
    Equipment aEquipment = equipment.get(index);
    return aEquipment;
  }

  public List<Equipment> getEquipment()
  {
    List<Equipment> newEquipment = Collections.unmodifiableList(equipment);
    return newEquipment;
  }

  public int numberOfEquipment()
  {
    int number = equipment.size();
    return number;
  }

  public boolean hasEquipment()
  {
    boolean has = equipment.size() > 0;
    return has;
  }

  public int indexOfEquipment(Equipment aEquipment)
  {
    int index = equipment.indexOf(aEquipment);
    return index;
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

  public Report getReport(int index)
  {
    Report aReport = reports.get(index);
    return aReport;
  }

  public List<Report> getReports()
  {
    List<Report> newReports = Collections.unmodifiableList(reports);
    return newReports;
  }

  public int numberOfReports()
  {
    int number = reports.size();
    return number;
  }

  public boolean hasReports()
  {
    boolean has = reports.size() > 0;
    return has;
  }

  public int indexOfReport(Report aReport)
  {
    int index = reports.indexOf(aReport);
    return index;
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

  public FundingAccount getFundingAccount()
  {
    return fundingAccount;
  }

  public static int minimumNumberOfStaffs()
  {
    return 0;
  }

  public Staff addStaff(String aName, String aIdNumber, String aRole)
  {
    return new Staff(aName, aIdNumber, aRole, this);
  }

  public boolean addStaff(Staff aStaff)
  {
    boolean wasAdded = false;
    if (staffs.contains(aStaff)) { return false; }
    URLMS existingURLMS = aStaff.getURLMS();
    boolean isNewURLMS = existingURLMS != null && !this.equals(existingURLMS);
    if (isNewURLMS)
    {
      aStaff.setURLMS(this);
    }
    else
    {
      staffs.add(aStaff);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStaff(Staff aStaff)
  {
    boolean wasRemoved = false;
    //Unable to remove aStaff, as it must always have a uRLMS
    //if (!this.equals(aStaff.getURLMS()))
     //{ TODO modified by hand
      staffs.remove(aStaff);
      wasRemoved = true;
    //}
    return wasRemoved;
  }

  public boolean addStaffAt(Staff aStaff, int index)
  {  
    boolean wasAdded = false;
    if(addStaff(aStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStaffs()) { index = numberOfStaffs() - 1; }
      staffs.remove(aStaff);
      staffs.add(index, aStaff);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStaffAt(Staff aStaff, int index)
  {
    boolean wasAdded = false;
    if(staffs.contains(aStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStaffs()) { index = numberOfStaffs() - 1; }
      staffs.remove(aStaff);
      staffs.add(index, aStaff);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStaffAt(aStaff, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfSupplies()
  {
    return 0;
  }

  public Supply addSupply(int aQuantity, String aType)
  {
    return new Supply(aQuantity, aType, this);
  }

  public boolean addSupply(Supply aSupply)
  {
    boolean wasAdded = false;
    if (supplies.contains(aSupply)) { return false; }
    URLMS existingURLMS = aSupply.getURLMS();
    boolean isNewURLMS = existingURLMS != null && !this.equals(existingURLMS);
    if (isNewURLMS)
    {
      aSupply.setURLMS(this);
    }
    else
    {
      supplies.add(aSupply);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSupply(Supply aSupply)
  {
    boolean wasRemoved = false;
    //Unable to remove aSupply, as it must always have a uRLMS
    if (!this.equals(aSupply.getURLMS()))
//    if (!this.equals(aSupply.getURLMS()))
  //  { TODO changed by hand
      supplies.remove(aSupply);
      wasRemoved = true;
   // }
    return wasRemoved;
  }

  public boolean addSupplyAt(Supply aSupply, int index)
  {  
    boolean wasAdded = false;
    if(addSupply(aSupply))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSupplies()) { index = numberOfSupplies() - 1; }
      supplies.remove(aSupply);
      supplies.add(index, aSupply);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSupplyAt(Supply aSupply, int index)
  {
    boolean wasAdded = false;
    if(supplies.contains(aSupply))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSupplies()) { index = numberOfSupplies() - 1; }
      supplies.remove(aSupply);
      supplies.add(index, aSupply);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSupplyAt(aSupply, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfEquipment()
  {
    return 0;
  }

  public Equipment addEquipment(int aQuantity, String aType)
  {
    return new Equipment(aQuantity, aType, this);
  }

  public boolean addEquipment(Equipment aEquipment)
  {
    boolean wasAdded = false;
    if (equipment.contains(aEquipment)) { return false; }
    URLMS existingURLMS = aEquipment.getURLMS();
    boolean isNewURLMS = existingURLMS != null && !this.equals(existingURLMS);
    if (isNewURLMS)
    {
      aEquipment.setURLMS(this);
    }
    else
    {
      equipment.add(aEquipment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEquipment(Equipment aEquipment)
  {
    boolean wasRemoved = false;
    //Unable to remove aEquipment, as it must always have a uRLMS
    //TODO modified by hand
      equipment.remove(aEquipment);
      wasRemoved = true;
    
    return wasRemoved;
  }

  public boolean addEquipmentAt(Equipment aEquipment, int index)
  {  
    boolean wasAdded = false;
    if(addEquipment(aEquipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEquipment()) { index = numberOfEquipment() - 1; }
      equipment.remove(aEquipment);
      equipment.add(index, aEquipment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEquipmentAt(Equipment aEquipment, int index)
  {
    boolean wasAdded = false;
    if(equipment.contains(aEquipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEquipment()) { index = numberOfEquipment() - 1; }
      equipment.remove(aEquipment);
      equipment.add(index, aEquipment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEquipmentAt(aEquipment, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfWeeklyProgressUpdates()
  {
    return 0;
  }

  public WeeklyProgressUpdate addWeeklyProgressUpdate(String aLabel, String aDateMade, String aProgressUpdate, Staff aStaff)
  {
    return new WeeklyProgressUpdate(aLabel, aDateMade, aProgressUpdate, this, aStaff);
  }

  public boolean addWeeklyProgressUpdate(WeeklyProgressUpdate aWeeklyProgressUpdate)
  {
    boolean wasAdded = false;
    if (weeklyProgressUpdates.contains(aWeeklyProgressUpdate)) { return false; }
    URLMS existingURLMS = aWeeklyProgressUpdate.getURLMS();
    boolean isNewURLMS = existingURLMS != null && !this.equals(existingURLMS);
    if (isNewURLMS)
    {
      aWeeklyProgressUpdate.setURLMS(this);
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
    //Unable to remove aWeeklyProgressUpdate, as it must always have a uRLMS
//    if (!this.equals(aWeeklyProgressUpdate.getURLMS()))
//    { TODO modified by hand
      weeklyProgressUpdates.remove(aWeeklyProgressUpdate);
      wasRemoved = true;
//    }
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

  public static int minimumNumberOfReports()
  {
    return 0;
  }

  public Report addReport()
  {
    return new Report(this);
  }

  public boolean addReport(Report aReport)
  {
    boolean wasAdded = false;
    if (reports.contains(aReport)) { return false; }
    URLMS existingURLMS = aReport.getURLMS();
    boolean isNewURLMS = existingURLMS != null && !this.equals(existingURLMS);
    if (isNewURLMS)
    {
      aReport.setURLMS(this);
    }
    else
    {
      reports.add(aReport);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReport(Report aReport)
  {
    boolean wasRemoved = false;
    //Unable to remove aReport, as it must always have a uRLMS
//    if (!this.equals(aReport.getURLMS()))
//    { TODO modified by hand
      reports.remove(aReport);
      wasRemoved = true;
//    }
    return wasRemoved;
  }

  public boolean addReportAt(Report aReport, int index)
  {  
    boolean wasAdded = false;
    if(addReport(aReport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReports()) { index = numberOfReports() - 1; }
      reports.remove(aReport);
      reports.add(index, aReport);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReportAt(Report aReport, int index)
  {
    boolean wasAdded = false;
    if(reports.contains(aReport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReports()) { index = numberOfReports() - 1; }
      reports.remove(aReport);
      reports.add(index, aReport);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReportAt(aReport, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfLabExpenses()
  {
    return 0;
  }

  public LabExpense addLabExpense(String aType, String aDateMade, int aAmount, Report aReport, FundingAccount aFundingAccount)
  {
    return new LabExpense(aType, aDateMade, aAmount, aReport, this, aFundingAccount);
  }

  public boolean addLabExpense(LabExpense aLabExpense)
  {
    boolean wasAdded = false;
    if (labExpenses.contains(aLabExpense)) { return false; }
    URLMS existingURLMS = aLabExpense.getURLMS();
    boolean isNewURLMS = existingURLMS != null && !this.equals(existingURLMS);
    if (isNewURLMS)
    {
      aLabExpense.setURLMS(this);
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
    //Unable to remove aLabExpense, as it must always have a uRLMS
//    if (!this.equals(aLabExpense.getURLMS()))
//    { TODO modified by hand
      labExpenses.remove(aLabExpense);
      wasRemoved = true;
//    }
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
    while (staffs.size() > 0)
    {
      Staff aStaff = staffs.get(staffs.size() - 1);
      aStaff.delete();
      staffs.remove(aStaff);
    }
    
    while (supplies.size() > 0)
    {
      Supply aSupply = supplies.get(supplies.size() - 1);
      aSupply.delete();
      supplies.remove(aSupply);
    }
    
    while (equipment.size() > 0)
    {
      Equipment aEquipment = equipment.get(equipment.size() - 1);
      aEquipment.delete();
      equipment.remove(aEquipment);
    }
    
    while (weeklyProgressUpdates.size() > 0)
    {
      WeeklyProgressUpdate aWeeklyProgressUpdate = weeklyProgressUpdates.get(weeklyProgressUpdates.size() - 1);
      aWeeklyProgressUpdate.delete();
      weeklyProgressUpdates.remove(aWeeklyProgressUpdate);
    }
    
    while (reports.size() > 0)
    {
      Report aReport = reports.get(reports.size() - 1);
      aReport.delete();
      reports.remove(aReport);
    }
    
    while (labExpenses.size() > 0)
    {
      LabExpense aLabExpense = labExpenses.get(labExpenses.size() - 1);
      aLabExpense.delete();
      labExpenses.remove(aLabExpense);
    }
    
//  FundingAccount existingFundingAccount = fundingAccount;
    fundingAccount = null;
//    if (existingFundingAccount != null)
//    {
//      existingFundingAccount.delete();
//    }
  }

  // line 15 "../../../../../../../../ump/tmp287379/model.ump"
   public  URLMS(){
    staffs = new ArrayList<Staff>();
    supplies = new ArrayList<Supply>();
    equipment = new ArrayList<Equipment>();
    weeklyProgressUpdates = new ArrayList<WeeklyProgressUpdate>();
    reports = new ArrayList<Report>();
    labExpenses = new ArrayList<LabExpense>();
    fundingAccount = new FundingAccount(this);
  }

}