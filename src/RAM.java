import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.time.LocalDate;
import java.util.Arrays;

public class RAM extends Donanim{
    private String bellekTuru;
    private int bellekHizi;
    /** GB türünden yazılması lazımdır **/
    private int kapasite;
    private String gecikmeDegeri;
    private int pinSayisi;
    private boolean sogutucuBlok;

    public RAM(String marka, String model, String bellekTuru, int bellekHizi, int kapasite, String gecikmeDegeri, boolean sogutucuBlok) {
        this(marka, model, bellekTuru, bellekHizi, kapasite, gecikmeDegeri, -1, sogutucuBlok, LocalDate.now(), 0);
    }

    public RAM(String marka, String model, String bellekTuru, int bellekHizi, int kapasite, String gecikmeDegeri, int pinSayisi, boolean sogutucuBlok, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setBellekTuru(bellekTuru.trim());
        setBellekHizi(bellekHizi);
        setKapasite(kapasite);
        setGecikmeDegeri(gecikmeDegeri.trim());
        setPinSayisi(pinSayisi);
        setSogutucuBlok(sogutucuBlok);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Bellek Türü: " + getBellekTuru());
        System.out.println("Bellek Hızı: " + getBellekHizi() + " MHz");
        System.out.println("Kapasite: " + getKapasite() + " GB");
        System.out.println("Gecikme Değeri: " + getGecikmeDegeri());
        System.out.println("Pin Sayısı: " + getPinSayisi() + " pin");
        System.out.println("Soğutucu Blok: " + super.isThere(getSogutucuBlok()));
        super.bilgileriGoster();
    }

    private boolean hizDusurCagirildiMi = false;
    private boolean hizAsirtCagirildiMi = false;

    public void hizAsirtma(int mhz){
        if (hizAsirtCagirildiMi)
            throw new IllegalStateException("Hız birden fazla kez aşırtılamaz!");
        if (mhz < 0)
            throw new IllegalStateException("MHz degeri negatif olamaz.");
        int max_mhz = (int) (getBellekHizi() * 0.15);
        if (mhz <= max_mhz){
            setBellekHizi(getBellekHizi() + mhz);
            System.out.println(mhz + " MHz hız aşırtıldı ve " + getMarka() + " marka RAM bellek " + getBellekHizi() + " MHz hızına aşırtılmıştır.");
            hizAsirtCagirildiMi = true;
        }
        else
            System.out.println(getMarka() + " marka RAM'e en fazla " + max_mhz + " MHz hız aşırtma yapabilirsin!");
    }
    public void hizDusur(int mhz){
        if (hizDusurCagirildiMi)
            throw new IllegalStateException("Hız birden fazla kez düşürülemez!");
        if (mhz < 0)
            throw new IllegalStateException("MHz degeri negatif olamaz.");
        int min_mhz = (int) (getBellekHizi() * 0.2);
        if (mhz <= min_mhz){
            setBellekHizi(getBellekHizi() - mhz);
            System.out.println(mhz + " MHz hız düşürüldü ve " + getMarka() + " marka RAM bellek " + getBellekHizi() + " MHz hızına düşmüştür.");
            hizDusurCagirildiMi = true;
        }
        else
            System.out.println(getMarka() + " marka RAM'e en fazla " + min_mhz + " MHz hız düşürme yapabilirsin!");
    }

    public String getBellekTuru() {
        return bellekTuru;
    }

    public void setBellekTuru(String bellekTuru) {
        this.bellekTuru = "";
        String[] RAMTurleri = {"DDR1", "DDR2", "DDR3", "DDR4", "DDR5", "SDRAM", "RDRAM", "SRAM"};
        for(String eleman : RAMTurleri){
            if (bellekTuru.equals(eleman)){
                this.bellekTuru = bellekTuru;
                break;
            }
        }
        if(this.bellekTuru.isEmpty())
            throw new IllegalStateException("Lütfen uygun bir bellek türü girin.\nUygun Ram Türleri: " + Arrays.toString(RAMTurleri).substring(1, Arrays.toString(RAMTurleri).length() - 1));

    }

    public int getBellekHizi() {
        return bellekHizi;
    }

    public void setBellekHizi(int bellekHizi) {
        if (bellekHizi < 0)
            throw new IllegalStateException("Bellek hızı negatif değer alamaz.");

        int max_mhz = 8000;
        if (bellekHizi < max_mhz)
            this.bellekHizi = bellekHizi;
        else
            throw new IllegalStateException("Bellek hızı en fazla " + max_mhz + " MHz hızında olabilir.");
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        if (kapasite < 0)
            throw new IllegalStateException("Kapasite negatif değer alamaz.");

        int max_kapasite = 1024;
        if (kapasite < max_kapasite)
            this.kapasite = kapasite;
        else
            throw new IllegalStateException("Kapasite en fazla " + max_kapasite + " GB olabilir.");
    }

    public String getGecikmeDegeri() {
        return gecikmeDegeri;
    }

    public void setGecikmeDegeri(String gecikmeDegeri) {
        this.gecikmeDegeri = gecikmeDegeri;
    }

    public int getPinSayisi() {
        return pinSayisi;
    }

    public void setPinSayisi(int pinSayisi) {
        if (pinSayisi < 0)
            throw new IllegalStateException("Pin sayısı negatif değer alamaz.");

        this.pinSayisi = pinSayisi;
    }

    public boolean getSogutucuBlok() {
        return sogutucuBlok;
    }

    public void setSogutucuBlok(boolean sogutucuBlok) {
        this.sogutucuBlok = sogutucuBlok;
    }
}
