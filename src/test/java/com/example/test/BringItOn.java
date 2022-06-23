package com.example.test;

import com.example.page.pastebin.PasteBinHomePage;
import com.example.page.pastebin.PastePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
1. Открыть https://pastebin.com  или аналогичный сервис в любом браузере
2. Создать New Paste со следующими деталями:
    - Код:
        git config --global user.name  "New Sheriff in Town"
        git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
        git push origin master --force
    - Syntax Highlighting: "Bash"
    - Paste Expiration: "10 Minutes"
    - Paste Name / Title: "how to gain dominance among developers"
3. Сохранить paste и проверить следующее:
    - Заголовок страницы браузера соответствует Paste Name / Title
    - Синтаксис подвечен для bash
    - Проверить что код соответствует введенному в пункте 2
*/

public class BringItOn extends AbstractTest {

    private static final String PASTE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String PASTE_SYNTAX_HIGHLIGHTING = "Bash";
    private static final String EXPECTED_SYNTAX_HIGHLIGHTING = "bash";
    private static final String PASTE_EXPIRATION_TIME = "10 Minutes";
    private static final String PASTE_TITLE = "how to gain dominance among developers";

    @Test
    public void verifyPasteTitle() {
        createNewPaste();
        Assert.assertEquals(driver.getTitle(), String.format("%s - Pastebin.com", PASTE_TITLE));
    }

    @Test
    public void verifyPasteSyntaxHighlighting() {
        Assert.assertEquals(createNewPaste().getPasteSyntaxHighlighting(), EXPECTED_SYNTAX_HIGHLIGHTING);
    }

    @Test
    public void verifyPasteText() {
        Assert.assertEquals(createNewPaste().getPasteText(), PASTE_TEXT);
    }

    private PastePage createNewPaste() {
        return new PasteBinHomePage(driver)
                .openPage()
                .inputPaste(PASTE_TEXT)
                .setSyntaxHighlighting(PASTE_SYNTAX_HIGHLIGHTING)
                .setExpiration(PASTE_EXPIRATION_TIME)
                .setTitle(PASTE_TITLE)
                .submitNewPaste();
    }
}
