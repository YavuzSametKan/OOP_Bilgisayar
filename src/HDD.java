import java.time.LocalDate;
import java.util.ArrayList;

public class HDD extends DepolamaBirimi{
    private int RPM;
    public HDD(String marka, String model, int kapasite, double inc, int RPM, boolean birincilDepolamaMi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka,model,kapasite,inc,birincilDepolamaMi,satinAlinmaTarihi,garantiSuresi);
        setRPM(RPM);
    }
    public HDD(String marka, String model, int kapasite, double inc,int RPM, OS os, ArrayList<Dosya> dosyalar, boolean birincilDepolamaMi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, kapasite, inc, os, dosyalar, birincilDepolamaMi, satinAlinmaTarihi, garantiSuresi);
        setRPM(RPM);
    }

    public void bilgileriGoster(){
        super.bilgileriGoster();
        System.out.println("RPM: "+getRPM() + " RPM");
    }

    public int getRPM() {
        return RPM;
    }

    public void setRPM(int RPM) {
        if (RPM < 0)
            throw new IllegalStateException("RPM degeri negatif olamaz.");
        this.RPM = RPM;
    }
}
