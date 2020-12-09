package entity;

import java.util.Date;

public class PhieuThuePhong {
	private HoaDon maHD;
	private PhieuThuePhong maPTP;
	private Date ngayThuePhong;
	private Date ngayTraPhong;
	private String tenKH;
	private String trangThaiPhong;
	
	public PhieuThuePhong() {
	}

	public HoaDon getMaHD() {
		return maHD;
	}

	public void setMaHD(HoaDon maHD) {
		this.maHD = maHD;
	}

	public PhieuThuePhong getMaPTP() {
		return maPTP;
	}

	public void setMaPTP(PhieuThuePhong maPTP) {
		this.maPTP = maPTP;
	}

	public Date getNgayThuePhong() {
		return ngayThuePhong;
	}

	public void setNgayThuePhong(Date ngayThuePhong) {
		this.ngayThuePhong = ngayThuePhong;
	}

	public Date getNgayTraPhong() {
		return ngayTraPhong;
	}

	public void setNgayTraPhong(Date ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getTrangThaiPhong() {
		return trangThaiPhong;
	}

	public void setTrangThaiPhong(String trangThaiPhong) {
		this.trangThaiPhong = trangThaiPhong;
	}

	@Override
	public String toString() {
		return "PhieuThuePhong [maHD=" + maHD + ", maPTP=" + maPTP + ", ngayThuePhong=" + ngayThuePhong
				+ ", ngayTraPhong=" + ngayTraPhong + ", tenKH=" + tenKH + ", trangThaiPhong=" + trangThaiPhong + "]";
	}
}
