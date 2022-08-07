package Manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
    WebDriver wd;
    HelperStudent student;

    public void init(){
        WebDriverManager.chromedriver().setup();
        wd =  new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.navigate().to("https://demoqa.com/forms");
        student =new HelperStudent(wd);


    }

    public HelperStudent getStudent(){return student;};

    public void stop(){
        wd.quit();

    }
}
