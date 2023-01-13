package ders06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClassAfterClass { //her method dan once 1 kere calısmasını istersen bu @BeforeClass

    //3 method
    //1.de amazona git, gitttigini test et
    //2. method da nutella aratın,nutella icerdigini test et
    //3. de sonucun 50 den fazla oldugunu test et
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

        if (actualTitle.contains(expectedKelime)) System.out.println(" 01 Passed");
        else System.out.println("01 failed");
    }

    @Test //eger @BeforeClass bunu kullanıyorsak test methodları bagımsız calısmayabilir
    public void test02() {
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String expectedKelime = "Nutella";
        ////h1[@class="a-size-base s-desktop-toolbar a-text-normal"] bu genis sonuc
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class=‘a-size-base s-desktop-toolbar a-text-normal’]"));
        String sonucYazisistr = sonucYaziElementi.getText();

        if (sonucYazisistr.contains(expectedKelime)) System.out.println("test02 passed");
        else System.out.println(" test02 failed");


    }

    @Test
    public void test03() {
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class=‘a-size-base s-desktop-toolbar a-text-normal’]"));
        String sonucYazisistr = sonucYaziElementi.getText();

        String[] sonucyazisiArr = sonucYazisistr.split(" ");
        String sonucAdediStr = sonucyazisiArr[2];
        int sonucsayisi = Integer.parseInt(sonucAdediStr);

        if (sonucsayisi >= 50) {

            System.out.println("03 passed");

        } else System.out.println("03 failed");

    }


}
