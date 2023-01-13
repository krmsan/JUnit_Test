package ders06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    int p1=60;
    int p2=66;
    int p3=70;
    @Test
    public void test01(){
        Assert.assertTrue(p2>65);
    }
    @Test
    public void test02(){
        Assert.assertFalse(p1>65);

    }
    @Test
    public void test03(){
        //p3 un emekli olamayacagini test edin
        Assert.assertFalse("yasımız 70 oldugundan emekli olabilir",p3>65);
    }
}
