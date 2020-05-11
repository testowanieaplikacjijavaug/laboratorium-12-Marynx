import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zad3PageObject {
    
    
    @FindBy(name = "q")
    private WebElement q;
    
    private WebDriver webDriver;
    
    public Zad3PageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    
    public void search(String link,String text) throws Exception{
        webDriver.get(link);
        q.sendKeys(text);
        q.submit();
    }
    
    public boolean assertTitle(String text) throws Exception{
        Boolean result = webDriver.getTitle().contains(text);
        return(result);
    }
    
}
