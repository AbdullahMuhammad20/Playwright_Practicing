package com.pw;

import com.microsoft.playwright.Keyboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PressOptions extends ScriptBase{

    @Test
    public void pressOptions()
    {
        page.navigate(home);

        page.fill("#exampleFormControlInput1","abdmohamed033@gmail.con"); // write an email with typo mistake

        Keyboard kb = page.keyboard();

        kb.press("Backspace");

        kb.press("m");

        page.focus("#contactReason");

        kb.press("ArrowDown");
        kb.press("ArrowDown");


        // this step just for assertion
        Assertions.assertTrue(page.isVisible("text=OK, but please make it interesting"));

    }
}
