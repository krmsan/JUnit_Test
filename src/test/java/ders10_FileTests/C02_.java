package ders10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_ extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. MerhabaJava.txt dosyasını indirelim
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void test01(){

        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.linkText("MerhabaJava.txt")).click();

        ReusableMethods.bekle(7);

       String dosyaYolu=System.getProperty("user.home")+"/Downloads/MerhabaJava.txt";//
        //String dosyaYolu="/Users/mac/Downloads/MerhabaJava.txt";//yada boyle

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));










    }
    @Test
    public void test02(){


       // String dosyaYolu="/Users/mac/Desktop/fileJunit.txt";

        String dosyaYolu= System.getProperty("user.home")+"/Desktop/fileJunit.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }


}
