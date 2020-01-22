package io.github.stykalin.jmjusara.ui;

import static com.codeborne.selenide.Selenide.open;

import io.github.stykalin.jmjusara.ui.pages.YaSearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * YaPicturesTests.
 *
 * @author Aleksandr_Stykalin
 */
public class YaPicturesTests extends BaseTests {

    @Test
    @Tag("ui.task2")
    @DisplayName("Проверка отображения вкладки 'Картинки'")
    public void pictureTabTest(){
        open("https://www.yandex.ru/");
        YaSearchPage searchPage = new YaSearchPage();
        searchPage.checkPictureTab();
    }

}
