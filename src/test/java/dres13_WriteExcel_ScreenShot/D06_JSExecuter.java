package dres13_WriteExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class D06_JSExecuter extends TestBase {




    @Test
    public void test01(){




        driver.get("https://www.amazon.com");

        //sell linkine JS executer ile click yap

        WebElement selllinki=driver.findElement(By.id("nav_cs_4"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("argument[0].click();",selllinki);//bu argumet boyle lazım olursa bak
        jse.executeScript("argument[0].scrollIntoView();",selllinki);//elemente kadar asagı in


        jse.executeScript("alert('Bu İs Bu Kadar');");//





    }
}
