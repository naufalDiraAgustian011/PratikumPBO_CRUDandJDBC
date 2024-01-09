import java.sql.*;

public class showDb {
    public void displayData() {
        try {
            Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiketcenter", "root", "");
            Statement mydb = db.createStatement();
            ResultSet myrs = mydb.executeQuery("SELECT * FROM datatiket");

            while (myrs.next()) {
                System.out.println(myrs.getString("id_obat") + "," + myrs.getString("nama_tiket") + "," + myrs.getInt("nomor_tiket"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tambahkan ini untuk melihat pesan kesalahan
        }
    }
}
