import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginTests {
  
  LoginPage loginPage = new LoginPage();
  
  @Test
  @DisplayName("Валидный логин и пароль - успешный логин")
  void correctCredentialsInput() throws MalformedURLException {
    loginPage.open();
    loginPage.authorizeWithValidCredential();
    loginPage.registrationFormShouldBeOpen();
  }
  
  @Test
  @DisplayName("Ввод невалидного логина, неверный формат email - неуспешный логин, ошибка формата email")
  void incorrectEmailFormat() throws MalformedURLException {
    loginPage.open();
    loginPage.authorizeWithInvalidEmail();
    loginPage.invalidEmailErrorWindowShouldBeVisible();
  }
  
  @Test
  @DisplayName("Ввод невалидного логина - неуспешный логин, ошибка логина и пароля")
  void incorrectLoginInput() throws MalformedURLException {
    loginPage.open();
    loginPage.authorizeWithInvalidLogin();
    loginPage.invalidEmailOrPasswordErrorWindowShouldBeVisible();
  }
  
  @Test
  @DisplayName("Ввод невалидного пароля - неуспешный логин, ошибка логина или пароля")
  void incorrectPasswordInput() throws MalformedURLException {
    loginPage.open();
    loginPage.authorizeWithInvalidPassword();
    loginPage.invalidEmailOrPasswordErrorWindowShouldBeVisible();
    
  }
  
}
