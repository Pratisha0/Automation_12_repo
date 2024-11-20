package genericutility;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass  implements ITestListener {
	
@Override
public void onTestFailure(ITestResult result) {
	test.log(Status.FAIL,result.getName()+"if failed");
	TakesScreenshot ts = (TakesScreenshot) sdriver;
	test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));//to add screenshots in excel
	
	//to add screenshot in screenshots folder
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screenshots/"+result.getName()+jUtil.getSystemTime()+".png");
	try {
		org.openqa.selenium.io.FileHandler.copy(temp, dest);
	}catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
