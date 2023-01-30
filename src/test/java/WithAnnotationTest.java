import com.codeborne.selenide.logevents.SelenideLogger;
import components.AnnotationStepForTest;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WithAnnotationTest extends BaseTest {

    @DisplayName("\"Product card contains Brand's link\" with AnnotationStep Test")
    @Test
    public void testWithAnnotationStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AnnotationStepForTest step = new AnnotationStepForTest();
        step.openMainPage(link);
        step.searchBrandsStock(request);
        step.openFirstProductCard();
        step.openProperties();
        step.cardContainsBrand(key, request);
    }
}
