import java.time.LocalDate;

public class Fan extends Donanim{
    /** Fan çapı mm olarak girilmelidir! **/
    private double fanCapi;
    private int RPM;

    public Fan(String marka, String model,double fanCapi, int RPM, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setFanCapi(fanCapi);
        setRPM(RPM);
    }

    public void bilgileriGoster(){
        System.out.println("Fan Çapı: " + getFanCapi() + "mm");
        System.out.println("RPM: " + getRPM() + " RPM");
        super.bilgileriGoster();
    }

    private boolean RPMAzaltCagirildiMi = false;
    private boolean RPMArttirCagirildiMi = false;

    public void RPMArttir(int RPM){
        if (RPMArttirCagirildiMi)
            throw new IllegalStateException("Bir fanda RPM birden fazla kez arttirilamaz!");
        if (RPM < 0)
            throw new IllegalStateException("RPM degeri negatif olamaz.");
        int max_rpm = (int) (getRPM() * 0.4);
        if (RPM <= max_rpm){
            setRPM(getRPM() + RPM);
            System.out.println(RPM + " RPM hız arttırıldı ve " + getMarka() + " marka fan " + getRPM() + " RPM'e ulaştı.");
            RPMArttirCagirildiMi = true;
        }
        else
            System.out.println(getMarka() + " marka fan en fazla " + max_rpm + " RPM arttırılabilir!");
    }

    public void RPMAzalt(int RPM){
        if (RPMAzaltCagirildiMi)
            throw new IllegalStateException("Bir fanda RPM birden fazla kez azaltılamaz!");
        if (RPM < 0)
            throw new IllegalStateException("RPM degeri negatif olamaz.");
        int min_rpm = (int) (getRPM() * 0.4);
        if (RPM <= min_rpm){
            setRPM(getRPM() - RPM);
            System.out.println(RPM + " RPM hız azaltıldı ve " + getMarka() + " marka fan " + getRPM() + " RPM'e düştü.");
            RPMAzaltCagirildiMi = true;
        }
        else
            System.out.println(getMarka() + " marka fan en fazla " + min_rpm + " RPM azaltılabilir!");
    }
    public double getFanCapi() {
        return fanCapi;
    }

    public void setFanCapi(double fanCapi) {
        this.fanCapi = fanCapi;
    }

    public int getRPM() {
        return RPM;
    }

    public void setRPM(int RPM) {
        this.RPM = RPM;
    }
}
