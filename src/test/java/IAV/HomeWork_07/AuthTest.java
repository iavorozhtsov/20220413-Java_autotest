package IAV.HomeWork_07;

import IAV.HomeWork_06.AuthPage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Method;

public class AuthTest extends AbstractTest {

    @Test
    @Story("Тестирование элементов окна аутентификации")
    @Description("Кнопка Войти должна быть отключена по умолчанию")
    @DisplayName("Login button is disabled while credentials field is empty")
    void EmptyCredentialsTest(){
        AuthPage ap = new AuthPage(getDriver());

        ap.openAuth();
        Assertions.assertTrue(ap.isLoginBtnDisabled());

        ap.writeToLoginField("1")
                .writeToPswdField("1");
        Assertions.assertTrue(ap.isLoginBtnEnabled());
    }

    @Test
    @Story("Тестирование элементов окна аутентификации")
    @Description("Проверка успешной аутентификации")
    @DisplayName("Positive authentication check")
    void PositiveAuthTest(){
        AuthPage ap = new AuthPage(getDriver());

        ap.doSimpleAuth("via-20220418", "20QWErty22");

        Assertions.assertEquals("VIA_20220418", ap.getUserMenuText());
        ap.doLogout();
    }

    @Test
    @Story("Тестирование элементов окна аутентификации")
    @Description("Проверка отказа в аутентификации при невалидных данных")
    @DisplayName("Negative authentication check")
//    @Disabled("Can block other tests")
    void NegativeAuthTest(){
        AuthPage ap = new AuthPage(getDriver());

        ap.doSimpleAuth("via-20220418", "20QWErty");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals("Неверный пароль", ap.getErrorMessage());
        MyUtilities.makeScreenshot(getDriver(), "./target/failure-" + System.currentTimeMillis() + ".png");
    }

    @Test
    @Story("Тестирование элементов окна аутентификации")
    @Description("Проверка работы механизма защиты от подбора пароля")
    @DisplayName("Bruteforce prevention check")
    @Disabled("Can block other tests")
    void BruteforcePreventionTest(){
        AuthPage ap = new AuthPage(getDriver());

        ap.openAuth()
                .writeToLoginField("via-20220418")
                .writeToPswdField("20QWErty");
        for (int i = 0; i < 5; i++) {
            ap.doAuth();
        }

        Assertions.assertEquals("Ваш IP временно заблокирован", ap.getBruteforceErr());
    }

}
