import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
public class Zad1Test {
    
    private WebDriver driver;
    
    private Zad1 zad1;
    
    public Zad1Test(ChromeDriver chromeDriver) {
        this.driver = chromeDriver;
        zad1 = new Zad1(driver);
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        driver.get("https://duckduckgo.com/");
    }
    
    @Test
    public void testTitlePage() {
        assertEquals("DuckDuckGo — Privacy, simplified.", zad1.getTitle());
    }
    
    @Test
    public void testSource(){
        String source = zad1.getSource();
        assertTrue(source.contains("DuckDuckGo"));
    }
    
    @Test
    public void testSearch(){
        zad1.search("Selenium");
        zad1.submitClick();
        assertEquals("Selenium at DuckDuckGo",zad1.getTitle());
    }

}
