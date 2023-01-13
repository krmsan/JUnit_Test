package ders11_SeleniumWait_cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class D04 extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.END).perform();


        List<WebElement>tumbody=driver.findElements(By.xpath("//tbody"));
        List<WebElement> list=new ArrayList<>();
        WebElement[][]webarr=new WebElement[10][13];

        String str="";
        WebElement web= driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
        for (int i = 1; i <9 ; i++) {

            if (i%2!=0) {
                for (int j = 1; j < 9; j++) {
                    if (j % 2 != 0) {
                        webarr[i - 1][j - 1] = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]"));

                    }else webarr[i - 1][j - 1] =web;
                }
            }
        }
        str+=webarr[6][6].getText();
        System.out.println(str);
        System.out.println("==========");
        System.out.println(list);

        //ReusableMethods.tablodanElementGetir(2,2);

    }

    }
