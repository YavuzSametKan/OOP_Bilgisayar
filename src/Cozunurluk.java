public class Cozunurluk {
    private int en;
    private int boy;

    public Cozunurluk(int en, int boy) {
        setEn(en);
        setBoy(boy);
    }

    public int getEn() {
        return en;
    }

    public void setEn(int en) {
        if (en < 0)
            throw new IllegalStateException("En degeri negatif olamaz.");
        this.en = en;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        if (boy < 0)
            throw new IllegalStateException("Boy degeri negatif olamaz.");
        this.boy = boy;
    }
}
