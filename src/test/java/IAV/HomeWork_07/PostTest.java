package IAV.HomeWork_07;

import IAV.HomeWork_06.PostPage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostTest extends AuthTest {

    @Test
    @Story("Тестирование публикации записей")
    @Description("Проверка наличия кнопки Новая запись у авторизованного пользователя")
    @DisplayName("Check post button and caption")
    void postLinkTest(){

        PostPage pt = new PostPage(getDriver());
        pt.doSimpleAuth("via-20220418", "20QWErty22");

        Assertions.assertEquals("https://www.livejournal.com/post", pt.getPostBthUrl());

        pt.clickPostBtn();

        Assertions.assertEquals("Новая запись", getDriver().getTitle(), "Открылась нужная страница.\nТест пройден");

        pt.doLogout();
    }

    @Test
    @Story("Тестирование публикации записей")
    @Description("Проверка открытия страницы с добавлением новой записи")
    @DisplayName("Check post page header in edit form")
    void postHeaderTest(){

        PostPage pt = new PostPage(getDriver());
        pt.doSimpleAuth("via-20220418", "20QWErty22");

        pt.clickPostBtn();
        Assertions.assertEquals("Новая запись", getDriver().getTitle(), "Открылась нужная страница.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals("Заголовок", pt.getHeaderOfPostAttrib("placeholder"));

        pt.doLogout();
    }

    @Test
    @Story("Тестирование публикации записей")
    @Description("Сознательно добавленный провальный тест для добавления красноты в график")
    @DisplayName("Is False = True?")
    void trueFalseTest(){

        PostPage pt = new PostPage(getDriver());
        pt.doSimpleAuth("via-20220418", "20QWErty22");

        pt.clickPostBtn();
        Assertions.assertEquals("Новая запись", getDriver().getTitle(), "Открылась нужная страница.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals("True", "False");

        pt.doLogout();
    }
}
