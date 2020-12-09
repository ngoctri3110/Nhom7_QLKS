package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;

public class TaiKhoanDao {
	public ArrayList<NhanVien> getTenNVTheoTaiKhoan(String tk){
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select TenNV from NhanVien where MaNV in (select MaNV from TaiKhoan where TaiKhoan = '" + tk + "')";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String tenNV = rs.getString("TenNV");
				NhanVien nhanVien = new NhanVien(tenNV);
				dsNV.add(nhanVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsNV;
	}
}
