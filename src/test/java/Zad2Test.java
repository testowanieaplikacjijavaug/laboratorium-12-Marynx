import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Zad2Test {
    
    private WebDriver driver;
    
    private Zad2 zad2;
    
    public Zad2Test() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        zad2 = new Zad2(driver);
    }
    
    
    @Test
    public void testLoginReddit(){
        zad2.login("test","test",true);
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/form/div/fieldset[2]/div")));
        boolean result=wait.until(ExpectedConditions.textToBePresentInElement(element,"Incorrect password"));
        assertTrue(result);
    }
    
    
    //lokalnie przechodzi
    @Test
    public void testLogin9gag(){
        zad2.login("test","test",false);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login-email\"]/div[2]/p")));
        WebElement e=driver.findElement(By.xpath("//*[@id=\"login-email\"]/div[2]/p"));
        assertEquals("Your email or password were incorrect.", e.getText());
    }
    
    
    
}
