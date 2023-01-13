package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

public class Q2 extends TestBase {



    //              ..Exercise2...
//  http://www.bestbuy.com 'a gidin,
//  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
//  Ayrica Relative Locator kullanarak;
//      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
//  Ayrica Relative Locator kullanarak;
//      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin


    @Before
    public void setUpclas(){
        driver.get("http://www.bestbuy.com");
    }

    @Test
    public void title(){



        // http://www.bestbuy.com 'a gidin,
        //driver.get("http://www.bestbuy.com");
        //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String act=driver.getTitle();
        String exp="Best";

        System.out.println(act);//bunu baslıgı gormek için bir yaz sonra sil
        Assert.assertTrue(act.contains(exp));

        //  Ayrica Relative Locator kullanarak;
        //      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        //  Ayrica Relative Locator kullanarak;
        //      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
    }
    @Test
    public void logo(){

        //  Ayrica Relative Locator kullanarak;
        WebElement hello=driver.findElement(By.xpath("//div[text()='Hello!']"));
       WebElement logo= driver.findElement(RelativeLocator.with(By.tagName("img")).above(hello));

        //      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        Assert.assertTrue(logo.isDisplayed());



    }
    @Test
    public void mexico(){
        //  Ayrica Relative Locator kullanarak;
        //      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
        //(//img[@alt='United States'])[1] veya (//h4[text()='United States'])[1]
        WebElement usa=driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mex=driver.findElement(RelativeLocator.with(By.tagName("*")).toRightOf(usa));//* koyunca bile calısr
        //WebElement mex=driver.findElement(RelativeLocator.with(By.tagName("h4")).toRightOf(usa));//* koyunca bile calısr
        //WebElement mex=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usa));//* koyunca bile calısr
        Assert.assertTrue(mex.isDisplayed());
    }
}
