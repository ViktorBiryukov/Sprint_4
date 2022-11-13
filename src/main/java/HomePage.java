import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    private final static String URL = "https://qa-scooter.praktikum-services.ru/";

    //Кнопки "Заказать"
    private By orderButtonAbowe = By.cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g");
    private By orderButtonBelow = By.cssSelector("div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button");

    //Вопросы раздела "Важные вопросы"
    //Сколько это стоит? И как оплатить?
    private By howMuchDoesItCost = By.id("accordion__heading-0");
    private By howMuchDoesItCostText = By.id("accordion__panel-0");
    //Хочу сразу несколько самокатов! Так можно?
    private By wantSeveralScootersAtOnce = By.id("accordion__heading-1");
    private By wantSeveralScootersAtOnceText = By.id("accordion__panel-1");
    //Как рассчитывается время аренды?
    private By howRentalTimeCalculated = By.id("accordion__heading-2");
    private By howRentalTimeCalculatedText = By.id("accordion__panel-2");
    //Можно ли заказать самокат прямо на сегодня?
    private By possibleToOrderScooterToday = By.id("accordion__heading-3");
    private By possibleToOrderScooterTodayText = By.id("accordion__panel-3");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private By possibleToExtendOrderOrReturnEarlier = By.id("accordion__heading-4");
    private By possibleToExtendOrderOrReturnEarlierText = By.id("accordion__panel-4");
    //Вы привозите зарядку вместе с самокатом?
    private By chargingAlongWithScooter = By.id("accordion__heading-5");
    private By chargingAlongWithScooterText = By.id("accordion__panel-5");
    //Можно ли отменить заказ?
    private By possibleToCancelOrder = By.id("accordion__heading-6");
    private By possibleToCancelOrderText = By.id("accordion__panel-6");
    //Я живу за МКАДом, привезёте?
    private By bringScooterBeyondMKAD = By.id("accordion__heading-7");
    private By bringScooterBeyondMKADText = By.id("accordion__panel-7");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Прокрутка страниц до раздела "Важные вопросы"
    public void ScrolligToQiestion () {
        WebElement element = driver.findElement(howMuchDoesItCost);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    //Открытие сайта
    public void Open() {
        driver.get(URL);
    }

    //Нажать верхнюю кнопку "Заказать"
    public void clickUpperOrderButton() {
        driver.findElement(orderButtonAbowe).click();
    }

    //Нажать нижнюю кнопку "Заказать"
    public void clickLowerOrderButton() {
        WebElement element = driver.findElement(orderButtonBelow);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(orderButtonBelow).click();
    }

    //Достать текст ответа
    public String getHowMuchDoesItCostAnswer() {
        driver.findElement(howMuchDoesItCost).click();
        return driver.findElement(howMuchDoesItCostText).getText();
    }
    public String getWantSeveralScootersAtOnceAnswer() {
        driver.findElement(wantSeveralScootersAtOnce).click();
        return driver.findElement(wantSeveralScootersAtOnceText).getText();
    }
    public String getHowRentalTimeCalculatedAnswer() {
        driver.findElement(howRentalTimeCalculated).click();
        return driver.findElement(howRentalTimeCalculatedText).getText();
    }
    public String getPossibleToOrderScooterToday() {
        driver.findElement(possibleToOrderScooterToday).click();
        return driver.findElement(possibleToOrderScooterTodayText).getText();
    }
    public String getPossibleToExtendOrderOrReturnEarlier() {
        driver.findElement(possibleToExtendOrderOrReturnEarlier).click();
        return driver.findElement(possibleToExtendOrderOrReturnEarlierText).getText();
    }
    public String getChargingAlongWithScooter() {
        driver.findElement(chargingAlongWithScooter).click();
        return driver.findElement(chargingAlongWithScooterText).getText();
    }
    public String getPossibleToCancelOrder() {
        driver.findElement(possibleToCancelOrder).click();
        return driver.findElement(possibleToCancelOrderText).getText();
    }
    public String getBringScooterBeyondMKAD() {
        driver.findElement(bringScooterBeyondMKAD).click();
        return driver.findElement(bringScooterBeyondMKADText).getText();
    }

}
