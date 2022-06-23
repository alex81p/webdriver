package com.example.test;

import com.example.page.pastebin.PasteBinHomePage;
import org.testng.annotations.Test;

/*
1. Открыть https://pastebin.com или аналогичный сервис в любом браузере
2. Создать New Paste со следующими деталями:
    - Код: "Hello from WebDriver"
    - Paste Expiration: "10 Minutes"
    - Paste Name / Title: "helloweb"
*/

public class ICanWin extends AbstractTest {

    private static final String PASTE_TEXT = "Hello from WebDriver";
    private static final String PASTE_EXPIRATION_TIME = "10 Minutes";
    private static final String PASTE_TITLE = "helloweb";

    @Test
    public void notATest(){
        new PasteBinHomePage(driver)
                .openPage()
                .inputPaste(PASTE_TEXT)
                .setExpiration(PASTE_EXPIRATION_TIME)
                .setTitle(PASTE_TITLE)
                .submitNewPaste();
    }
}
