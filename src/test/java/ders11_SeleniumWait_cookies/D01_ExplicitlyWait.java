package ders11_SeleniumWait_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class D01_ExplicitlyWait {



    //presence var oluncaya kadar
    // .


    protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void teardown(){
        driver.quit();
    }
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //  Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitWaittest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removebutton=driver.findElement(By.xpath("//button[text()='Remove']"));
        removebutton.click();
        WebElement itsgoneyazi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsgoneyazi.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']")).click();
        WebElement itsblackyazi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsblackyazi.isDisplayed());
    }
    @Test
    public void explicitWaittest(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Remove']")).click();

       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

       WebElement isgoneelementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
       Assert.assertTrue(isgoneelementi.isDisplayed());


        //ReusableMethods.bekle(5);bunu yazınca calısır yoksa nosuchElement diyor
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));veya bunu yazmalısın


        WebElement itsgoneyazi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsgoneyazi.isDisplayed());


    }
}
