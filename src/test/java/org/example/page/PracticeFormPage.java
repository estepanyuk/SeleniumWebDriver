package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormPage {

    private final By firstName = By.id("firstName");

    private final By lastName = By.id("lastName");

    private final By userEmail = By.id("userEmail");

    private final By genderRadioFemaleLabel = By.xpath("//*[@for='gender-radio-2']");

    private final By userNumber = By.id("userNumber");

    private final By dateOfBirthInput = By.id("dateOfBirthInput");

    private final By datePickerMonth = By.className("react-datepicker__month-select");

    private final By datePickerYear = By.className("react-datepicker__year-select");

    private final By subjectsContainer = By.id("subjectsContainer");
    private final By subjectsInput = By.id("subjectsInput");

    private final By multiValueLabel = By.xpath("//div[@id='subjectsContainer']//div[contains(@class,'subjects-auto-complete__multi-value__label')]");

    private final By hobbiesCheckboxSportLabel = By.xpath("//*[@for='hobbies-checkbox-1']");

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

    public String GetCurrentUrl() {
        return currentUrl;
    }

    public void pasteFirstName(String text) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(text);
    }

    public String getFirstName() {
        return driver.findElement(firstName).getAttribute("value");
    }

    public void pasteLastName(String text) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(text);
    }

    public String getLastName() {
        return driver.findElement(lastName).getAttribute("value");
    }

    public void pasteUserEmail(String text) {
        driver.findElement(userEmail).clear();
        driver.findElement(userEmail).sendKeys(text);
    }

    public String getUserEmail() {
        return driver.findElement(userEmail).getAttribute("value");
    }

    public void clickGenderRadioFemale(){
        driver.findElement(genderRadioFemaleLabel).click();
    }

    public void pasteUserNumber(String text) {
        driver.findElement(userNumber).clear();
        driver.findElement(userNumber).sendKeys(text);
    }

    public String getUserNumber() {
        return driver.findElement(userNumber).getAttribute("value");
    }

    public void pasteDateOfBirthInput(String day, String month, String year) {
        driver.findElement(dateOfBirthInput).click();

        new Select(driver.findElement(datePickerMonth)).selectByVisibleText(month);
        new Select(driver.findElement(datePickerYear)).selectByVisibleText(year);

        driver.findElements(By.xpath("//div[contains(@aria-label, '" + month + " " + day + "')]")).get(0).click();
    }

    public String getDateOfBirthInput(){
        return driver.findElement(dateOfBirthInput).getAttribute("value");
    }

    public void pasteSubjectsContainer(String subject) {
        driver.findElement(subjectsContainer).click();
        driver.findElement(subjectsInput).sendKeys(subject);
        sleep(1000);
        driver.findElement(subjectsInput).sendKeys(Keys.ENTER);
    }

    public String getSubjectsContainer() {
        return driver.findElements(multiValueLabel).get(0).getText();
    }

    public void clickHobbiesCheckboxSport() {
        driver.findElement(hobbiesCheckboxSportLabel).click();
    }

    public void uploadPicture(String file) {
        driver.findElement(uploadPicture).sendKeys(System.getProperty("user.dir") + "/img/" + file);
    }


    public void pasteCurrentAddress(String text) {
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

    public void waitFormVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(form));
    }

    public String getFormData(int index){
        return driver.findElements(formData).get(index).getText();
    }

    public void closeLargeModal() {
        driver.findElement(closeLargeModal).click();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
