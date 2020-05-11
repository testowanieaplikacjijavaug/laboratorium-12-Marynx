import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zad2 {
    
    @FindBy(name = "username")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    
    private WebDriver webDriver;
    
    public Zad2(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    
    public void login(String username,String password, boolean isReddit){
        if(isReddit){
            webDriver.get("https://reddit.com/login");
        }else{
            webDriver.get("https://9gag.com/login");
        }
        this.username.sendKeys(username);
        this.password.sendKeys(password + Keys.ENTER);
    }
    
}
