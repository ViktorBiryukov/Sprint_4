import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckingQuestions {

    private WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void expectedFirstImportantQuestion(){
        HomePage sectionQuestions = new HomePage(driver);
        TextQuestions questions = new TextQuestions(driver);
        sectionQuestions.ScrolligToQiestion();
        String actual = sectionQuestions.getHowMuchDoesItCostAnswer();
        String expected = questions.FIRST_EXPECTATION;
        Assert.assertEquals("Text is not equal.", expected,actual);

    }

    @Test
    public void expectedSecondImportantQuestion(){
        HomePage sectionQuestions = new HomePage(driver);
        TextQuestions questions = new TextQuestions(driver);
        sectionQuestions.ScrolligToQiestion();
        String actual = sectionQuestions.getWantSeveralScootersAtOnceAnswer();
        String expected = questions.SECOND_EXPECTATION;
        Assert.assertEquals("Text is not equal.",expected,actual);

    }

    @Test
    public void expectedThirdImportantQuestion(){
        HomePage sectionQuestions = new HomePage(driver);
        TextQuestions questions = new TextQuestions(driver);
        sectionQuestions.ScrolligToQiestion();
        String actual = sectionQuestions.getHowRentalTimeCalculatedAnswer();
        String expected = questions.THIRD_EXPECTATION;
        Assert.assertEquals("Text is not equal.", expected,actual);

    }

    @Test
    public void expectedFourthImportantQuestion(){
        HomePage sectionQuestions = new HomePage(driver);
        TextQuestions questions = new TextQuestions(driver);
        sectionQuestions.ScrolligToQiestion();
        String actual = sectionQuestions.getPossibleToOrderScooterToday();
        String expected = questions.FOURTH_EXPECTATION;
        Assert.assertEquals("Text is not equal.", expected,actual);

    }

    @Test
    public void expectedFifthImportantQuestion(){
        HomePage sectionQuestions = new HomePage(driver);
        TextQuestions questions = new TextQuestions(driver);
        sectionQuestions.ScrolligToQiestion();
        String actual = sectionQuestions.getPossibleToExtendOrderOrReturnEarlier();
        String expected = questions.FIFTH_EXPECTATION;
        Assert.assertEquals("Text is not equal.", expected,actual);

    }
    @Test
    public void expectedSixthImportantQuestion(){
        HomePage sectionQuestions = new HomePage(driver);
        TextQuestions questions = new TextQuestions(driver);
        sectionQuestions.ScrolligToQiestion();
        String actual = sectionQuestions.getChargingAlongWithScooter();
        String expected = questions.SIXTH_EXPECTATION;
        Assert.assertEquals("Text is not equal.", expected,actual);

    }
    @Test
    public void expectedSeventhImportantQuestion(){
        HomePage sectionQuestions = new HomePage(driver);
        TextQuestions questions = new TextQuestions(driver);
        sectionQuestions.ScrolligToQiestion();
        String actual = sectionQuestions.getPossibleToCancelOrder();
        String expected =questions.SEVENTH_EXPECTATION;
        Assert.assertEquals("Text is not equal.", expected,actual);

    }
    @Test
    public void expectedEightImportantQuestion(){
        HomePage sectionQuestions = new HomePage(driver);
        TextQuestions questions = new TextQuestions(driver);
        sectionQuestions.ScrolligToQiestion();
        String actual = sectionQuestions.getBringScooterBeyondMKAD();
        String expected = questions.EIGHTH_EXPECTATION;
        Assert.assertEquals("Text is not equal.", expected,actual);
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

}

