package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestManifest {
    public static void main(String[] args) {
            testManifest();
    }
    public static void testManifest() {

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:6789");

        WebElement manifestLink = driver.findElement(By.cssSelector("link[rel='manifest']"));
        if (manifestLink != null) {
            System.out.println("Manifest link is present.");
        } else {
            System.out.println("Manifest link is not present.");
        }
        driver.quit();
    }
}
