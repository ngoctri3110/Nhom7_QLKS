package entity;

public class ChiTietThuePhong {
	private PhieuDichVu maPhieuDV;
	private Phong maPhong;
	private PhieuThuePhong maPTP;
	
	public ChiTietThuePhong() {
	}

	public PhieuDichVu getMaPhieuDV() {
		return maPhieuDV;
	}

	public void setMaPhieuDV(PhieuDichVu maPhieuDV) {
		this.maPhieuDV = maPhieuDV;
	}

	public Phong getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(Phong maPhong) {
		this.maPhong = maPhong;
	}

	public PhieuThuePhong getMaPTP() {
		return maPTP;
	}

	public void setMaPTP(PhieuThuePhong maPTP) {
		this.maPTP = maPTP;
	}

	@Override
	public String toString() {
		return "ChiTietThuePhong [maPhieuDV=" + maPhieuDV + ", maPhong=" + maPhong + ", maPTP=" + maPTP + "]";
	}
	
	
}
