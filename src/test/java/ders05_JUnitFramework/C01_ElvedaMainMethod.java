package ders05_JUnitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMethod {
    @Test //notasyon deniyor
    public void test01() {
        System.out.println("test01 calıstı");
        //@Test notasyonu sayesinde her method bagimsiz olarak calisabilir
        //eger testin içinde assertion yoksa JUnit passed olarak raporlar
    }

    @Test
    @Ignore //varsa görmezden gel diyoruz
    public void test02() {
        System.out.println("test02 calıstı");
    }

    @Test
    public void test03() {
        System.out.println("test03 calıstı");
    }
}
