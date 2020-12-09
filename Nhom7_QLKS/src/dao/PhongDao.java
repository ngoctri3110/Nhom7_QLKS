package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;

public class PhongDao {
	public ArrayList<LoaiPhong> getLoaiPhongSoGiuongTheoTenPhong(String tenP){
		ArrayList<LoaiPhong> dsP = new ArrayList<LoaiPhong>();		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select TenLoaiPhong, SoGiuong from LoaiPhong where [MaLoaiPhong] in(\r\n"
					+ "Select [MaLoaiPhong] from [dbo].[Phong] where [TenPhong]=" + tenP + ")";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String tenLP = rs.getString("TenLoaiPhong");
				int soG = rs.getInt("SoGiuong");
				
				LoaiPhong lp = new LoaiPhong(soG, tenLP);
				dsP.add(lp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsP;
	}
	
	public ArrayList<Phong> getTatCaPhong(){
		ArrayList<Phong> dsKH = new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from Phong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maPhong = rs.getString("MaPhong");
				String maLoaiPhong = rs.getString("MaLoaiPhong");
				String tenPhong = rs.getString("TenPhong");
				String moTa = rs.getString("MoTa");
				String tinhTrangPhong = rs.getString("TinhTrangPhong");
				Phong phong = new Phong(new LoaiPhong(maLoaiPhong), maPhong, moTa, tenPhong, tinhTrangPhong);
				dsKH.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
}
