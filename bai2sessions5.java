public class bai2sessions5 {
    public static void main(String[] args) {
        int soLanLap = 1000000; // 1 triệu lần
        String chuoiThem = " World";

        System.out.println("=== SO SÁNH THỜI GIAN NỐI CHUỖI ===");
        System.out.println("Số lần nối: " + soLanLap);
        System.out.println("Chuỗi thêm: \"" + chuoiThem + "\"");
        System.out.println();

        // 1. Sử dụng String
        System.out.println("1. Sử dụng String:");
        long batDauString = System.currentTimeMillis();

        String ketQuaString = "Hello";
        for (int i = 0; i < soLanLap; i++) {
            ketQuaString += chuoiThem;
        }

        long ketThucString = System.currentTimeMillis();
        long thoiGianString = ketThucString - batDauString;
        System.out.println("   Thời gian thực hiện: " + thoiGianString + " ms");
        System.out.println("   Độ dài chuỗi kết quả: " + ketQuaString.length() + " ký tự");

        // 2. Sử dụng StringBuilder
        System.out.println("\n2. Sử dụng StringBuilder:");
        long batDauStringBuilder = System.currentTimeMillis();

        StringBuilder ketQuaStringBuilder = new StringBuilder("Hello");
        for (int i = 0; i < soLanLap; i++) {
            ketQuaStringBuilder.append(chuoiThem);
        }
        String chuoiStringBuilder = ketQuaStringBuilder.toString();

        long ketThucStringBuilder = System.currentTimeMillis();
        long thoiGianStringBuilder = ketThucStringBuilder - batDauStringBuilder;
        System.out.println("   Thời gian thực hiện: " + thoiGianStringBuilder + " ms");
        System.out.println("   Độ dài chuỗi kết quả: " + chuoiStringBuilder.length() + " ký tự");

        // 3. Sử dụng StringBuffer
        System.out.println("\n3. Sử dụng StringBuffer:");
        long batDauStringBuffer = System.currentTimeMillis();

        StringBuffer ketQuaStringBuffer = new StringBuffer("Hello");
        for (int i = 0; i < soLanLap; i++) {
            ketQuaStringBuffer.append(chuoiThem);
        }
        String chuoiStringBuffer = ketQuaStringBuffer.toString();

        long ketThucStringBuffer = System.currentTimeMillis();
        long thoiGianStringBuffer = ketThucStringBuffer - batDauStringBuffer;
        System.out.println("   Thời gian thực hiện: " + thoiGianStringBuffer + " ms");
        System.out.println("   Độ dài chuỗi kết quả: " + chuoiStringBuffer.length() + " ký tự");

        // So sánh kết quả
        System.out.println("\n=== KẾT QUẢ SO SÁNH ===");
        System.out.println("String:        " + thoiGianString + " ms");
        System.out.println("StringBuilder: " + thoiGianStringBuilder + " ms");
        System.out.println("StringBuffer:  " + thoiGianStringBuffer + " ms");

        // Tính tỷ lệ hiệu suất
        if (thoiGianStringBuilder > 0) {
            double tyLeStringVsBuilder = (double) thoiGianString / thoiGianStringBuilder;
            double tyLeBufferVsBuilder = (double) thoiGianStringBuffer / thoiGianStringBuilder;

            System.out.println("\n=== TỶ LỆ HIỆU SUẤT ===");
            System.out.println("String chậm hơn StringBuilder: " + String.format("%.1f", tyLeStringVsBuilder) + " lần");
            System.out.println("StringBuffer chậm hơn StringBuilder: " + String.format("%.1f", tyLeBufferVsBuilder) + " lần");
        }

        // Nhận xét
        System.out.println("\n=== NHẬN XÉT ===");
        System.out.println("1. String:");
        System.out.println("   - Không hiệu quả cho phép nối chuỗi nhiều lần");
        System.out.println("   - Tạo ra nhiều đối tượng mới trong bộ nhớ");
        System.out.println("   - Chậm nhất do phải tạo và hủy nhiều đối tượng");

        System.out.println("\n2. StringBuilder:");
        System.out.println("   - Hiệu quả và nhanh chóng nhất");
        System.out.println("   - Thích hợp cho nhiều thao tác nối chuỗi trong một luồng");
        System.out.println("   - Không đồng bộ (không an toàn với đa luồng)");

        System.out.println("\n3. StringBuffer:");
        System.out.println("   - Tương tự như StringBuilder nhưng an toàn với đa luồng");
        System.out.println("   - Có thể chậm hơn một chút do cơ chế đồng bộ hóa");
        System.out.println("   - Nên sử dụng khi làm việc với đa luồng");

        System.out.println("\n=== KHUYẾN NGHỊ SỬ DỤNG ===");
        System.out.println("- Sử dụng String: Khi chuỗi ít thay đổi hoặc số lần nối ít");
        System.out.println("- Sử dụng StringBuilder: Khi cần nối chuỗi nhiều lần trong một luồng");
        System.out.println("- Sử dụng StringBuffer: Khi cần nối chuỗi nhiều lần trong môi trường đa luồng");
    }
}