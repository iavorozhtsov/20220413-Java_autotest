package IAV.HomeWork_05;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomeWork_05_05_Test extends HomeWork_05_Abstract_Test{

    void doLogin(){
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
        Assertions.assertEquals("VIA_20220418", webElement4.getText(), "Осуществлён успешный вход под пользователем VIA_20220418.");
    }

    void doLogout(){
        //Ищем кнопку Выйти и выходим из ЖЖ
        Actions actions = new Actions(getDriver());
        WebElement webElement1 = getDriver().findElement(By.cssSelector("._39"));
        actions.moveToElement(webElement1).perform();

        WebElement webElement2 = getDriver().findElement(By.xpath("//div[@class=\"_vp\"][2]/a[3]"));
        webElement2.click();
    }

    @Test
    @Epic("Тестирование ЖЖ, урок 5")
    @Description("Проверка открытия страницы написания публикации при нажатии кнопки Написать в блог")
    @DisplayName("Post button check")
    void test () throws InterruptedException {

        //Логинимся в ЖЖ
        doLogin();

        //Ищем кнопку Написать в блог
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-header-item__link--post"));
        Assertions.assertEquals("https://www.livejournal.com/post", webElement1.getAttribute("href"), "Ссылка \"Написать в блог \" ведёт на нужную страницу.");

        //Прожимаем кнопку
        webElement1.click();

        //Проверяем, что открылась страница с названием Новая запись
        Assertions.assertEquals("Новая запись", getDriver().getTitle(), "Открылась нужная страница.\nТест пройден");

        //Задержка для визуального подтверждения успешной аутентификации
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Выходим из ЖЖ
        doLogout();
    }
}
