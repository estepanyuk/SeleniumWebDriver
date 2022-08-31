package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class PracticeFormPage {

    private final By firstName = By.id("firstName");

    private final By lastName = By.id("lastName");

    private final By userEmail = By.id("userEmail");

    private final By genderRadio2 = By.xpath("//*[@id='gender-radio-2']");
    private final By genderRadio2Label = By.xpath("//*[@for='gender-radio-2']");

    private final By userNumber = By.id("userNumber");

    private final By dateOfBirthInput = By.id("dateOfBirthInput");

    private final By datePickerMonth = By.className("react-datepicker__month-select");

    private final By datePickerYear = By.className("react-datepicker__year-select");

    private final By subjectsContainer = By.id("subjectsContainer");
    private final By subjectsInput = By.id("subjectsInput");

    private final By multiValueLabel = By.xpath("//div[@id='subjectsContainer']//div[contains(@class,'subjects-auto-complete__multi-value__label')]");


    private final By hobbiesCheckbox1 = By.id("hobbies-checkbox-1");

    private final By hobbiesCheckbox1Label = By.xpath("//*[@for='hobbies-checkbox-1']");

    private final By uploadPicture = By.id("uploadPicture");

    private final By currentAddress = By.id("currentAddress");

    private final By state = By.xpath("//div[@id='state']//div[contains(@class, 'singleValue')]");
    private final By stateInput = By.id("react-select-3-input");

    private final By city = By.xpath("//div[@id='city']//div[contains(@class, 'singleValue')]");

    private final By cityInput = By.id("react-select-4-input");

    private final By submit = By.id("submit");

    private final By form = By.className("modal-content");
    private final By formData = By.xpath("//div[@class='modal-content']//tr/td[2]");

    private final By closeLargeModal = By.id("closeLargeModal");


    protected WebDriver driver;

    protected String currentUrl = "https://demoqa.com/automation-practice-form";


    public PracticeFormPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void open() {
        driver.get(currentUrl);
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public void PasteFirstName(String text) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(text);
    }

    public String getFirstName() {
        return driver.findElement(firstName).getAttribute("value");
    }

    public void PasteLastName(String text) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(text);
    }

    public String getLastName() {
        return driver.findElement(lastName).getAttribute("value");
    }

    public void PasteUserEmail(String text) {
        driver.findElement(userEmail).clear();
        driver.findElement(userEmail).sendKeys(text);
    }

    public String getUserEmail() {
        return driver.findElement(userEmail).getAttribute("value");
    }

    public void clickGenderRadio2(){
        driver.findElement(genderRadio2Label).click();
    }

    public void PasteUserNumber(String text) {
        driver.findElement(userNumber).clear();
        driver.findElement(userNumber).sendKeys(text);
    }

    public String getUserNumber() {
        return driver.findElement(userNumber).getAttribute("value");
    }

    public void PasteDateOfBirthInput(int day, String month, int year) {
        driver.findElement(dateOfBirthInput).click();

        new Select(driver.findElement(datePickerMonth)).selectByVisibleText(month);
        new Select(driver.findElement(datePickerYear)).selectByVisibleText(String.valueOf(year));

        driver.findElements(By.xpath("//div[contains(@aria-label, '" + month + " " + day + "')]")).get(0).click();
    }

    public String getDateOfBirthInput(){
        return driver.findElement(dateOfBirthInput).getAttribute("value");
    }

    public void PasteSubjectsContainer(String Chemistry) {
        driver.findElement(subjectsContainer).click();
        driver.findElement(subjectsInput).sendKeys("Chemistry");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(subjectsInput).sendKeys(Keys.ENTER);
    }

    public String getSubjectsContainer() {
        return driver.findElements(multiValueLabel).get(0).getText();
    }

    public void clickHobbiesCheckbox1() {
        driver.findElement(hobbiesCheckbox1Label).click();
    }

    public void uploadPicture(){
        driver.findElement(uploadPicture).sendKeys("/Users/ekaterinastepanuk/IdeaProjects/SeleniumWebDriver/img/04.png");
    }


    public void PasteCurrentAddress(String text) {
        driver.findElement(currentAddress).clear();
        driver.findElement(currentAddress).sendKeys(text);
    }

    public String getCurrentAddress() {
        return driver.findElement(currentAddress).getAttribute("value");
    }

    public void chooseState(String value) {
        driver.findElement(stateInput).sendKeys(value);
        driver.findElement(stateInput).sendKeys(Keys.ENTER);
    }

    public String getState() {
        return driver.findElement(state).getText();
    }

    public void chooseCity(String value) {
        driver.findElement(cityInput).sendKeys(value);
        driver.findElement(cityInput).sendKeys(Keys.ENTER);
    }

    public String getCity() {
        return driver.findElement(city).getText();
    }

    public void clickSubmit() {
        driver.findElement(submit).click();
    }

    public void waitFormVisible () {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(form));
    }

    public String getFormData(int index){
        return driver.findElements(formData).get(index).getText();
    }

    public void closeLargeModal() {
        driver.findElement(closeLargeModal).click();
    }

}
