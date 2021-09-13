package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class SeleniumBase {

//	 @DataProvider(name="Login Data")
//	  public String[][] loginDataProvider()
//	  {
//		  String[][] loginData= {  //Main array defines how many time same flow should iterate
//				  					{"Admin","admin123"}, //valid   //Child array defines the no of parameters taken by dataprovide method
//				  					{"Admin","admin"}, //invalid 
//				  					{"",""} //blank
//				  				};
//		  return loginData;
//	  }
	 
	 @DataProvider(name="CSVDataProvider")
	 public String[][] csvDataProvider() throws FileNotFoundException
	 {
		 String loginData[][]=null;
		 try
		 {
			File file=new File("C:\\Users\\jiten\\eclipse-workspace\\selenium-complete-framework-maven\\src\\main\\resources\\LoginDataCSV.csv");
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String line;	
			int maxColumn=getColCount(new BufferedReader(fr));
			int maxRow=getRowCount(new BufferedReader(fr));			
			loginData=new String[maxRow][maxColumn];
			int i=0;
			while((line=br.readLine())!=null)
			{
				String data[]=line.split(",");
				loginData[i]=data;
				i++;
			}
			
		 }	
 		catch (IOException e) 
 		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		 return loginData; 
	 }
	 
	 public int getRowCount(BufferedReader br) throws IOException
	 {
		 int rowCount=0;
		 String line;
		 while((line=br.readLine())!=null)
		 {
			rowCount++;
		 }
		 return rowCount;
	 }
	 
	 public int getColCount(BufferedReader br) throws IOException
	 {
		 int colCount=0;
		 String line;
		 while((line=br.readLine())!=null)
		 {
			String arr[]=line.split(",");
			colCount=arr.length;
			break;
		 }
		 return colCount;
	 }
}
