import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.ItemPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(ScreenShooterExtension.class)
public class FindPhoneTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @ParameterizedTest
    @CsvSource({"Huawei P40 Lite, Смартфон Huawei P40 lite (ярко-зеленый), '600,00 р.'"})
    public void testFindMobileHuaweiSelenide(String searchContent, String expectedPhoneName, String expectedPhonePrice) {

        MainPage mainPage = open("https://onliner.by", MainPage.class);

        ItemPage itemPage = mainPage
                .enterTextToSearchString(searchContent)
                .selectItemByText("ярко-зеленый");

        String actualPhoneName = itemPage.getItemName();
        String actualPhonePrice = itemPage.getItemPrice();

        Assertions.assertEquals(expectedPhoneName, actualPhoneName, "Phone name is not correct");
        Assertions.assertEquals(expectedPhonePrice, actualPhonePrice, "Phone price is not correct");
    }
}
