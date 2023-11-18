<%-- 
    Document   : search.jsp
    Created on : May 21, 2023, 5:46:57 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Booking Start -->
<div class="container-fluid booking mt-5 pb-5">
    <div class="container pb-5">
        <div class="bg-light shadow" style="padding: 30px;">
            <form action="SearchCondidion">
                <div class="row align-items-center" style="min-height: 60px;">
                    <div class="col-md-10">

                        <div class="row">
                            <div class="col-md-4">
                                <div class="mb-3 mb-md-0">
                                    <select class="custom-select px-4" style="height: 47px;" name="regionSearch">
                                        <c:forEach var="r" items="${myRegions}" varStatus="status">
                                            <option value="${r.regionId}">${r.regionName}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                            <div class="col-md-4">
                                <div class="mb-3 mb-md-0">
                                    <select class="custom-select px-4" style="height: 47px;" name="placeSearch">
                                        <c:forEach var="p" items="${myPlaces}" varStatus="status">
                                            <option value="${p.placeId}">${p.placeName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-4">
                                <div class="mb-3 mb-md-0">
                                    <div class="date" id="date1" data-target-input="nearest">
                                        <input type="text" name="dateStartSearch" class="form-control p-4 datetimepicker-input" placeholder="Ngày khởi hành" data-target="#date1" data-toggle="datetimepicker"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <input type="submit" name="searchStr" value="Search" class="text-primary">

                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Booking End -->

