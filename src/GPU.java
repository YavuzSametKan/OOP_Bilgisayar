import java.time.LocalDate;
import java.util.ArrayList;

public class GPU extends Donanim{
    private String bellekTipi;
    private int bitDegeri;
    private String chipSet;
    private int cekirdekHizi;
    /** Bellek GB türünden yazılmalıdır! **/
    private int bellek;
    /** Güç tüketimi Watt olarak yazılmalıdır **/
    private int gucTuketimi;
    private int yuvaSayisi;
    private boolean HDMI;
    private boolean displayPort;
    private boolean VGA;
    private boolean DVI;
    private ArrayList<Fan> fanlar;
    private boolean sogutucuBlok;
    private boolean rayTracingVarMi;

    public GPU(String marka, String model, String bellekTipi, int bellek, int bitDegeri, String chipSet, int cekirdekHizi, int gucTuketimi, int yuvaSayisi, boolean HDMI, boolean displayPort, boolean VGA, boolean DVI,boolean sogutucuBlok, boolean rayTracingVarMi, LocalDate satinAlinmaTarihi, int garantiSuresi){
        this(marka,model,bellekTipi,bellek,bitDegeri,chipSet,cekirdekHizi,gucTuketimi,yuvaSayisi,HDMI,displayPort,VGA,DVI,new ArrayList<>(),sogutucuBlok,rayTracingVarMi,satinAlinmaTarihi,garantiSuresi);
    }

    public GPU(String marka, String model, String bellekTipi, int bellek, int bitDegeri, String chipSet, int cekirdekHizi, int gucTuketimi, int yuvaSayisi, boolean HDMI, boolean displayPort, boolean VGA, boolean DVI, ArrayList<Fan> fanlar,boolean sogutucuBlok, boolean rayTracingVarMi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setBellekTipi(bellekTipi.trim());
        setBellek(bellek);
        setBitDegeri(bitDegeri);
        setChipSet(chipSet.trim());
        setCekirdekHizi(cekirdekHizi);
        setGucTuketimi(gucTuketimi);
        setYuvaSayisi(yuvaSayisi);
        setHDMI(HDMI);
        setDisplayPort(displayPort);
        setVGA(VGA);
        setDVI(DVI);
        setFanlar(fanlar);
        setSogutucuBlok(sogutucuBlok);
        setRayTracingVarMi(rayTracingVarMi);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Bellek Tipi: " + getBellekTipi());
        System.out.println("Bellek: " + getBellek() + " GB");
        System.out.println("Bit Değeri: " + getBitDegeri() + " bit");
        System.out.println("Chipset: " + getChipSet());
        System.out.println("Cekirdek Hızı: " + getCekirdekHizi() + " MHz");
        System.out.println("Güç Tüketimi: " + getGucTuketimi() + " Watt");
        System.out.println("Yuva Sayısı: " + getYuvaSayisi() + " adet");
        System.out.println("HDMI: " + super.isThere(getHDMI()));
        System.out.println("Display Port: " + super.isThere(getDisplayPort()));
        System.out.println("VGA: " + super.isThere(getVGA()));
        System.out.println("DVI: " + super.isThere(getDVI()));
        System.out.println("Fan Sayısı: " + getFanlar().size());
        System.out.println("Soğutucu Blok: " + super.isThere(getSogutucuBlok()));
        System.out.println("Ray Tracing: " + super.isThere(getRayTracingVarMi()));
        super.bilgileriGoster();
    }

    private boolean hizDusurCagirildiMi = false;
    private boolean hizAsirtCagirildiMi = false;

    public void hizAsirtma(double mhz){
        if (hizAsirtCagirildiMi)
            throw new IllegalStateException("Hız birden fazla kez aşırtılamaz!");
        if (mhz < 0)
            throw new IllegalStateException("MHz degeri negatif olamaz.");
        int max_mhz = (int) (getCekirdekHizi() * 0.15);
        if (mhz <= max_mhz){
            setCekirdekHizi((int)(getCekirdekHizi() + mhz));
            System.out.println(mhz + " MHz hız aşırtıldı ve " + getMarka() + " marka ekran kartı bellek " + getCekirdekHizi() + " MHz hızına aşırtılmıştır.");
            hizAsirtCagirildiMi = true;
        }
        else
            System.out.println(getMarka() + " marka ekran kartı en fazla " + max_mhz + " MHz hız aşırtma yapabilirsin!");
    }
    public void hizDusur(int mhz){
        if (hizDusurCagirildiMi)
            throw new IllegalStateException("Hız birden fazla kez düşürülemez!");
        if (mhz < 0)
            throw new IllegalStateException("MHz degeri negatif olamaz.");
        int min_mhz = (int) (getCekirdekHizi() * 0.15);
        if (mhz <= min_mhz){
            setCekirdekHizi(getCekirdekHizi() - mhz);
            System.out.println(mhz + " MHz hız düşürüldü ve " + getMarka() + " marka ekran kartı bellek " + getCekirdekHizi() + " MHz hızına düşmüştür.");
            hizDusurCagirildiMi = true;
        }
        else
            System.out.println(getMarka() + " marka ekran kartı en fazla " + min_mhz + " MHz hız düşürme yapabilirsin!");
    }

