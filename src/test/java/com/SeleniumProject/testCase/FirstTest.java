package com.SeleniumProject.testCase;

import com.SeleniumProject.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class FirstTest extends BaseClass {

    WebDriverWait wait;
    @Test
    public void test1() throws InterruptedException, IOException {
        driver.findElement(By.linkText(p.getProperty("signin_link"))).click();
        driver.findElement(By.id(p.getProperty("email_field"))).sendKeys("akila.sabherath@gmail.com");

        WebElement nextBtn = driver.findElement(By.id(p.getProperty("next_button")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", nextBtn);

//        driver.findElement(By.id("nextbtn")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(p.getProperty("password_field")))).sendKeys("PassworD394@033");

//        driver.findElement(By.id("nextbtn")).click();

        WebElement signin = driver.findElement(By.id(p.getProperty("login_next_button")));
        executor.executeScript("arguments[0].click();", signin);

    }
}
