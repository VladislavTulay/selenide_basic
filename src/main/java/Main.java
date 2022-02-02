import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        open("https://catalog.onliner.by/");
        Thread.sleep(3000);
    }

}
