import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zad1 {
    
    @FindBy(id = "search_form_input_homepage")
    private WebElement searchMe;
    @FindBy(id = "search_button_homepage")
    private WebElement submitMe;
    private WebDriver webDriver;
    
    public Zad1(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    
    public Zad1 search(String keys) {
        searchMe.sendKeys(keys);
        return this;
    }
    
    public Zad1 submitClick() {
        submitMe.click();
        return this;
    }
    
    public String getTitle() {
        return webDriver.getTitle();
    }
    
    public String getSource() {
        return webDriver.getPageSource();
    }
    
}
