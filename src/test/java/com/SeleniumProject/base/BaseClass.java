package com.SeleniumProject.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static FileReader fr;
    public static FileReader fr1;
    public static Properties p;
    public static WebDriverWait wait;

    @BeforeTest
    public void setup() throws IOException {

        if (driver == null) {
            String configproperties_path = System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties";
            String locatorproperties_path = System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\locators.properties";
            fr = new FileReader(configproperties_path);
            fr1 = new FileReader(locatorproperties_path);

            p = new Properties();
            p.load(fr);
            p.load(fr1);
        }
        if (p.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(p.getProperty("baseURL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }

        else if(p.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(p.getProperty("baseURL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }

        else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.get(p.getProperty("baseURL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }
    }

    @AfterTest
    public void teatdown(){

        //driver.quit();
    }

    public void login(){
        driver.findElement(By.linkText(p.getProperty("signin_link"))).click();
        driver.findElement(By.id(p.getProperty("email_field"))).sendKeys("akila.sabherath@gmail.com");

        WebElement nextBtn = driver.findElement(By.id(p.getProperty("next_button")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", nextBtn);

//        driver.findElement(By.id("nextbtn")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(p.getProperty("password_field")))).sendKeys("PassworD394@033");

//        driver.findElement(By.id("nextbtn")).click();

        WebElement signin = driver.findElement(By.id(p.getProperty("login_next_button")));
        executor.executeScript("arguments[0].click();", signin);
    }
}

