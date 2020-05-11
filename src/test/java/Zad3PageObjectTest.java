import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumExtension.class)
public class Zad3PageObjectTest {
    
    private String title="Selenium";
    private WebDriver driver;
    
    private Zad3PageObject zad3;
    
    @BeforeEach
    public void setup(ChromeDriver chromeDriver) {
        this.driver = chromeDriver;
        zad3 = new Zad3PageObject(driver);
    }
    
    @Test
    public void searchBing() throws Exception {
        zad3.search("https://www.bing.com/",title);
        boolean result=zad3.assertTitle(title);
        assertTrue(result);
    }
    
    @Test
    public void searchDuckDuckGo() throws Exception {
        zad3.search("https://duckduckgo.com/",title);
        boolean result=zad3.assertTitle(title);
        assertTrue(result);
    }
}
