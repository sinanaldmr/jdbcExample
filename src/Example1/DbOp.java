package Example1;

public interface DbOp {
    public void ogrAdd(Ogrenci ogrenci);
    public void ogrDelete(int ogrID);
    public void ogrUpdate(Ogrenci ogrenci);
    public void ogrPrint();
    public void ogrFind(int ogrId);
}
