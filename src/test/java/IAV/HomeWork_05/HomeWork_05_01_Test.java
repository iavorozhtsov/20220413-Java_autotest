package IAV.HomeWork_05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork_05_01_Test extends HomeWork_05_Abstract_Test{
/*
    При открытии окна аутентификации кнопка Войти должна быть заблокирована
    пока пользователь не введёт хотя бы по одному символу в поля Логин и Пароль
 */
    @Test
    @DisplayName("Login button is disabled while credentials field is empty")
    void test() {

        //Ищем кнопку Войти
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();

        //Ищем поле Логин
        webElement1 = getDriver().findElement(By.id("user"));

        //Ищем поле Пароль
        WebElement webElement2 = getDriver().findElement(By.id("lj_loginwidget_password"));

        //Ищем кнопку Войти, которая должна быть заблокирована, что определяется стилем --disabled
        WebElement webElement3 = getDriver().findElement(By.cssSelector(".b-loginform-btn--disabled"));
        System.out.println("Кнопка 'Войти' с заблокированным стилем найдена.");

        webElement1.click();
        webElement1.sendKeys("1");

        webElement2.click();
        webElement2.sendKeys("1");

        //Ищем кнопку Войти, которая теперь активна
        List<WebElement> webElements = getDriver().findElements(By.xpath("//button[@class=\"b-loginform-btn b-loginform-btn--login b-loginform-btn--auth b-loginform-btn--center b-loginform-btn--disabled\"]"));

        Assertions.assertEquals(0, webElements.size(), "Кнопка 'Войти' с заблокированным стилем отсутствует, то есть кнопка активна.\nТест пройден.");

    }
}
