package com.pw;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;

public class LocatorExample extends ScriptBase
{

    @Test
    public void locatorExample()
    {
        page.navigate(home);

        // Get list of elements using CSS selector and  how to interact with all of them!
        Locator input=  page.locator(".form-control");

        System.out.println(input.count());

        // Get the first element and type into it
        input.first().fill("First");

        // Get the last element and type into it
        input.last().fill("Last");

        // How to get specific element with specific number and act with it
        input.nth(1).fill("Second"); // should be 2nd element at index 1

    }
}
