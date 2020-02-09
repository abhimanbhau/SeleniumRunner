package io.github.abemurica.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommandProcessor {
    public static void processCommand(String command, String xpath, String value, ChromeDriver driver) throws InterruptedException {
        switch (command) {
            case "load":
                System.out.println(String.format("%s %s", command, xpath));
                driver.get(xpath);
                break;
            case "input":
                driver.findElementByXPath(xpath).sendKeys(value);
                break;
            case "click":
                driver.findElementByXPath(xpath).click();
                break;
            case "wait":
                Thread.sleep(Integer.parseInt(value));
                break;
            case "save-imgs":
                for (WebElement e : driver.findElementsByTagName("img")) {
                    ImageDownloader.saveImage(e.getAttribute("src"), e.getAttribute("alt"));
                }
                break;
            default:
                ;
        }
    }
}
