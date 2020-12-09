package entity;

import java.util.Date;

public class KhachHang {
	private String cmnd;
	private String diaChi;
	private boolean gioiTinh;
	private String maKH;
	private Date ngaySinh;
	private String quocTich;
	private String tenKH;
	
	public KhachHang() {
	}
	
	public KhachHang(String tenKH) {
		super();
		this.tenKH = tenKH;
	}

	public KhachHang(String cmnd, String diaChi, boolean gioiTinh, String maKH, Date ngaySinh, String quocTich,
			String tenKH) {
		super();
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.maKH = maKH;
		this.ngaySinh = ngaySinh;
		this.quocTich = quocTich;
		this.tenKH = tenKH;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	@Override
	public String toString() {
		return "KhachHang [cmnd=" + cmnd + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", maKH=" + maKH
				+ ", ngaySinh=" + ngaySinh + ", quocTich=" + quocTich + ", tenKH=" + tenKH + "]";
	}
	
	
	
	
	
	
	
}
