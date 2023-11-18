<%-- 
    Document   : paymentSelect
    Created on : Jun 15, 2023, 11:40:27 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="includes/head.jsp" %>

</head>

<body>
    <%@include file="includes/topbar.jsp" %>
    <!-- Hướng dẫn thanh toán -->

    <!-- Hướng dẫn thanh toán bằng video -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle" aria-hidden="true" style="min-width: 50%">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Hướng dẫn thanh toán bằng video</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <video style="max-width: 100%;" src="https://sandbox.vnpayment.vn/apis/assets/images/Gioi-thieu-CTT-VNPAY.mp4" controls></video>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-dark" data-dismiss="modal">Đóng</button>
                </div>
            </div>
        </div>
    </div>

    <div class="container mt-5 mb-5">
        <div class="row" style="margin-top: 9%;">
            <div class="col-md-6 border-right">
                <div class="p-3 py-5">
                    <div class="col-md-12 text-center" style="">
                        <img style="width: 40%;" src="images/cart-completion/checked.png">
                    </div><br>
                    <div class="col-md-12">
                        <h3>Cảm ơn vì đã đặt hàng</h3>
                    </div><br>
                    <div class="col-md-12">
                        <h6><i>Chúng tôi sẽ gửi cho bạn một email xác nhận đơn hàng <br> với thông tin chi tiết và hướng dẫn thanh toán</i></h6>
                    </div><br>
                    <button type="button" class="btn btn-dark mt-3" data-toggle="modal" data-target="#exampleModalLong">
                        Hướng dẫn thanh toán
                    </button>
                    <button type="button" class="btn btn-light btn-outline-dark mt-3" data-toggle="modal"
                            data-target="#exampleModalCenter">
                        Hướng dẫn thanh toán bằng video
                    </button>
                </div>
            </div>
            <div class="col-md-6">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h3 class="text-right">Hình thức thanh toán</h3>
                    </div>
                    <div class="radio-buttons">
                        <div>
                            <form>
                                <label class="payment-method__item">
                                    <span class="payment-method__item-custom-checkbox custom-radio">
                                        <input type="radio" id="payment-COD" name="payment-method" value="COD">
                                        <span class="checkmark">
                                        </span>
                                    </span>
                                    <span class="payment-method__item-icon-wrapper"><img
                                            src="https://www.coolmate.me/images/COD.svg"></span>
                                    <span class="payment-method__item-name">COD <br>Thanh toán khi nhận hàng
                                    </span>
                                </label>
                                
                                
                                <label class="payment-method__item">
                                    <span class="payment-method__item-custom-checkbox custom-radio">
                                        <input type="radio" id="payment-vnpay" name="payment-method" value="vnpay">
                                        <span class="checkmark"> </span>
                                    </span>
                                    <span class="payment-method__item-icon-wrapper">
                                        <img src="https://www.coolmate.me/images/vnpay.png">
                                    </span>
                                    <span class="payment-method__item-name">
                                        Thẻ ATM / Internet Banking<br>Thẻ tín dụng (Credit card) / Thẻ ghi nợ (Debit
                                        card)<br>VNPay QR
                                    </span>
                                </label>
                                <div class="mt-5 text-center"><button class="btn btn-primary" type="submit">Thanh
                                        toán</button></div>
                            </form>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>
    <!-- Footer-->
    <%@include file="includes/footer.jsp" %>

    <!-- Bootstrap core JS-->

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<%@include file="includes/foot.jsp" %>

</html>
