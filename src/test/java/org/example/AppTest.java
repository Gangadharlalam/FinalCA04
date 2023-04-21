package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.annotation.concurrent.ThreadSafe;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

public class AppTest {
    WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeClass
    void setupDriver(String browser, String link) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        Thread.sleep(15000);
        driver.manage().window().maximize();

    }
    @Test
    void getTitlefrompage() throws InterruptedException {
//        driver.findElement(By.xpath("//*[@id=\"wrapper\"]"));
//        Thread.sleep(10000);
        driver.findElement(By.id("dropdowm-menu-1")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-1\"]/option[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("dropdowm-menu-2")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-2\"]/option[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("dropdowm-menu-3")).click();
        driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-3\"]/option[3]")).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//input[@value='option-2']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@value='option-3']")).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//input[@value='yellow']")).click();
        Thread.sleep(1000);

    }
}
