import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import pages.CartPage;
import pages.ItemPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;


public class PracticeTest {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("target/screenshots");

    @BeforeAll
    public static void setUp() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Description("Тест для нахождения Яндекс Станции")
    @DisplayName("Тест для нахождения Яндекс Станции")
    @ParameterizedTest(name = "Найти Яндекс Станцию")
    @CsvSource({"Яндекс Станция, Умная колонка Яндекс Станция Макс (темно-синий), '728,21 р.'"})
    public void testFindMobileHuaweiSelenide(String searchContent, String expectedItemName, String expectedItemPrice) throws InterruptedException {

        MainPage mainPage = open("https://onliner.by", MainPage.class);

        ItemPage itemPage = mainPage
                .enterTextToSearchString(searchContent)
                .selectItemByText("Макс (темно-синий)");

        String actualItemName = itemPage.getItemName();
        String actualItemPrice = itemPage.getItemPrice();

        Assertions.assertEquals(expectedItemName, actualItemName, "Item name is not correct");
        Assertions.assertEquals(expectedItemPrice, actualItemPrice, "Item price is not correct");

        CartPage cartPage = itemPage
                .addToCart()
                .openCart();

        Assertions.assertTrue(cartPage.checkCartIsNotEmpty(), "Cart is empty!");
        Assertions.assertTrue(cartPage.checkIfSpecifiedItemExistInCart("Яндекс Станция Макс (темно-синий)"), "This item doesn't exist in cart");
    }

    @AfterEach
    public void printLogs() {
        System.out.println("Printing logs");
        LogEntries logEntries = WebDriverRunner.getWebDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry);
        }
    }
}
