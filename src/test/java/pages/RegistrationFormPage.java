package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationFormPage {
  
  @Step("Проверяем добавленные данные")
  public RegistrationFormPage checkAddedData() {
    
    String email = $("#dataTable tbody tr:nth-child(1) td:nth-child(1)").getText();
    String name = $("#dataTable tbody tr:nth-child(1) td:nth-child(2)").getText();
    assertEquals("test@test.com", email);
    assertEquals("Name", name);
    return this;
    //Второй вариант
//    $$("#dataTable").get(0).shouldHave(
//      text("test@test.com"),
//      text("Name"),
//      text("Мужской"),
//      text("1.1, 1.2"),
//      text("2.1");
  
  }
  @Step("Добавить данные")
  public RegistrationFormPage submitForm(){
    $("#dataSend").click();
    return this;
  }
  
  @Step("Заполняем Имя")
  public RegistrationFormPage setName(){
    $("#dataName").setValue("Name");
    return this;
  }
  
  @Step("Заполняем Email")
  public RegistrationFormPage setEmail(){
    $("#dataEmail").setValue("test@test.com");
    return this;
  }
  
   @Step("Выбираем пол")
  public RegistrationFormPage setGender(){
    $("#dataGender").selectOptionContainingText("Мужской");
    return this;
  }
  
   @Step("Выбираем чекбоксы")
  public RegistrationFormPage setCheckBox(){
     $("#dataCheck11").click();
     $("#dataCheck12").click();
     return this;
  }
  
   @Step("Выбираем радиобатон")
  public RegistrationFormPage setRadio(){
     $("#dataSelect21").click();
     return this;
  }
  
   @Step("Отображается popup подтверждения")
  public RegistrationFormPage confirmationPopupShouldBeVisible(){
     $(".uk-modal").shouldBe(visible);
     $(".uk-modal-close").click();
     return this;
  }
  
  @Step("Отображается ошибка невалидного email")
  public RegistrationFormPage emailFormatErrorShouldBeVisible(){
     $("#emailFormatError").shouldBe(visible);
     $("#emailFormatError").shouldHave(text("Неверный формат E-Mail"));
     return this;
  }
  @Step("Отображается ошибка, что имя не заполнено")
  public RegistrationFormPage nameShouldNotBeEmpty(){
     $("#blankNameError").shouldBe(visible);
     $("#blankNameError").shouldHave(text("Поле имя не может быть пустым"));
     return this;
  }
   
   @Step("Если не заполнен чекбокс, то в таблице отображается 'Нет'")
  public RegistrationFormPage unpinnedCheckboxInTableShouldHaveText(){
     String choice1 = $("#dataTable tbody tr:nth-child(1) td:nth-child(4)").getText();
     assertEquals("Нет", choice1);
     return this;
  }
  
  
}
