package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    //@FindBy(xpath = "//input[@class='fast-search__input']")
    private SelenideElement searchStr = $x("//input[@class='fast-search__input']");

    //@FindBy(xpath = "//iframe[@class='modal-iframe']")
    private SelenideElement iFrame = $x("//iframe[@class='modal-iframe']");

    //@FindBy(xpath = "//a")
    private ElementsCollection itemLink = $$x("//a");

    @Step("Ввести текст {0} в поле")
    public MainPage enterTextToSearchString(String text) {
        searchStr.setValue(text);
        return this;
    }

    @Step("Выбрать товар по имени {0}")
    public ItemPage selectItemByText(String text) {
        switchTo().frame(iFrame);
        itemLink.find(Condition.text(text)).scrollIntoView(false).click();
        switchTo().defaultContent();
        return page(ItemPage.class);
    }


}
