package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    //@FindBy(xpath = "//input[@class='fast-search__input']")
    private SelenideElement searchStr = $x("//input[@class='fast-search__input']");

    //@FindBy(xpath = "//iframe[@class='modal-iframe']")
    private SelenideElement iFrame = $x("//iframe[@class='modal-iframe']");

    //@FindBy(xpath = "//a")
    private ElementsCollection itemLink = $$x("//a");

    public MainPage enterTextToSearchString(String text) {
        searchStr.setValue(text);
        return this;
    }

    public ItemPage selectItemByText(String text) {
        switchTo().frame(iFrame);
        itemLink.find(Condition.text(text)).scrollIntoView(false).click();
        switchTo().defaultContent();
        return page(ItemPage.class);
    }


}
