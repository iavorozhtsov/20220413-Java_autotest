package IAV.HomeWork_06;

import IAV.HomeWork_05.HomeWork_05_Abstract_Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthTest extends HomeWork_05_Abstract_Test {

    @Test
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
    @DisplayName("Positive authentication check")
    void PositiveAuthTest(){
        AuthPage ap = new AuthPage(getDriver());

        ap.doSimpleAuth("via-20220418", "20QWErty22");

        Assertions.assertEquals("VIA_20220418", ap.getUserMenuText());
        ap.doLogout();
    }

    @Test
    @DisplayName("Negative authentication check")
//    @Disabled("Can block other tests.")
    void NegativeAuthTest(){
        AuthPage ap = new AuthPage(getDriver());

        ap.doSimpleAuth("via-20220418", "20QWErty");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals("Неверный пароль", ap.getErrorMessage());
    }

    @Test
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
