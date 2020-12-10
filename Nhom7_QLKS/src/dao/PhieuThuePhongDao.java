package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhieuThuePhong;

public class PhieuThuePhongDao {
	public ArrayList<PhieuThuePhong> getTatCaPTP(){
		ArrayList<PhieuThuePhong> dsPTP = new ArrayList<PhieuThuePhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhieuThuePhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maPTP = rs.getString("MaPTP");
				Date ngayThuePhong = rs.getDate("NgayThuePhong");
				Date ngayTraPhong = rs.getDate("NgayTraPhong");
				String tenKH = rs.getString("TenKh");
				String trangThaiPhong = rs.getString("TrangThaiPhong");
				PhieuThuePhong ptp = new PhieuThuePhong(maPTP, ngayThuePhong, ngayTraPhong, tenKH, trangThaiPhong);
				dsPTP.add(ptp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPTP;
	}
	
	public boolean create(PhieuThuePhong ptp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into PhieuThuePhong values(?, ?, ?, ?, ?)";
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ptp.getMaPTP());
			stmt.setDate(2, (Date) ptp.getNgayThuePhong());
			stmt.setDate(3, (Date) ptp.getNgayTraPhong());
			stmt.setString(4, ptp.getTenKH());
			stmt.setString(5, ptp.getTrangThaiPhong());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
