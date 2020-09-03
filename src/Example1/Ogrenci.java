package Example1;

public class Ogrenci {
    private int ogrId;
    private String ogrAdi;
    private String ogrSoyadi;
    private int ogrDyili;
    private String ogrNo;

    public Ogrenci(int ogrId, String ogrAdi, String ogrSoyadi, int ogrDyili, String ogrNo) {
        this.ogrId = ogrId;
        this.ogrAdi = ogrAdi;
        this.ogrSoyadi = ogrSoyadi;
        this.ogrDyili = ogrDyili;
        this.ogrNo = ogrNo;
    }

    public Ogrenci() {
    }

    public int getOgrId() {
        return ogrId;
    }

    public void setOgrId(int ogrId) {
        this.ogrId = ogrId;
    }

    public String getOgrAdi() {
        return ogrAdi;
    }

    public void setOgrAdi(String ogrAdi) {
        this.ogrAdi = ogrAdi;
    }

    public String getOgrSoyadi() {
        return ogrSoyadi;
    }

    public void setOgrSoyadi(String ogrSoyadi) {
        this.ogrSoyadi = ogrSoyadi;
    }

    public int getOgrDyili() {
        return ogrDyili;
    }

    public void setOgrDyili(int ogrDyili) {
        this.ogrDyili = ogrDyili;
    }

    public String getOgrNo() {
        return ogrNo;
    }

    public void setOgrNo(String ogrNo) {
        this.ogrNo = ogrNo;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "ogrId=" + ogrId +
                ", ogrAdi='" + ogrAdi + '\'' +
                ", ogrSoyadi='" + ogrSoyadi + '\'' +
                ", ogrDyili=" + ogrDyili +
                ", ogrNo='" + ogrNo + '\'' +
                '}';
    }
}
