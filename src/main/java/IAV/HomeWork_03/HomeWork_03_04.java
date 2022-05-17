package IAV.HomeWork_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HomeWork_03_04 {
/*
    Проверка блокировки по IP при неоднократной неуспешной аутентификации.
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

        //Нажимаем Войти 5 раз
        webElement3 = driver.findElement(By.name("action:login"));
        for (int i = 0; i < 5; i++) {
            webElement3.click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Ищем сообщение о блокировке IP адреса
        WebElement webElement4 = driver.findElement(By.cssSelector(".b-loginform-field__errorMsg"));

        if (webElement4.getText().equals("Ваш IP временно заблокирован")){
            System.out.println("Получено сообщение о блокировке IP-адреса.\nТест пройден.");
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
