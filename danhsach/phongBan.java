package danhsach;

import java.util.ArrayList;
import java.util.List;

public class phongBan {
	private String tenPhong;
    private List<nhanVien> danhSachNV;
    public phongBan(String tenPhong) {
        this.tenPhong = tenPhong;
        this.danhSachNV = new ArrayList<>();
    }
    public void themNhanVien(nhanVien nv) {
        danhSachNV.add(nv);
    }

    public void inDanhSach() {
        System.out.println("=== Danh sách nhân viên phòng " + tenPhong + " ===");
        for (nhanVien nv : danhSachNV) {
            System.out.println(nv);
        }
    }
    public double tinhLuongTrungBinh() {
        if (danhSachNV.isEmpty()) return 0;
        double tong = 0;
        for (nhanVien nv : danhSachNV) {
            tong += nv.tinhLuong();
        }
        return tong / danhSachNV.size();
    }

    public void inNhanVienLuongCaoHonTrungBinh() {
        double tb = tinhLuongTrungBinh();
        System.out.println("\n>> Nhân viên có lương cao hơn mức trung bình (" + tb + "):");
        for (nhanVien nv : danhSachNV) {
            if (nv.tinhLuong() > tb) {
                System.out.println(nv);
            }
        }
    }

    public double tongChiPhiLuong() {
        double tong = 0;
        for (nhanVien nv : danhSachNV) {
            tong += nv.tinhLuongThucNhan(); // bao gồm 10% thưởng
        }
        return tong;
    }
}
