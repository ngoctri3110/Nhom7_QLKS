package entity;

import java.util.Date;

public class HoaDon {
	private String maHD;
	private KhachHang maKH;
	private NhanVien maNV;
	private Date ngaylapHD;
	private Date ngayNhanPhong;
	
	public HoaDon() {
	}

	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public Date getNgaylapHD() {
		return ngaylapHD;
	}

	public void setNgaylapHD(Date ngaylapHD) {
		this.ngaylapHD = ngaylapHD;
	}

	public Date getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public void setNgayNhanPhong(Date ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maKH=" + maKH + ", maNV=" + maNV + ", ngaylapHD=" + ngaylapHD
				+ ", ngayNhanPhong=" + ngayNhanPhong + "]";
	}
	
	
}
