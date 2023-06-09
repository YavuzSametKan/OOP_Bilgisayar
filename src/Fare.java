import java.time.LocalDate;

public class Fare extends Donanim{
    private int DPI;
    private int maxDPI;
    private int butonSayisi;

    public Fare(String marka, String model, int maxDPI, int DPI, int butonSayisi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setMaxDPI(maxDPI);
        setDPI(DPI);
        setButonSayisi(butonSayisi);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Maksimum DPI: " + getMaxDPI());
        System.out.println("DPI: " + getDPI());
        System.out.println("Buton Sayısı: " + getButonSayisi());
        super.bilgileriGoster();
    }

    public int getMaxDPI() {
        return maxDPI;
    }

    public void setMaxDPI(int maxDPI) {
        if (maxDPI < 0)
            throw new IllegalStateException("Maksimum DPI degeri negatif olamaz.");
        this.maxDPI = maxDPI;
    }


    public int getDPI() {
        return DPI;
    }

    public void setDPI(int DPI) {
        if (DPI < 0)
            throw new IllegalStateException("DPI degeri negatif olamaz.");

        if (DPI <= getMaxDPI())
            this.DPI = DPI;
        else
            System.out.println("DPI değeri maksimum " + getMaxDPI() + " olabilir.");
    }
    public int getButonSayisi() {
        return butonSayisi;
    }

    public void setButonSayisi(int butonSayisi) {
        if (butonSayisi < 0)
            throw new IllegalStateException("Buton Sayısı negatif olamaz.");
        this.butonSayisi = butonSayisi;
    }
}
