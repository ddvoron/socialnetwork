<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container col-md-12 row">
    <div class="col-md-4 col-md-offset-4">
        <p class="text-center">Join us</p>
        <div class="col-md-8 col-md-offset-2">
            <a href="SignUp.html">
                <div class="col-md-6 init1">
                    Sign Up
                </div>
            </a>
            <a href="SignIn.html">
                <div class="col-md-6 init2">
                    Sign In
                </div>
            </a>
        </div>
    </div>
    <div class="col-md-6 col-md-offset-4"><img src="<c:url value="/resources/img/viber%20image.jpg"/>"/></div>
</div>