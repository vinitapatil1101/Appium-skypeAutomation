package dataProvider_Component;

import mobileLib.MobileConfigReader;
import mobileLib.MobileExcelDataConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
/**
 * @author Vinita Patil
 */
public class Dataprovider_Login {
	
	@DataProvider(name="LoginData")
	public static Iterator<Object[]> getAddLocdata() throws IOException
	{
		List<Object[]> Obj = flagrowCount("loginDetails");
	//	System.out.println("The object is "+Obj.iterator());
		return Obj.iterator();
	}
	
	public static List<Object[]> flagrowCount(String Scriptname) throws IOException
	{
		MobileConfigReader MobileConfigRead = new MobileConfigReader();
		MobileExcelDataConfig LoginDataSheet = new MobileExcelDataConfig(MobileConfigRead.LoginInputData(), "LoginData");

		int RowCount = LoginDataSheet.getRowcount();
		System.out.println("The number of rows is "+RowCount);
		int Colcount = LoginDataSheet.getColumncount(0);
		System.out.println("The number of columns is "+Colcount);

		List<Object[]> arrlist_Cart= new ArrayList<Object[]>();

				for(int irow=1;irow<=RowCount;irow++)
				{
					String Execute_Flag = LoginDataSheet.readValue(irow, "ExecuteFlag");
					String Script_name =LoginDataSheet.readValue(irow, "Scriptname"); 

					if((Execute_Flag.equalsIgnoreCase("Y")) && (Script_name.equalsIgnoreCase(Scriptname)))
					{
						Map<String, String> dcMap= new HashMap<String, String>();

						for(int jCol=0;jCol<Colcount;jCol++)
						{
							String Key = LoginDataSheet.getData( 0, jCol);
							String Value = LoginDataSheet.getData(irow, jCol);

							dcMap.put(Key, Value);
							
						}//col for loop
						System.out.println("The map is "+ dcMap);
						Object[] x=new Object[1];
						x[0]=dcMap;
						arrlist_Cart.add(x);

					}//end of if condition	

				}//end of row for loop
				System.out.println("The arrlist_cart for return is "+arrlist_Cart);
				return arrlist_Cart;
  }
}
