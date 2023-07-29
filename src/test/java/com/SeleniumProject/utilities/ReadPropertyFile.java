package com.SeleniumProject.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    WebDriver driver;
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\akila\\OneDrive\\Desktop\\TesingPortfolio\\SeleniumProjects\\SeleniumProject\\src\\test\\resources\\configFiles\\config.properties");

        Properties p =  new Properties();
        p.load(fr);
        System.out.println(p.getProperty("browser"));
        System.out.println(p.getProperty("baseURL"));
    }

    public void getProperty(String browser) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\akila\\OneDrive\\Desktop\\TesingPortfolio\\SeleniumProjects\\SeleniumProject\\src\\test\\resources\\configFiles\\config.properties");
        Properties p =  new Properties();
        p.load(fr);

        if(p.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.zoho.com/");
        }
    }
}
