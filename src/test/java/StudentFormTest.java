import Models.Student;
import org.testng.annotations.Test;

public class StudentFormTest extends TestBase{
    @Test
    public void positiveRegistration(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Student student= Student.builder()
                .name("Vasya")
                .lastname("Pupkin")
                .email("dnskldn"+ i + "@lka.jkd")
                .mobile("0536095333")
                //.dateOfBirth("10 Aug 2010")
                .subject("Arts")
                .currentAddress("Netania")
                .state("Haryana")
                .city("Karnal")
                .build();

        app.getStudent().openRegistrationForm();
        app.getStudent().fillStudentForm(student);

    }
}
