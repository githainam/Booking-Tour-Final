<%-- 
    Document   : index.jsp
    Created on : May 20, 2023, 9:55:05 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home </title>
        <%@include file="includes/head.jsp" %>

    </head>
    <style>

    </style>
    <body>
        <%@include file="includes/topbar.jsp" %>


        


      
        <!-- Packages Start -->
        <div class="container-fluid py-5">
            <div class="container pt-5 pb-3">
                <div class="text-center mb-3 pb-3">
                    <h6 class="text-primary text-uppercase" style="letter-spacing: 5px;">Khám phá</h6>
                    <h1>Danh sách tua</h1>
                </div>
                <div class="row">   
                    <c:set var="itemsPerPage" value="12" /> <!-- Số lượng mục hiển thị trên mỗi trang -->
                    <c:set var="currentPage" value="${param.pageNumber eq null ? 1 : param.pageNumber}" /> <!-- Trang hiện tại, mặc định là trang 1 -->
                    <c:set var="totalPages" value="${(myTours.size() + itemsPerPage - 1) / itemsPerPage}" /> <!-- Tổng số trang -->

                    <c:forEach var="t" items="${myTours}" varStatus="status">
                        <c:if test="${status.index >= (currentPage - 1) * itemsPerPage && status.index < currentPage * itemsPerPage}">
                            <div class="col-lg-4 col-md-6 mb-4" >
                                <div class="package-item bg-white mb-2">
                                    <img class="img-fluid" src="img/${t.imageTour}" alt="">
                                    <div class="p-4">
                                        <div class="d-flex justify-content-between mb-3">
                                            <small class="m-0"><i class="fa fa-map-marker-alt text-primary mr-2"></i>${t.placeName}                                            
                                            </small>
                                            <small class="m-0"><i class="fa fa-user text-primary mr-2"></i>1 Person</small>
                                        </div>
                                        <div class="d-flex justify-content-between mb-3">
                                            <small class="m-0"><i class="fa fa-calendar-alt text-primary mr-2"></i>${t.dateStart}</small>
                                            <small class="m-0"><i class="fa fa-calendar-alt text-primary mr-2 "></i>${t.dateEnd}</small>
                                        </div>
                                        <div class="d-flex justify-content-between mb-3">
                                            <small class="m-0"><i class="fa fa-map text-primary mr-2"></i>${t.regionName}</small>
                                        </div>
                                        <a class="h5 text-decoration-none" href="detail?tid=${t.tourId}">${t.tourName}  <span class="badge badge-danger">HOT</span></a>
                                        <div class="border-top mt-4 pt-4">
                                            <div class="d-flex justify-content-between">
                                                <h5 class="m-0"><fmt:formatNumber value="${t.price}" pattern="#,##0" /> VND</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <!-- Hiển thị phân trang -->
                <c:if test="${myTours.size() > itemsPerPage}">
                    <ul class="pagination justify-content-center mt-4">
                        <li class="page-item${currentPage eq 1 ? ' disabled' : ''}">
                            <a class="page-link" href="?pageNumber=${currentPage - 1}">&laquo; Previous</a>
                        </li>
                        <c:forEach var="page" begin="1" end="${totalPages}">
                            <c:url var="pageURL" value="?pageNumber=${page}" />
                            <li class="page-item${page eq currentPage ? ' active' : ''}">
                                <a class="page-link" href="${pageURL}">${page}</a>
                            </li>
                        </c:forEach>
                        <li class="page-item${currentPage eq totalPages ? ' disabled' : ''}">
                            <a class="page-link" href="?pageNumber=${currentPage + 1}">Next &raquo;</a>
                        </li>
                    </ul>
                </c:if>
                <div class="container">
                    <!-- Các mã HTML khác -->
                    <div class="hotline-container">
                        <a href="tel:0789458707" class="hotline-link">Đường dây nóng 0789458707</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Destination Start -->
    </div>
</div>
<!-- Destination Start -->
<!-- Packages End -->
<%@include file="includes/footer.jsp" %>
</body>
<%@include file="includes/foot.jsp" %>

</html>
