import java.util.Random;

public class bai4sessions5 {

    public static String taoChuoiNgauNhien(int n) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(n);

        String kyTuHoa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String kyTuThuong = "abcdefghijklmnopqrstuvwxyz";
        String chuSo = "0123456789";
        String tatCaKyTu = kyTuHoa + kyTuThuong + chuSo;

        for (int i = 0; i < n; i++) {
            char kyTu = tatCaKyTu.charAt(random.nextInt(tatCaKyTu.length()));
            sb.append(kyTu);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] testCases = {5, 8, 12, 20, 1, 3, 15, 25, 50};

        System.out.println("=== KIỂM TRA TẠO CHUỖI NGẪU NHIÊN ===");
        System.out.println("| Test Case | Input | Output (Ngẫu nhiên) | Độ dài |");
        System.out.println("|-----------|-------|---------------------|--------|");

        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i];
            String ketQua = taoChuoiNgauNhien(n);

            System.out.printf("| %-9d | %-5d | %-19s | %-6d |\n",
                    i + 1, n, ketQua, ketQua.length());
        }

        // Test với n = 1000
        System.out.println("\n=== TEST HIỆU SUẤT VỚI n = 1000 ===");
        long batDau = System.currentTimeMillis();
        String chuoi1000 = taoChuoiNgauNhien(1000);
        long ketThuc = System.currentTimeMillis();

        System.out.println("Độ dài: " + chuoi1000.length());
        System.out.println("Thời gian tạo: " + (ketThuc - batDau) + " ms");

        // Kiểm tra các loại ký tự có trong chuỗi 1000 ký tự
        int demHoa = 0, demThuong = 0, demSo = 0;
        for (char c : chuoi1000.toCharArray()) {
            if (Character.isUpperCase(c)) demHoa++;
            else if (Character.isLowerCase(c)) demThuong++;
            else if (Character.isDigit(c)) demSo++;
        }

        System.out.println("\nPhân bố ký tự trong chuỗi 1000:");
        System.out.println("- Chữ hoa: " + demHoa + " (" + (demHoa*100.0/1000) + "%)");
        System.out.println("- Chữ thường: " + demThuong + " (" + (demThuong*100.0/1000) + "%)");
        System.out.println("- Chữ số: " + demSo + " (" + (demSo*100.0/1000) + "%)");
    }
}