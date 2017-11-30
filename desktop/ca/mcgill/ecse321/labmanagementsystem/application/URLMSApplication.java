package ca.mcgill.ecse321.labmanagementsystem.application;

import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.persistence.PersistenceXStream;
import ca.mcgill.ecse321.labmanagementsystem.view.*;

public class URLMSApplication {
	private static String fileName = "output/urlms.xml";
	
	public static void main(String[] args) {
		final URLMS urlms = PersistenceXStream.prepareToSave(fileName);
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DirectorMainPage(urlms);
				DirectorMainPage.f.setVisible(true);
			}
	});

}
	
}
