import java.time.LocalDate;

public class Dosya {
    private String tur;
    private String dosyaAdi;
    private double boyut;
    private String konum;
    private LocalDate olusturulmaTarihi;

    public Dosya(String tur, String dosyaAdi, double boyut, String konum, LocalDate olusturulmaTarihi) {
        setTur(tur);
        setDosyaAdi(dosyaAdi);
        setBoyut(boyut);
        setKonum(konum);
        setOlusturulmaTarihi(olusturulmaTarihi);
    }

    public void bilgileriGoster(){
        System.out.println("Dosya Türü: " + getTur());
        System.out.println("Dosya Adı: " + getDosyaAdi());
        System.out.println("Dosya Boyutu: " + getBoyut() + " MB");
        System.out.println("Dosya Konumu: "+getKonum());
        System.out.println("Dosya Oluşturulma Tarihi: " + getOlusturulmaTarihiDuzenli());
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getDosyaAdi() {
        return dosyaAdi;
    }

    public void setDosyaAdi(String dosyaAdi) {
        this.dosyaAdi = dosyaAdi;
    }

    public double getBoyut() {
        return boyut;
    }

    public void setBoyut(double boyut) {
        if (boyut < 0)
            throw new IllegalStateException("Boyut degeri negatif olamaz.");

        this.boyut = boyut;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    public LocalDate getOlusturulmaTarihi() {
        return olusturulmaTarihi;
    }

    public String getOlusturulmaTarihiDuzenli(){
        return getOlusturulmaTarihi().getDayOfMonth() + "/" + getOlusturulmaTarihi().getMonthValue() + "/" + getOlusturulmaTarihi().getYear();
    }

    public void setOlusturulmaTarihi(LocalDate olusturulmaTarihi) {
        this.olusturulmaTarihi = olusturulmaTarihi;
    }
}
