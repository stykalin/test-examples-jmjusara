package io.github.stykalin.jmjusara.ui;

import static com.codeborne.selenide.Selenide.open;

import io.github.stykalin.jmjusara.ui.pages.YaSearchPage;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

/**
 * YaSearchPageTests.
 *
 * @author Aleksandr_Stykalin
 */
public class YaSearchSuggestTests extends BaseTests {

    public void suggestTest(String searchWord) {
        open("https://www.yandex.ru/");
        YaSearchPage searchPage = new YaSearchPage();
        searchPage.inputText(searchWord);
        searchPage.printConsoleFirstSuggestion();
        searchPage.checkSuggestionContains(searchWord);
    }

    @Tag("ui.task1")
    @TestFactory
    public Collection<DynamicTest> suggestTestFactory() {
        final String nameTemplate = "Парсинг значения из предолжений поиска по слову '%s'";
        return Arrays.asList(
                DynamicTest.dynamicTest(String.format(nameTemplate, "погода"), () -> suggestTest("погода")),
                DynamicTest.dynamicTest(String.format(nameTemplate, "Липецк"), () -> suggestTest("Липецк")),
                DynamicTest.dynamicTest(String.format(nameTemplate, "Лото"), () -> suggestTest("Лото"))
        );
    }

}
