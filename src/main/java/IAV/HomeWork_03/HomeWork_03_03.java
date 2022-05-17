package IAV.HomeWork_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HomeWork_03_03 {
/*
    Проверка отказа в аутентификации при неправильном пароле.
 */

    public static void main (String[] args){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");

        //Ищем кнопку Войти
        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();

        //Ищем поле Логин
        webElement1 = driver.findElement(By.id("user"));
        webElement1.click();
        webElement1.sendKeys("via-20220418");

        //Ищем поле Пароль
        WebElement webElement2 = driver.findElement(By.id("lj_loginwidget_password"));
        webElement2.click();
        webElement2.sendKeys("20QWErty");

        //Снимаем галку Запомнить меня
        WebElement webElement3 = driver.findElement(By.cssSelector(".b-loginform-checkbox__control"));
        webElement3.click();

        //Нажимаем Войти
        webElement3 = driver.findElement(By.name("action:login"));
        webElement3.click();

        //Ищем сообщение о неправильном пароле
        WebElement webElement4 = driver.findElement(By.cssSelector(".b-loginform-field--error > .b-loginform-field__errorMsg"));

        if (webElement4.getText().equals("Неверный пароль")){
            System.out.println("Получено сообщение о неверном пароле.\nТест пройден.");
        }
        else {
            System.out.println("Тест не пройден.");
        }

        //Задержка для визуального подтверждения неуспешной аутентификации
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        driver.quit();

    }
}
