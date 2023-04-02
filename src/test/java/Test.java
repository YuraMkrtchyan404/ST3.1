import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class Test {
    public static final String WEBDRIVER = "webdriver.chrome.driver";
    public static final String GOOGLE_PLAY_LINK = "https://play.google.com/store/apps/details?id=com.appstation.wordly&pli=1";
    public static final String DRIVER_PATH = "src/drivers/chromedriver.exe";
    public static final String baseURL = "https://wordlegame.org/";
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty(WEBDRIVER, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @org.testng.annotations.Test
    public void statsButtonTest(){
        driver.get(baseURL);
        WebElement statsButton = driver.findElement(By.cssSelector("button mini_modal_link active"));
        statsButton.click();
        Assert.assertTrue(driver.findElement(By.id("modal_stats")).isDisplayed());
    }

    @org.testng.annotations.Test
    public void keyboardTest(){
        driver.get(baseURL);
        WebElement keyboardKey = driver.findElement(By.cssSelector("Game-keyboard-button"));
        Assert.assertFalse(keyboardKey.getText().isEmpty());
    }

    @org.testng.annotations.Test
    public void downloadAddTest(){
        driver.get(baseURL);
        WebElement xpathButton = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/a[1]"));
        String link = xpathButton.getText();
        Assert.assertEquals(link, GOOGLE_PLAY_LINK);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

