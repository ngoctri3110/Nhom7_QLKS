package entity;

public class ChiTietDichVu {
	private String maCTDV;
	private DichVu maDV;
	private PhieuDichVu maPhieuDV;
	
	public ChiTietDichVu() {
	}

	public String getMaCTDV() {
		return maCTDV;
	}

	public void setMaCTDV(String maCTDV) {
		this.maCTDV = maCTDV;
	}

	public DichVu getMaDV() {
		return maDV;
	}

	public void setMaDV(DichVu maDV) {
		this.maDV = maDV;
	}

	public PhieuDichVu getMaPhieuDV() {
		return maPhieuDV;
	}

	public void setMaPhieuDV(PhieuDichVu maPhieuDV) {
		this.maPhieuDV = maPhieuDV;
	}

	@Override
	public String toString() {
		return "ChiTietDichVu [maCTDV=" + maCTDV + ", maDV=" + maDV + ", maPhieuDV=" + maPhieuDV + "]";
	}
	
	
}
