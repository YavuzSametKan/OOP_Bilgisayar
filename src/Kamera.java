import java.time.LocalDate;

public class Kamera extends Donanim{
    private Cozunurluk cozunurluk;
    private int FPS;
    private Mikrofon mikrofon;

    public Kamera(String marka, String model, Cozunurluk cozunurluk, int FPS,LocalDate satinAlinmaTarihi, int garantiSuresi) {
        this(marka,model,cozunurluk,FPS, new Mikrofon("","","",LocalDate.of(1970,1,1),0),satinAlinmaTarihi,garantiSuresi);
    }

    public Kamera(String marka, String model, Cozunurluk cozunurluk, int FPS, Mikrofon mikrofon,LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setCozunurluk(cozunurluk);
        setFPS(FPS);
        setMikrofon(mikrofon);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Cözünürlük: " + getCozunurluk().getEn() + "x" + getCozunurluk().getBoy() + " px");
        System.out.println("FPS: " + getFPS() + "fps");
        super.bilgileriGoster();
    }

    private boolean kameraAcikMi = true;

    public void kameraAc(){
        if (!kameraAcikMi){
            String metin = "Kamera Açılıyor...\n";
            for (int i = 0; i < metin.length(); i++) {
                System.out.print(metin.charAt(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            kameraAcikMi = true;
        }else{
            System.out.println("Kamera zaten açık.");
        }
    }
    public void kameraKapat(){
        if (kameraAcikMi){
            String metin = "Kamera Kapatılıyor...\n";
            for (int i = 0; i < metin.length(); i++) {
                System.out.print(metin.charAt(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            kameraAcikMi = false;
        }else{
            System.out.println("Kamera zaten kapalı.");
        }
    }


    private boolean videoKaydiAcikMi = false;

    public void videoKaydet(){
        if (kameraAcikMi){
            if (!videoKaydiAcikMi){
                String metin = "Video Kaydı Açılıyor...\n";
                for (int i = 0; i < metin.length(); i++) {
                    System.out.print(metin.charAt(i));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                videoKaydiAcikMi = true;
                System.out.println("Video Kaydı Başladı.");
            }else{
                System.out.println("Video zaten açık.");
            }
        }else
            System.out.println("Kamera Kapalı!");
    }

    private boolean videoKaydiDurduMu = false;

    public void videoKaydiDurdur(){
        if (kameraAcikMi) {
            if (videoKaydiAcikMi) {
                if (!videoKaydiDurduMu) {
                    System.out.println("Video Kaydı Durdu.");
                    videoKaydiDurduMu = true;
                } else
                    System.out.println("Video Kaydı Zaten Duruk vaziyette.");
            } else
                System.out.println("Durdurulacak Kayıt Bulunmuyor.");
        }else
            System.out.println("Kamera Kapalı!");
    }

    public void videoKaydiDevamEttir(){
        if (kameraAcikMi) {
            if (videoKaydiAcikMi) {
                if (videoKaydiDurduMu) {
                    System.out.println("Video Kaydı Devam Ettirildi.");
                    videoKaydiDurduMu = false;
                } else
                    System.out.println("Video Kaydı Zaten Devam Eder vaziyette.");
            } else
                System.out.println("Devam Ettirilecek Kayıt Bulunmuyor.");
        }else
            System.out.println("Kamera Kapalı!");
    }

    public void videoKaydiniBitir(){
        if (kameraAcikMi) {
            if (videoKaydiAcikMi) {
                String metin = "Video Kaydı Kapatılıyor...\n";
                for (int i = 0; i < metin.length(); i++) {
                    System.out.print(metin.charAt(i));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                videoKaydiAcikMi = false;
                System.out.println("Video Kaydı Bitti.");
            } else {
                System.out.println("Video zaten kapalı.");
            }
        }else
            System.out.println("Kamera Kapalı!");
    }

    public Cozunurluk getCozunurluk() {
        return cozunurluk;
    }

    public void setCozunurluk(Cozunurluk cozunurluk) {
        this.cozunurluk = cozunurluk;
    }

    public int getFPS() {
        return FPS;
    }

    public void setFPS(int FPS) {
        if (FPS < 0)
            throw new IllegalStateException("FPS degeri negatif olamaz.");
        int max = 1080;
        if (FPS <= max)
            this.FPS = FPS;
        else
            throw new IllegalStateException("FPS değeri en fazla " + max + " olabilir.");

    }

    public Mikrofon getMikrofon() {
        return mikrofon;
    }

    public void setMikrofon(Mikrofon mikrofon) {
        this.mikrofon = mikrofon;
    }
}
