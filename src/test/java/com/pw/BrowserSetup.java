package com.pw;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BrowserSetup
{
    @Test
    public void browserSupport()
    {
        try(Playwright pw = Playwright.create())
        {
            List<BrowserType> browserTypes = List.of(pw.chromium(),pw.firefox(),pw.webkit());
            for (BrowserType type : browserTypes)
            {
                Page page = type.launch().newPage();
                page.navigate("https://playwright.dev/");
            }
        }
    }
}
