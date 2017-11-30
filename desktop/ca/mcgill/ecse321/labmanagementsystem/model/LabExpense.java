/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-341e397-3616 modeling language!*/

package ca.mcgill.ecse321.labmanagementsystem.model;

// line 47 "../../../../../../../../ump/tmp287379/model.ump"
// line 97 "../../../../../../../../ump/tmp287379/model.ump"
public class LabExpense
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LabExpense Attributes
  private String type;
  private String dateMade;
  private int amount;

  //LabExpense Associations
  private Report report;
  private URLMS uRLMS;
  private FundingAccount fundingAccount;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LabExpense(String aType, String aDateMade, int aAmount, Report aReport, URLMS aURLMS, FundingAccount aFundingAccount)
  {
    type = aType;
    dateMade = aDateMade;
    amount = aAmount;
    boolean didAddReport = setReport(aReport);
    if (!didAddReport)
    {
      throw new RuntimeException("Unable to create labExpense due to report");
    }
    boolean didAddURLMS = setURLMS(aURLMS);
    if (!didAddURLMS)
    {
      throw new RuntimeException("Unable to create labExpense due to uRLMS");
    }
    boolean didAddFundingAccount = setFundingAccount(aFundingAccount);
    if (!didAddFundingAccount)
    {
      throw new RuntimeException("Unable to create labExpense due to fundingAccount");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
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

  public boolean setAmount(int aAmount)
  {
    boolean wasSet = false;
    amount = aAmount;
    wasSet = true;
    return wasSet;
  }

  public String getType()
  {
    return type;
  }

  public String getDateMade()
  {
    return dateMade;
  }

  public int getAmount()
  {
    return amount;
  }

  public Report getReport()
  {
    return report;
  }

  public URLMS getURLMS()
  {
    return uRLMS;
  }

  public FundingAccount getFundingAccount()
  {
    return fundingAccount;
  }

  public boolean setReport(Report aReport)
  {
    boolean wasSet = false;
    if (aReport == null)
    {
      return wasSet;
    }

    Report existingReport = report;
    report = aReport;
    if (existingReport != null && !existingReport.equals(aReport))
    {
      existingReport.removeLabExpense(this);
    }
    report.addLabExpense(this);
    wasSet = true;
    return wasSet;
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
      existingURLMS.removeLabExpense(this);
    }
    uRLMS.addLabExpense(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setFundingAccount(FundingAccount aFundingAccount)
  {
    boolean wasSet = false;
    if (aFundingAccount == null)
    {
      return wasSet;
    }

    FundingAccount existingFundingAccount = fundingAccount;
    fundingAccount = aFundingAccount;
    if (existingFundingAccount != null && !existingFundingAccount.equals(aFundingAccount))
    {
      existingFundingAccount.removeLabExpense(this);
    }
    fundingAccount.addLabExpense(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Report placeholderReport = report;
    this.report = null;
    placeholderReport.removeLabExpense(this);
    URLMS placeholderURLMS = uRLMS;
    this.uRLMS = null;
    placeholderURLMS.removeLabExpense(this);
    FundingAccount placeholderFundingAccount = fundingAccount;
    this.fundingAccount = null;
    placeholderFundingAccount.removeLabExpense(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "type" + ":" + getType()+ "," +
            "dateMade" + ":" + getDateMade()+ "," +
            "amount" + ":" + getAmount()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "report = "+(getReport()!=null?Integer.toHexString(System.identityHashCode(getReport())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "uRLMS = "+(getURLMS()!=null?Integer.toHexString(System.identityHashCode(getURLMS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "fundingAccount = "+(getFundingAccount()!=null?Integer.toHexString(System.identityHashCode(getFundingAccount())):"null");
  }
}