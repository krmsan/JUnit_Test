package ders11_SeleniumWait_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utilities.ReusableMethods.tablodanElementGetir;

public class C04_WebTables extends TestBase {

    @Test
    public void test01(){

        // 1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin

        WebElement tumBody= driver.findElement(By.xpath("//tbody"));

        //System.out.println(tumBody);//[[ChromeDriver: chrome on MAC (8e58201628e534a442d91faea6bb4df7)] -> xpath: //tbody]
        //tumbody i yazmaz webelement cunku
        //System.out.println(tumBody.getText().toUpperCase());//boylede yazmıyor
        //4.Web table’daki satir sayisinin 9 oldugunu test edin

        System.out.println("==========gjhgjgkj");

        List<WebElement> satirlarListesi= driver.findElements(By.xpath("//tbody/tr"));
        System.out.println(satirlarListesi.size());
        Assert.assertEquals(10,satirlarListesi.size());

        //5.Tum satirlari yazdirin

        for (WebElement eachRow: satirlarListesi
             ) {

            System.out.println(eachRow.getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutunlarListesi= driver.findElements(By.xpath("//tbody/tr[5]/td"));
        System.out.println(sutunlarListesi.size());
        Assert.assertEquals(13, sutunlarListesi.size());
        //7. 5.sutunu yazdirin
        List<WebElement> sutunList= driver.findElements(By.xpath("//tbody/tr/td[5]"));
        List<String> stlist=new ArrayList<>();
        for (WebElement each:sutunList
             ) {
            stlist.add(each.getText());
        }

        System.out.println(stlist);
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println("==========gjhgjgkj");

        WebElement webElement= getElement(3,3);
        System.out.println(webElement.getText());


        ReusableMethods.bekle(5);
    }


    private WebElement getElement(int satir,int sutun) {

        WebElement webElement= driver.findElement(By.xpath("//tbody/tr["+satir+"]/td["+sutun+"]"));
        return webElement;
    }








}
