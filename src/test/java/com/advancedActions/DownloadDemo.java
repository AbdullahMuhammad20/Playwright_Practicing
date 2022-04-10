package com.advancedActions;

import com.microsoft.playwright.Download;
import com.pw.ScriptBase;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class DownloadDemo extends ScriptBase
{
    // you can use the interfaces about download from here
    @Test
    public void checkDownload()
    {
        // you can use the interfaces about download from here
        page.navigate(home);

        // Interface download contain more than one option
        // InputStream createReadStream();
        // Path path();
        // void saveAS(Path p); >> note that Playwright saves the file to a temporary folder and deletes it after the browser context is closed

        page.onDownload(download -> {
            System.out.println("");
        });

        page.click("text=Download ZIP");

    }
}
