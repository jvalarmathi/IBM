package Utility;

import org.testng.annotations.DataProvider;

public class dataproviderClass {
	
	@DataProvider(name="searchprovider")
	public static Object[][] parameterfromdataprovider()
	{
		return new Object [][]
				{
			
			{"Guru","USA"},
			{"Mathi", "USA1"},
			{"Madhu","CA"}
				};
				
					}
	
	@DataProvider(name="GmailLogin")
	public static Object[][] gmail()
	{
		return new Object[][]
				{
			{"jvalar1","naksha197"},
			{"jvalar1","naksha1970"}
			
				
			};
				}
	}


