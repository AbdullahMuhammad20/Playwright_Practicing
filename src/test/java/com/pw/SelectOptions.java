package com.pw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectOptions extends ScriptBase{

    @Test
    public void checkFeature()
    {
        page.navigate(home);

        // Note That! we not pass the text display to the user, we will pass the value for the specific option
        page.selectOption("id=contactReason","Bored");

        // this step just for assertion
        Assertions.assertTrue(page.isVisible("text=OK, but please make it interesting"));
    }
}
