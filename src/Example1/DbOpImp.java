package Example1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbOpImp implements DbOp{

    private DbConn baglanti=new DbConn();
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;

    @Override
    public void ogrAdd(Ogrenci ogrenci) {
        String query="insert into ogrenci(ogrId,ogrAdi,ogrSoyadi,ogrDyili,ogrNo) values (?,?,?,?,?)";
        Connection connection=baglanti.getConnection();
        try {
            preparedStatement=(PreparedStatement)connection.prepareStatement(query);
            preparedStatement.setInt(1,ogrenci.getOgrId());
            preparedStatement.setString(2,ogrenci.getOgrAdi());
            preparedStatement.setString(3,ogrenci.getOgrSoyadi());
            preparedStatement.setInt(4,ogrenci.getOgrDyili());
            preparedStatement.setString(5,ogrenci.getOgrNo());
            preparedStatement.executeUpdate();
            baglanti.ConnectionsClose(connection,preparedStatement,null);
        } catch (SQLException e) {
            System.err.println("Öğrenci kaydedilirken hata oluştu... Hata: "+e);
        }
    }

    @Override
    public void ogrDelete(int ogrID) {
        String query="delete from ogrenci where ogrId=?";
        Connection connection=baglanti.getConnection();
        try {
            preparedStatement=(PreparedStatement)connection.prepareStatement(query);
            preparedStatement.setInt(1,ogrID);
            preparedStatement.executeUpdate();
            baglanti.ConnectionsClose(connection,preparedStatement,null);
        } catch (SQLException e) {
            System.err.println("Öğrenci silinirken hata oluştu... Hata: "+e );
        }
    }

    @Override
    public void ogrUpdate(Ogrenci ogrenci) {
        String query="update ogrenci set ogrAdi=?, ogrSoyadi=?, ogrDyili=?, ogrNo=? where ogrId=?";
        Connection connection=baglanti.getConnection();
        try {
            preparedStatement=(PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, ogrenci.getOgrAdi());
            preparedStatement.setString(2,ogrenci.getOgrSoyadi());
            preparedStatement.setInt(3,ogrenci.getOgrDyili());
            preparedStatement.setString(4,ogrenci.getOgrNo());
            preparedStatement.setInt(5,ogrenci.getOgrId());
            preparedStatement.executeUpdate();
            baglanti.ConnectionsClose(connection,preparedStatement,null);
        } catch (SQLException e) {
            System.err.println("Öğrenci güncellenirken hata oluştu... Hata: "+e );
        }
    }

    @Override
    public void ogrPrint() {
        String query="select * from ogrenci";
        ArrayList<Ogrenci> ogrenciler=new ArrayList<>();
        Connection connection=baglanti.getConnection();
        try {
            preparedStatement=(PreparedStatement)connection.prepareStatement(query);
            resultSet= (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt(1);
                String adi=resultSet.getString(2);
                String soyadi=resultSet.getString(3);
                int dyili=resultSet.getInt(4);
                String no=resultSet.getString(5);
                Ogrenci ogrenci=new Ogrenci(id,adi,soyadi,dyili,no);
                ogrenciler.add(ogrenci);
            }
            baglanti.ConnectionsClose(connection,preparedStatement,resultSet);
        } catch (SQLException e) {
            System.err.println("Öğrenci bulunurken hata oluştu... Hata: "+e);
        }
        for (Ogrenci ogrenci:ogrenciler) {
            System.out.println(ogrenci);
        }
    }

    @Override
    public void ogrFind(int ogrId) {
        String query="select * from ogrenci where ogrId=?";
        Connection connection=baglanti.getConnection();
        try {
            preparedStatement=(PreparedStatement)connection.prepareStatement(query);
            preparedStatement.setInt(1,ogrId);
            resultSet= (ResultSet) preparedStatement.executeQuery();
            resultSet.next();
            int id =resultSet.getInt(1);
            String adi=resultSet.getString(2);
            String soyadi=resultSet.getString(3);
            int dyili=resultSet.getInt(4);
            String no=resultSet.getString(5);
            Ogrenci ogrenci=new Ogrenci(id,adi,soyadi,dyili,no);
            System.out.println(ogrenci);
            baglanti.ConnectionsClose(connection,preparedStatement,resultSet);
        } catch (SQLException e) {
            System.err.println("Öğrenci bulunurken hata oluştu... Hata: "+e);
        }

    }
}
