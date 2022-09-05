package org.example.test;

import org.junit.jupiter.api.Test;

public class PracticeFormTest extends BaseTest {

    @Test
    public void testPracticeForm() {
        String firstName = "TestFirst";
        String lastName = "TestLast";
        String email = "test@test.com";
        String female = "Female";
        String phone = "1488467984";
        String[] dateOfBirth = {"16", "Sep", "September", "1995"};
        String subject = "Chemistry";
        String hobby = "Sports";
        String file = "04.png";
        String currentAddress = "Test residential address";
        String state = "Haryana";
        String city = "Karnal";

        practiceFormPage.open();
        softAssertions.assertThat(driver.getCurrentUrl()).as("Current url").isEqualTo(practiceFormPage.GetCurrentUrl());

        practiceFormPage.pasteFirstName(firstName);
        softAssertions.assertThat(practiceFormPage.getFirstName()).as("First name field").isEqualTo(firstName);

        practiceFormPage.pasteLastName(lastName);
        softAssertions.assertThat(practiceFormPage.getLastName()).as("Last name field").isEqualTo(lastName);

        practiceFormPage.pasteUserEmail(email);
        softAssertions.assertThat(practiceFormPage.getUserEmail()).as("Email field").isEqualTo(email);

        practiceFormPage.clickGenderRadioFemale();

        practiceFormPage.pasteUserNumber(phone);
        softAssertions.assertThat(practiceFormPage.getUserNumber()).as("Email field").isEqualTo(phone);

        practiceFormPage.pasteDateOfBirthInput(dateOfBirth[0], dateOfBirth[2], dateOfBirth[3]);
        softAssertions.assertThat(practiceFormPage.getDateOfBirthInput()).as("Email field").isEqualTo(dateOfBirth[0] + " " + dateOfBirth[2] + " " + dateOfBirth[3]);

        practiceFormPage.pasteSubjectsContainer(subject);
        softAssertions.assertThat(practiceFormPage.getSubjectsContainer()).as("Subjects field").isEqualTo(subject);

        practiceFormPage.clickHobbiesCheckboxSport();

        practiceFormPage.uploadPicture(file);

        practiceFormPage.pasteCurrentAddress(currentAddress);
        softAssertions.assertThat(currentAddress).as("Current address field").isEqualTo(practiceFormPage.getCurrentAddress());

        practiceFormPage.chooseState(state);
        softAssertions.assertThat(practiceFormPage.getState()).as("State field").isEqualTo(state);

        practiceFormPage.chooseCity(city);
        softAssertions.assertThat(practiceFormPage.getCity()).as("City field").isEqualTo(city);

        practiceFormPage.clickSubmit();
        practiceFormPage.waitFormVisible();

        softAssertions.assertThat(practiceFormPage.getFormData(0)).as("First and Last names in table").isEqualTo(firstName + " " + lastName);
        softAssertions.assertThat(practiceFormPage.getFormData(1)).as("Email in table").isEqualTo(email);
        softAssertions.assertThat(practiceFormPage.getFormData(2)).as("Sex in table").isEqualTo(female);
        softAssertions.assertThat(practiceFormPage.getFormData(3)).as("Phone in table").isEqualTo(phone);
        softAssertions.assertThat(practiceFormPage.getFormData(4)).as("Date of birthday in table").isEqualTo(dateOfBirth[0] + " " + dateOfBirth[2] + "," + dateOfBirth[3]);
        softAssertions.assertThat(practiceFormPage.getFormData(5)).as("Subject in table").isEqualTo(subject);
        softAssertions.assertThat(practiceFormPage.getFormData(6)).as("Hobbies in table").isEqualTo(hobby);
        softAssertions.assertThat(practiceFormPage.getFormData(7)).as("File in table").isEqualTo(file);
        softAssertions.assertThat(practiceFormPage.getFormData(8)).as("Current address in table").isEqualTo(currentAddress);
        softAssertions.assertThat(practiceFormPage.getFormData(9)).as("State and City in table").isEqualTo(state + " " + city);

        practiceFormPage.closeLargeModal();
    }
}
