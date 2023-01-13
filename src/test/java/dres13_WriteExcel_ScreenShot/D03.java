package dres13_WriteExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class D03 extends TestBase {


    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);


        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String exp = "Nutella";
        String act = sonuc.getText();
        Assert.assertTrue(act.contains(exp));

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);

        String dosyayolu="target/ekranRresimleri/tumEkranSS"+tarih+".png";



        TakesScreenshot tss = (TakesScreenshot) driver;
       // File tumsayfa_screenshot = new File("target/ekranRresimleri/tumEkranSS.png");
        File tumsayfa_screenshot = new File(dosyayolu);

        File gecicidosya = tss.getScreenshotAs(OutputType.FILE);





        FileUtils.copyFile(gecicidosya, tumsayfa_screenshot);

        ReusableMethods.tumsayfaScreenShotCek(driver);

        ReusableMethods.elementResmiCek(sonuc);

        ReusableMethods.bekle(3);


    }

    private void tumsayfaScreenShotCek() throws IOException {
        // 1- TakeScreenshot objesi olustur
        TakesScreenshot tss = (TakesScreenshot) driver;
// 2- resmi son olarak kaydedecegimiz dosyayi olustur
        File tumSayfaScreenshot = new File("target/ekranResimleri/tumEkranSS.jpeg");
// 3- tss objesi kullanarak ekran goruntusu alip, gecici dosyaya kaydet
        File geciciDopsya = tss.getScreenshotAs(OutputType.FILE);
// 4- gecici dosyayi ana dosyaya kopyala
        FileUtils.copyFile(geciciDopsya, tumSayfaScreenshot);
    }
}
