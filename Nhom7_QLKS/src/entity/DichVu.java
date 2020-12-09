package entity;

public class DichVu {
	private double donGia;
	private String maDV;
	private LoaiDichVu maLoaiDV;
	private String tenDV;
	
	public DichVu() {
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public LoaiDichVu getMaLoaiDV() {
		return maLoaiDV;
	}

	public void setMaLoaiDV(LoaiDichVu maLoaiDV) {
		this.maLoaiDV = maLoaiDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	@Override
	public String toString() {
		return "DichVu [donGia=" + donGia + ", maDV=" + maDV + ", maLoaiDV=" + maLoaiDV + ", tenDV=" + tenDV + "]";
	}
	
	
}
