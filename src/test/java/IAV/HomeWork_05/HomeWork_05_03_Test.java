package IAV.HomeWork_05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HomeWork_05_03_Test extends HomeWork_05_Abstract_Test {
/*
    Проверка отказа в аутентификации при неправильном пароле.
 */

    @Test
    @DisplayName("Authentication check with wrong credentials")
    @Disabled
    void test (){

        //Ищем кнопку Войти
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();

        //Ищем поле Логин
        webElement1 = getDriver().findElement(By.id("user"));
        webElement1.click();
        webElement1.sendKeys("via-20220418");

        //Ищем поле Пароль
        WebElement webElement2 = getDriver().findElement(By.id("lj_loginwidget_password"));
        webElement2.click();
        webElement2.sendKeys("20QWErty");

        //Снимаем галку Запомнить меня
        WebElement webElement3 = getDriver().findElement(By.cssSelector(".b-loginform-checkbox__control"));
        webElement3.click();

        //Нажимаем Войти
        webElement3 = getDriver().findElement(By.name("action:login"));
        webElement3.click();

        //Ищем сообщение о неправильном пароле
        WebElement webElement4 = getDriver().findElement(By.cssSelector(".b-loginform-field--error > .b-loginform-field__errorMsg"));

        Assertions.assertEquals(webElement4.getText(), "Неверный пароль","Получено сообщение о неверном пароле.\nТест пройден.");

        //Задержка для визуального подтверждения неуспешной аутентификации
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
