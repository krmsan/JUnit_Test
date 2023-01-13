package dres13_WriteExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class D05_elementSS extends TestBase {


    @Test
    public void test01() throws IOException {





        driver.get("https://www.amazon.com");

        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);


        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String exp = "Nutella";
        String act = sonuc.getText();
        Assert.assertTrue(act.contains(exp));


        /*
        File elementSS=new File("target/ekranResimleri/elementSS.png");

        File gecici=sonuc.getScreenshotAs(OutputType.FILE);// burda artık tss yok TakesScreenShot ---elementi yaz sonuc

        FileUtils.copyFile(gecici,elementSS);


         */


        ReusableMethods.elementResmiCek(sonuc);




    }




}
