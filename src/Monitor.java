import java.time.LocalDate;

public class Monitor extends Donanim{
    private int yuvaSayisi;
    private Cozunurluk cozunurluk;
    private double inc;
    private int Hz;
    /**Tepkime Süresi ms (milisecond) olarak girilmelidir!**/
    private int tepkimeSuresi;
    /**Parlaklık değeri NIT (cd/m) olmalıdır!**/
    private int parlaklik;
    private boolean HDMI;
    private boolean displayPort;
    private boolean VGA;
    private boolean DVI;
    private boolean HDR;
    private boolean kavisliYuzey;
    private boolean monitorAcikMi = true;

    public Monitor(String marka, String model,double inc, int yuvaSayisi, Cozunurluk cozunurluk, int hz, int tepkimeSuresi, int parlaklik, boolean HDMI, boolean displayPort, boolean VGA, boolean DVI, boolean HDR, boolean kavisliYuzey, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setInc(inc);
        setYuvaSayisi(yuvaSayisi);
        setCozunurluk(cozunurluk);
        setHz(hz);
        setTepkimeSuresi(tepkimeSuresi);
        setParlaklik(parlaklik);
        setHDMI(HDMI);
        setDisplayPort(displayPort);
        setVGA(VGA);
        setDVI(DVI);
        setHDR(HDR);
        setKavisliYuzey(kavisliYuzey);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Inc: " + getInc() + '"');
        System.out.println("Yuva Sayısı: " + getYuvaSayisi());
        System.out.println("Cözünürlük: " + getCozunurluk().getEn() + "x" + getCozunurluk().getBoy() + " px");
        System.out.println("Hz: " + getHz() + "Hz");
        System.out.println("Tepkime Süresi: " + getTepkimeSuresi() + "ms");
        System.out.println("Parlaklık: " + getParlaklik() + "cd");
        System.out.println("HDMI: " + isThere(getHDMI()));
        System.out.println("DisplayPost: " + isThere(getDisplayPort()));
        System.out.println("DVI: " + isThere(getDVI()));
        System.out.println("VGA: " + isThere(getVGA()));
        System.out.println("HDR: " + isThere(getHDR()));
        System.out.println("Kavisli Yuzey: " + isThere(getKavisliYuzey()));
        super.bilgileriGoster();
    }

    public double getInc() {
        return inc;
    }

    public void setInc(double inc) {
        if (inc < 0)
            throw new IllegalStateException("Inc degeri negatif olamaz.");
        this.inc = inc;
    }

    public int getYuvaSayisi() {
        return yuvaSayisi;
    }

    public void monitorAc(){
        if (!monitorAcikMi){
            String metin = "Monitör Açılıyor...\n";
            for (int i = 0; i < metin.length(); i++) {
                System.out.print(metin.charAt(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            monitorAcikMi = true;
        }else{
            System.out.println("Monitör zaten açık.");
        }
    }

    public void monitorKapat(){
        if (monitorAcikMi){
            String metin = "Monitör Kapatılıyor...\n";
            for (int i = 0; i < metin.length(); i++) {
                System.out.print(metin.charAt(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            monitorAcikMi = false;
        }else{
            System.out.println("Monitör zaten kapalı.");
        }
    }

    public void setYuvaSayisi(int yuvaSayisi) {
        if (yuvaSayisi < 0)
            throw new IllegalStateException("Yuva Sayısı degeri negatif olamaz.");
        int max = 48;
        if (yuvaSayisi <= max)
            this.yuvaSayisi = yuvaSayisi;
        else
            throw new IllegalStateException("Yuva Sayısı en fazla " + max + " adet olabilir.");
    }

    public Cozunurluk getCozunurluk() {
        return cozunurluk;
    }

    public void setCozunurluk(Cozunurluk cozunurluk) {
        this.cozunurluk = cozunurluk;
    }

    public int getHz() {
        return Hz;
    }

    public void setHz(int hz) {
        if (hz < 0)
            throw new IllegalStateException("Hz degeri negatif olamaz.");
        int max = 2400;
        if (hz <= max)
            Hz = hz;
        else
            throw new IllegalStateException("Hz değeri en fazla " + max + "Hz olabilir.");
    }

    public int getTepkimeSuresi() {
        return tepkimeSuresi;
    }

    public void setTepkimeSuresi(int tepkimeSuresi) {
        if (tepkimeSuresi < 0)
            throw new IllegalStateException("Tepkime Süresi degeri negatif olamaz.");
        int max = 1000;
        if (tepkimeSuresi <= max)
            this.tepkimeSuresi = tepkimeSuresi;
        else
            throw new IllegalStateException("Tepkime Süresi en fazla " + max + "ms olabilir.");
    }

    public int getParlaklik() {
        return parlaklik;
    }

    public void setParlaklik(int parlaklik) {
        if (parlaklik < 0)
            throw new IllegalStateException("Parlaklık degeri negatif olamaz.");

        this.parlaklik = parlaklik;
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

    public boolean getHDR() {
        return HDR;
    }

    public void setHDR(boolean HDR) {
        this.HDR = HDR;
    }

    public boolean getKavisliYuzey() {
        return kavisliYuzey;
    }

    public void setKavisliYuzey(boolean kavisliYuzey) {
        this.kavisliYuzey = kavisliYuzey;
    }
}
