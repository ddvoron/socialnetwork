<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container col-md-12 row">
    <div class="col-md-4 col-md-offset-4">
        <p class="text-center">Sign In</p>
    </div>
    <div class="col-md-6 col-md-offset-3">
        <s:form role="form" action="logging" modelAttribute="userForm" method="post">
            <div class="col-md-8 col-md-offset-2 form-group">
                <label for="email"></label>
                <s:input type="text" class="form-control" id="email" path="Email" placeholder="Input your E-mail"/>
            </div>
            <div class="col-md-8 col-md-offset-2 form-group">
                <label for="password"></label>
                <s:input type="password" class="form-control" id="password" path="Password" placeholder="Input your Password"/>
            </div>
            <div class="row-button col-md-8 col-md-offset-2 form-group">
                <div class="col-md-6">
                    <a class="ahref" href="">Forgot password?</a>
                </div>
                <div class="col-md-6">
                    <button type="submit" class="btn_reg btn btn-primary">Accept</button>
                </div>
            </div>
        </s:form>
    </div>
</div>