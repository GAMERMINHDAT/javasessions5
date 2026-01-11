import java.util.Scanner;

public class bai3sessions5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CHƯƠNG TRÌNH KIỂM TRA MẬT KHẨU ===");
        System.out.println("Mật khẩu hợp lệ phải đáp ứng các yêu cầu:");
        System.out.println("1. Ít nhất 8 ký tự");
        System.out.println("2. Có ít nhất một chữ cái viết hoa");
        System.out.println("3. Có ít nhất một chữ cái viết thường");
        System.out.println("4. Có ít nhất một ký tự số");
        System.out.println("5. Có ít nhất một ký tự đặc biệt (@, #, $, !, %, ...)");
        System.out.println("=======================================\n");

        System.out.print("Nhập mật khẩu cần kiểm tra: ");
        String matKhau = scanner.nextLine();

        // Kiểm tra tính hợp lệ
        boolean hopLe = kiemTraMatKhauHopLe(matKhau);

        // Hiển thị kết quả
        if (hopLe) {
            System.out.println("\nKết quả: Mật khẩu hợp lệ");
        } else {
            System.out.println("\nKết quả: Mật khẩu không hợp lệ");
        }

        scanner.close();
    }

    public static boolean kiemTraMatKhauHopLe(String matKhau) {
        // Kiểm tra độ dài
        if (matKhau.length() < 8) {
            return false;
        }

        boolean coChuHoa = false;
        boolean coChuThuong = false;
        boolean coSo = false;
        boolean coKyTuDacBiet = false;

        // Duyệt qua từng ký tự trong mật khẩu
        for (int i = 0; i < matKhau.length(); i++) {
            char kyTu = matKhau.charAt(i);

            if (Character.isUpperCase(kyTu)) {
                coChuHoa = true;
            } else if (Character.isLowerCase(kyTu)) {
                coChuThuong = true;
            } else if (Character.isDigit(kyTu)) {
                coSo = true;
            } else {
                // Kiểm tra xem có phải là ký tự đặc biệt không
                // Các ký tự đặc biệt thông dụng: @#$!%^&*()-_+=<>?
                String kyTuDacBietStr = "@#$!%^&*()-_+=<>?";
                if (kyTuDacBietStr.indexOf(kyTu) != -1) {
                    coKyTuDacBiet = true;
                }
            }
        }

        // Trả về true nếu thỏa mãn tất cả điều kiện
        return coChuHoa && coChuThuong && coSo && coKyTuDacBiet;
    }
}