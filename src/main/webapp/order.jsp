<%-- 
    Document   : order
    Created on : Jun 5, 2023, 10:38:10 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your orders</title>
        <%@include file="includes/head.jsp" %>

    </head>
    <body>
        <%@include file="includes/topbar.jsp" %>

        <div class="container">
            <table class="table  table-bordered mt-5">

                <thead class="table-dark">
                    <tr class="text-light ">
                        <th scope="col">Mã đặt vé</th>
                        <th scope="col">Ngày</th>
                        <th scope="col">Tên khách hàng</th>
                        <th scope="col">Tên tour</th>
                        <th scope="col">Số lượng người lớn, trẻ em</th>
                        <th scope="col">Mã tour</th>
                        <th scope="col">Thành tiền</th>
                        <th scope="col">Ghi chú</th>


                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${myOrders}" var="o">
                        <tr>     
                            <td><a href="detail?tid=${o.tourId}">${o.tourId}</a></td>
                            <td>${o.date}</td>
                            <td>${o.name}</td>

                            <td><a href="detail?tid=${o.tourId} " >${o.tourName}</a></td>

                            <td>${o.quantityAd} - ${o.quantityChildren}</td>
                            <td>${o.tourId}</td>
                            <td><c:out value="${String.format('%.0f', o.totalAmount)} VND" /></td>
                            <td>${o.note}</td>


                        </tr>
                    </c:forEach>

                </tbody>

            </table>
            <c:if test="${empty myOrders}">
                <div class="alert alert-warning d-flex justify-content-center align-items-center" role="alert">
                    <div class="text-center">
                        <h4 class="alert-heading mb-3">Thông báo</h4>
                        <p class="mb-0">Danh sách của bạn hiện đang trống.</p>
                    </div>
                </div>
            </c:if>
        </div>
        <%@include file="includes/footer.jsp" %>

    </body>
    <%@include file="includes/foot.jsp" %>

</html>
