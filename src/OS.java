import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class OS {
    private String OSTuru;
    private String OSVersiyonu;
    /** boyut GB olarak girilmelidir **/
    private double boyut;

    public OS(String OSTuru, String OSVersiyonu, double boyut) {
        setOSTuru(OSTuru);
        setOSVersiyonu(OSVersiyonu);
        setBoyut(boyut);
    }

    public void bilgileriGoster(){
        System.out.println("İşletim Sistem Türü: " + getOSTuru());
        System.out.println("İşletim Sistemi Versiyonu: "+ getOSVersiyonu());
        System.out.println("İşletim Sistemi Boyutu: " + getBoyut() + " GB");
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
    public String getOSTuru() {
        return OSTuru;
    }

    public void setOSTuru(String OSTuru) {
        this.OSTuru = OSTuru;
    }

    public String getOSVersiyonu() {
        return OSVersiyonu;
    }

    public void setOSVersiyonu(String OSVersiyonu) {
        this.OSVersiyonu = OSVersiyonu;
    }

    public double getBoyut() {
        return boyut;
    }

    public void setBoyut(double boyut) {
        if (boyut < 0)
            throw new IllegalStateException("Boyut degeri negatif olamaz.");

        this.boyut = boyut;
    }
}
