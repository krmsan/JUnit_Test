package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Q3 extends TestBase {

    // /*
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully
    //     */
    @Test
    public void test1() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement exercisebaslik = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        boolean baslıkgörunurmu = exercisebaslik.isDisplayed();
        Assert.assertTrue(baslıkgörunurmu);
        //4. Click on 'Contact Us' button
        WebElement act = driver.findElement(By.partialLinkText("Contact us"));//linktext olmadı bunda da basdaki boslugu silince oldu
        act.click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement yazi = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(yazi.isDisplayed());


        //6. Enter name, email, subject and message

        WebElement firstname = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        firstname.sendKeys("asd");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB)
                .sendKeys("can@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("subject")
                .sendKeys(Keys.TAB)
                .sendKeys("mesaj")
                .sendKeys(Keys.TAB).perform();
        //7. Upload file
        WebElement button = driver.findElement(By.name("upload_file"));
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/filejunit.txt";
        button.sendKeys(dosyaYolu);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(5);

        //8. Click 'Submit' button

        //driver.findElement(By.xpath("//*[@class='btn btn-primary pull-left submit_form']")).click();
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        ReusableMethods.bekle(3);

        //9. Click OK button
        driver.switchTo().alert().accept();


        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible

        //WebElement succesfullYazisi = driver.findElement(By.xpath("(//div[text()='Success! Your details have been submitted successfully.'])[1]"));
        WebElement succesfullYazisi = driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
        Assert.assertTrue(succesfullYazisi.isDisplayed());
        ReusableMethods.bekle(3);


        //11. Click 'Home' button and verify that landed to home page successfully
        //driver.navigate().back();

        //driver.navigate().forward();


        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        //driver.findElement(By.xpath("(//a[text()=' Home'])[1]")).click();////a[@class='btn btn-success']
       // driver.findElement(By.xpath("(//span[text()=' Home'])[1]")).click();////a[@class='btn btn-success']

       // WebElement iframe=driver.findElement(By.xpath("//iframe[@id='aswift_1']"));
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='ad_iframe']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//div[@id='dismiss-button']"));
        driver.switchTo().defaultContent();
        //driver.findElement(By.xpath("//*[@viewBox='0 0 48 48']")).click();
        ReusableMethods.bekle(3);
        // driver.findElement(By.id("dismiss-button")).click();
        Assert.assertTrue(baslıkgörunurmu);
    }


    public void test2() {
    }

    public void test3() {
    }
}
