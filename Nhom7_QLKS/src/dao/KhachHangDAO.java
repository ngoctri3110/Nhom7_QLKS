package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHangDAO {
	public ArrayList<KhachHang> getTatCaKH(){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String cmnd = rs.getString("CMND");
				String diaChi = rs.getString("DiaChi");
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				String maKH = rs.getString("MaKH");
				Date ngaySinh = rs.getDate("NgaySinh");
				String quocTich = rs.getString("QuocTich");
				String tenKH = rs.getString("TenKH");
				KhachHang kh = new KhachHang(cmnd, diaChi, gioiTinh, maKH, ngaySinh, quocTich, tenKH);
				dsKH.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	public boolean create(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into KhachHang values(?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setBoolean(3, kh.isGioiTinh());
			stmt.setDate(4, (Date) kh.getNgaySinh());
			stmt.setString(5, kh.getDiaChi());
			stmt.setString(6, kh.getCmnd());
			stmt.setString(7, kh.getQuocTich());
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
	
	public ArrayList<KhachHang> getTenKHTheoCMND(String cmnd){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select TenKH from KhachHang where CMND = '" + cmnd + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String tenKH = rs.getString("TenKH");
				KhachHang kh1 = new KhachHang(tenKH);
				dsKH.add(kh1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsKH;
	}
}
