package com.pw;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Selectors {

    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";
    Page page;

    void setUp()
    {
        try (Playwright playwright = Playwright.create())
        {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(4000));
            page = browser.newPage();
            page.navigate(home);
        }
    }

    // Selecting by Test
    @Test
    public void textSelectorsTest() {

            setUp();
            page.click("text=More Info");
            Assertions.assertEquals(page.title(), "Advantages");

    }

    @ParameterizedTest
    @ValueSource(strings = {"text=More Info","text=more info","'More Info'"})
    public void textSelectorsTestWithParameterized(String stringSelector)
    {
            setUp();
            page.click(stringSelector);
            Assertions.assertEquals(page.title(),"Advantages");
    }


    // Selecting by ID
    @Test
    public void _IDSelectorsTest() {

            setUp();
            page.fill("id=surnameInput","Abdullah");
            page.fill("data-test-id=surnameInput","Sarah");
           // page.fill("my-id=surnameInput","Asmaa"); //  will get error for sure

    }

    // Selecting by CSS Selectors
    @Test
    public void _CSSSelectorsTest() {

        setUp();

        //most generic option
        page.fill("input","first input box that PW finds");

        // finds the FIRST element and fills it in
        page.fill(".form-control","First box with this class");

        // works too, but still wrong
        page.fill("from #exampleFormControlInput1","Combined");

        // works, but overkill
        page.fill(":nth-match(.form-control,2)","Hello there MR.Divo");

    }

}
