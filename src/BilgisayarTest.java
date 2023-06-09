import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BilgisayarTest {
    public static void main(String[] args) {
        RAM ram1 = new RAM("XPG", "Gammix D30", "DDR4", 3600, 8, "CL19", 288, true, LocalDate.of(2021,8,3), 24);
        RAM ram2 = new RAM("XPG","Gammix D30", "DDR4", 3600, 8, "CL19", 288, true, LocalDate.of(2021,8,3), 24);
        CPU cpu = new CPU("Intel", "Core i5 12400F","12. nesil", "LGA1700" ,3.7, 18, 6, 1700, 10.0, LocalDate.of(2021, 12, 15), 24);
        ArrayList<Fan> gpuFanlari = new ArrayList<>(Collections.nCopies(3, new Fan("Zotac", "Ekran Kartı Fanı",100,1300,LocalDate.of(2023,3,21),24)));
        GPU gpu = new GPU("Zotac", "Nvidia Geforge RXT 4090 Gaming Trinity ZT-D40900D-10P", "GDDR6X", 24, 384, "NVIDIA", 1065, 107, 4, true, true, false , false, gpuFanlari,true, true,LocalDate.of(2023,3,21), 24);
        EthernetKarti ethernetKarti = new EthernetKarti("Intel", "E1G42ET", false, 40000, 2, true, LocalDate.of(2022,3,8), 24);
        Mikrofon kameraMikrofonu = new Mikrofon("Logitech","C920 PRO MİKROFON","65Hz ~ 18KHz",LocalDate.of(2022,10,5),12);
        SesKaynagi hopallor = new SesKaynagi("Anker","Soundcore Motion B",LocalDate.of(2023,1,1),24);
        SesKarti sesKarti = new SesKarti("S-Link", "SL-48A",hopallor, true,kameraMikrofonu, 5, LocalDate.of(2022,3,8), 24);
        Anakart anakart = new Anakart("ASUS", "Pro B660M-C D4-Csm B660", 4, 12, false,64,2,"DDR4", new RAM[]{ram1,ram2}, "LGA1700", cpu, gpu, ethernetKarti,sesKarti,LocalDate.of(2022, 9,23), 24);
        OS os = new OS("Microsoft Windows","Windows 11",67.5);
        ArrayList<Dosya> dosyalar = new ArrayList<>(Arrays.asList(
                new Dosya("pdf", "merhabaDunya", 5.8,"\\Users\\Masaüstü",LocalDate.now()),
                new Dosya("exe", "Intelij Idea", 4096,"\\Users\\Masaüstü",LocalDate.now()),
                new Dosya("png", "yazılım", 4,"\\Users\\Masaüstü",LocalDate.now()),
                new Dosya("pdf", "İngilizce Notları", 15,"\\Users\\Masaüstü",LocalDate.now()),
                new Dosya("mp4", "Interstellar", 6144,"\\Users\\Masaüstü",LocalDate.now())
        ));
        SSD ssd = new SSD("SanDisk","Ultra 3D SDSSDH3",500,2.5,550.0,500.0, os ,dosyalar,true,LocalDate.of(2023,2,7),24);
        HDD hdd = new HDD("Wd","Blue WD20EZBX ",2000,3.5,7200,false,LocalDate.of(2023,4,5),24);
        PSU psu = new PSU("Corsair","CP-9020210-EU", 550, true,1,LocalDate.of(2022,5,4), 24);
        ArrayList<Dosya> DVDDosyalari = new ArrayList<>(Collections.singletonList(new Dosya("iso", "Windows 11", 3788.8,"Y:\\",LocalDate.now())));
        DVD dvd = new DVD(4.7, DVDDosyalari);
        DVDRom dvdRom = new DVDRom("Loviver", "Combo Cd-R", dvd,LocalDate.of(2023,2,15),24);
        ArrayList<Fan> kasaFanlari = new ArrayList<>(Arrays.asList(
                new Fan("Rampage","4C-120",120,1200,LocalDate.of(2021,9,21),24),
                new Fan("Rampage","4C-120",120,1200,LocalDate.of(2021,9,21),24),
                new Fan("Rampage","4C-120",120,1200,LocalDate.of(2021,9,21),24),
                new Fan("Rampage","4C-120",120,1200,LocalDate.of(2021,9,21),24),
                new Fan("Rampage","4C-120",120,1200,LocalDate.of(2021,9,21),24),
                new Fan("Rampage","4C-120",120,1200,LocalDate.of(2021,9,21),24),
                /* işlemci fanları */
                new Fan("Snowman","Rainbow X6",90,2000,LocalDate.of(2021,9,21),24),
                new Fan("Snowman","Rainbow X6",90,2000,LocalDate.of(2021,9,21),24),
                new Fan("Snowman","Rainbow X6",90,2000,LocalDate.of(2021,9,21),24)
        ));
        Kasa kasa = new Kasa("MSI","MAG Forge 100R","Siyah","Alüminyum",true,521,503,206,2,2,anakart,kasaFanlari,new ArrayList<>(Collections.singletonList(hdd)),psu,new ArrayList<>(Collections.singletonList(ssd)),dvdRom,LocalDate.of(2021,12,10),21);
        Cozunurluk monitorCozunurlugu = new Cozunurluk(1920, 1080);
        Monitor monitor = new Monitor("Casper", "Excalibur M.E238FHD-G", 23.8,6, monitorCozunurlugu,200,1,300,true,true,false,false,true,true,LocalDate.of(2022,10,5),24);
        Cozunurluk kameraCozunurlugu = new Cozunurluk(1920, 1080);
        Kamera kamera = new Kamera("Logitech","C920 PRO",kameraCozunurlugu,60,kameraMikrofonu,LocalDate.of(2022,10,5),12);
        Fare fare = new Fare("SteelSeries","Rival 3",8500,1600,6,LocalDate.of(2023,1,1),    24);
        Klavye klavye = new Klavye("Gamebooster","G918 Fire Storm","Türkçe Q","Mekanik",120,true,true,true,LocalDate.of(2023,1,1),24);
        Bilgisayar pc = new Bilgisayar(kasa,monitor,kamera,fare,klavye);
        System.out.println(pc.getKasa().getAnakart().getCpu().decimalToBinary(64));
    }
}
