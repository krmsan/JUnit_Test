package ders06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AssertionMethodlari {
    static WebDriver driver; //static olamk zorunda

    @BeforeClass// eger boyle sie static olmak zorunda method @BeforeClass , @AfterClass   ise
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        String expectedKelime = "Amazon";
        String actualTitle = driver.getTitle();

       // if (actualTitle.contains(expectedKelime)) System.out.println(" 01 Passed");
       // else System.out.println("01 failed");

        //================
        Assert.assertTrue(actualTitle.contains(expectedKelime));


    }

    @Test //eger @BeforeClass bunu kullanıyorsak test methodları bagımsız calısmayabilir
    public void test02() {
        System.out.println("s\"");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String expectedKelime = "Nutella";
        ////h1[@class="a-size-base s-desktop-toolbar a-text-normal"] bu genis sonuc
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class=\"a-size-base s-desktop-toolbar a-text-normal\"]"));
        String sonucYazisistr = sonucYaziElementi.getText();

        //=======================
        Assert.assertTrue(sonucYazisistr.contains(expectedKelime));

    }

    @Test
    public void test03() {
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class=\"a-size-base s-desktop-toolbar a-text-normal\"]"));
        String sonucYazisistr = sonucYaziElementi.getText();

        String[] sonucyazisiArr = sonucYazisistr.split(" ");
        String sonucAdediStr = sonucyazisiArr[2];
        int actualsonucsayisi = Integer.parseInt(sonucAdediStr);



        //==============
        Assert.assertTrue(actualsonucsayisi>50);

    }

}
