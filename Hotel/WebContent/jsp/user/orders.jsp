
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${Locale}" scope="session" />
<fmt:bundle basename="resources.pagecontent" >
<html>
<head>
  <link rel="stylesheet" href="/css/bootstrap.css" type="text/css" />
  <link href="/css/orders.css" rel="stylesheet" type="text/css" />
    <title>Orders</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="controller?command=goto_main"><span><fmt:message key="main.main" /></span></a></li>
        <li><a href="controller?command=goto_rooms" name="rooms"><span><fmt:message key="main.rooms" /></span></a></li>
        <li><a href="controller?command=goto_contacts" name="contacts"><span><fmt:message key="main.orders" /></span></a></li>
        <li><a href="controller?command=goto_aboutus" name="aboutus"><span><fmt:message key="main.aboutus" /></span></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="controller?command=logout"><fmt:message key="main.logout" /></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<table class="simple-little-table" cellpadding="0" style="margin: auto;">
  <tr>
    <td><fmt:message key="orders.table.price" /></td>
    <td><fmt:message key="orders.table.id" /></td>
    <td><fmt:message key="orders.table.action" /></td>
  </tr>
    <tr>
      <c:forEach items="${checks}" var="element">
        <td>${element.price} </td>
        <td>${element.checkId}</td>
        <td>
        <form action="controller" method="post">
          <button type="submit" name="command" value ="pay" class = button><fmt:message key="orders.pay" /></button>
          <input type = "hidden" name = "price" value = ${element.price}>
          <input type = "hidden" name = "login" value = ${element.login}>
          <input type = "hidden" name = "check_id" value = ${element.checkId}>
        </form>
      </td>
     </c:forEach>
    </tr>

</table>
</body>
</html>
</fmt:bundle>