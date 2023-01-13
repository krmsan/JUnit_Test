package ders10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_ extends TestBase {

    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim -ama yolu gönderecegiz click() yapmıyoruz
        WebElement buton=driver.findElement(By.id("file-upload"));
        //bu elemente sendKeys yapıcagiz
        String dosyaYolu=System.getProperty("user.home")+"/Desktop/fileJunit.txt";
        buton.sendKeys(dosyaYolu);
        //simdi upload a basalım
        driver.findElement(By.id("file-submit")).click();
        //simdi  //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yazi_h3tagi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yazi_h3tagi.isDisplayed());
        ReusableMethods.bekle(2);




        /*
             Bu gorevi yapabilmek icin chooseFile butonuna basildiginda
             acilan bilgisayarimizdaki file dosyalarini click yapabilmeemiz gerekir
             ancak Selenium bilgisayarimizdaki dosyalari click yapamaz
             Bunun yerine soyle bir cozum uretilmistir
             1- chooseFile butonunu locate edin
             2- upload edilecek dosyanin dosya yolunu olusturun
             3- chooseFile butonuna sendKeys ile dosya yolunu gonderin
         */






    }


}
