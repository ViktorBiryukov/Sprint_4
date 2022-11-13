import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.startsWith;

public class TestOrder {
    private WebDriver driver;

    @Before
    public void setPropAndStartBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void TestWithUpperOrderButton() {
        OrderPage orderInformationPage = new OrderPage(driver);
        HomePage sectionQuestions = new HomePage(driver);
        sectionQuestions.Open();
        sectionQuestions.clickUpperOrderButton();
        orderInformationPage.creatingAnOrder(
                "Виктор",  "Бирюков",  "Москва",  "Тушинская",
                "+79998887766",  "01.01.2001", "сутки",  "чёрный жемчуг",
                "тест1");
        String expected = "Заказ оформлен";
        String actual = orderInformationPage.getNotificationOfOrderCreation();
        Assert.assertThat("The order creation notification has not appeared or the order has not been created", actual, startsWith(expected));
    }
    @Test
    public void TestWithLowerOrderButton() {
        OrderPage orderInformationPage = new OrderPage(driver);
        HomePage sectionQuestions = new HomePage(driver);
        sectionQuestions.Open();
        sectionQuestions.clickLowerOrderButton();
        orderInformationPage.creatingAnOrder(
                "Илья",  "Гребенюк",  "Санкт-Петеобург", "Войковская",
                "+79996667788", "12.12.2022", "двое суток",  "серая безысходность",
                "тест2");
        String expected = "Заказ оформлен";
        String actual = orderInformationPage.getNotificationOfOrderCreation();
        Assert.assertThat("The order creation notification has not appeared or the order has not been created", actual, startsWith(expected));
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
