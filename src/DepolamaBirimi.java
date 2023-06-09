import java.time.LocalDate;
import java.util.ArrayList;

public class DepolamaBirimi extends Donanim{
    /** kapasite GB olarak girilmelidir **/
    private int kapasite;
    private double inc;
    private OS os;
    private ArrayList<Dosya> dosyalar;
    private boolean birincilDepolamaMi;
    private int kalanKapasite;

    public DepolamaBirimi(String marka, String model, int kapasite, double inc, boolean birincilDepolamaMi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka,model,kapasite,inc,new OS("OS yok!","OS yok!", 0),new ArrayList<>(),birincilDepolamaMi,satinAlinmaTarihi,garantiSuresi);
    }

    public DepolamaBirimi(String marka, String model, int kapasite, double inc, OS os, ArrayList<Dosya> dosyalar, boolean birincilDepolamaMi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setKapasite(kapasite);
        setInc(inc);
        setOs(os);
        setDosyalar(dosyalar);
        setBirincilDepolamaMi(birincilDepolamaMi);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Kapasite: " + (getKapasite() - kalanKapasite) + " GB / " + getKapasite()+" GB");
        System.out.println("Kalan Kapasite: " + kalanKapasite + " GB");
        System.out.println("Boyut(inc): " + getInc() + '"');
        System.out.println("Birincil Depolama Mı?: " + isThere(getBirincilDepolamaMi(), "Evet", "Hayır"));
        super.bilgileriGoster();
    }

    public void dosyalariGoster(){
        if (getOs().getBoyut() != 0)
            System.out.println(getOs().getOSTuru() + " " + getOs().getOSVersiyonu() + " - " + (getOs().getBoyut() * 1024) + " MB");
        else
            System.out.println("Hiç Dosya Bulunmuyor.");
        for (int i = 0; i < getDosyalar().size(); i++){
            String dosyaAd = getDosyalar().get(i).getDosyaAdi();
            String dosyaUzanti = getDosyalar().get(i).getTur();
            double dosyaBoyut = getDosyalar().get(i).getBoyut();
            System.out.println(dosyaAd + "." + dosyaUzanti + " - " + dosyaBoyut + " MB");
        }
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        if (kapasite < 0)
            throw new IllegalStateException("Kapasite negatif değer alamaz!");

        this.kapasite = kapasite;
    }

    public double getInc() {
        return inc;
    }

    public void setInc(double inc) {
        if (kapasite < 0)
            throw new IllegalStateException("Inc değeri negatif olamaz!");

        this.inc = inc;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public ArrayList<Dosya> getDosyalar() {
        return dosyalar;
    }

    public void setDosyalar(ArrayList<Dosya> dosyalar) {
        kalanKapasite = getKapasite() - (int)getOs().getBoyut();
        dosyalar.forEach(e -> kalanKapasite -= e.getBoyut() / 1024.0);

        if (kalanKapasite < 0)
            throw new IllegalStateException("Depolama yetersiz, bu sebeple dosya silmeniz gerekmekte.");

        this.dosyalar = dosyalar;
    }

    public boolean getBirincilDepolamaMi() {
        return birincilDepolamaMi;
    }

    public void setBirincilDepolamaMi(boolean birincilDepolamaMi) {
        this.birincilDepolamaMi = birincilDepolamaMi;
    }
}
