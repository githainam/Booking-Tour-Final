<%-- 
    Document   : Blog.jsp
    Created on : Jun 18, 2023, 1:17:48 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog Page</title>
        <%@include file="includes/head.jsp" %>

    </head>

    <body>
        <%@include file="includes/topbar.jsp" %>
        <div class="container-fluid page-header">
            <div class="container">
                <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 400px">
                    <h3 class="display-4 text-white text-uppercase">Blog</h3>
                    <div class="d-inline-flex text-white">
                        <p class="m-0 text-uppercase"><a class="text-white" href="">Home</a></p>
                        <i class="fa fa-angle-double-right pt-1 px-3"></i>
                        <p class="m-0 text-uppercase">Blog</p>
                    </div>
                </div>
            </div>
        </div>
                <%@include file="includes/search.jsp" %>

        <div class="container-fluid py-5">
            <div class="container py-5">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="row pb-3">   
                            <c:forEach var="b" items="${myBlogs}">
                                <div class="col-md-6 mb-4 pb-2">
                                    <div class="blog-item">
                                        <div class="position-relative">
                                            <img class="img-fluid w-100" src="img/${b.thumbnail}" alt="">
                                            <div class="blog-date">
                                                <h6 class="font-weight-bold mb-n1">${b.updated_date}</h6>
                                            </div>
                                        </div>
                                        <div class="bg-white p-4">
                                            <div class="d-flex mb-2">
                                                <a class="text-primary text-uppercase text-decoration-none" href="blogDetail?blog_id=${b.blog_id}">Admin</a>
                                                <span class=" px-2">${b.brief_infor}</span>
                                            </div>
                                            <a class="h5 m-0 text-decoration-none" href="blogDetail?blog_id=${b.blog_id}">${b.title}</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="col-lg-4 mt-5 mt-lg-0">



                        <!-- Category List -->


                        <!-- Recent Post -->
                        <div class="mb-5">
                            <h4 class="text-uppercase mb-4" style="letter-spacing: 5px;">Recent Post</h4>
                            <c:forEach var="b" items="${myBlogs}">
                                <a class="d-flex align-items-center text-decoration-none bg-white mb-3" href="">
                                    <img class="img-fluid" src="img/blog-100x100.jpg" alt="">
                                    <div class="pl-3">
                                        <h6 class="m-1">${b.title}</h6>
                                        <small>Jan 01, 2050</small>
                                    </div>
                                </a>
                            </c:forEach>

                        </div>

                        <!-- Tag Cloud -->

                    </div>
                </div>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>

    </body>
    <%@include file="includes/foot.jsp" %>

</html>
