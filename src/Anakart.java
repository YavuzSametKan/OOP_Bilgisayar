import javax.naming.ldap.LdapName;
import java.time.LocalDate;
import java.util.Arrays;

public class Anakart extends Donanim {
    private int sataSayisi;
    private int yuvaSayisi;
    private boolean bluetooth;
    private int RAMKapasitesi;
    private int RAMSlotSayisi;
    private String RAMSlotTipi;
    private RAM[] ram = new RAM[RAMSlotSayisi];
    private String islemciSlotMimarisi;
    private CPU cpu;
    private GPU gpu;
    private EthernetKarti ethernetKarti;
    private SesKarti sesKarti;

    public Anakart(String marka, String model, int sataSayisi, int yuvaSayisi, boolean bluetooth, int RAMKapasitesi, int RAMSlotSayisi, String RAMSlotTipi, RAM[] ram, String islemciSlotMimarisi, CPU cpu, GPU gpu, EthernetKarti ethernetKarti, SesKarti sesKarti, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setSataSayisi(sataSayisi);
        setYuvaSayisi(yuvaSayisi);
        setBluetooth(bluetooth);
        setRAMKapasitesi(RAMKapasitesi);
        setRAMSlotSayisi(RAMSlotSayisi);
        setRAMSlotTipi(RAMSlotTipi.trim());
        setRam(ram);
        setIslemciSlotMimarisi(islemciSlotMimarisi.trim());
        setCpu(cpu);
        setGpu(gpu);
        setEthernetKarti(ethernetKarti);
        setSesKarti(sesKarti);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Sata Yuva Sayısı: " + getSataSayisi());
        System.out.println("Yuva Sayısı: " + getYuvaSayisi());
        System.out.println("Bluetooth Desteği: " + isThere(getBluetooth()));
        System.out.println("Maksimum RAM Kapasitesi: "+ getRAMKapasitesi());
        System.out.println("RAM Slot Sayısı: "+ getRAMSlotSayisi());
        System.out.println("RAM Slot Tipi: " + getRAMSlotTipi());
        System.out.println("İşlemci Slot Mimarisi: " + getIslemciSlotMimarisi());
        super.bilgileriGoster();
    }

    public int getSataSayisi() {
        return sataSayisi;
    }

    public void setSataSayisi(int sataSayisi) {
        if (sataSayisi < 0)
            throw new IllegalStateException("Sata sayısı negatif değer alamaz.");

        int max_kapasite = 32;
        if (sataSayisi < max_kapasite)
            this.sataSayisi = sataSayisi;
        else
            throw new IllegalStateException("Sata sayisi en fazla " + max_kapasite + " adet olabilir.");
    }

    public int getYuvaSayisi() {
        return yuvaSayisi;
    }

    public void setYuvaSayisi(int yuvaSayisi) {
        if (yuvaSayisi < 0)
            throw new IllegalStateException("Yuva Sayısı negatif değer alamaz.");

        int max_kapasite = 32;
        if (yuvaSayisi < max_kapasite)
            this.yuvaSayisi = yuvaSayisi;
        else
            throw new IllegalStateException("Yuva sayısı en fazla " + max_kapasite + " adet olabilir.");

    }

    public boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public int getRAMKapasitesi() {
        return RAMKapasitesi;
    }

    public void setRAMKapasitesi(int RAMKapasitesi) {
        if (RAMKapasitesi < 0)
            throw new IllegalStateException("RAM Kapasitesi negatif değer alamaz.");

        this.RAMKapasitesi = RAMKapasitesi;
    }

    public int getRAMSlotSayisi() {
        return RAMSlotSayisi;
    }

    public void setRAMSlotSayisi(int RAMSlotSayisi) {
        if (RAMSlotSayisi < 0)
            throw new IllegalStateException("RAM slot sayısı negatif değer alamaz.");

        int max_kapasite = 16;
        if (RAMSlotSayisi < max_kapasite)
            this.RAMSlotSayisi = RAMSlotSayisi;
        else
            throw new IllegalStateException("RAM slot sayısı en fazla " + max_kapasite + " adet olabilir.");

    }

