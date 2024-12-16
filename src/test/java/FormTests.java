import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RegistrationFormPage;

import java.net.MalformedURLException;

public class FormTests {
  
  LoginPage loginPage = new LoginPage();
  RegistrationFormPage registrationFormPage = new RegistrationFormPage();
  
  @Test
  @DisplayName("Заполняем форму целиком и подтверждаем - запись добавлена в таблицу")
  void fillFormAndSubmit() throws MalformedURLException {
    //чейнинг сделан умышленно
    loginPage.open();
    loginPage.authorizeWithValidCredential();
    registrationFormPage
      .setName()
      .setEmail()
      .setGender()
      .setCheckBox()
      .setRadio();
    registrationFormPage
      .submitForm();
    registrationFormPage
      .confirmationPopupShouldBeVisible();
    registrationFormPage
      .checkAddedData();
  }
  
  @Test
  @DisplayName("Заполняем форму, имя пустое - ошибка")
  void fillFormWithoutName() throws MalformedURLException {
    //чейнинг сделан умышленно
    loginPage.open();
    loginPage.authorizeWithValidCredential();
    registrationFormPage
      .setEmail()
      .setGender()
      .setCheckBox()
      .setRadio();
    registrationFormPage
      .submitForm();
    registrationFormPage
      .nameShouldNotBeEmpty();
  }
  
  @Test
  @DisplayName("Заполняем форму, email пустое - ошибка")
  void fillFormWithoutEmail() throws MalformedURLException {
    //чейнинг сделан умышленно
    loginPage.open();
    loginPage.authorizeWithValidCredential();
    registrationFormPage
      .setName()
      .setGender()
      .setCheckBox()
      .setRadio();
    registrationFormPage
      .submitForm();
    registrationFormPage
      .emailFormatErrorShouldBeVisible();
  }
  
  @Test
  @DisplayName("Заполняем форму целиком и подтверждаем - запись добавлена в таблицу")
  void emptyCheckboxesShouldHaveTextInDataTable() throws MalformedURLException {
    loginPage.open();
    loginPage.authorizeWithValidCredential();
    registrationFormPage
      .setName()
      .setEmail()
      .setGender()
      .setRadio();
    registrationFormPage
      .submitForm();
    registrationFormPage
      .confirmationPopupShouldBeVisible();
    registrationFormPage
      .unpinnedCheckboxInTableShouldHaveText();
  }
  
}
