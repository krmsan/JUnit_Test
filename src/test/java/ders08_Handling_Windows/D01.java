package ders08_Handling_Windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class D01 {
    WebDriver driver;
    String ilkSayfaHandleDegeri;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        // Testin ilerleyen asamalarinda yeniden amazon sayfasina donmek gerekiyorsa
        // amazon sayfasindayken bu window'un window handle degerini alip kaydetmeliyiz
        ilkSayfaHandleDegeri = driver.getWindowHandle();



        String actualUrl= driver.getCurrentUrl();
        String expectedKelime ="amazon";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        ReusableMethods.bekle(2);
        driver.switchTo().newWindow(WindowType.TAB);
        ReusableMethods.bekle(5);

    }

    @Test
    public void test02() {
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");

        String actualUrl= driver.getCurrentUrl();
        String expectedKelime ="wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        ReusableMethods.bekle(3);

        // wisequarter testini yaptiktan sonra
        // yeniden amazon'un acik oldugu tab'a gecin
        // ve amazon anasayfanin acik oldugunu test edin

        driver.switchTo().window(ilkSayfaHandleDegeri);//burası null olur
        // ilk method daki degeri kaydetmedik method calıstı bitti



    }

}
