package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import java.io.File;
import java.net.MalformedURLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
  
  @Step("Открываем страницу логина")
  public void open() throws MalformedURLException {
    File htmlFile = new File("src/test/resources/testPageHtml/qa-test.html");
    String loginPage = htmlFile.toURI().toURL().toString();
    Selenide.open(loginPage);
  }
  
  @Step("Авторизуемся - валидные логин и пароль")
  public void authorizeWithValidCredential() {
    $("#loginEmail").setValue("test@protei.ru");
    $("#loginPassword").setValue("test");
    $("#authButton").click();
  }
  
  @Step("Авторизуемся - неверный формат email")
   public void authorizeWithInvalidEmail() {
    $("#loginEmail").setValue("testprotei.ru");
    $("#loginPassword").setValue("test");
    $("#authButton").click();
  }
  
  @Step("Авторизуемся - неверный логин")
  public void authorizeWithInvalidLogin() {
    $("#loginEmail").setValue("test@protei1.ru");
    $("#loginPassword").setValue("test");
    $("#authButton").click();
  }
  
  @Step("Авторизуемся - неверный пароль")
  public void authorizeWithInvalidPassword() {
    $("#loginEmail").setValue("test@protei.ru");
    $("#loginPassword").setValue("test1");
    $("#authButton").click();
  }
  
  @Step("Отображается ошибка формата email")
  public void invalidEmailErrorWindowShouldBeVisible() {
    $("#authAlertsHolder").shouldBe(visible);
    $("#authAlertsHolder").shouldHave(text("Неверный формат E-Mail"));
  }
  
  @Step("Отображается ошибка формата email")
  public void invalidEmailOrPasswordErrorWindowShouldBeVisible() {
    $("#authAlertsHolder").shouldBe(visible);
    $("#authAlertsHolder").shouldHave(text("Неверный E-Mail или пароль"));
  }
  
  @Step("Открыта форма регистрации")
  public void registrationFormShouldBeOpen() {
    $("#inputsPage").shouldBe(visible);
  }
  
}
