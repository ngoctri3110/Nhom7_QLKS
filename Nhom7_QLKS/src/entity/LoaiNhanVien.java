package entity;

public class LoaiNhanVien {
	private String maLoaiNV;
	private String tenLoaiNV;
	
	public LoaiNhanVien() {
	}

	public String getMaLoaiNV() {
		return maLoaiNV;
	}

	public void setMaLoaiNV(String maLoaiNV) {
		this.maLoaiNV = maLoaiNV;
	}

	public String getTenLoaiNV() {
		return tenLoaiNV;
	}

	public void setTenLoaiNV(String tenLoaiNV) {
		this.tenLoaiNV = tenLoaiNV;
	}

	@Override
	public String toString() {
		return "LoaiNhanVien [maLoaiNV=" + maLoaiNV + ", tenLoaiNV=" + tenLoaiNV + "]";
	}
	
	
}
