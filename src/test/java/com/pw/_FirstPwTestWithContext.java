package com.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class _FirstPwTestWithContext extends  ScriptBase
{
    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";


    @Test
    public void firstPlayWrightTestWithContext() {
            page.navigate(home);
            Assertions.assertEquals(page.title(),"Home Page");

    }


    @Test
    public void secondPlayWrightTestWithContext() {
            page.navigate(home);
            String content = page.content();
            Assertions.assertTrue(content.contains("Cat In The Bag"));

    }


}
