package org.example;

import com.microsoft.playwright.*;

public class DemoQAtest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page page = browser.newPage();

        page.navigate("https://demoqa.com/automation-practice-form");

        //  ცარიელი ფორმა

        page.click("#submit");
        // არ გაეშვა, გაწითლდა */

       /* // არასწორი ნომრიტ
        
        page.fill("#userNumber", "123");
        page.click("#submit");
        //გაწითლდა */

        // სწორი მონაცემებით

        page.fill("#firstName", "Tamar");
        page.fill("#lastName", "Kurtsikashvili");
        page.fill("#userEmail", "tamar@email.com");
        page.click("text=Female");


       page.fill("#userNumber", "5551234567");

        page.click("#submit");


        if (page.isVisible(".modal-content")) {
            System.out.println("წარმატებული");
        }

        page.waitForTimeout(3000);
        browser.close();
        playwright.close();
    }
}