package calling.Skype;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumStart {
	
	/*AppiumDriverLocalService appiumService;
    String appiumServiceUrl;*/
    
    @BeforeSuite
    public void appiumStartCode() throws IOException, InterruptedException
    {
	     /*
     * 1. Install Node.js
      *  MAC
     * 2. https://github.com/isonic1/appium-workshop/blob/master/Appium%20Mac%20Installation%20Instructions.md
     * 3. npm install -g appium
     * 4 APpium -V
     * 5 Appium
     */
    
     // starting the Appium server code

     AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
     service.start();
     // your test scripts logic...
     service.stop();
}

}
