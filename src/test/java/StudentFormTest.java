import Models.Student;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        app.getStudent().hideFooter();
        app.getStudent().hideAds();
        app.getStudent().selectItemForm();
        app.getStudent().hideFooter();
        app.getStudent().hideAds();
        app.getStudent().selectPracticeForm();
        app.getStudent().hideFooter();
        app.getStudent().hideAds();
        app.getStudent().hideSomething();

    }
    @Test
    public void positiveRegistration(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Student student= Student.builder()
                .name("Vasya")
                .lastname("Pupkin")
                .email("dnskldn"+ i + "@lka.jkd")
                .gender("Female")
                .mobile("0536095333")
                .dateOfBirth("20 08 1990")
                .subject("Arts")
                .hobbies("Sports")
                .currentAddress("Netania")
                .state("Haryana")
                .city("Karnal")
                .build();


        app.getStudent().fillStudentForm(student);
        app.getStudent().uploadPicture();
       app.getStudent().pause(3000);
        app.getStudent().submit();

    }
}
