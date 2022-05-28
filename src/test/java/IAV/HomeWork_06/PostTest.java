package IAV.HomeWork_06;

import IAV.HomeWork_05.HomeWork_05_Abstract_Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostTest extends AuthTest{

    @Test
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


}
