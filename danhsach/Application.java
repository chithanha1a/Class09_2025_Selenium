package danhsach;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		phongBan pb = new phongBan("CNTT");

        System.out.print("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhân viên thứ " + (i + 1) + " ---");
            System.out.print("Mã NV: ");
            String ma = sc.nextLine();
            System.out.print("Tên NV: ");
            String ten = sc.nextLine();
            System.out.print("Phòng ban: ");
            String phong = sc.nextLine();
            System.out.print("Lương cơ bản: ");
            double luongCB = Double.parseDouble(sc.nextLine());
            System.out.print("Hệ số lương: ");
            double heso = Double.parseDouble(sc.nextLine());

            nhanVien nv = new nhanVien(ma, ten, phong, luongCB, heso);
            pb.themNhanVien(nv);
        }

        System.out.println("\n===== DANH SÁCH NHÂN VIÊN =====");
        pb.inDanhSach();

        pb.inNhanVienLuongCaoHonTrungBinh();

        System.out.println("\n>> Tổng chi phí trả lương (gồm 10% thưởng): " + pb.tongChiPhiLuong());

	}

}
