package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PWATestOne {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:6789");

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".button"));
        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("admin123");
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        if (successMessage.getText().equals("Login successfull")) {
            System.out.println("Test Case 1 Passed: Valid Login");
        } else {
            System.out.println("Test Case 1 Failed: InValid Login");
        }

        usernameInput.clear();
        passwordInput.clear();
        driver.navigate().back();
        driver.navigate().refresh();


        driver.quit();
    }
}

