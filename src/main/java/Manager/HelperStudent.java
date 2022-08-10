package Manager;

import Models.Student;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperStudent extends HelperBase{
    public HelperStudent(WebDriver wd) {
        super(wd);
    }

    public void selectItemForm() {
        if(isElementPresent(By.id("adplus-anchor"))){
            hideAds();
        }
        click(By.xpath("//div[@class='category-cards']/div[2]"));


    }
public void selectPracticeForm(){
    click(By.xpath("//span[.='Practice Form']"));
}
public void uploadPicture(){
wd.findElement(By.id("uploadPicture")).sendKeys("/Users/valeriiastrakovskaya/Documents/GitHub/DemoQA_13/kia_black.jpg");


}
public void submit(){
click(By.xpath("//div[contains(@class,'css-yk16xz-control')]//div[contains(@class,'css-tlfecz-indicatorContainer')]//*[name()='svg']"));
        click(By.id("submit"));
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
        String os=System.getProperty("os.name");
        System.out.println(os);
        if(isFormPresent()){
type(By.id("firstName"),student.getName());
type(By.id("lastName"),student.getLastname());
type(By.id("userEmail"),student.getEmail());
selectGender(student.getGender());
type(By.id("userNumber"),student.getMobile());
typeBDay(student.getDateOfBirth());
typeSubject(student.getSubject());
selectHobby(student.getHobbies());
type(By.id("currentAddress"),student.getCurrentAddress());
typeState(student.getState());
            typeCity(student.getCity());
//type(By.id("react-select-3-input"),student.getState());
//type(By.id("react-select-4-input"),student.getCity());

        }


    }

    private void selectHobby(String hobbies) {
        JavascriptExecutor js=(JavascriptExecutor) wd;
        if(hobbies.equals("Sports")){
            js.executeScript("document.querySelector('#hobbies-checkbox-1').click()");

        }else if(hobbies.equals("Reading")){
            js.executeScript("document.querySelector('#hobbies-checkbox-2').click()");
        }else{
            js.executeScript("document.querySelector('#hobbies-checkbox-3').click()");
        }

    }


//    private void typeSubject2(String subject) {
//        click(By.id("subjectsInput"));
//        String  [] all =subject.split(",");
//        for (String s:all){
//
//            // String locator = "//div[text()='"+s+"']";
//            String  locator2 =  String.format("//div[text()='%s']",s);
//            click(By.xpath(locator2));
//        }
//    }


    //    public void typeState(String state){
//        WebElement State =wd.findElement(By.cssSelector("div[id='state'] div[class=' css-tlfecz-indicatorContainer']"));
//        State.click();
//        State.sendKeys(state);
//        State.sendKeys(Keys.ENTER);
//
//    }
    public void typeState(String state) {
        click(By.xpath("//div[@id='state']//div[contains(@class,'css-1wy0on6')]"));
        switch (state) {
            case "NCR":
                click(By.id("react-select-3-option-0"));
                break;
            case "Uttar Pradesh":
                click(By.id("react-select-3-option-1"));
                break;
            case "Haryana":
                click(By.id("react-select-3-option-2"));
                break;
            case "Rajasthan":
                click(By.id("react-select-3-option-3"));
                break;
        }
    }
        public void typeCity(String city) {
            click(By.xpath("//div[contains(text(),'Select City')]"));
            switch (city) {
                case "Karnal":
                    click(By.id("react-select-4-option-0"));
                    break;
                case "Panipat":
                    click(By.id("react-select-4-option-1"));
                    break;
                case "Delhi":
                    click(By.id("react-select-4-option-0"));
                    break;
                case "Gurgaon":
                    click(By.id("react-select-4-option-1"));
                    break;
                case "Noida":
                    click(By.id("react-select-4-option-2"));
                    break;
            }
        }
            public void typeSubject(String subject){
        WebElement S =wd.findElement(By.id("subjectsInput"));
        S.click();
        S.sendKeys(subject);
        S.sendKeys(Keys.ENTER);
        pause(500);
    }





    public void typeBDay(String birthday){
        WebElement Bday =wd.findElement(By.id("dateOfBirthInput"));
        Bday.click();
        String os=System.getProperty("os.name");
        System.out.println(os);
        if(os.startsWith("Mac")){
           Bday.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        }else{
            Bday.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        }
        Bday.sendKeys(birthday);
        Bday.sendKeys(Keys.ENTER);

    }
    public void selectGender(String gender){
        if(gender.equals("Male")){
            click(By.xpath("//label[@for='gender-radio-1']"));

        }else if(gender.equals("Female")){
            click(By.xpath("//label[@for='gender-radio-2']"));
        }else{
            click(By.xpath("//label[@for='gender-radio-3']"));
        }

    }
}
