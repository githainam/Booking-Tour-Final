<%-- 
    Document   : aboutus
    Created on : May 21, 2023, 6:18:32 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About</title>
        <%@include file="includes/head.jsp" %>

    </head>
        <style>
        .img-fixed-size {
            width: 100%;
            height: 390px; /* Định rõ chiều cao */
        }
        .link-margin {
            font-size: 1px;
            height: 35px;
        }
    </style>
    <body>
        <%@include file="includes/topbar.jsp" %>
        <div class="container-fluid page-header">
            <div class="container">
                <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 400px">
                    <h3 class="display-4 text-white text-uppercase">About</h3>
                    <div class="d-inline-flex text-white">
                        <p class="m-0 text-uppercase"><a class="text-white" href="">Home</a></p>
                        <i class="fa fa-angle-double-right pt-1 px-3"></i>
                        <p class="m-0 text-uppercase">About</p>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="includes/search.jsp" %>
        <%@include file="includes/aboutus.jsp" %>


        <%@include file="includes/features.jsp" %>
        <!-- Team Start -->
        <div class="container-fluid py-5">
            <div class="container pt-5 pb-3">
                <div class="text-center mb-3 pb-3">
                    <h6 class="text-primary text-uppercase" style="letter-spacing: 5px;">Guides</h6>
                    <h1>Our Travel Guides</h1>
                </div>
                <div class="row" id="guidesContainer">
                    <c:forEach var="g" items="${myGuides}" varStatus="status">
                        <div class="col-lg-4 col-md-4 col-sm-6 pb-1">
                            <div class="team-item bg-white mb-4">
                                <div class="team-img position-relative overflow-hidden">
                                    <img class="img-fluid w-100 img-fixed-size" src="img/${g.guideImage}" alt="">
                                    <div class="team-social">
                                        <a class="btn btn-outline-primary btn-square" href=""><i class="fab fa-twitter"></i></a>
                                        <a class="btn btn-outline-primary btn-square" href=""><i class="fab fa-facebook-f"></i></a>
                                        <a class="btn btn-outline-primary btn-square" href=""><i class="fab fa-instagram"></i></a>
                                        <a class="btn btn-outline-primary btn-square" href=""><i class="fab fa-linkedin-in"></i></a>
                                    </div>
                                </div>
                                <div class="text-center p y-4">
                                    <a href="detailGuide?gid=${g.guideId}">
                                       <h5 class="text-truncate pb-3" style="margin: 10px">${g.guideName}</h5></a>
<!--                                    <p class="m-0">Designation</p>-->
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
        <!-- Team End -->
        <%@include file="includes/footer.jsp" %>

    </body>

    <%@include file="includes/foot.jsp" %>

</html>
