import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class SelenideTest extends BaseTest {

    @DisplayName("\"Product card contains Brand's link\" simple Selenide Test")
    @Test
    public void selenideTest() {
        open(link);
        $("#title-search-input").setValue(request).pressEnter();
        $(".products-product-images:not(tech)").click();
        $x("//div[@class='accord__open product-data__accord__open']" +
                "[contains(text(), 'Характеристики')]").click();
        $x("//table//span[contains(text(),'" + key + "')]").shouldHave(text(key));
        $x("//table//a[contains(text(), '" + request + "')]").shouldHave(text(request));
    }
}