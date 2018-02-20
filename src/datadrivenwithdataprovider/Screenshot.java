package datadrivenwithdataprovider;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	
public static WebDriver driver;
	
public static  void screenshottaken(WebDriver driver,String printpage){
	
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	
      File source=ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(source, new File("./screenshots/"+printpage+".png"));
	} 
	
	catch (IOException e) 
	{
System.out.println(e.getMessage());		
	}
	System.out.println("screenshot added");
	
}
}
