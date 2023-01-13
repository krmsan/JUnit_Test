package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ReusableMethods {


    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }
    public static void bekle2(int sn) throws InterruptedException {//bu olmadı usttekini kullan
        Thread.sleep(sn*1000);
    }



    public static String ikinciSayfaWHD(Set<String> tumWHDSeti,String ilkSayfaWHD){
        String ikinciSayfaWHDstr="";

        for (String eachWHD: tumWHDSeti
        ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHDstr= eachWHD;
            }
        }
        return ikinciSayfaWHDstr;
    }

    public static String tablodanElementGetir(int satir,int sutun){//calısmadı bura sonra silebilirsin

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        String str= driver.findElement(By.xpath("//tbody/tr["+satir+"]/td["+sutun+"]")).getText();

        System.out.println(str);
        return str;
    }


    public static void tumsayfaScreenShotCek(WebDriver driver)  {


        TakesScreenshot tss= (TakesScreenshot) driver;

        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);

        String dosyaYolu="target/ekranResimleri/sayfaResmi"+tarih+".png";


        File sayfaSS=new File(dosyaYolu);

        File temp= tss.getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(temp,sayfaSS);
        } catch (IOException e) {

        }



    }

    public static void elementResmiCek(WebElement element) {

        //TakesScreenshot tss= (TakesScreenshot) driver; burda bu yok element veriyoruz

        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);

        String dosyaYolu="target/ekranResimleri/sayfaResmi"+tarih+".png";


        File sayfaSS=new File(dosyaYolu);

        File temp =element.getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(temp,sayfaSS);
        } catch (IOException e) {

        }


    }
}
