package entity;

import java.util.Date;

public class ChiTietHoaDon {
	private String maCTHD;
	private HoaDon maHD;
	private Date ngayTraPhong;
	private String tenDV;
	private String tenKH;
	private String tenNV;
	private double thanhTien;
	
	public ChiTietHoaDon() {
	}

	public String getMaCTHD() {
		return maCTHD;
	}

	public void setMaCTHD(String maCTHD) {
		this.maCTHD = maCTHD;
	}

	public HoaDon getMaHD() {
		return maHD;
	}

	public void setMaHD(HoaDon maHD) {
		this.maHD = maHD;
	}

	public Date getNgayTraPhong() {
		return ngayTraPhong;
	}

	public void setNgayTraPhong(Date ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [maCTHD=" + maCTHD + ", maHD=" + maHD + ", ngayTraPhong=" + ngayTraPhong + ", tenDV="
				+ tenDV + ", tenKH=" + tenKH + ", tenNV=" + tenNV + ", thanhTien=" + thanhTien + "]";
	}
	
	
}
