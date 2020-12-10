package entity;

import java.util.Date;

public class PhieuThuePhong {
	private String maPTP;
	private Date ngayThuePhong;
	private Date ngayTraPhong;
	private String tenKH;
	private String trangThaiPhong;
	
	public PhieuThuePhong() {
	}
	
	

	public PhieuThuePhong(String maPTP, Date ngayThuePhong, Date ngayTraPhong, String tenKH,
			String trangThaiPhong) {
		super();
		this.maPTP = maPTP;
		this.ngayThuePhong = ngayThuePhong;
		this.ngayTraPhong = ngayTraPhong;
		this.tenKH = tenKH;
		this.trangThaiPhong = trangThaiPhong;
	}
	
	public String getMaPTP() {
		return maPTP;
	}



	public void setMaPTP(String maPTP) {
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
		return "PhieuThuePhong [maPTP=" + maPTP + ", ngayThuePhong=" + ngayThuePhong + ", ngayTraPhong=" + ngayTraPhong
				+ ", tenKH=" + tenKH + ", trangThaiPhong=" + trangThaiPhong + "]";
	}

}
