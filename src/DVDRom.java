import java.time.LocalDate;
import java.util.ArrayList;

public class DVDRom extends Donanim{
    private DVD dvd;

    public DVDRom(String marka, String model, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka, model, new DVD(0) , satinAlinmaTarihi, garantiSuresi);
    }

    public DVDRom(String marka, String model, DVD dvd, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setDvd(dvd);
    }
    public void bilgileriGoster(){
        System.out.println("DVD Takılı Mı: " + isThere(getDVDTakiliMi(), "Takılı", "Takılı Değil"));
        super.bilgileriGoster();
    }

    public boolean getDVDTakiliMi(){
        return getDvd().getKapasite() > 0;
    }


    public DVD getDvd() {
        return dvd;
    }

    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }
}
