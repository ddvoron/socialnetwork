<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="content col-md-12 row">
    <div class="col-md-2 empty">

    </div>
    <div class="col-md-2 menu">
        <a href="">
            <div class="menu-point">My Page</div>
        </a>
        <a href="">
            <div class="menu-point">My Contacts</div>
        </a>
        <a href="">
            <div class="menu-point">Messages</div>
        </a>
        <a href="">
            <div class="menu-point">Contacts search</div>
        </a>
    </div>
    <div class="col-md-4 middle">
        3
        <div class="col-md-12 messageForm">
            <form role="form">
                <input type="text" class="form-control" id="newMessage" placeholder="Type a message..."/>
            </form>
            <button class="btn_send" type="button"
                    onclick="event.preventDefault();sendFormReg();">Send</button>
        </div>
    </div>
    <div class="col-md-2 profile">
        4
    </div>
    <div class="col-md-2 empty">

    </div>
</div>