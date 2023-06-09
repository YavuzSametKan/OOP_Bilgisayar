import java.time.LocalDate;
import java.util.ArrayList;

public class SSD extends DepolamaBirimi{
    private double okumaHizi;
    private double yazmaHizi;

    public SSD(String marka, String model, int kapasite, double inc, double okumaHizi, double yazmaHizi, boolean birincilDepolamaMi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka,model,kapasite,inc,birincilDepolamaMi,satinAlinmaTarihi,garantiSuresi);
        setYazmaHizi(yazmaHizi);
        setOkumaHizi(okumaHizi);
    }

    public SSD(String marka, String model, int kapasite, double inc, double okumaHizi, double yazmaHizi, OS os, ArrayList<Dosya> dosyalar, boolean birincilDepolamaMi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, kapasite, inc, os, dosyalar, birincilDepolamaMi, satinAlinmaTarihi, garantiSuresi);
        setOkumaHizi(okumaHizi);
        setYazmaHizi(yazmaHizi);
    }

    public void bilgileriGoster(){
        super.bilgileriGoster();
        System.out.println("Okuma Hızı: "+getOkumaHizi() + " MB/s");
        System.out.println("Yazma Hızı: "+getYazmaHizi() + " MB/s");
    }

    public double getOkumaHizi() {
        return okumaHizi;
    }

    public void setOkumaHizi(double okumaHizi) {
        if (okumaHizi < 0)
            throw new IllegalStateException("Okuma Hızı degeri negatif olamaz.");
        this.okumaHizi = okumaHizi;
    }

    public double getYazmaHizi() {
        return yazmaHizi;
    }

    public void setYazmaHizi(double yazmaHizi) {
        if (yazmaHizi < 0)
            throw new IllegalStateException("Yazma hızı degeri negatif olamaz.");
        this.yazmaHizi = yazmaHizi;
    }
}
