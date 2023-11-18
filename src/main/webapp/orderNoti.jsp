<%-- 
    Document   : orderSuccess
    Created on : Jun 7, 2023, 3:49:21 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xác nhận thành công</title>
        <%@include file="includes/head.jsp" %>

    </head>
    <body>
        <%@include file="includes/topbar.jsp" %>
        <div class="container mt-5">
        <div class="alert alert-warning d-flex justify-content-center align-items-center" role="alert">
            <div class="text-center">
                <h1 class="alert-heading mb-3">Đặt vé tour thành công!</h1>
            <a href="OrderListServlet">Chuyen huong den Order</a>
            </div>
        </div></div>
        <%@include file="includes/footer.jsp" %>

    </body>
    <%@include file="includes/foot.jsp" %>

</html>