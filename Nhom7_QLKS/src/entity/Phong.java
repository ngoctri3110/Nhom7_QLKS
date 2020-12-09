package entity;

public class Phong {
	private LoaiPhong maLoaiPhong;
	private String maPhong;
	private String moTa;
	private String tenPhong;
	private String tinhTrangPhong;
	
	public Phong() {
	}

	public Phong(LoaiPhong maLoaiPhong, String maPhong, String moTa, String tenPhong, String tinhTrangPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.maPhong = maPhong;
		this.moTa = moTa;
		this.tenPhong = tenPhong;
		this.tinhTrangPhong = tinhTrangPhong;
	}
	public LoaiPhong getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(LoaiPhong maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getTinhTrangPhong() {
		return tinhTrangPhong;
	}

	public void setTinhTrangPhong(String tinhTrangPhong) {
		this.tinhTrangPhong = tinhTrangPhong;
	}

	@Override
	public String toString() {
		return "Phong [maLoaiPhong=" + maLoaiPhong + ", maPhong=" + maPhong + ", moTa=" + moTa + ", tenPhong="
				+ tenPhong + ", tinhTrangPhong=" + tinhTrangPhong + "]";
	}
	
	
}
