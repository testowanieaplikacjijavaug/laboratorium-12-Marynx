import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zad3 {
    
    private WebElement q;
    public WebDriver driver;
    
    public Zad3(WebDriver driver){
        this.driver = driver;
    }
    
    public void search(String link,String text) throws Exception{
        driver.get(link);
        q.sendKeys(text);
        q.submit();
    }
    
    public boolean assertTitle(String text) throws Exception{
        Boolean result = driver.getTitle().contains(text);
        return(result);
    }
    
}
