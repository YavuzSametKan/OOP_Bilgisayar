import java.util.ArrayList;

public class DVD {
    /** Kapasite GB olarak girilmelidir! **/
    private double kapasite;
    private ArrayList<Dosya> dosyalar;
    double kullanilanKapasite = 0;

    public DVD(double kapasite) {
        this(kapasite, new ArrayList<>());
    }
    public DVD(double kapasite, ArrayList<Dosya> dosyalar) {
        setKapasite(kapasite);
        setDosyalar(dosyalar);
    }

    public void bilgileriGoster(){
        System.out.println("Kapasite: " + kullanilanKapasite + " GB / " + getKapasite() + " GB");
        System.out.println("Kalan Kapasite: " + (getKapasite() - kullanilanKapasite) + " GB");
        System.out.println("Dosya Sayisi: " + getDosyalar().size());
    }

    public void dosyalariGoster(){
        if (getDosyalar().size() > 0){
            for (int i = 0; i < getDosyalar().size(); i++) {
                String dosyaAd = getDosyalar().get(i).getDosyaAdi();
                String dosyaUzanti = getDosyalar().get(i).getTur();
                double dosyaBoyut = getDosyalar().get(i).getBoyut();
                System.out.println(dosyaAd + "." + dosyaUzanti + " - " + dosyaBoyut + " MB");
            }
        }
        else
            System.out.println("Hiç Dosya Yok");
    }

    public double getKapasite() {
        return kapasite;
    }

    public void setKapasite(double kapasite) {
        if (kapasite < 0)
            throw new IllegalStateException("Kapasite negatif değer alamaz!");

        this.kapasite = kapasite;
    }

    public ArrayList<Dosya> getDosyalar() {
        return dosyalar;
    }

    public void setDosyalar(ArrayList<Dosya> dosyalar) {
        dosyalar.forEach(e -> kullanilanKapasite += e.getBoyut() / 1024);

        if (kullanilanKapasite > getKapasite())
            throw new IllegalStateException("Yetersiz depolama, bu sebeple dosya silmeniz gerekmekte.");

        this.dosyalar = dosyalar;
    }
}
