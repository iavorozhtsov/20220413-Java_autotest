package IAV.HomeWork_05;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HomeWork_05_02_Test extends HomeWork_05_Abstract_Test{
    @Test
    @Epic("Тестирование ЖЖ, урок 5")
    @Description("Проверка успешной аутентификации." +
            "Должны перейти на домашнюю страницу с заголовком в виде имени пользователя.")
    @DisplayName("Authentication check")
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
        webElement2.sendKeys("20QWErty22");

        //Снимаем галку Запомнить меня
        WebElement webElement3 = getDriver().findElement(By.cssSelector(".b-loginform-checkbox__control"));
        webElement3.click();

        //Нажимаем Войти
        webElement3 = getDriver().findElement(By.name("action:login"));
        webElement3.click();

        //Ищем имя пользователя на странице
        WebElement webElement4 = getDriver().findElement(By.cssSelector(".s-nav-item__name"));
        Assertions.assertEquals("VIA_20220418", webElement4.getText(), "Осуществлён успешный вход под пользователем VIA_20220418.\nТест пройден.");

        //Задержка для визуального подтверждения успешной аутентификации
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Ищем кнопку Выйти и выходим из ЖЖ
        Actions actions = new Actions(getDriver());
        actions.moveToElement(webElement4).perform();

        WebElement webElement5 = getDriver().findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        webElement5.click();
    }
}
