package ders08_Handling_Windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class D02 {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedSayfaYazisi="Opening a new window";
        String actualSayfaYazisi=driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedSayfaYazisi,actualSayfaYazisi);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedSayfaTitle="The Internet";
        String actualsayfaTitle= driver.getTitle();
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        Assert.assertEquals(expectedSayfaTitle,actualsayfaTitle);
        //● Click Here butonuna basın.

        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);


        /*
               Kontrolsuz acilan tab'a gecis yapmak icin
               1- ilk sayfada iken o sayfanin WHD alip kaydedin
               2- 2.sayfa acildiktan sonra getWindowhandles() kullanarak
                  acik olan tum sayfalarin WH degerlerini bir Set olarak kaydedin
               3- su anda elimizde 2 elementli bir Set var,
                  elementlerden bir tanesi 1.sayfanin WHD
                  1.sayfanin WHD'ine esit olmayan ise 2.sayfanin WHD olur
               4- bu sekilde 2.sayfanin WHD elde edildikten sonra
                  WHD'leri kullanilarak sayfalar arasinda gecis yapilabilir
         */

        Set<String> tumWHDegerleriSeti= driver.getWindowHandles();

        String ikinciSayfaWHD="";

        tumWHDegerleriSeti.remove(ilkSayfaHandleDegeri);

        Iterator it1= tumWHDegerleriSeti.iterator();
        ikinciSayfaWHD=(String)it1.next();


        /*
        veya=========>
        tumWHDegerleriSeti.remove(ilkSayfaHandleDegeri);


        for (String eachWhd: tumWHDegerleriSeti
        ) {
                ikinciSayfaWHD=eachWhd;
        }
         */


        /*=================ITERATOR===============
        System.out.println(it1.hasNext()); // true
        System.out.println(it1.next()); //CDwindow-57470158C9B4AFCA33AC41B98CEE2401
        ikinciSayfaWHD=it1.toString();
        System.out.println(ikinciSayfaWHD);//java.util.LinkedHashMap$LinkedKeyIterator@6cf31447
         */




        ReusableMethods.bekle(3);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWHD);//eger bunu yapmasak ilk sayfa yı getirir "The Internet" yazar
        String expectedNewSayfaTitle="New Window";
        String actualNewSayfaTitle= driver.getTitle();

        Assert.assertEquals(expectedNewSayfaTitle,actualNewSayfaTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedYeniSayfaYazi="New Window";
        String actualYenisayfaYazi= driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedYeniSayfaYazi,actualYenisayfaYazi);

        ReusableMethods.bekle(3);
        //● Bir önceki pencereye geri döndükten sonra
        // sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaHandleDegeri);
        expectedSayfaTitle="The Internet";
        actualsayfaTitle= driver.getTitle();

        Assert.assertEquals(expectedSayfaTitle,actualsayfaTitle);


        Thread.sleep(3000);
    }
}


