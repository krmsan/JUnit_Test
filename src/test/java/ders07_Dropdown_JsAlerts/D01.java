package ders07_Dropdown_JsAlerts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class D01 extends TestBase {

    @Test
    public void test01(){

        driver.get("https://amazon.com");
        List<WebElement> frames= driver.findElements(By.xpath("//iframe"));
        System.out.println(frames.size());//size

    }
}
