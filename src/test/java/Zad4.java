import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Zad4 {
    
    private WebDriver driver;
    
    @FindBy(xpath = "//*[@id=\"clearance\"]/div/div/form/div[4]/a")
    private WebElement signIn;
    
    @FindBy(xpath = "/html/body/div/div[1]")
    private WebElement error;
    
    @FindBy(id = "sign-in")
    private WebElement loginPage;
    
    @FindBy(id = "session_email")
    private WebElement sessionEmail;
    
    @FindBy(id = "session_password")
    private WebElement sessionPassword;
    
    @FindBy(id = "user_email")
    private WebElement user;
    
    @FindBy(id = "user_password")
    private WebElement password;
    
    @FindBy(name = "commit")
    private WebElement commit;
    
    @FindBy(xpath = "//*[@id=\"navbar\"]/div[1]/a[2]")
    private WebElement addresses;
    
    @FindBy(xpath = "/html/body/div/a")
    private WebElement newAddress;
    
    @FindAll(@FindBy(xpath = "//input[@type='text']"))
    List<WebElement> input;
    
    @FindAll(@FindBy(xpath = "//tbody/tr"))
    List<WebElement> allAddresses;
    
    @FindBy(xpath = "/html/body/div/div[1]")
    private WebElement success;
    
    
    @FindBy(id= "error_explanation")
    private WebElement errors;
    
    public Zad4(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.driver.get("http://a.testaddressbook.com/");
    }
    
    public void login(String username, String password) {
        this.driver.get("http://a.testaddressbook.com/sign_in");
        this.sessionEmail.sendKeys(username);
        this.sessionPassword.sendKeys(password + Keys.ENTER);
    }
    
    public void signUp(String username, String password) {
        this.driver.get("http://a.testaddressbook.com/sign_up");
        this.user.sendKeys(username);
        this.password.sendKeys(password + Keys.ENTER);
    }
    
    public String getError() {
        return this.error.getText();
    }
    
    public void goToAddresses() {
        driver.get("http://a.testaddressbook.com/addresses");
    }
    
    public void goToNewAddress() {
        driver.get("http://a.testaddressbook.com/addresses/new");
    }
    
    public void addNewAddress(String firstName, String lastName, String address1, String zipCode, String city) {
        input.get(0).sendKeys(firstName);
        input.get(1).sendKeys(lastName);
        input.get(2).sendKeys(address1);
        input.get(4).sendKeys(city);
        input.get(5).sendKeys(zipCode);
        commit.click();
    }

    public boolean getErrors(){
       return errors.getText().contains("error");
    }
    
    public boolean getSuccess(){
        return success.getText().contains("created");
    }
    
    public int getAddressesCount(){
        return allAddresses.size();
    }
    
}
