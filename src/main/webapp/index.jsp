<%-- 
    Document   : index.jsp
    Created on : May 20, 2023, 9:55:05 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home </title>
        <%@include file="includes/head.jsp" %>

    </head>
    <style>
        .img-fixed-size {
            width: 100%;
            height: 250px; /* Định rõ chiều cao */
        }
        .link-margin {
            font-size: 1px;
            height: 35px;
        }
    </style>
    <body>
        <%@include file="includes/topbar.jsp" %>
        <%@include file="includes/carousel.jsp" %>
        <%@include file="includes/search.jsp" %>

        <div id="demo" class="carousel slide" data-ride="carousel">
            <ul class="carousel-indicators">
                <li data-target="#demo" data-slide-to="0" class="active"></li>
                <li data-target="#demo" data-slide-to="1"></li>
            </ul>
            <div class="container banner-container carousel-inner">

                <div class="carousel-item active">
                    <img src="img/quaaa-3238.gif" alt="Banner Image" class="banner-image">
                </div>
                <div class="carousel-item ">
                    <img src="img/banner-he-roi-di-thoi-4090.gif" alt="Banner Image" class="banner-image">
                </div>

            </div>
        </div>


        <%@include file="includes/aboutus.jsp" %>
        <div class="container py-5">
            <div class="container pt-5 pb-3">
                <div class="text-center mb-3 pb-3">
                    <h6 class="text-primary text-uppercase" style="letter-spacing: 5px;">Destination</h6>
                    <h1>Khám phá 3 miền</h1>
                    <p>Hiện đang có : ${tourCount}</p>

                </div>
                <div class="row">
                    <c:forEach var="r" items="${myRegions}" varStatus="status">

                        <div class="col-lg-4 col-md-4 mb-4">
                            <div class="destination-item position-relative overflow-hidden mb-2">
                                <img class="img-thumbnail"  src="img/${r.regionImage}" alt="">
                                <a class="destination-overlay text-white text-decoration-none" href="regionList?rid=${r.regionId}">
                                    <h5 class="text-white">${r.regionName}</h5>
                                </a>
                            </div>
                        </div> 
                    </c:forEach>
                </div>
            </div>


        </div>
        <!-- Packages Start -->
        <div class="container-fluid py-5">
            <div class="container pt-5 pb-3">
                <div class="text-center mb-3 pb-3">
                    <h6 class="text-primary text-uppercase" style="letter-spacing: 5px;">Khám phá</h6>
                    <h1>Danh sách tour</h1>
                </div>


                <div class="row">
                    <c:set var="itemsPerPage" value="6" /> <!-- Số lượng mục hiển thị trên mỗi trang -->
                    <c:set var="currentPage" value="${param.pageNumber eq null ? 1 : param.pageNumber}" /> <!-- Trang hiện tại, mặc định là trang 1 -->
                    <c:set var="totalPages" value="${(myTours.size() + itemsPerPage - 1) / itemsPerPage}" /> <!-- Tổng số trang -->

                    <c:forEach var="t" items="${myTours}" varStatus="status">
                        <c:if test="${status.index >= (currentPage - 1) * itemsPerPage && status.index < currentPage * itemsPerPage}">
                            <div class="col-lg-4 col-md-6 mb-4" >
                                <div class="package-item bg-white mb-2">
                                    <img class="img-fluid img-fixed-size" src="img/${t.imageTour}" alt="">
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
                                            <small class="m-0"><i class="fa fa-map text-primary mr-2"></i>Còn ${t.seat} chỗ</small>

                                        </div>
                                        <div  class= "link-margin text-center">
                                            <a class="h5 text-decoration-none " href="detail?tid=${t.tourId}">${t.tourName}</a>
                                        </div>
                                        <div class="border-top mt-4 pt-4">
                                            <div class="d-flex justify-content-between">
                                                <h6 class="m-0"><i class="fa fa-calendar-day text-primary mr-2"></i>${t.numberDay}<small> ngày</small></h6>
                                                <h5 class="m-0"><fmt:formatNumber value="${t.price}" pattern="#,##0" /> VND</h5>


                                            </div>
                                        </div>
                                        <div class="countdown" id="countdown-${t.tourId}" style="font-size: 17px; font-weight: bold; color: #7AB730;
                                             text-align: center; padding: 5px; margin-top: 15px; background-color: #f2f2f2; border-radius: 20px"></div>

                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>

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
                    <div class="hotline-container">
                        <a href="tel:0789458707" class="hotline-link">Đường dây nóng 0789458707</a>
                    </div>
                </div>
            </div>
        </div>



        <!-- Destination Start -->


        <!-- Destination Start -->

        <!-- Packages End -->
        <%@include file="includes/footer.jsp" %>


    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <script>
        function updateCountdown(dateStart, tourId) {
            var countdownElement = document.getElementById('countdown-' + tourId);
            var startDate = moment(dateStart, "YYYY-MM-DD"); // Chuyển đổi ngày bắt đầu thành đối tượng Moment

            function updateTimer() {
                var now = moment();
                var difference = startDate.diff(now); // Tính toán khoảng thời gian còn lại (diff)

                if (difference > 0) {
                    var duration = moment.duration(difference); // Chuyển đổi khoảng thời gian thành đối tượng Duration

                    var days = duration.days();
                    var hours = duration.hours();
                    var minutes = duration.minutes();
                    var seconds = duration.seconds();

                    countdownElement.innerHTML =
                            "Còn " + days + 'd ' + hours + 'h ';
                } else {
                    countdownElement.innerHTML = 'Tour đã bắt đầu!';
                    clearInterval(intervalId);
                }
            }

            // Cập nhật đếm ngược ngay lập tức
            updateTimer();

            // Cập nhật đếm ngược mỗi giây (1000 milliseconds)
            var intervalId = setInterval(updateTimer, 1000);
        }

        function updateAllCountdowns() {
        <c:forEach var="t" items="${myTours}">
            updateCountdown('${t.dateStart}', '${t.tourId}');
        </c:forEach>
        }

        // Gọi hàm updateAllCountdowns sau khi trang đã tải
        document.addEventListener("DOMContentLoaded", function () {
            updateAllCountdowns();
        });





    </script>


    <script>
        var today = new Date().toISOString().split('T')[0];
        document.getElementsByName("dateStartSearch")[0].setAttribute('min', today);
    </script>





    <%@include file="includes/foot.jsp" %>

</html>