    public void topluRPMArttir(int RPM){
        if (getFanlar().size() > 0){
            for (int i = 0; i < getFanlar().size(); i++){
                getFanlar().get(i).RPMArttir(RPM);
            }
        }
        else
            System.out.println("Ekran kartında fan bulunmuyor!");
    }

    public void topluRPMAzalt(int RPM){
        if (getFanlar().size() > 0){
            for (int i = 0; i < getFanlar().size(); i++){
                getFanlar().get(i).RPMAzalt(RPM);
            }
        }
        else
            System.out.println("Ekran kartında fan bulunmuyor!");
    }

    public void rayTracingOzelliginiAc(){
        String mesaj = getRayTracingVarMi() ? "Ray tracing Özelliği açılıyor..." : "Ekran kartınız ray tracing özelliğini desteklemiyor.";
        System.out.println(mesaj);
    }

    public void directXOzelliginiAc(){
        System.out.println("DirectX Özelliği açılıyor...");
    }

    public boolean getRayTracingVarMi() {
        return rayTracingVarMi;
    }

    public void setRayTracingVarMi(boolean rayTracingVarMi) {
        this.rayTracingVarMi = rayTracingVarMi;
    }


    public String getBellekTipi() {
        return bellekTipi;
    }

    public void setBellekTipi(String bellekTipi) {
        this.bellekTipi = bellekTipi;
    }

    public int getBitDegeri() {
        return bitDegeri;
    }

    public void setBitDegeri(int bitDegeri) {
        if (bitDegeri < 0)
            throw new IllegalStateException("Bit degeri negatif değer alamaz.");

        int max_bit = 1024;
        if (bitDegeri > max_bit)
            throw new IllegalStateException("Bit değeri en fazla " + max_bit + " b olabilir.");

        this.bitDegeri = bitDegeri;
    }

    public String getChipSet() {
        return chipSet;
    }

    public void setChipSet(String chipSet) {
        this.chipSet = chipSet;
    }

    public int getCekirdekHizi() {
        return cekirdekHizi;
    }

    public void setCekirdekHizi(int cekirdekHizi) {
        if (cekirdekHizi < 0)
            throw new IllegalStateException("Çekirdek hızı negatif değer alamaz.");

        this.cekirdekHizi = cekirdekHizi;
    }

    public int getBellek() {
        return bellek;
    }

    public void setBellek(int bellek) {
        if (bellek < 0)
            throw new IllegalStateException("Bellek negatif GB değeri alamaz.");

        int max_GB = 1024;
        if (bellek > max_GB)
            throw new IllegalStateException("Bellek en fazla " + max_GB + " GB olabilir.");

        this.bellek = bellek;
    }

    public int getGucTuketimi() {
        return gucTuketimi;
    }

    public void setGucTuketimi(int gucTuketimi) {
        if (gucTuketimi < 0)
            throw new IllegalStateException("Güç tüketimi negatif değer alamaz.");

        int max_W = 1000;
        if (gucTuketimi > max_W)
            throw new IllegalStateException("Güç tüketimi değeri en fazla " + max_W + " Watt olabilir.");
        this.gucTuketimi = gucTuketimi;
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

    public boolean getHDMI() {
        return HDMI;
    }

    public void setHDMI(boolean HDMI) {
        this.HDMI = HDMI;
    }

    public boolean getDisplayPort() {
        return displayPort;
    }

    public void setDisplayPort(boolean displayPort) {
        this.displayPort = displayPort;
    }

    public boolean getVGA() {
        return VGA;
    }

    public void setVGA(boolean VGA) {
        this.VGA = VGA;
    }

    public boolean getDVI() {
        return DVI;
    }

    public void setDVI(boolean DVI) {
        this.DVI = DVI;
    }

    public ArrayList<Fan> getFanlar() {
        return fanlar;
    }

    public void setFanlar(ArrayList<Fan> fanlar) {
        this.fanlar = fanlar;
    }

    public boolean getSogutucuBlok() {
        return sogutucuBlok;
    }

    public void setSogutucuBlok(boolean sogutucuBlok) {
        this.sogutucuBlok = sogutucuBlok;
    }
}
