import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class GitHunTests extends BaseTest {

    @Test
    @DisplayName("\"Product card contains Brand's link\" with Lambda Steps Test")
    public void checkNameIssueSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу " + link, () -> {
            Selenide.open(link);
        });

        step("Ищем товары бренда" + request, () -> {
            $("#title-search-input").setValue(request).pressEnter();
        });
        step("Переходим в первую карточку товара", () -> {
            $(".products-product-images:not(tech)").click();
        });
        step("Открываем вкладку Характеристики", () -> {
            $(byText("Характеристики")).click();
        });

        step("Проверяем, что свойство \"Бренд\" равно искомому запросу " + request, () -> {
            $x("//table//span[contains(text(),'" + key + "')]").shouldHave(text(key));
            $x("//table//a[contains(text(), '" + request + "')]").shouldHave(text(request));
        });
    }
}
