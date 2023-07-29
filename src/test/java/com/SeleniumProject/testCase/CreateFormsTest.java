package com.SeleniumProject.testCase;

import com.SeleniumProject.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class CreateFormsTest extends BaseClass {
    @Test
    public void createForms() throws InterruptedException {
        login();

        WebElement form_link = driver.findElement(By.cssSelector("[href='https://forms.zoho.com.au/']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", form_link);

        driver.findElement(By.id("createFormBtn")).click();

        try {
            // Wait until the element is visible and interactable
            WebElement form_title_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formNameDiv")));

            // Perform actions on the element
            form_title_field.sendKeys("Employee Details");
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable: " + e.getMessage());

        }
        driver.findElement(By.id("createBtn")).click();

    }

}