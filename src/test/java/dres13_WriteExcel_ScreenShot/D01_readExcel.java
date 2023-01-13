package dres13_WriteExcel_ScreenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class D01_readExcel {

    @Test
    public void test01() throws IOException {
        String dosyayolu = "src/test/java/ders12_WebTable_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyayolu);

        Workbook w= WorkbookFactory.create(fis);
        String str=w.getSheet("Sayfa1").getRow(0).getCell(0).toString();//Ülke (İngilizce)
        System.out.println(str);

        dataYazdir(25,2);
    }

    private void dataYazdir(int satir, int sutun) throws IOException {

        String dosyayolu = "src/test/java/ders12_WebTable_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyayolu);

        Workbook w= WorkbookFactory.create(fis);
        String str=w.getSheet("Sayfa1").getRow(satir).getCell(sutun).toString();
        System.out.println(str);
    }


}
