import java.time.LocalDate;

public class SesKarti extends Donanim{
    private boolean dahiliMi;
    private int yuvaSayisi;
    private SesKaynagi sesKaynagi;
    private Mikrofon mikrofon;
    public SesKarti(String marka, String model, boolean dahiliMi, Mikrofon mikrofon, int yuvaSayisi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka,model,new SesKaynagi("","",LocalDate.of(1970,1,1),0),dahiliMi,mikrofon,yuvaSayisi,satinAlinmaTarihi,garantiSuresi);
    }
    public SesKarti(String marka, String model,SesKaynagi sesKaynagi, boolean dahiliMi, int yuvaSayisi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka,model,sesKaynagi,dahiliMi,new Mikrofon("","","",LocalDate.of(1970,1,1),0),yuvaSayisi,satinAlinmaTarihi,garantiSuresi);
    }
    public SesKarti(String marka, String model, boolean dahiliMi, int yuvaSayisi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka,model,new SesKaynagi("","",LocalDate.of(1970,1,1),0),dahiliMi,new Mikrofon("","","",LocalDate.of(1970,1,1),0),yuvaSayisi,satinAlinmaTarihi,garantiSuresi);
    }
    public SesKarti(String marka, String model,SesKaynagi sesKaynagi, boolean dahiliMi, Mikrofon mikrofon, int yuvaSayisi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setMikrofon(mikrofon);
        setSesKaynagi(sesKaynagi);
        setDahiliMi(dahiliMi);
        setYuvaSayisi(yuvaSayisi);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Dahili mi, Harici mi?: " + isThere(getDahiliMi(), "Dahili", "Harici"));
        System.out.println("Yuva Sayısı: " + getYuvaSayisi());
        System.out.println("Ses Düzeyi: %" + getSesKaynagi().getSesDuzeyi());
        super.bilgileriGoster();
    }

    public SesKaynagi getSesKaynagi() {
        return sesKaynagi;
    }

    public void setSesKaynagi(SesKaynagi sesKaynagi) {
        this.sesKaynagi = sesKaynagi;
    }

    public Mikrofon getMikrofon() {
        return mikrofon;
    }

    public void setMikrofon(Mikrofon mikrofon) {
        this.mikrofon = mikrofon;
    }

    public boolean getDahiliMi() {
        return dahiliMi;
    }

    public void setDahiliMi(boolean dahiliMi) {
        this.dahiliMi = dahiliMi;
    }

    public int getYuvaSayisi() {
        return yuvaSayisi;
    }

    public void setYuvaSayisi(int yuvaSayisi) {
        if (yuvaSayisi < 0)
            throw new IllegalStateException("Yuva Sayisi negatif değer alamaz.");

        int max_yuva = 256;
        if (yuvaSayisi > max_yuva)
            throw new IllegalStateException("Yuva sayısı en fazla " + max_yuva + " adet olabilir.");

        this.yuvaSayisi = yuvaSayisi;
    }
}
