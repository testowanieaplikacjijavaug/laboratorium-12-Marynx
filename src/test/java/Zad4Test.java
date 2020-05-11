import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Zad4Test {
    
    private WebDriver driver;
    
    private Zad4 zad4;
    
    private String login="test@test.pl";
    private String password="test123";
    
    
    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        zad4 = new Zad4(driver);
        zad4.signUp(login,password);
    }
    
    @Test
    public void addNotValidFirstAndLastNameAddress(){
        zad4.login(login,password);
        zad4.goToAddresses();
        zad4.goToNewAddress();
        zad4.addNewAddress("","","","12-123","Test");
        assertTrue(zad4.getErrors());
    }
    
    @Test
    public void addNotValidFirstNameAddress(){
        zad4.login(login,password);
        zad4.goToAddresses();
        zad4.goToNewAddress();
        zad4.addNewAddress("","Test","","12-123","Test");
        assertTrue(zad4.getErrors());
    }
    
    
    @Test
    public void addNotValidAddress(){
        zad4.login(login,password);
        zad4.goToAddresses();
        zad4.goToNewAddress();
        zad4.addNewAddress("","","","","Test");
        assertTrue(zad4.getErrors());
    }
    
    @Test
    public void addNotValidAddress1(){
        zad4.login(login,password);
        zad4.goToAddresses();
        zad4.goToNewAddress();
        zad4.addNewAddress("","","","","");
        assertTrue(zad4.getErrors());
    }
    
    @Test
    public void addValidAddress(){
        zad4.login(login,password);
        zad4.goToAddresses();
        zad4.goToNewAddress();
        zad4.addNewAddress("afss","Test","adsa","12-123","Test");
        assertTrue(zad4.getSuccess());
    }
    
    
    @Test
    public void addValidAddress1(){
        zad4.login(login,password);
        zad4.goToAddresses();
        int sizeBefore=zad4.getAddressesCount();
        zad4.goToNewAddress();
        zad4.addNewAddress("afss","Test","adsa","12-123","Test");
        zad4.goToAddresses();
        int sizeAfter=zad4.getAddressesCount();
        assertEquals(sizeBefore+1,sizeAfter);
    }
    
}
