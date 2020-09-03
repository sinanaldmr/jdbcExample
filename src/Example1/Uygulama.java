package Example1;

public class Uygulama {
    public static void main(String[] args) {
        DbOp dbOp=new DbOpImp();
        Ogrenci ogr1=new Ogrenci(1,"sinan","aldemir",1994,"72");
        Ogrenci ogr2=new Ogrenci(2,"ahmet","boz",1231,"123");
        Ogrenci ogr3=new Ogrenci(3,"mehmet","toz",3453,"4234");
        Ogrenci ogr4=new Ogrenci(4,"osman","koz",1544,"345");
        dbOp.ogrFind(3);
        dbOp.ogrPrint();


    }
}
