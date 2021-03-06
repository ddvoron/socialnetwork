<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <tiles:insertAttribute name="head"/>
    <title>
        <tiles:insertAttribute name="title"/>
    </title>
</head>
<body>
<div id="menu-top">
    <tiles:insertAttribute name="menu"/>
</div>
<div id="content">
    <tiles:insertAttribute name="content"/>
</div>
</body>
</html>
