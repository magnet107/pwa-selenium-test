package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileResponsivenessTest {

    public static void main(String[] args) {
        testMobileResponsiveness();
    }

    public static void testMobileResponsiveness() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=360,640");
        WebDriver mobileDriver = new ChromeDriver(options);

        mobileDriver.get("http://localhost:6789");

        WebElement usernameInput = mobileDriver.findElement(By.id("username"));
        WebElement passwordInput = mobileDriver.findElement(By.id("password"));
        WebElement loginButton = mobileDriver.findElement(By.cssSelector(".button"));


        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("admin123");


        loginButton.click();

        WebDriverWait wait = new WebDriverWait(mobileDriver, 1);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        if (successMessage.getText().equals("Password Not Valid")) {
            System.out.println("Test Case 1 Passed: Password is not valid");
        }

        usernameInput.clear();
        passwordInput.clear();
        mobileDriver.navigate().back();
        mobileDriver.navigate().refresh();

        mobileDriver.quit();
    }
}
