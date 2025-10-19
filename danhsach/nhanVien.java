package danhsach;

public class nhanVien {
	private String maNV;
    private String tenNV;
    private String phongBan;
    private double luongCoBan;
    private double heSoLuong;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public double getLuongCoBan() {
		return luongCoBan;
	}
	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
    
	public nhanVien(String maNV, String tenNV, String phongBan, double luongCoBan, double heSoLuong) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.phongBan = phongBan;
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }
	public double tinhLuong() {
        // Công thức: Lương = Lương cơ bản * Hệ số lương
        return luongCoBan * heSoLuong;
    }

    public double tinhLuongThucNhan() {
        // Có thêm thưởng trung bình hàng tháng = 10%
        return tinhLuong() * 1.1;
    }
    
    @Override
    public String toString() {
        return String.format("Mã: %s | Tên: %s | Phòng: %s | Lương: %.2f | Lương thực nhận: %.2f",
                maNV, tenNV, phongBan, tinhLuong(), tinhLuongThucNhan());
    }
}

