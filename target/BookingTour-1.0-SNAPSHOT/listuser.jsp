<%-- 
    Document   : listuser
    Created on : Jun 6, 2023, 12:23:53 PM
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
        <div class="container">
            <div class="card-header my-3">All Orders</div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">username</th>
                        <th scope="col">password</th>
                        <th scope="col">email </th>
                        <th scope="col">phone</th>
                        <th scope="col">avatar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${acc}" var="a">
                        <tr>
                            <td>${a.id}</td>
                            <td>${a.username}</td>
                            <td>${a.password}</td>
                            <td>${a.email}</td>
                            <td>${a.phone}</td>
                            <td><img src="img/${a.avatar}" width="100" height="100" alt="alt"/></td>

                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>    </body>
</html>
