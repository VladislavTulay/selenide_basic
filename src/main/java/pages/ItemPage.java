package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ItemPage {

    //@FindBy(css = "h1.catalog-masthead__title")
    private SelenideElement itemName = $("h1.catalog-masthead__title");

    //@FindBy(xpath = "//a[@class='offers-description__link offers-description__link_nodecor']")
    private SelenideElement itemPrice = $x("//a[@class='offers-description__link offers-description__link_nodecor']");

    //@FindBy(xpath = "//a[@class='button-style button-style_base-alter product-aside__item-button button-style_expletive']")
    private SelenideElement addToCart = $x("//a[@class='button-style button-style_base-alter product-aside__item-button button-style_expletive']");

    //@FindBy(xpath = "//a[@title='Корзина']")
    private SelenideElement cart = $x("//a[@title='Корзина']");

    public String getItemName() {
        return itemName.text();
    }

    public String getItemPrice() {
        return itemPrice.text();
    }

}
