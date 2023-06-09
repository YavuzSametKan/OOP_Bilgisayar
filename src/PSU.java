import java.time.LocalDate;

public class PSU extends Donanim{
    private int watt;
    private boolean seksenPlusSertifikasi;
    private int fanSayisi;

    public PSU(String marka, String model, int watt, boolean seksenPlusSertifikasi, int fanSayisi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setWatt(watt);
        setSeksenPlusSertifikasi(seksenPlusSertifikasi);
        setFanSayisi(fanSayisi);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Watt: " + getWatt() + " W");
        System.out.println("Seksen Plus Sertifikası: " + isThere(getSeksenPlusSertifikasi()));
        System.out.println("Fan Sayısı: " + getFanSayisi() + " adet");
        super.bilgileriGoster();
    }

    public int getWatt() {
        return watt;
    }

    public void setWatt(int watt) {
        if (watt < 0)
            throw new IllegalStateException("Watt değeri negatif olamaz!");
        this.watt = watt;
    }

    public boolean getSeksenPlusSertifikasi() {
        return seksenPlusSertifikasi;
    }

    public void setSeksenPlusSertifikasi(boolean seksenPlusSertifikasi) {
        this.seksenPlusSertifikasi = seksenPlusSertifikasi;
    }

    public int getFanSayisi() {
        return fanSayisi;
    }

    public void setFanSayisi(int fanSayisi) {
        if (fanSayisi < 0)
            throw new IllegalStateException("Fan Sayısı negatif olamaz!");
        this.fanSayisi = fanSayisi;
    }
}
