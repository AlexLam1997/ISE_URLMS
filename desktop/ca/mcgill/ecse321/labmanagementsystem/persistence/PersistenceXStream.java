package ca.mcgill.ecse321.labmanagementsystem.persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.thoughtworks.xstream.XStream;

import ca.mcgill.ecse321.labmanagementsystem.model.Equipment;
import ca.mcgill.ecse321.labmanagementsystem.model.FundingAccount;
import ca.mcgill.ecse321.labmanagementsystem.model.LabExpense;
import ca.mcgill.ecse321.labmanagementsystem.model.Report;
import ca.mcgill.ecse321.labmanagementsystem.model.Staff;
import ca.mcgill.ecse321.labmanagementsystem.model.Supply;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.model.WeeklyProgressUpdate;


public abstract class PersistenceXStream {

    private static XStream xstream = new XStream();
    private static String filename = "data.xml";

    public static URLMS prepareToSave(String fileName) {
        // Initialization for persistence
        URLMS lm;
        setFilename(fileName);
        setAlias("equipment", Equipment.class);
        setAlias("funding-account", FundingAccount.class);
        setAlias("lab-expense", LabExpense.class);
        setAlias("report", Report.class);
        setAlias("staff", Staff.class);
        setAlias("supply", Supply.class);
        setAlias("progress-updates", WeeklyProgressUpdate.class);

        // load model if exists, create otherwise
        File file = new File(fileName);
        if (file.exists()) {
            lm = (URLMS) loadFromXMLwithXStream();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
            lm = new URLMS();
            saveToXMLwithXStream(lm);
        }
        return lm;

    }
//return true if successfully saved, false if not. used to store full URLMS objects to xml
    public static boolean saveToXMLwithXStream(Object obj) {
        xstream.setMode(XStream.ID_REFERENCES);
        String xml = xstream.toXML(obj); 
// save to our xml file
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(xml);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Object loadFromXMLwithXStream() {
        xstream.setMode(XStream.ID_REFERENCES);
        try {
            FileReader fileReader = new FileReader(filename); // load our xml file
            Object loaded = xstream.fromXML(fileReader);
            fileReader.close();
            return loaded;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setAlias(String xmlTagName, Class<?> className) {
        xstream.alias(xmlTagName, className);
    }

    public static void setFilename(String fn) {
        filename = fn;
    }
    
    public static void  clearXML(String fileName) {
    	File file = new File(fileName);
    	file.delete();
    }

}
