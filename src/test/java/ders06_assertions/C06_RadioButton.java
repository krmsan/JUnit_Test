package ders06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @After
    public void teardown(){}
    @Test
    public void test01(){
        driver.get("https://facebook.com");
        WebElement cb1=driver.findElement(By.xpath("//(button[@title=''])[1]"));////*[@id="checkboxes"]/text()[1]
        WebElement cb2=driver.findElement(By.xpath("/a[@class=‘_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy’]"));
    }
}
