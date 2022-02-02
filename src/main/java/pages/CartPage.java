package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    //@FindBy(xpath = "//div[@class='cart-form__offers-list']")
    private SelenideElement cartList = $x("//div[@class='cart-form__offers-list']");

    private ElementsCollection itemsList = $$x("//a[@class='cart-form__link cart-form__link_primary cart-form__link_base-alter']");

    @Step("Проверка, что корзина не пустая")
    public boolean checkCartIsNotEmpty() {
        return cartList.should(Condition.exist).exists();
    }

    @Step("Проверка на сушествование предмета {0} в корзине")
    public boolean checkIfSpecifiedItemExistInCart(String name) {
        return cartList.exists() && itemsList.find(Condition.text(name)).exists();
    }

}
