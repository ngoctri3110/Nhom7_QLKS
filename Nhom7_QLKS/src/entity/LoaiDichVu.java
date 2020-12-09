package entity;

public class LoaiDichVu {
	private String maLoaiDV;
	private String tenLoaiDV;
	
	public LoaiDichVu() {
		// TODO Auto-generated constructor stub
	}

	public String getMaLoaiDV() {
		return maLoaiDV;
	}

	public void setMaLoaiDV(String maLoaiDV) {
		this.maLoaiDV = maLoaiDV;
	}

	public String getTenLoaiDV() {
		return tenLoaiDV;
	}

	public void setTenLoaiDV(String tenLoaiDV) {
		this.tenLoaiDV = tenLoaiDV;
	}

	@Override
	public String toString() {
		return "LoaiDichVu [maLoaiDV=" + maLoaiDV + ", tenLoaiDV=" + tenLoaiDV + "]";
	}
	
	
}
