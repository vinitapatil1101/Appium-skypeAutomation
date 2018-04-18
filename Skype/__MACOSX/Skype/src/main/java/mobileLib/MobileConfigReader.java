package mobileLib;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/**
 * @author Vinita Patil
 */
public class MobileConfigReader {
	Properties pro;
	public MobileConfigReader(){
		
		try {
			File src = new File ("src/mobileProperties/MobileConfig.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
}	
	
	public String LoginInputData()
	{
		return pro.getProperty("LoginData");
	}
	
	public String LoginReport()
	{
		return pro.getProperty("LoginReport");
	}
	


}

