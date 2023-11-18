<%--
    Document   : single
    Created on : May 21, 2023, 12:22:04 AM
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
        <title>Single Tour Detail</title>
        <%@include file="includes/head.jsp" %>
        <style>
            .tour-image {
                width: 100%;
                height: auto;
            }
            .reviews-rating {
                position: absolute;
                top: 0;
                padding: 0px 10px;
            }
            .reviews-rating__star{
                width: 8px;
                height: 8px;
                margin: 0 2px;
                background-image: url(../..//images/star-none.svg);
                display: inline-block;
            }
            .is-active{
                background-image: url(../..//images/star.svg);
            }
            .is-half{
                background-image: url(../..//images/star-half.svg);
            }
        </style>
    </head>
    <body>
        <div id="notification"></div>

        <%@include file="includes/topbar.jsp" %>
        <div class="container py-5">

            <div class="row">
                <div class="col-md-6">
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="img/${detail.imageTour}" class="d-block w-100" alt="Image 1">
                            </div>
                            <div class="carousel-item">
                                <img src="img/${detail.imageTour}" class="d-block w-100" alt="Image 2">
                            </div>
                            <div class="carousel-item">
                                <img src="img/${detail.imageTour}" class="d-block w-100" alt="Image 3">
                            </div>
                            <div class="carousel-item">
                                <img src="img/${detail.imageTour}" class="d-block w-100" alt="Image 4">
                            </div>
                            <div class="carousel-item">
                                <img src="img/${detail.imageTour}" class="d-block w-100" alt="Image 5">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>



                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a id="menu1-tab"  class="nav-link active" data-toggle="tab" href="#home">Lịch trình</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#menu1">Điều khoản và chính sách</a>
                        </li>

                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div id="home" class="container tab-pane active"><br>
                            <h3>Schedule</h3>
                            <p> ${detail.day1}</p> <br>
                            <p> ${detail.day2}</p> <br>
                            <p> ${detail.day3}</p> <br>
                            <p> ${detail.day4}</p> <br>
                            <p> ${detail.day5}</p> <br>
                            <p> ${detail.day6}</p> <br>
                            <p> ${detail.day7}</p> <br>


                        </div>

                        <%@include file="includes/policies.jsp" %>


                    </div>

                </div>

                <div class="col-md-6">

                    <div class="col-md-12">
                        <h1>${detail.tourName} <span class="badge badge-danger">New</span></h1>

<!--                         <h2> ${detail.tourName} </h2>-->
                        <p><strong>Giá vé trên một người:  </strong><fmt:formatNumber value="  ${detail.price}" pattern="#,##0" /> VND</p>

                        <p><strong>Ngày khởi hành:</strong> ${detail.dateStart}</p>
                        <p><strong>Ngày kết thúc:</strong> ${detail.dateEnd}</p>
                        <p><strong>Số chỗ còn trống:</strong> ${detail.seat}</p>

                        <p><strong>Địa điểm:</strong> ${detail.placeName}</p>
                        <p><a href="detailGuide?gid=${detail.guideId}">
                                <strong>Hướng dẫn viên du lịch:</strong> ${detail.guideName}
                            </a></p>
                        <p>${detail.detailTour}</p>


                        <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo">Book Now</button>

                        <div id="demo" class="collapse mt-3" >
                            <form action="BookingServlet" method="post" >
                                <div class="form-group">
                                    <label for="fullName">Họ tên:</label>
                                    <input type="text" name="fullName" class="form-control" id="fullName" placeholder="Nhập họ tên" value="" minlength="3"  required>
                                </div>
                                <div class="form-group">
                                    <label for="phone">Số điện thoại:</label> 
                                    <input type="number" class="form-control"  name="phone" id="phone" pattern="[-+]?[0-9]" placeholder="Nhập số điện thoại" minlength="10" maxlength="10" value="" required>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Nhập địa chỉ email" value="" required>
                                </div>
                                <div class="form-group">
                                    <label for="address">Address:</label>
                                    <input type="address" class="form-control" name="address" id="address" placeholder="Nhập địa chỉ" value="" required>
                                </div>
                                <div class="form-group">
                                    <label for="adults">Số lượng người lớn:</label>
                                    <input type="number" class="form-control" id="adults" name="adults" placeholder="Nhập số lượng người lớn" min="1" value="1">
                                </div>
                                <div class="form-group">
                                    <label for="children">Số lượng trẻ em:</label>
                                    <input type="number" class="form-control" id="children" name="children" placeholder="Nhập số lượng trẻ em" min="0">
                                </div>

                                <div class="form-group">
                                    <label for="note">Ghi chú:</label>
                                    <textarea class="form-control" id="note" name="note" rows="3" placeholder="Nhập ghi chú" value="hello" required></textarea>
                                </div>



                                <input type="hidden" name="id" value="${detail.tourId}">
                                <button type="submit" class="btn btn-primary">Đặt vé</button>
                            </form>
                        </div>
                        <div class="col-md-12 mt-5">
                            <h4 class="text-uppercase mb-4" style="letter-spacing: 5px;">Some new tours</h4>
                            <c:forEach var="r" items="${tRelated}" varStatus="status">
                                <div class="d-flex align-items-center text-decoration-none bg-white mb-3">
                                    <img class="img-fluid" src="img/${r.imageTour}" alt="" width="100" height="100">
                                    <div class="pl-3">
                                        <h6 class="m-1" id="tour-${r.tourId}" onclick="redirectToDetail('${r.tourId}')" style="cursor: pointer">${r.tourName}</h6>
                                        <small>Jan 01, 2050</small>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>


                </div>
            </div>

            <div class="modal fade col-md-12" role="dialog" id="feedback">
                <div class="modal-dialog">
                    <div class="modal-content" style="border-radius: 10px; margin-top: 60px;">
                        <div class="modal-header">
                            <h2 style="margin-left: 35%">Bình luận</h2>
                        </div>
                        <div class="modal-body">
                            <form action="feedback">
                                <input type="hidden" name="tid" value="${detail.tourId}"/>
                                <b>Viết bình luận:</b>&nbsp;&nbsp;
                                <div class="form-group">
                                    <textarea name="subject" placeholder="Viết bình luận.." style="height:200px ; width: 460px"></textarea>
                                </div>

                                <b>Đánh giá:</b>&nbsp;&nbsp;
                                <div class="form-group" >
                                    <select name = "star" style="border-radius: 100px;" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                        <option >Ðánh giá sao cho tour </option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5" selected>5</option>
                                    </select>
                                </div>
                                <br>


                                <center><button type="submit" class="btn btn-dark" style="padding-right: 160px;padding-left: 160px; border-radius: 100px;">Bình luận</button></center>

                            </form>
                            <br><br>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade col-md-12" role="dialog" id="feedbackEdit">
                <div class="modal-dialog">
                    <div class="modal-content" style="border-radius: 10px; margin-top: 60px;">
                        <div class="modal-header">
                            <h2 style="margin-left: 35%">Bình luận</h2>
                        </div>
                        <div class="modal-body">
                            <form action="edit-feedback" method="post">
                                <input type="hidden" name="id" value="${detail.tourId}">
                                <div class="form-group">
                                    <textarea name="subject" placeholder="Viết bình luận.." style="height: 200px; width: 460px" value=""></textarea>
                                </div>
                                <h1>hello ${update.subject}</h1>
                                <div class="form-group">
                                    <select name="star" style="border-radius: 100px;" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                        <option>Ðánh giá sao cho tour </option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>                      `
                                    </select>
                                </div>
                                <br>
                                <center><button type="submit" class="btn btn-dark" style="padding-right: 160px;padding-left: 160px; border-radius: 100px;">Bình luận</button></center>
                            </form>
                            <br><br>
                        </div>
                    </div>
                </div>
            </div>


            <c:if test="${total == 0}">
                <h3 style="text-align: center; font-style: oblique;">Không có bình luận</h3>
            </c:if>        
            <div class="bg-white" style="padding: 30px; margin-bottom: 30px;">
                <h4 class="text-uppercase mb-4" style="letter-spacing: 5px;">${total} Comments</h4>
                <c:if test="${acc != null}">

                    <a data-toggle="modal" data-dismiss="modal" data-target="#feedback">
                        <h4 >
                            Viết nhận xét của bạn
                        </h4>
                    </a>
                </c:if>
                <c:forEach items="${listfeedbackbyproduct}" var="f">
                    <div class="media mb-4">
                        <img src="img/${f.avatar}" alt="Image" class="img-fluid mr-3 mt-1" style="width: 65px;">

                        <br/>
                        <div class="media-body">
                            <h6><a href="">${f.username}</a> <small><i>${f.date}</i></small></h6>
                            <c:if test="${f.u_id eq acc.id}">
                                <a href="delete-feedback?id=${f.id}" class="float-right btn btn-outline-danger">Xóa</a>

                            </c:if>

                            <c:if test="${f.u_id eq acc.id}">
                                <a href="edit-feedback?id=${f.id}" class="float-right btn btn-outline-danger" data-toggle="modal" data-dismiss="modal" data-target="#feedbackEdit">Edit</a>
                            </c:if>


                            <p class="mb-0">${f.feedback}</p>

                            <c:forEach var="i" begin="0" end="4">
                                <c:if test="${(f.rated_star - i) >= 1}">
                                    <div class="reviews-rating__star is-active"></div> 
                                </c:if>    
                                <c:if test="${(f.rated_star - i) < 1 && (f.rated_star - i) > 0}">
                                    <div class="reviews-rating__star is-active is-half"></div> 
                                </c:if>
                                <c:if test="${(f.rated_star - i) <= 0}">
                                    <div class="reviews-rating__star"></div> 
                                </c:if>
                            </c:forEach>
                        </div>

                    </div>
                </c:forEach>


            </div>

        </div>

        <%@include file="includes/footer.jsp" %>

    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://web8802.com/wp-content/themes/hienads/assets/js/quanhuyen.js"></script>
    <script>
                                            // Kiểm tra số chỗ còn trống
                                            var seatCount = ${detail.seat};
                                            if (seatCount === 0) {
                                                // Hiển thị thông báo "Tour đã hết chỗ"
                                                alert("Tour đã hết chỗ");
                                            }

    </script>
    <%@include file="includes/foot.jsp" %>

</html>