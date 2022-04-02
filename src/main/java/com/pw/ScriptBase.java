package com.pw;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class ScriptBase {

    protected static Playwright playwright;
    protected static Browser browser;

   protected final String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";
   protected BrowserContext context;
   protected Page page;

    @BeforeAll
    static void launchBrowser()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().
                launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    void createContextAndPage()
    {
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920,1080);
    }

    @AfterEach
    void closeContext()
    {
        context.close();
    }

    @AfterAll
    static void closeBrowser()
    {

        browser.close();
        playwright.close();
    }
}
