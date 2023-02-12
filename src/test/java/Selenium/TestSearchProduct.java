package Selenium;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class TestSearchProduct {

    private WebDriver driver;
    private static final String SEARCH_INPUT = "searchInput";
    JavascriptExecutor js;

    @After
    public void tearDown() {
        driver.quit();
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\programmi\\java\\ISPW_Project_22-23_JFX\\src\\test\\java\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testSearchProduct() {
        // Test name: testSpidermanAuthor
        // Step # | name | target | value | comment
        // 1 | open | /wiki/Pagina_principale |  |
        driver.get("https://it.wikipedia.org/wiki/Pagina_principale");
        // 2 | setWindowSize | 945x1012 |  |
        driver.manage().window().setSize(new Dimension(945, 1012));
        // 3 | click | id=searchInput |  |
        driver.findElement(By.id(SEARCH_INPUT)).click();
        // 4 | type | id=searchInput | uomo ragno |
        driver.findElement(By.id(SEARCH_INPUT)).sendKeys("uomo ragno");
        // 5 | sendKeys | id=searchInput | ${KEY_ENTER} |
        driver.findElement(By.id(SEARCH_INPUT)).sendKeys(Keys.ENTER);
        // 6 | runScript | window.scrollTo(0,495) |  |
        js.executeScript("window.scrollTo(0,495)");
        // 7 | assertText | linkText=Stan Lee | Stan Lee |
        assertThat(driver.findElement(By.linkText("Stan Lee")).getText(), is("Stan Lee"));
        }
}
