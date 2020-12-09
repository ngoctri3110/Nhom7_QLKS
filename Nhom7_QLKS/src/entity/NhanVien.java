package entity;

import java.util.Date;

public class NhanVien {
	private String maNV;
	private LoaiNhanVien loaiNV;
	private String tenNV;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String sdt;
	private String diaChi;
	
	public NhanVien() {
	}

	public NhanVien(String tenNV) {
		super();
		this.tenNV = tenNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public LoaiNhanVien getLoaiNV() {
		return loaiNV;
	}

	public void setLoaiNV(LoaiNhanVien loaiNV) {
		this.loaiNV = loaiNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", loaiNV=" + loaiNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", diaChi=" + diaChi + "]";
	}
	
	
}
