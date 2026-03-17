package org.example;

import com.microsoft.playwright.*;

public class DemoQAtest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page page = browser.newPage();

        page.navigate("https://demoqa.com/automation-practice-form");

        //  ნეგატიური ტესტი (ცარიელი ფორმა) ---

        page.click("#submit");
        // არ გაეშვა, გაწითლდა*/

       /* // არასწორი ნომერი მობილური
        System.out.println("არასწორი ნომრიტ");
        page.fill("#userNumber", "123");
        page.click("#submit");
        //გაწითლდა */

        // --- ნაწილი 3: სწორი მონაცემები (Happy Path) ---

        page.fill("#firstName", "Tamar");
        page.fill("#lastName", "Kurtsikashvili");
        page.fill("#userEmail", "tamar@email.com");
        page.click("text=Female");

        // ვასწორებთ ნომერს სწორით
       page.fill("#userNumber", "5551234567");

        page.click("#submit");

        // ვამოწმებთ გამოჩნდა თუ არა დადასტურების ფანჯარა
        if (page.isVisible(".modal-content")) {
            System.out.println("წარმატებული");
        }

        page.waitForTimeout(3000);
        browser.close();
        playwright.close();
    }
}