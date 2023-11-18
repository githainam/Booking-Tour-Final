<%-- 
    Document   : topbar
    Created on : May 20, 2023, 10:02:33 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="sticky-top">
            <!-- Topbar Start -->
            <div class="container-fluid bg-light pt-3 d-none d-lg-block">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 text-center text-lg-left mb-2 mb-lg-0">
                            <div class="d-inline-flex align-items-center">
                                <p><i class="fa fa-envelope mr-2"></i>info@example.com</p>
                                <p class="text-body px-3">|</p>
                                <p><i class="fa fa-phone-alt mr-2"></i>+012 345 6789</p>
                            </div>
                        </div>
                        <div class="col-lg-6 text-center text-lg-right">
                            <div class="d-inline-flex align-items-center">
                                <a class="text-primary px-3" href="https://www.facebook.com/trandtrieu2002">
                                    <i class="fab fa-facebook-f"></i>
                                </a>
                                <a class="text-primary px-3" href="">
                                    <i class="fab fa-twitter"></i>
                                </a>
                                <a class="text-primary px-3" href="">
                                    <i class="fab fa-linkedin-in"></i>
                                </a>
                                <a class="text-primary px-3" href="https://www.facebook.com/trandtrieu2002/">
                                    <i class="fab fa-instagram"></i>
                                </a>
                                <a class="text-primary pl-3" href="">
                                    <i class="fab fa-youtube"></i>
                                </a>

                                <form action="SearchServlet" style="margin-left: 20px"   >
                                    <input type="text" name="searchStr" placeholder="Search products...">
                                    <input type="submit" name="searchStr" value="Search" class="text-primary">
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <!-- Topbar End -->  
            <!-- Navbar Start -->
            <div class="container-fluid position-relative nav-bar p-0">
                <div class="container-lg position-relative p-0 px-lg-3" style="z-index: 9;">
                    <nav class="navbar navbar-expand-lg bg-light navbar-light shadow-lg py-3 py-lg-0 pl-3">
                        <a href="HomeController" class="navbar-brand">
                            <h1 class="m-0 text-primary"><span class="text-dark">Explore</span>Now</h1>
                        </a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between px-3" id="navbarCollapse">
                            <div class="navbar-nav ml-auto py-0">
                                <a href="HomeController" class="nav-item nav-link">Trang chủ</a>
                                <a href="AboutServlet" class="nav-item nav-link">Giới thiệu</a>
                                <a href="blog" class="nav-item nav-link">Blog</a>

                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Gói tour</a>
                                    <div class="dropdown-menu border-0 rounded-0 m-0">
                                        <c:forEach var="r" items="${myRegions}" varStatus="status">
                                            <a href="regionList?rid=${r.regionId}" class="dropdown-item">${r.regionName}</a>
                                        </c:forEach>
                                    </div>
                                </div>
                                <a href="#footerContact" class="nav-item nav-link">Liên hệ</a>
                                <c:if test="${sessionScope.acc != null}">
                                    <a href="OrderListServlet" class="nav-item nav-link">Order</a>
                                </c:if>
                                <c:if test="${sessionScope.acc == null}">
                                    <a href="Login" class="nav-item nav-link">Đăng nhập</a>
                                </c:if>
                                <c:if test="${sessionScope.acc != null}">
                                    <a href="LogoutServlet" class="nav-item nav-link">Đăng xuất</a>
                                </c:if>

                                <c:if test="${sessionScope.acc != null}">
                                    <a class="nav-item nav-link" style="text-decoration: none" href="Profile">
                                        Hello ${sessionScope.acc.username}
                                    </a>
                                </c:if> 
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Navbar End -->
    </body>
</html>
