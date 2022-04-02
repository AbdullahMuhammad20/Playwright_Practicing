package com.pw;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClickFillOptions extends ScriptBase{


    @Test
    public void clickOptionCount()
    {
        page.navigate(home);
        page.click("#clap-image", new Page.ClickOptions().setClickCount(2));
        Assertions.assertTrue(page.isVisible("#thank-you-2"));
        //OR
        Assertions.assertTrue(page.isVisible("text=You can only clap once, but thanks for your enthusiasm."));

        page.click("#any-selector",new Page.ClickOptions().setButton(MouseButton.RIGHT));

    }

    // How to type with fill options
    @Test
    public void fillOptions()
    {
        page.navigate(home);
        // Playwright internally checks that the element is visible, is not disable, and so on...
        // use overloading to write with fill option into text area
        page.fill("id=exampleMessage","So I was thinking the other way..."
                                        , new Page.FillOptions().setForce(true));
    }

    @Test
    public void checkFeature()
    {
        page.navigate(home);
        page.fill("#exampleFormControlInput1","abdmohamed033@gmail.com");
        page.fill("#exampleMessage","Hello from Egypt");


        // This way to know how to click on check-box and unCheck also
        page.check("#sendCopy");
        //page.uncheck("#sendCopy"); //  Here will uncheck the box is checked before

        page.click("#submit-contact");
        Assertions.assertTrue((page.isVisible("text=We sent you a copy of your message : Hello from Egypt")));
    }
}
