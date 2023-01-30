import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    String link = "https://sportpoint.ru";
    String request = "Puma";
    String key = "Бренд";

}
