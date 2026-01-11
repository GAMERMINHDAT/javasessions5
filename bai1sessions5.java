import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class bai1sessions5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập email từ bàn phím
        System.out.print("Nhập địa chỉ email: ");
        String email = scanner.nextLine();

        // Kiểm tra tính hợp lệ
        String ketQua = kiemTraEmailHopLe(email);

        // Hiển thị kết quả
        System.out.println(ketQua);

        scanner.close();
    }

    public static String kiemTraEmailHopLe(String email) {
        // Loại bỏ khoảng trắng thừa ở đầu và cuối
        email = email.trim();

        // Biểu thức chính quy kiểm tra email hợp lệ
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$";

        // Tạo Pattern và Matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        // Kiểm tra khớp
        if (matcher.matches()) {
            return "Email hợp lệ";
        } else {
            return "Email không hợp lệ";
        }
    }
}