import java.time.LocalDate;

public class Bilgisayar {
    private Kasa kasa;
    private Monitor monitor;
    private Kamera kamera;
    private Fare fare;
    private Klavye klavye;

    public Bilgisayar(Kasa kasa, Monitor monitor, Fare fare, Klavye klavye) {
        this(kasa,monitor,new Kamera("","",new Cozunurluk(0,0),0, LocalDate.of(1970,1,1),0),fare,klavye);
    }

    public Bilgisayar(Kasa kasa, Monitor monitor, Kamera kamera, Fare fare, Klavye klavye) {
        setKasa(kasa);
        setMonitor(monitor);
        setKamera(kamera);
        setFare(fare);
        setKlavye(klavye);
    }

    public Kasa getKasa() {
        return kasa;
    }

    public void setKasa(Kasa kasa) {
        this.kasa = kasa;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Kamera getKamera() {
        return kamera;
    }

    public void setKamera(Kamera kamera) {
        this.kamera = kamera;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public Klavye getKlavye() {
        return klavye;
    }

    public void setKlavye(Klavye klavye) {
        this.klavye = klavye;
    }
}
