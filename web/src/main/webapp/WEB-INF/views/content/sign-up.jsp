<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container col-md-12 row">
    <div class="col-md-4 col-md-offset-4">
        <p class="text-center">Registration</p>
    </div>
    <div class="col-md-6 col-md-offset-3">
        <s:form role="form" id="registrationForm" action="add" modelAttribute="userForm" method="post">
            <div class="col-md-8 col-md-offset-2 form-group">
                <label for="name"></label>
                <s:input type="text" class="form-control" id="name" path="Name" placeholder="Input your Name"/>
            </div>
            <div class="col-md-8 col-md-offset-2 form-group">
                <label for="surname"></label>
                <s:input type="text" class="form-control" id="surname" path="Surname" placeholder="Input your Surname"/>
            </div>
            <div class="col-md-8 col-md-offset-2 form-group">
                <label for="email"></label>
                <s:input type="text" class="form-control" id="email" path="Email" placeholder="Input your E-mail"/>
            </div>
            <div class="col-md-8 col-md-offset-2 form-group">
                <label for="phone"></label>
                <s:input type="text" class="form-control" id="phone" path="Phone" placeholder="Input your Phone number"/>
            </div>
            <div class="col-md-8 col-md-offset-2 form-group">
                <label for="password"></label>
                <s:input type="password" class="form-control" id="password" path="Password" placeholder="Input your Password"/>
            </div>
            <div class="col-md-8 col-md-offset-2 form-group">
                <label for="password_repeat"></label>
                <input type="password" class="form-control" name="PasswordRepeat" id="password_repeat" placeholder="Repeat Password">
            </div>
            <div class="row-button col-md-8 col-md-offset-2 form-group">
                <div class="col-md-6">
                    <a class="ahref" href="">Already registered? Sign In</a>
                </div>
                <div class="col-md-6">
                    <button class="btn_reg btn btn-primary" type="button"
                            onclick="event.preventDefault();sendFormReg();">Accept</button>
                </div>
            </div>
        </s:form>
    </div>
</div>