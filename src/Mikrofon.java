import java.time.LocalDate;

public class Mikrofon extends Donanim{
    /**Örnek yazım standartı: 65Hz ~ 18KHz**/
    private String frekansAraligi;

    public Mikrofon(String marka, String model,String frekansAraligi, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setFrekansAraligi(frekansAraligi.trim());
    }

    public void bilgileriGoster(){
        System.out.println("Marka: "+getMarka());
        System.out.println("Model: "+getModel());
        System.out.println("Frekans Aralığı: "+getFrekansAraligi());
        super.bilgileriGoster();
    }

    private boolean mikrofonAcikMi = true;

    public void mikrofonAc(){
        if (!getModel().equals(""))
            throw new IllegalStateException("Kameranın mikrofonu yok!");
        if (!mikrofonAcikMi){
            String metin = "Mikrofon Açılıyor...\n";
            for (int i = 0; i < metin.length(); i++) {
                System.out.print(metin.charAt(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mikrofonAcikMi = true;
        }else{
            System.out.println("Mikrofon zaten açık.");
        }
    }
    public void mikrofonKapat(){
        if (!getModel().equals(""))
            throw new IllegalStateException("Kameranın mikrofonu yok!");
        if (mikrofonAcikMi){
            String metin = "Mikrofon Kapatılıyor...\n";
            for (int i = 0; i < metin.length(); i++) {
                System.out.print(metin.charAt(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mikrofonAcikMi = false;
        }else{
            System.out.println("Mikrofon zaten kapalı.");
        }
    }

    private boolean sesKaydediliyorMu = false;

    public void sesKaydiBaslat(){
        if (!getModel().equals(""))
            throw new IllegalStateException("Kameranın mikrofonu yok!");
        if (mikrofonAcikMi){
            if (!sesKaydediliyorMu){
                String metin = "Ses Kaydı Başlatılıyor...\n";
                for (int i = 0; i < metin.length(); i++) {
                    System.out.print(metin.charAt(i));
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sesKaydediliyorMu = true;
                System.out.println("Ses Kaydı Başladı.");
            }else{
                System.out.println("Ses kaydı zaten başladı.");
            }
        }else
            System.out.println("Mikrofon Kapalı!");
    }

    private boolean sesKaydiDurduMu = false;

    public void sesKaydiDurdur(){
        if (!getModel().equals(""))
            throw new IllegalStateException("Kameranın mikrofonu yok!");
        if (mikrofonAcikMi) {
            if (sesKaydediliyorMu) {
                if (!sesKaydiDurduMu) {
                    System.out.println("Ses Kaydı Durdu.");
                    sesKaydiDurduMu = true;
                } else
                    System.out.println("Ses Kaydı Zaten Duruk vaziyette.");
            } else
                System.out.println("Durdurulacak Kayıt Bulunmuyor.");
        }else
            System.out.println("Mikrofon Kapalı!");
    }

    public void sesKaydiDevamEttir(){
        if (!getModel().equals(""))
            throw new IllegalStateException("Kameranın mikrofonu yok!");
        if (mikrofonAcikMi) {
            if (sesKaydediliyorMu) {
                if (sesKaydiDurduMu) {
                    System.out.println("Ses Kaydı Devam Ettirildi.");
                    sesKaydiDurduMu = false;
                } else
                    System.out.println("Ses Kaydı Zaten Devam Eder vaziyette.");
            } else
                System.out.println("Devam Ettirilecek Kayıt Bulunmuyor.");
        }else
            System.out.println("Mikrofon Kapalı!");
    }

    public void sesKaydiBitir(){
        if (!getModel().equals(""))
            throw new IllegalStateException("Kameranın mikrofonu yok!");
        if (mikrofonAcikMi) {
            if (sesKaydediliyorMu) {
                String metin = "Ses Kaydı Bitiriliyor...\n";
                for (int i = 0; i < metin.length(); i++) {
                    System.out.print(metin.charAt(i));
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sesKaydediliyorMu = false;
                System.out.println("Ses Kaydı Bitti.");
            } else {
                System.out.println("Ses kaydı başlatılmadı.");
            }
        }else
            System.out.println("Mikrofon Kapalı!");
    }

    public String getFrekansAraligi() {
        return frekansAraligi;
    }

    public void setFrekansAraligi(String frekansAraligi) {
        this.frekansAraligi = frekansAraligi;
    }
}
