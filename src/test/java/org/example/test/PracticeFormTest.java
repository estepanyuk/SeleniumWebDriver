package org.example.test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormTest extends BaseTest {

    @Test
    public void testPracticeForm() throws InterruptedException {
        //Step 1
        practiceFormPage.open();
        Assertions.assertEquals(practiceFormPage.getCurrentUrl(), driver.getCurrentUrl());

        //Step 2
        practiceFormPage.PasteFirstName("TestFirst");
        Assertions.assertEquals("TestFirst", practiceFormPage.getFirstName());

        //Step 3
        practiceFormPage.PasteLastName("TestLast");
        Assertions.assertEquals("TestLast", practiceFormPage.getLastName());

        //Step 4
        practiceFormPage.PasteUserEmail("test@test.com");
        Assertions.assertEquals("test@test.com", practiceFormPage.getUserEmail());

        //Step 5
        practiceFormPage.clickGenderRadio2();

        //Step 6
        practiceFormPage.PasteUserNumber("1488467984");
        Assertions.assertEquals("1488467984", practiceFormPage.getUserNumber());

        //Step 7
        practiceFormPage.PasteDateOfBirthInput(6, "September", 1995);
        Assertions.assertEquals("06 Sep 1995", practiceFormPage.getDateOfBirthInput());

        //Step 8
        practiceFormPage.PasteSubjectsContainer("Chemistry");
        Assertions.assertEquals("Chemistry", practiceFormPage.getSubjectsContainer());

        //Step 9
        practiceFormPage.clickHobbiesCheckbox1();

        //Step 10
        practiceFormPage.uploadPicture();

        //Step 11 адрес
        practiceFormPage.PasteCurrentAddress("Test residential address");
        Assertions.assertEquals("Test residential address", practiceFormPage.getCurrentAddress());

        //Step 12
        practiceFormPage.chooseState("Haryana");
        Assertions.assertEquals("Haryana", practiceFormPage.getState());

        //Step 13
        practiceFormPage.chooseCity("Karnal");
        Assertions.assertEquals("Karnal", practiceFormPage.getCity());

        //Step 14
        practiceFormPage.clickSubmit();
        practiceFormPage.waitFormVisible();

        //Step 15
        Assertions.assertEquals("TestFirst TestLast", practiceFormPage.getFormData(0));
        Assertions.assertEquals("test@test.com", practiceFormPage.getFormData(1));
        Assertions.assertEquals("Female", practiceFormPage.getFormData(2));
        Assertions.assertEquals("1488467984", practiceFormPage.getFormData(3));
        Assertions.assertEquals("06 September,1995", practiceFormPage.getFormData(4));
        Assertions.assertEquals("Chemistry", practiceFormPage.getFormData(5));
        Assertions.assertEquals("Sports", practiceFormPage.getFormData(6));
        Assertions.assertEquals("04.png", practiceFormPage.getFormData(7));
        Assertions.assertEquals("Test residential address", practiceFormPage.getFormData(8));
        Assertions.assertEquals("Haryana Karnal", practiceFormPage.getFormData(9));

        //Step16
        practiceFormPage.closeLargeModal();

    }
}
