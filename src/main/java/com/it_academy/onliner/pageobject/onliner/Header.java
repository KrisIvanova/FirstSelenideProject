package com.it_academy.onliner.pageobject.onliner;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class Header extends BasePage {

    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTER =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    private final ElementsCollection footerElements =
            $$x("//li[contains(@class, 'footer')]");

    public CatalogPage clickOnMainNavigationLink(String link) {
        $x(format(MAIN_NAVIGATION_LINK_XPATH_PATTER, link))
                .shouldBe(visible, ofSeconds(30))
                .click();
        return new CatalogPage();
    }

    public List<String> getTitlesOfFooterElements() {
        return footerElements.texts();
    }
}
