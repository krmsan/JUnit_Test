package dres13_WriteExcel_ScreenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class D02_WriteExcel {

    @Test
    public void test01() throws IOException {
        String dosyayolu = "src/test/java/ders12_WebTable_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyayolu);

        Workbook w= WorkbookFactory.create(fis);
        //okurken
        //  w.getSheet("Sayfa1").getRow(0).getCell(0);.

        //5.sutun f suutunu oluyor A=0
        w.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");


        //3.satir
        w.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue(1500000);

        //7.satir
        w.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue(3000000);


        FileOutputStream fos=new FileOutputStream(dosyayolu);
        w.write(fos);

        w.close();//workbook
        fis.close();
        fos.close();








    }




}
