package ders09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_DragAndDrop extends  TestBase {


    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim



        //=================

        WebElement dragMeElementi=driver.findElement(By.id("draggable"));
        WebElement birakilacakAlanElementi=driver.findElement(By.id("droppable"));//3 tane var ama ilkini getirir

         Actions actions = new Actions(driver);

        actions.dragAndDrop(dragMeElementi,birakilacakAlanElementi).perform();//perform u unutma

        ReusableMethods.bekle(3);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin


        //======================


        WebElement droppedYaziElementi= driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertTrue(birakilacakAlanElementi.isDisplayed());//buda calısır ama drop here yazıyordu bunda

        //Assert.assertTrue(droppedYaziElementi.isDisplayed());

    }


}
