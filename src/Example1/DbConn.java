package Example1;

import java.sql.*;

public class DbConn {

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver bulundu...");
        } catch (ClassNotFoundException e) {
            System.err.println("MySql driver bulunamadı... Hata: " + e);
            return null;
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calisma", "root", "Sinan.2062433");
            System.out.println("Bağlantı başarılı...");
        } catch (SQLException e) {
            System.err.println("Bağlantı kurulamadı...");
            return null;
        }
        return connection;
    }

    public void ConnectionsClose(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        if (preparedStatement!=null){
            try{
                preparedStatement.close();
                System.out.println("PreparedStatement kapatıldı...");
            }catch (SQLException e){
                System.out.println("PreparedStatement kapatılırken sorun oluştu... Hata: "+e );
            }
        }
        if (resultSet!=null){
            try{
                resultSet.close();
                System.out.println("ResultSet kapatıldı...");
            }catch (SQLException e){
                System.err.println("ResultSet kapatılırken hata oluştu... Hata: "+e);
            }
        }
        if (connection!=null) {
            try {
                connection.close();
                System.out.println("Bağlantı kapatıldı...");
            } catch (SQLException e) {
                System.err.println("Bağlantı kapatılırken hata oluştu... hata: " + e);
            }
        }
    }

}
