package tiketcenter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateDataTiket {
    private static final String URL = "jdbc:mysql://localhost:3306/tiketcenter";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    
    public static void updateEmployeeCredentials(Scanner scanner) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE datatiket SET nama_tiket = ?, harga_tiket = ? WHERE id_tiket = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("----UPDATE DATA TIKET----");
                System.out.print("nomor_ID tiket: ");
                int employeeId = scanner.nextInt();
                
                System.out.print("jenis tiket: ");
                String newUsername = scanner.next();

                System.out.print("harga tiket: ");
                String newPassword = scanner.next();

                preparedStatement.setString(1, newUsername);
                preparedStatement.setString(2, newPassword);
                preparedStatement.setInt(3, employeeId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data tiket diupdate!");
                } else {
                    System.out.println("tidak ditemukan data tiket dengan id tersebut tidak ditemukan !!! ");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
