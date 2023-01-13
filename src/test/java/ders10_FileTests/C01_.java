package ders10_FileTests;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_ {


    @Test
    public void test01() throws FileNotFoundException {

        String dosyaYolu="/Users/mac/Desktop/fileJunit.txt";


        FileInputStream fis=new FileInputStream(dosyaYolu);//java ile dosya okumak için

        File inFile = new File("/Users/mac/Desktop/fileJunit.txt");

        FileReader ins = null;

        try {
            ins = new FileReader(inFile);

            int ch;
            while ((ch = ins.read()) != -1) {
                System.out.print((char) ch);//Merhaba yı yazdırdık

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                ins.close();
            } catch (Exception e) {
            }
        }
        System.out.println(fis);//java.io.FileInputStream@2bbaf4f0




        System.out.println(System.getProperty("user.dir"));///Users/mac/IdeaProjects/com.JUnit1
        System.out.println(System.getProperty("user.home"));///Users/mac

        String dinamikDosyaYolu=System.getProperty("user.home")+"/Dekstop/fileJunit.txt";

        System.out.println(dinamikDosyaYolu);///Users/mac/Dekstop/fileJunit.txt

       // Assert için
        // Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); //yapiyoruz.





    }
}
