package IAV.HomeWork_05;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
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

public class HomeWork_05_04_Test extends HomeWork_05_Abstract_Test{
    @Test
    @Epic("Тестирование ЖЖ, урок 5")
    @Description("Проверка блокировки по IP при неоднократной неуспешной аутентификации.")
    @DisplayName("IP-address blocked in case of bruteforce attempt")
    @Disabled("Other tests can be blocked")
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

        //Нажимаем Войти 5 раз
        webElement3 = getDriver().findElement(By.name("action:login"));
        for (int i = 0; i < 5; i++) {
            webElement3.click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Ищем сообщение о блокировке IP адреса
        WebElement webElement4 = getDriver().findElement(By.cssSelector(".b-loginform-field__errorMsg"));

        Assertions.assertEquals("Ваш IP временно заблокирован", webElement4.getText(), "Получено сообщение о блокировке IP-адреса.\nТест пройден.");

        //Задержка для визуального подтверждения неуспешной аутентификации
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
