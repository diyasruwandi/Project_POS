/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author DIYAS
 */
public class LaporanTransaksi {
    Connection con = dbkoneksi.konfig.sambung();

    // Fungsi untuk mendapatkan produk terjual
    public int getProdukTerjual(Date startDate, Date endDate) {
        String query = "SELECT SUM(qty) AS total_qty FROM transaksi WHERE tanggal_pesanan BETWEEN ? AND ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(startDate.getTime()));
            stmt.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total_qty");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Fungsi untuk mendapatkan produk terlaris
//    public String getProdukTerlaris(Date startDate, Date endDate) {
//        String query = "SELECT kode_produk, SUM(qty) AS total_qty " +
//                       "FROM transaksi WHERE tanggal_pesanan BETWEEN ? AND ? " +
//                       "GROUP BY kode_produk ORDER BY total_qty DESC LIMIT 1";
//        try (PreparedStatement stmt = con.prepareStatement(query)) {
//            stmt.setDate(1, new java.sql.Date(startDate.getTime()));
//            stmt.setDate(2, new java.sql.Date(endDate.getTime()));
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return rs.getString("kode_produk");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "-";
//    }
    
    public String getProdukTerlaris(Date startDate, Date endDate) {
    String query = "SELECT pp.nama_produk, SUM(t.qty) AS total_qty " +
                   "FROM transaksi t " +
                   "JOIN produkpenjualan pp ON t.kode_produk = pp.kode_produk " +
                   "WHERE t.tanggal_pesanan BETWEEN ? AND ? " +
                   "GROUP BY pp.nama_produk " +
                   "ORDER BY total_qty DESC LIMIT 1";
    try (PreparedStatement stmt = con.prepareStatement(query)) {
        stmt.setDate(1, new java.sql.Date(startDate.getTime()));
        stmt.setDate(2, new java.sql.Date(endDate.getTime()));
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("nama_produk"); // Mengambil nama produk dari hasil query
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return "Tidak ada produk terlaris";
}


    // Fungsi untuk mendapatkan pendapatan
    public double getPendapatan(Date startDate, Date endDate) {
        String query = "SELECT SUM(total) AS total_pendapatan FROM transaksi WHERE tanggal_pesanan BETWEEN ? AND ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(startDate.getTime()));
            stmt.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("total_pendapatan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
}
