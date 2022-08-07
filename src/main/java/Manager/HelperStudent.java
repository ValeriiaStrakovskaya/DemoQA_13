package Manager;

import Models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperStudent extends HelperBase{
    public HelperStudent(WebDriver wd) {
        super(wd);
    }

    public void openRegistrationForm() {
       // click(By.cssSelector("//div[@class='home-body']//div[2]//div[1]//div[3"));
        click(By.xpath("//span[.='Practice Form']"));

    }

    public void select(By locator, String option){
        new Select(wd.findElement(locator)).selectByValue(option);
    }
    public boolean isFormPresent(){
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.xpath("//h5[.='Student Registration Form']")),
                                "Student Registration Form"));
    }
    public void fillStudentForm(Student student){
        if(isFormPresent()){
type(By.id("firstName"),student.getName());
type(By.id("lastName"),student.getLastname());
type(By.id("userEmail"),student.getEmail());
type(By.id("userNumber"),student.getMobile());
type(By.id("dateOfBirthInput"),student.getDateOfBirth());
type(By.id("subjectsInput"),student.getSubject());
type(By.id("currentAddress"),student.getCurrentAddress());
select(By.id("react-select-3-input"),student.getState());
select(By.id("react-select-4-input"),student.getCity());

        }


    }
}
