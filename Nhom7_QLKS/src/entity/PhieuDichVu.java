package entity;

public class PhieuDichVu {
	private double giaDV;
	private ChiTietHoaDon maCTHD;
	private String maPhieuDV;
	private int soLuongSuDung;
	private double tongTienDV;
	
	public PhieuDichVu() {
	}

	public double getGiaDV() {
		return giaDV;
	}

	public void setGiaDV(double giaDV) {
		this.giaDV = giaDV;
	}

	public ChiTietHoaDon getMaCTHD() {
		return maCTHD;
	}

	public void setMaCTHD(ChiTietHoaDon maCTHD) {
		this.maCTHD = maCTHD;
	}

	public String getMaPhieuDV() {
		return maPhieuDV;
	}

	public void setMaPhieuDV(String maPhieuDV) {
		this.maPhieuDV = maPhieuDV;
	}

	public int getSoLuongSuDung() {
		return soLuongSuDung;
	}

	public void setSoLuongSuDung(int soLuongSuDung) {
		this.soLuongSuDung = soLuongSuDung;
	}

	public double getTongTienDV() {
		return tongTienDV;
	}

	public void setTongTienDV(double tongTienDV) {
		this.tongTienDV = tongTienDV;
	}

	@Override
	public String toString() {
		return "PhieuDichVu [giaDV=" + giaDV + ", maCTHD=" + maCTHD + ", maPhieuDV=" + maPhieuDV + ", soLuongSuDung="
				+ soLuongSuDung + ", tongTienDV=" + tongTienDV + "]";
	}
	
	
}