    public String getRAMSlotTipi() {
        return RAMSlotTipi;
    }

    public void setRAMSlotTipi(String RAMSlotTipi) {
        this.RAMSlotTipi = "";
        String[] RAMTurleri = {"DDR1", "DDR2", "DDR3", "DDR4", "DDR5", "SDRAM", "RDRAM", "SRAM"};
        for(String eleman : RAMTurleri){
            if (RAMSlotTipi.equals(eleman)){
                this.RAMSlotTipi = RAMSlotTipi;
                break;
            }
        }
        if(this.RAMSlotTipi.isEmpty())
            throw new IllegalStateException("Lütfen uygun bir bellek slot tipi girin.\nUygun Ram Türleri: " + Arrays.toString(RAMTurleri).substring(1, Arrays.toString(RAMTurleri).length() - 1));
    }

    public RAM[] getRam() {
        return ram;
    }

    public void setRam(RAM[] ram) {
        int toplamRAMKapasitesi = 0;
        int takilanRAMSayisi = ram.length;
        for (int i = 0; i < takilanRAMSayisi; i++) {
            if (!ram[i].getBellekTuru().equals(getRAMSlotTipi()))
                throw new IllegalStateException(getMarka() + " " + getModel() + " anakart yalnızca " + getRAMSlotTipi() + " tipindeki RAM'leri destekliyor.\nSizin takmaya çalıştığınız RAM tipi: " + ram[i].getBellekTuru() + " tipindedir.");
            toplamRAMKapasitesi += ram[i].getKapasite();
        }
        if (takilanRAMSayisi > getRAMSlotSayisi())
            throw new IllegalStateException(getMarka() + " " + getModel() + " anakart maksimum " + getRAMSlotSayisi() + " adet RAM destekliyor.\nSizin takmaya çalıştığınız RAM sayısı: "+takilanRAMSayisi+" adettir.");

        if (toplamRAMKapasitesi > getRAMKapasitesi())
            throw new IllegalStateException(getMarka() + " " + getModel() + " anakart maksimum " + getRAMKapasitesi() + " GB RAM kapasitesi destekliyor.\nSizin taktığınız RAM kapasitesi: "+toplamRAMKapasitesi+" GB kadardır.");
        if (takilanRAMSayisi > 1){
            for (int i = 0; i < takilanRAMSayisi-1; i++){
                if (!ram[i].getGecikmeDegeri().equals(ram[i+1].getGecikmeDegeri())){
                    System.out.println("UYARI:\n\tTakılan RAM'lerin gecikme değerleri aynı değil!\n\tBilgisayar kullanılabilir ancak çalışırken hata almanız olası.\n");
                }
            }
        }
        this.ram = ram;
    }

    public String getIslemciSlotMimarisi() {
        return islemciSlotMimarisi;
    }

    public void setIslemciSlotMimarisi(String islemciSlotMimarisi) {
        this.islemciSlotMimarisi = islemciSlotMimarisi;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        if (!getIslemciSlotMimarisi().equals(cpu.getMimariTipi()))
            throw new IllegalStateException(getMarka() + " " + getModel() + " anakart yalnızca " + getIslemciSlotMimarisi() + " mimari tipindeki işlemcileri destekliyor.\nSizin takmaya çalıştığınız İşlemci mimari tipi: " + cpu.getMimariTipi() + " tipindedir.");
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public EthernetKarti getEthernetKarti() {
        return ethernetKarti;
    }

    public void setEthernetKarti(EthernetKarti ethernetKarti) {
        this.ethernetKarti = ethernetKarti;
    }

    public SesKarti getSesKarti() {
        return sesKarti;
    }

    public void setSesKarti(SesKarti sesKarti) {
        this.sesKarti = sesKarti;
    }
}
