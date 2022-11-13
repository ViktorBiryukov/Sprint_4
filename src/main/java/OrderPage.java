import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver driver;

    //Имя
    private By firstNameField = By.cssSelector("div.Order_Form__17u6u > div:nth-child(1) > input");
    //Фамилия
    private By secondNameField = By.cssSelector("div.Order_Form__17u6u > div:nth-child(2) > input");
    //Адрес
    private By addressField = By.cssSelector("div.Order_Form__17u6u > div:nth-child(3) > input");
    //Станция метро
    private By metroStationField = By.className("select-search__input");
    //Телефон
    private By phoneNumberField = By.cssSelector("div.Order_Form__17u6u > div:nth-child(5) > input");
    //Кнопка "Далее"
    private By nextButton = By.cssSelector("div.Order_NextButton__1_rCA > button");
    //Когда привезти самокат
    private By dateDeliveryField = By.cssSelector("div.Order_MixedDatePicker__3qiay > div > div > input");
    //Срок аренды
    private By rentalPeriodField = By.className("Dropdown-control");
    //Выбор срока аренды из выпадающего списка
    private String classRentalPeriodDropDown = "Dropdown-option";
    //Выбор цвета самоката
    private String classScooterColorCheckBox = "Order_Checkboxes__3lWSI";
    //Комментарий для курьера
    private By commentForDeliverymanField = By.cssSelector("div.Order_Form__17u6u > div.Input_InputContainer__3NykH > input");
    //Кнопка "Заказать"
    private By orderButton = By.cssSelector("div.Order_Buttons__1xGrp > button:nth-child(2)");
    //Кнопка "Да" в окне подтверждения заказа
    private  By yesButton = By.cssSelector("div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button:nth-child(2)");
    //Сообщение об успешном создании заказа
    public By notificationOfOrderCreation = By.className("Order_ModalHeader__3FDaJ");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setFirstName (String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setSecondName (String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    public void setAddress (String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void clickNextButton () {
        driver.findElement(nextButton).click();
    }
    public void setMetroStation(String metroStation) {
        driver.findElement(metroStationField).sendKeys(metroStation + Keys.ARROW_DOWN + Keys.ENTER);
    }
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    public void setDateDelivery(String dateDelivery) {
        driver.findElement(dateDeliveryField).sendKeys(dateDelivery + Keys.ENTER);
    }
    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(String.format(classRentalPeriodDropDown, rentalPeriod))).click();
    }
    public void setScooterColor(String scooterColor) {
        driver.findElement(By.xpath(String.format(classScooterColorCheckBox, scooterColor))).click();
    }
    public void setCommentForDeliveryman(String commentForDeliveryman){
        driver.findElement(commentForDeliverymanField).sendKeys(commentForDeliveryman);
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    public String getNotificationOfOrderCreation() {
        return driver.findElement(notificationOfOrderCreation).getText();
    }
    public void creatingAnOrder (String firstName, String secondName, String address, String metroStation, String phoneNumber,
                                 String dateDelivery, String rentalPeriod, String scooterColor, String commentForDeliveryman) {
        setFirstName(firstName);
        setSecondName(secondName);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
        clickNextButton();
        setDateDelivery(dateDelivery);
        setRentalPeriod(rentalPeriod);
        setScooterColor(scooterColor);
        setCommentForDeliveryman(commentForDeliveryman);
        clickOrderButton();
        clickYesButton();
    }
}
