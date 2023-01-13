package ders11_SeleniumWait_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class D02_cookies extends TestBase {

    //Yeni bir class olusturun : cookiesAutomation
    //1- Amazon anasayfaya gidin
    @Test
    public void test01(){

        driver.get("https://www.amazon.com");


        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesseti = driver.manage().getCookies();
        int sirano=1;
        for (Cookie each:cookiesseti
             ) {
            System.out.println(sirano+"-"+each);
            sirano++;
        }
        /*
        1-sp-cdn="L5Z9:TR"; expires=Paz, 31 Ara 2023 07:10:24 TRT; path=/; domain=.amazon.com;secure;
2-i18n-prefs=USD; expires=Paz, 31 Ara 2023 07:10:24 TRT; path=/; domain=.amazon.com
3-ubid-main=130-6794405-5810409; expires=Paz, 31 Ara 2023 07:10:25 TRT; path=/; domain=.amazon.com;secure;
4-session-id-time=2082787201l; expires=Paz, 31 Ara 2023 07:10:24 TRT; path=/; domain=.amazon.com;secure;
5-skin=noskin; path=/; domain=.amazon.com
6-session-token="lDChsz9pjOQLBgSglTY11sAlqLlUUFXWS2F26FwhvUXSeQZQsneBkWg9zg+mqqOOZ1NIqcLk/uw0NoQzYkc7O1P7TF4VHzx0nuzCm41E/afV5Y7eX/qTOEMUrbggOUtVQAQbERcKR9jMP8BGxi6Smz5djiM6EcIOsWZ6xgRyCgAmY8+d9woKMs6r27bf9ro+F3gmWrYpdqxo+9IIl3jC+QQnwm5uQMb3oAEzien9ot0="; expires=Paz, 31 Ara 2023 07:10:26 TRT; path=/; domain=.amazon.com;secure;
7-csm-hit=tb:s-9VX7C6ZGRPJ5PDHC8BFC|1672503024518&t:1672503025412&adb:adblk_no; expires=Cmt, 16 Ara 2023 07:10:25 TRT; path=/; domain=www.amazon.com
8-session-id=143-5265727-3932763; expires=Paz, 31 Ara 2023 07:10:24 TRT; path=/; domain=.amazon.com;secure;
         */



        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesseti.size()>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String exp="USD";
        String act="";
        for (Cookie each:cookiesseti
             ) {
            if (each.getName().equals("i18n-prefs")) {
                act=each.getValue();

            }
        }
        Assert.assertEquals(exp,act);






        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin

        Cookie benimcookie=new Cookie("en sevdigim","cikolatali");

        driver.manage().addCookie(benimcookie);
        cookiesseti=driver.manage().getCookies();

        for (Cookie each:cookiesseti
             ) {
            List<Cookie>l=new ArrayList<>();
            l.add(each);
            l.add(benimcookie);
            System.out.println("============");
            System.out.println(l);
        }
        System.out.println(cookiesseti);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        String expdegeri="cikolatali";
        act="";
        int cikolatalısayısı=0;
        for (Cookie each:cookiesseti
             ) {
            if (each.getName().equals("en sevdigim")){
                cikolatalısayısı++;
            }
        }
        Assert.assertTrue(cikolatalısayısı>0);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin


        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();
        cookiesseti=driver.manage().getCookies();
        Assert.assertEquals(0,cookiesseti.size());

    }





}
