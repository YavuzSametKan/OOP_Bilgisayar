import java.math.BigInteger;
import java.time.LocalDate;
public class CPU extends Donanim{
    private String nesil;
    private String mimariTipi;
    /** İşlemci hızı GHz olarak girilmelidir! **/
    private double islemciHizi;
    /** Cache Bellek MB olarak girilmelidir! **/
    private int cacheBellek;
    private int cekirdekSayisi;
    private int pinSayisi;
    private double nanometre;

    public CPU(String marka, String model, String nesil, String mimariTipi, double islemciHizi, int cacheBellek, int cekirdekSayisi, int pinSayisi, double nanometre, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setNesil(nesil.trim());
        setMimariTipi(mimariTipi.trim());
        setIslemciHizi(islemciHizi);
        setCacheBellek(cacheBellek);
        setCekirdekSayisi(cekirdekSayisi);
        setPinSayisi(pinSayisi);
        setNanometre(nanometre);
    }
    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Nesil: " + getNesil());
        System.out.println("Mimari Tipi: " + getMimariTipi());
        System.out.println("İşlemci Hızı: " + getIslemciHizi() + " GHz");
        System.out.println("Cache Bellek: " + getCacheBellek() + " MB");
        System.out.println("Çekirdek Sayısı: " + getCekirdekSayisi() + " çekirdek");
        System.out.println("Pin Sayısı: " + getPinSayisi() + " pin");
        super.bilgileriGoster();
    }

    public String binaryToText(String binary){
        StringBuilder metin = new StringBuilder();

        binary = binary.replaceAll(" ", "");
        int uzunluk = binary.length();

        for (int i = 0; i < uzunluk; i += 8) {
            String oktal = binary.substring(i, Math.min(i + 8, uzunluk));
            int decimal = Integer.parseInt(oktal, 2);
            metin.append((char) decimal);
        }

        return metin.toString();
    }

    public String textToBinary(String metin){
        StringBuilder ikilikSayi = new StringBuilder();

        for (int i = 0; i < metin.length(); i++) {
            char karakter = metin.charAt(i);
            String binary = Integer.toBinaryString(karakter);

            while (binary.length() < 7) {
                binary = "0".concat(binary);
            }

            ikilikSayi.append(binary);
            ikilikSayi.append(" ");
        }

        return ikilikSayi.toString();
    }

    public BigInteger binaryToDecimal(String binary){
        binary = binary.replaceAll(" ", "");
        int uzunluk = binary.length();
        BigInteger decimal = new BigInteger("0");

        for (int i = 0; i < uzunluk; i++) {
            char karakter = binary.charAt(uzunluk - 1 - i);
            int deger = Character.getNumericValue(karakter);
            decimal = decimal.add(BigInteger.valueOf((long)(deger * Math.pow(2, i))));
        }
        return decimal;
    }

    public static String decimalToBinary(long decimal) {
        StringBuilder binary = new StringBuilder();

        while (decimal > 0) {
            byte kalan = (byte)(decimal % 2);
            binary.insert(0, kalan);
            decimal /= 2;
        }

        return binary.toString();
    }

    private boolean hizDusurCagirildiMi = false;
    private boolean hizAsirtCagirildiMi = false;

    public void hizAsirtma(double ghz){
        if (hizAsirtCagirildiMi)
            throw new IllegalStateException("Hız birden fazla kez aşırtılamaz!");
        if (ghz < 0)
            throw new IllegalStateException("GHz degeri negatif olamaz.");
        double max_ghz = getIslemciHizi() * 0.35;
        if (ghz <= max_ghz){
            setIslemciHizi(getIslemciHizi() + ghz);
            System.out.println(ghz + " GHz hız aşırtıldı ve " + getMarka() + " marka işlemci bellek " + getIslemciHizi() + " GHz hızına aşırtılmıştır.");
            hizAsirtCagirildiMi = true;
        }
        else
            System.out.println(getMarka() + " marka işlemci en fazla " + max_ghz + " GHz hız aşırtma yapabilirsin!");

    }
    public void hizDusur(double ghz) {
        if (hizDusurCagirildiMi)
            throw new IllegalStateException("Hız birden fazla kez düşürülemez!");
        if (ghz < 0)
            throw new IllegalStateException("GHz degeri negatif olamaz.");
        double min_ghz = getIslemciHizi() * 0.3;
        if (ghz <= min_ghz) {
            setIslemciHizi(getIslemciHizi() - ghz);
            System.out.println(ghz + " Ghz hız düşürüldü ve " + getMarka() + " marka işlemci bellek " + getIslemciHizi() + " GHz hızına düşmüştür.");
            hizDusurCagirildiMi = true;
        } else
            System.out.println(getMarka() + " marka işlemci en fazla " + min_ghz + " GHz hız düşürme yapabilirsin!");

    }

    public String getMimariTipi() {
        return mimariTipi;
    }

    public void setMimariTipi(String mimariTipi) {
        this.mimariTipi = mimariTipi;
    }

    public String getNesil() {
        return nesil;
    }

    public void setNesil(String nesil) {
        this.nesil = nesil;
    }

    public double getIslemciHizi() {
        return islemciHizi;
    }

    public void setIslemciHizi(double islemciHizi) {
        if (islemciHizi < 0)
            throw new IllegalStateException("İşlemci hızı negatif değer alamaz.");

        double max_ghz = 10.0;
        if (islemciHizi > max_ghz)
            throw new IllegalStateException("İşlemci hızı en fazla " + max_ghz + " GHz hızında olabilir.");

        this.islemciHizi = islemciHizi;
    }

    public int getCacheBellek() {
        return cacheBellek;
    }

    public void setCacheBellek(int cacheBellek) {
        if (cacheBellek < 0)
            throw new IllegalStateException("Cache Bellek negatif değer alamaz.");

        double max_mb = 1024;
        if (cacheBellek > max_mb)
            throw new IllegalStateException("Cache bellek en fazla " + max_mb + " MB olabilir.");

        this.cacheBellek = cacheBellek;
    }

    public int getCekirdekSayisi() {
        return cekirdekSayisi;
    }

    public void setCekirdekSayisi(int cekirdekSayisi) {
        this.cekirdekSayisi = cekirdekSayisi;
    }

    public int getPinSayisi() {
        return pinSayisi;
    }

    public void setPinSayisi(int pinSayisi) {
        if (pinSayisi < 0)
            throw new IllegalStateException("Pin Sayısı negatif değer alamaz.");

        this.pinSayisi = pinSayisi;
    }

    public double getNanometre() {
        return nanometre;
    }

    public void setNanometre(double nanometre) {
        if (nanometre < 0)
            throw new IllegalStateException("Negatif nanometre değeri olamaz.");

        this.nanometre = nanometre;
    }
}
