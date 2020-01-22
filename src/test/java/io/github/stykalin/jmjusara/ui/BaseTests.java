package io.github.stykalin.jmjusara.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

/**
 * BaseTests.
 *
 * @author Aleksandr_Stykalin
 */
abstract public class BaseTests {

    @BeforeEach
    public void setup() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

}
