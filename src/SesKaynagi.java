import java.time.LocalDate;

public class SesKaynagi extends Donanim{
    private int sesDuzeyi;

    public SesKaynagi(String marka, String model, LocalDate satinAlinmaTarihi, int garantiSuresi) {
        super(marka, model, satinAlinmaTarihi, garantiSuresi);
        setSesDuzeyi(100);
    }

    public void bilgileriGoster(){
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Ses Düzeyi: %" + getSesDuzeyi());
        super.bilgileriGoster();
    }

    public void sesAc(){
        setSesDuzeyi(100);
        System.out.println("Ses düzeyi: %" + getSesDuzeyi());
    }

    public void sesArttir(){
        setSesDuzeyi(getSesDuzeyi() + 10);
        System.out.println("Ses düzeyi: %" + getSesDuzeyi());
    }

    public void sesKis(){
        setSesDuzeyi(getSesDuzeyi() - 10);
        System.out.println("Ses düzeyi: %" + getSesDuzeyi());
    }

    public void sesKapat(){
        setSesDuzeyi(0);
        System.out.println("Ses düzeyi: %" + getSesDuzeyi());
    }
    public int getSesDuzeyi() {
        return sesDuzeyi;
    }

    public void setSesDuzeyi(int sesDuzeyi) {
        if (sesDuzeyi < 0)
            sesDuzeyi = 0;
        else if (sesDuzeyi > 100)
            sesDuzeyi = 100;

        this.sesDuzeyi = sesDuzeyi;
    }
}
