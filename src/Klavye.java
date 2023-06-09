import java.time.LocalDate;

public class Klavye extends Donanim{
    private String dili;
    private String klavyeTipi;
    private int butonSayisi;
    private boolean multimediaTuslari;
    private boolean bilekDestegi;
    private boolean numerikTuslar;

    public Klavye(String marka, String model, String dili, String klavyeTipi, int butonSayisi, boolean multimediaTuslari, boolean bilekDestegi, boolean numerikTuslar, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setDili(dili.trim());
        setKlavyeTipi(klavyeTipi.trim());
        setButonSayisi(butonSayisi);
        setMultimediaTuslari(multimediaTuslari);
        setBilekDestegi(bilekDestegi);
        setNumerikTuslar(numerikTuslar);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: "+ getModel());
        System.out.println("Dili: " + getDili());
        System.out.println("Klavye Tipi: " + getKlavyeTipi());
        System.out.println("Tuş Sayısı: " + getButonSayisi());
        System.out.println("Multimedia Tuşları: " + isThere(getMultimediaTuslari()));
        System.out.println("Bilek Desteği: " + isThere(getBilekDestegi()));
        System.out.println("Numerik Tuşlar: " + isThere(getNumerikTuslar()));
        super.bilgileriGoster();
    }

    public String getDili() {
        return dili;
    }

    public void setDili(String dili) {
        this.dili = dili;
    }

    public String getKlavyeTipi() {
        return klavyeTipi;
    }

    public void setKlavyeTipi(String klavyeTipi) {
        this.klavyeTipi = klavyeTipi;
    }

    public int getButonSayisi() {
        return butonSayisi;
    }

    public void setButonSayisi(int butonSayisi) {
        if (butonSayisi < 0)
            throw new IllegalStateException("Buton Sayısı negatif olamaz.");
        this.butonSayisi = butonSayisi;
    }

    public boolean getMultimediaTuslari() {
        return multimediaTuslari;
    }

    public void setMultimediaTuslari(boolean multimediaTuslari) {
        this.multimediaTuslari = multimediaTuslari;
    }

    public boolean getBilekDestegi() {
        return bilekDestegi;
    }

    public void setBilekDestegi(boolean bilekDestegi) {
        this.bilekDestegi = bilekDestegi;
    }

    public boolean getNumerikTuslar() {
        return numerikTuslar;
    }

    public void setNumerikTuslar(boolean numerikTuslar) {
        this.numerikTuslar = numerikTuslar;
    }
}
