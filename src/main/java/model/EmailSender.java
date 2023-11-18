/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class EmailSender {

    public static void sendConfirmationEmail(String email, BookTour order, Tour tour) throws MessagingException {
        // Cấu hình thông tin liên quan đến thư
        String host = "smtp.gmail.com";
        String port = "587";
        final String username = "trieudz02@gmail.com";
        final String password = "hylpmfiuezpxbxia";
        String fromEmail = "trieudz02@gmail.com";
        String subject = "Xac nhan dat tour";
        // Tạo đối tượng Session từ thông tin cấu hình
        java.util.Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        double totalAmount = order.getTotalAmount();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        decimalFormat.applyPattern("#,###");
        String formattedTotalAmount = decimalFormat.format(totalAmount);
        // Xây dựng nội dung email
        String content = "<html><head>"
                + "<style>"
                + "table {"
                + "  border-collapse: collapse;"
                + "  width: 5 0%;"
                + "}"
                + "th, td {"
                + "  padding: 8px;"
                + "  text-align: left;"
                + "  border-bottom: 1px solid #ddd;"
                + "}"
                + "th {"
                + "  background-color: #f2f2f2;"
                + "}"
                + "</style>"
                + "</head><body>"
                + "<h1>Xin chào, " + order.getName() + "</h1>"
                + "<p>Tour của bạn đã được đặt thành công.</p>"
                + "<h2>Thông tin tour:</h2>"
                + "<table>"
                + "<tr><th>Tên khách hàng</th><td>" + order.getName() + "</td></tr>"
                + "<tr><th>Tên tour</th><td>" + tour.getTourName() + "</td></tr>"
                + "<tr><th>Ngày khởi hành</th><td>" + tour.getDateStart() + "</td></tr>"
                + "<tr><th>Ngày kết thúc</th><td>" + tour.getDateEnd() + "</td></tr>"
                + "<tr><th>Ngày đặt vé</th><td>" + order.getDate() + "</td></tr>"
                + "<tr><th>Số lượng người lớn</th><td>" + order.getQuantityAd() + "</td></tr>"
                + "<tr><th>Số lượng trẻ em</th><td>" + order.getQuantityChildren() + "</td></tr>"
                + "<tr><th>Tổng tiền</th><td>" + formattedTotalAmount + " VND </td></tr>"
                + "</table>"
                + "</body></html>";

        // Tạo đối tượng MimeMessage
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject(subject);
        message.setContent(content, "text/html; charset=utf-8");

        // Gửi email
        Transport.send(message);
    }
}
