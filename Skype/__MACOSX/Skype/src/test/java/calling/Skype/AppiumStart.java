package calling.Skype;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

public class AppiumStart {
@BeforeSuite
public void appiumStartCode() throws IOException, InterruptedException
{
	Runtime.getRuntime().exec("cmd /c start D:\\startappium.bat appium -a 127.0.0.1 -p 4723");
	Thread.sleep(7000L);
}

}
