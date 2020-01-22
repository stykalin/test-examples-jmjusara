package io.github.stykalin.jmjusara.ui.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.screenshot;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * YaSearchPage.
 *
 * @author Aleksandr_Stykalin
 */
public class YaSearchPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(YaSearchPage.class);

    private SelenideElement searchInput = $("#text");

    private ElementsCollection suggestList = $$("li[class~='suggest2-item']");

    private SelenideElement pictureTab = $("a[data-id='images']");

    @Step("Ввести текст '{searchText}' в строку поиска")
    public void inputText(String searchText) {
        searchInput.sendKeys(searchText);
    }

    @Step("Вывести на экран первый предложенный вариант")
    public void printConsoleFirstSuggestion() {
        String firstSuggestion = suggestList.first().text();
        LOGGER.info("вывод первого предложенного варианта: " + firstSuggestion);
        Allure.addAttachment("Вывод в консоль.txt", firstSuggestion);
        addScreenshotToAllure("firstSuggestion");
    }

    @Step("Проверить, что первый предложенный вариант содержит текст '{text}'")
    public void checkSuggestionContains(String text) {
        suggestList.first().shouldBe(Condition.text(text));
    }

    @Step("Проверить, что вкладка 'Картинки' корректно отображается")
    public void checkPictureTab() {
        addScreenshotToAllure("picTab");
        pictureTab.shouldBe(Condition.enabled);
        pictureTab.shouldBe(Condition.exactText("Картинки"));
    }

    /**
     * Wrapper for adding screenshot to report.
     *
     * @param fileName file name in report.
     */
    private void addScreenshotToAllure(String fileName) {
        try {
            Allure.addAttachment(fileName + ".png", new FileInputStream(screenshot(fileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
