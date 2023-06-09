import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.time.LocalDate;

public class EthernetKarti extends Donanim{
    private boolean dahiliMi;
    private int maxMbpsDestegi;
    private int yuvaSayisi;
    private boolean wifiDestegi;
    private boolean internet;

    public EthernetKarti(String marka, String model, boolean dahiliMi, int maxMbpsDestegi, int yuvaSayisi, boolean wifiDestegi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setDahiliMi(dahiliMi);
        setMaxMbpsDestegi(maxMbpsDestegi);
        setYuvaSayisi(yuvaSayisi);
        setWifiDestegi(wifiDestegi);
        setInternet(true);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Dahili mi, Harici mi?: " + isThere(getDahiliMi(), "Dahili", "Harici"));
        System.out.println("Maksimum Mbps değeri: " + getMaxMbpsDestegi() + " Mbps");
        System.out.println("Yuva Sayısı: " + getYuvaSayisi());
        System.out.println("Wifi Desteği: " + isThere(getWifiDestegi(), "Var", "Yok"));
        System.out.println("Internet" + isThere(getInternet(), "Var", "Yok"));
        super.bilgileriGoster();
    }

    public void internetiKapat(){
        if (getInternet()){
            System.out.println("Internet kapatılıyor...");
            setInternet(false);
        }
        else
            System.out.println("Internet zaten kapalı.");
    }

    public void internetiAc(){
        if (!getInternet()){
            System.out.println("Internet açılıyor...");
            setInternet(true);
        }
        else
            System.out.println("Internet zaten açık.");
    }

    public int getYuvaSayisi() {
        return yuvaSayisi;
    }

    public void setYuvaSayisi(int yuvaSayisi) {
        if (yuvaSayisi < 0)
            throw new IllegalStateException("Yuva Sayisi negatif değer alamaz.");

        int max_yuva = 20;
        if (yuvaSayisi > max_yuva)
            throw new IllegalStateException("Yuva sayısı en fazla " + max_yuva + " adet olabilir.");

        this.yuvaSayisi = yuvaSayisi;
    }

    public boolean getWifiDestegi() {
        return wifiDestegi;
    }

    public void setWifiDestegi(boolean wifiDestegi) {
        this.wifiDestegi = wifiDestegi;
    }

    public boolean getDahiliMi() {
        return dahiliMi;
    }

    public void setDahiliMi(boolean dahiliMi) {
        this.dahiliMi = dahiliMi;
    }

    public int getMaxMbpsDestegi() {
        return maxMbpsDestegi;
    }

    public void setMaxMbpsDestegi(int maxMbpsDestegi) {
        if (maxMbpsDestegi < 0)
            throw new IllegalStateException("Mbps değeri negatif olamaz.");

        int max_mbps = 1000000;
        if (maxMbpsDestegi > max_mbps)
            throw new IllegalStateException("Mbps değeri en fazla " + max_mbps + " Mbps olabilir.");

        this.maxMbpsDestegi = maxMbpsDestegi;
    }

    public boolean getInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }
}
