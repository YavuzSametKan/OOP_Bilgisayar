import java.time.LocalDate;
import java.util.ArrayList;

public class Kasa extends Donanim{
    private String renk;
    private String materyal;
    private boolean temperliCam;
    /** En mm olarak girilmelidir! **/
    private int en;
    /** Boy mm olarak girilmelidir! **/
    private int boy;
    /** Yukseklik mm olarak girilmelidir! **/
    private int yukseklik;
    private int usbSayisi;
    private int jakGirisi;
    private Anakart anakart;
    private ArrayList<Fan> fanlar;
    private ArrayList<HDD> hddler = new ArrayList<>();
    private ArrayList<SSD> ssdler = new ArrayList<>();
    private PSU psu;
    private DVDRom dvdRom;

    public Kasa(String marka, String model, String renk, String materyal, boolean temperliCam, int en, int boy, int yukseklik, int usbSayisi, int jakGirisi, Anakart anakart, ArrayList<Fan> fanlar, PSU psu, ArrayList<SSD> ssdler, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka,model,renk,materyal,temperliCam,en,boy,yukseklik,usbSayisi,jakGirisi,anakart,fanlar,new ArrayList<>(),psu,ssdler,new DVDRom("-","-",LocalDate.of(1970,1,1),0),satinAlinmaTarihi,garantiSuresi);
    }

    public Kasa(String marka, String model, String renk, String materyal, boolean temperliCam, int en, int boy, int yukseklik, int usbSayisi, int jakGirisi, Anakart anakart, ArrayList<Fan> fanlar, ArrayList<HDD> hddler, PSU psu, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka,model,renk,materyal,temperliCam,en,boy,yukseklik,usbSayisi,jakGirisi,anakart,fanlar,hddler,psu,new ArrayList<>(),new DVDRom("-","-",LocalDate.of(1970,1,1),0),satinAlinmaTarihi,garantiSuresi);
    }

    public Kasa(String marka, String model, String renk, String materyal, boolean temperliCam, int en, int boy, int yukseklik, int usbSayisi, int jakGirisi, Anakart anakart, ArrayList<Fan> fanlar, PSU psu, ArrayList<SSD> ssdler, DVDRom dvdRom, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka,model,renk,materyal,temperliCam,en,boy,yukseklik,usbSayisi,jakGirisi,anakart,fanlar,new ArrayList<>(),psu,ssdler,dvdRom,satinAlinmaTarihi,garantiSuresi);
    }

    public Kasa(String marka, String model, String renk, String materyal, boolean temperliCam, int en, int boy, int yukseklik, int usbSayisi, int jakGirisi, Anakart anakart, ArrayList<Fan> fanlar, ArrayList<HDD> hddler, PSU psu, DVDRom dvdRom, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka,model,renk,materyal,temperliCam,en,boy,yukseklik,usbSayisi,jakGirisi,anakart,fanlar,hddler,psu,new ArrayList<>(),dvdRom,satinAlinmaTarihi,garantiSuresi);
    }

    public Kasa(String marka, String model, String renk, String materyal, boolean temperliCam, int en, int boy, int yukseklik, int usbSayisi, int jakGirisi, Anakart anakart, ArrayList<Fan> fanlar, ArrayList<HDD> hddler, PSU psu, ArrayList<SSD> ssdler, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka,model,renk,materyal,temperliCam,en,boy,yukseklik,usbSayisi,jakGirisi,anakart,fanlar,hddler,psu,ssdler,new DVDRom("-","-",LocalDate.of(1970,1,1),0),satinAlinmaTarihi,garantiSuresi);
    }
    public Kasa(String marka, String model, String renk, String materyal, boolean temperliCam, int en, int boy, int yukseklik, int usbSayisi, int jakGirisi, Anakart anakart, ArrayList<Fan> fanlar, ArrayList<HDD> hddler, PSU psu, ArrayList<SSD> ssdler, DVDRom dvdRom, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setRenk(renk.trim());
        setMateryal(materyal.trim());
        setTemperliCam(temperliCam);
        setEn(en);
        setBoy(boy);
        setYukseklik(yukseklik);
        setUsbSayisi(usbSayisi);
        setJakGirisi(jakGirisi);
        setAnakart(anakart);
        setFanlar(fanlar);
        setHddler(hddler);
        setSsdler(ssdler);
        setPsu(psu);
        setDvdRom(dvdRom);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Materyal: " + getMateryal());
        System.out.println("Renk: " + getRenk());
        System.out.println("Temperli Cam Var Mı?: " + isThere(getTemperliCam()));
        System.out.println("En: " + getEn() + "mm");
        System.out.println("Boy: " + getBoy() + "mm");
        System.out.println("Yükseklik: " + getYukseklik() + "mm");
        System.out.println("Usb Sayısı: " + getUsbSayisi() + " adet");
        System.out.println("Jak Sayısı: " + getJakGirisi() + " adet");
        System.out.println("Toplam Depolama Alanı: " + toplamDepolamaAlani() + " GB");
        System.out.println("Takılan Depolama Birimi Sayısı: " + depolamaBirimiSayisi() + " adet");
        System.out.println("Takılan Fan Sayısı: " + getFanlar().size() + " adet");
        System.out.println("DVDROM Var Mı?: " + isThere(!getDvdRom().getModel().equals("-")));
        super.bilgileriGoster();
    }

    public double toplamDepolamaAlani(){
        double toplamDepolamaAlani = 0;
        for (int i = 0; i < getSsdler().size(); i++){
            toplamDepolamaAlani += getSsdler().get(i).getKapasite();
        }
        for (int i = 0; i < getHddler().size(); i++){
            toplamDepolamaAlani += getHddler().get(i).getKapasite();
        }
        return toplamDepolamaAlani;
    }

    public void bilgisayariKapat(){
        String metin = "Görüşürüz...\n";
        for (int i = 0; i < metin.length(); i++) {
            System.out.print(metin.charAt(i));
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getMateryal() {
        return materyal;
    }

    public void setMateryal(String materyal) {
        this.materyal = materyal;
    }

    public boolean getTemperliCam() {
        return temperliCam;
    }

    public void setTemperliCam(boolean temperliCam) {
        this.temperliCam = temperliCam;
    }

    public int getEn() {
        return en;
    }

    public void setEn(int en) {
        if (en < 0)
            throw new IllegalStateException("En değeri negatif olamaz.");
        this.en = en;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        if (boy < 0)
            throw new IllegalStateException("Boy değeri negatif olamaz.");
        this.boy = boy;
    }

    public int getYukseklik() {
        return yukseklik;
    }

    public void setYukseklik(int yukseklik) {
        if (yukseklik < 0)
            throw new IllegalStateException("Yükseklik değeri negatif olamaz.");
        this.yukseklik = yukseklik;
    }

    public int getUsbSayisi() {
        return usbSayisi;
    }

    public void setUsbSayisi(int usbSayisi) {
        if (usbSayisi < 0)
            throw new IllegalStateException("Usb Sayısı negatif olamaz.");

        int max = 100;
        if (usbSayisi < max)
            this.usbSayisi = usbSayisi;
        else
            throw new IllegalStateException("Usb Sayısı en fazla " + max + " adet olabilir.");
    }

    public int getJakGirisi() {
        return this.jakGirisi;
    }

    public void setJakGirisi(int jakGirisi) {
        if (jakGirisi < 0)
            throw new IllegalStateException("Usb Sayısı negatif olamaz.");

        int max = 32;
        if (jakGirisi < max)
            this.jakGirisi = jakGirisi;
        else
            throw new IllegalStateException("Jak Girişi en fazla " + max + " adet olabilir.");
    }

    public Anakart getAnakart() {
        return anakart;
    }

    public void setAnakart(Anakart anakart) {
        this.anakart = anakart;
    }

    public ArrayList<Fan> getFanlar() {
        return fanlar;
    }

    public void setFanlar(ArrayList<Fan> fanlar) {
        this.fanlar = fanlar;
    }

    public ArrayList<HDD> getHddler() {
        return hddler;
    }

    public void setHddler(ArrayList<HDD> hddler) {
        if(hddler.size()+getSsdler().size() > getAnakart().getSataSayisi())
            throw new IllegalStateException("Maksimum Depolama Birimi Sayısı Aşıldı!\nMaksimum Depolama Birimi Kapasitesi: " + getAnakart().getSataSayisi() + " adet");
        this.hddler = hddler;
    }

    public ArrayList<SSD> getSsdler() {
        return ssdler;
    }

    public void setSsdler(ArrayList<SSD> ssdler) {
        if(getHddler().size()+ssdler.size() > getAnakart().getSataSayisi())
            throw new IllegalStateException("Maksimum Depolama Birimi Sayısı Aşıldı!\nMaksimum Depolama Birimi Kapasitesi: " + getAnakart().getSataSayisi() + " adet");
        this.ssdler = ssdler;
    }

    public int depolamaBirimiSayisi(){
        return getHddler().size() + getSsdler().size();
    }

    public PSU getPsu() {
        return psu;
    }

    public void setPsu(PSU psu) {
        this.psu = psu;
    }

    public DVDRom getDvdRom() {
        return dvdRom;
    }

    public void setDvdRom(DVDRom dvdRom) {
        this.dvdRom = dvdRom;
    }
}
