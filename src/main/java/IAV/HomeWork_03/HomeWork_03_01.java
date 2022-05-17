package IAV.HomeWork_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork_03_01 {
/*
    При открытии окна аутентификации кнопка Войти должна быть заблокирована
    пока пользователь не введёт хотя бы по одному символу в поля Логин и Пароль
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

        //Ищем поле Пароль
        WebElement webElement2 = driver.findElement(By.id("lj_loginwidget_password"));

        //Ищем кнопку Войти, которая должна быть заблокирована, что определяется стилем --disabled
        WebElement webElement3 = driver.findElement(By.cssSelector(".b-loginform-btn--disabled"));
        System.out.println("Кнопка 'Войти' с заблокированным стилем найдена.");

        webElement1.click();
        webElement1.sendKeys("1");

        webElement2.click();
        webElement2.sendKeys("1");

        //Ищем кнопку Войти, которая теперь активна
        List<WebElement> webElements = driver.findElements(By.xpath("//button[@class=\"b-loginform-btn b-loginform-btn--login b-loginform-btn--auth b-loginform-btn--center b-loginform-btn--disabled\"]"));
        if (webElements.size() == 0){
            System.out.println("Кнопка 'Войти' с заблокированным стилем отсутствует, то есть кнопка активна.\nТест пройден.");
        }
        else {
            System.out.println("Тест не пройден.");
        }

//        driver.quit();

    }
}
