package ders12_WebTable_excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class D02_readExcel {

    @Test
    public void test01() throws IOException {


        String dosyaYolu="src/test/java/ders12_WebTable_excel/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sheet=workbook.getSheet("Sayfa1");




    }
}
