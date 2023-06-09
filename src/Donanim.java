import java.time.Duration;
import java.time.LocalDate;
public class Donanim {
    private String marka;
    private String model;
    private LocalDate satinAlinmaTarihi;
    /** Garanti süresinin ay olarak girilmesi uygundur **/
    private int garantiSuresi;

    public Donanim(String marka, String model ,LocalDate satinAlinmaTarihi, int garantiSuresi) {
        setMarka(marka.trim());
        setModel(model.trim());
        setSatinAlinmaTarihi(satinAlinmaTarihi);
        setGarantiSuresi(garantiSuresi);
    }

    public void bilgileriGoster(){
        System.out.println("Garanti Süresi: " + getGarantiSuresi() + " Ay");
        System.out.println("Satın Alınma Tarihi: " + getSatinAlinmaTarihiDuzenli());
        System.out.println("Garanti Durumu: " + isThere(garantiDurum(), "Devam Ediyor", "Devam Etmiyor"));
        System.out.println(kalanGarantiSuresi());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public LocalDate getSatinAlinmaTarihi() {
        return satinAlinmaTarihi;
    }

    public String getSatinAlinmaTarihiDuzenli(){
        return getSatinAlinmaTarihi().getDayOfMonth() + "/" + getSatinAlinmaTarihi().getMonthValue() + "/" + getSatinAlinmaTarihi().getYear();
    }

    public void setSatinAlinmaTarihi(LocalDate satinAlinmaTarihi) {
        LocalDate suankiTarih = LocalDate.now();

        if((suankiTarih.getYear() > satinAlinmaTarihi.getYear())){
            this.satinAlinmaTarihi = satinAlinmaTarihi;
        }
        else if((suankiTarih.getYear() == satinAlinmaTarihi.getYear())){
            if((suankiTarih.getMonthValue() > satinAlinmaTarihi.getMonthValue())){
                this.satinAlinmaTarihi = satinAlinmaTarihi;
            }
            else if ((suankiTarih.getMonthValue() == satinAlinmaTarihi.getMonthValue())){
                if((suankiTarih.getDayOfMonth() >= satinAlinmaTarihi.getDayOfMonth())){
                    this.satinAlinmaTarihi = satinAlinmaTarihi;
                }
                else {
                    throw new IllegalStateException("Satın alınma tarihi gelecek zaman olamaz!");
                }
            }
            else {
                throw new IllegalStateException("Satın alınma tarihi gelecek zaman olamaz!");
            }
        }
        else {
            throw new IllegalStateException("Satın alınma tarihi gelecek zaman olamaz!");
        }
    }

    public int getGarantiSuresi() {
        return garantiSuresi;
    }

    public void setGarantiSuresi(int garantiSuresi) {
        this.garantiSuresi = garantiSuresi;
    }

    public boolean garantiDurum(){
        LocalDate suankiTarih = LocalDate.now();
        Duration  fark = Duration.between(getSatinAlinmaTarihi().atStartOfDay(), suankiTarih.atStartOfDay());
        long gecenAySayisi = fark.toDays() / 30;
        return gecenAySayisi < getGarantiSuresi();
    }


    public String  kalanGarantiSuresi(){
        LocalDate suankiTarih = LocalDate.now();
        Duration  fark = Duration.between(getSatinAlinmaTarihi().atStartOfDay(), suankiTarih.atStartOfDay());
        long kalanAy = getGarantiSuresi() - (fark.toDays() / 30);
        if(garantiDurum())
            return "Kalan Garanti Süresi: " + kalanAy + " Ay";
        else
            return "Ürünün garantisi tükenmiştir.";
    }

    public String isThere(boolean mantiksalDeger){
        return mantiksalDeger ? "Var" : "Yok";
    }
    public String isThere(boolean mantiksalDeger, String textT, String textF){
        return mantiksalDeger ? textT : textF;
    }
}
