package ders12_WebTable_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class D01 extends TestBase {
    //1. “https://demoqa.com/webtables” sayfasina gidin
    // 2. Headers da bulunan basliklari yazdirin
    // 3. 3.sutunun basligini yazdirin
    // 4. Tablodaki tum datalari yazdirin
    // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
    // 6. Tablodaki satir sayisini yazdirin
    // 7. Tablodaki sutun sayisini yazdirin
    // 8. Tablodaki 3.kolonu yazdirin
    // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    @Test
    public void test01(){

        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin
       /*
        List<WebElement>baslıklarlist = driver.findElements(By.xpath("//*[@class='rt-thead -header']"));
        //bu tek bir eleman liste atmana gerek yoktu
        String[] baslıklar=new String[baslıklarlist.size()];
        int a=0;
        for (WebElement each:baslıklarlist
             ) {
           baslıklar[a]=each.getText();
           a++;
        }
        System.out.print(Arrays.toString(baslıklar));

        */
        WebElement headerElementi= driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("basliktaki bilgiler : "+headerElementi.getText());

        // 3. 3.sutunun basligini yazdirin

        //List<WebElement> baslist = driver.findElements(By.xpath("//*[@class='rt-thead -header']"));//
        //bu oluyor cunku bunu tek eleman gibi goruyor
        //System.out.println(baslıklar[0]);

        //alttakini kullan
        List<WebElement> basliklarListesi= driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("3.sutunun basligi : " + basliklarListesi.get(2).getText());


        // 4. Tablodaki tum datalari yazdirin
       // List<WebElement>listdata=driver.findElements(By.xpath("//"));

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        // 6. Tablodaki satir sayisini yazdirin
        // 7. Tablodaki sutun sayisini yazdirin
        // 8. Tablodaki 3.kolonu yazdirin
        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
    }
}
