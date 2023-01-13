package dres13_WriteExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class D04 extends TestBase {

    //WebDriver driver;bunu kabul etmez diğer classlarda hata var

    @Test
    public void test01() {//static degil driveri static yaparsan burda görur ama setUp() method için
        //  Method setUp() should not be static der

        driver.get("https://www.amazon.com");
        ReusableMethods.tumsayfaScreenShotCek(driver);


        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("sallanan koltuk");
        aramakutusu.submit();
        ReusableMethods.bekle(3);
        WebElement sonuclar= driver.findElement(By.xpath("//*[@class='sg-col-14-of-20 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
        ReusableMethods.elementResmiCek(sonuclar);



    }
}
