package ders11_SeleniumWait_cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class D03_webtable extends TestBase {
    //1.“https://www.amazon.com” adresine gidin



    @Test
    public void teat01(){
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //3.Web table tum body’sini yazdirin
        //WebElement tumbody=driver.findElement(By.xpath("//tbody"));
        List<WebElement> tumbody2=driver.findElements(By.xpath("//tbody"));
        List<String>tbodylist=new ArrayList<>();
        // System.out.println(tumbody.getText());bunu yazmadı
        for (int i = 0; i < tumbody2.size(); i++) {
            WebElement tbody=tumbody2.get(i);
            tbodylist.add(tbody.getText());
        }
        System.out.println(tbodylist);


        System.out.println("==================");


        String bodytext="";
        for (WebElement each: tumbody2
             ) {

           bodytext+="\n "+ each.getText();
        }

        System.out.println(bodytext);
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        ////tbody/tr

        //5.Tum satirlari yazdirin
        //tbody/tr

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        //tbody/tr[1]/td
        //7. 5.sutunu yazdirin
        //tbody/tr/td[5]
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun


    }
}
