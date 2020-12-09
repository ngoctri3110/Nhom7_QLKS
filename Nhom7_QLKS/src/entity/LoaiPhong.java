package entity;

public class LoaiPhong {
	private String dienTich;
	private double donGia;
	private String maLoaiPhong;
	private int soGiuong;
	private int soLuongNg;
	private String tenLoaiPhong;
	
	public LoaiPhong() {
	}
	
	
	
	public LoaiPhong(String maLoaiPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
	}



	public LoaiPhong(String dienTich, double donGia, String maLoaiPhong, int soGiuong, int soLuongNg,
			String tenLoaiPhong) {
		super();
		this.dienTich = dienTich;
		this.donGia = donGia;
		this.maLoaiPhong = maLoaiPhong;
		this.soGiuong = soGiuong;
		this.soLuongNg = soLuongNg;
		this.tenLoaiPhong = tenLoaiPhong;
	}
	
	public LoaiPhong(int soGiuong, String tenLoaiPhong) {
		super();
		this.soGiuong = soGiuong;
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public String getDienTich() {
		return dienTich;
	}

	public void setDienTich(String dienTich) {
		this.dienTich = dienTich;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public int getSoGiuong() {
		return soGiuong;
	}

	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}

	public int getSoLuongNg() {
		return soLuongNg;
	}

	public void setSoLuongNg(int soLuongNg) {
		this.soLuongNg = soLuongNg;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	@Override
	public String toString() {
		return "LoaiPhong [dienTich=" + dienTich + ", donGia=" + donGia + ", maLoaiPhong=" + maLoaiPhong + ", soGiuong="
				+ soGiuong + ", soLuongNg=" + soLuongNg + ", tenLoaiPhong=" + tenLoaiPhong + "]";
	}
	
	
}
