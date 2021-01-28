<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isErrorPage="true" %>

<!DOCTYPE html>
<head>
    <title>Transfer Inventory</title>
</head>
<body>
    <h1>Transfer Inventory</h1>
    <p>
        <form:errors path="aSingleItemObject.*"/>
    </p>
    <!-- The difference between a new register and update is to get object.id, instead of object. -->
    <form:form action="/transferInventory/${aSingleItemObject.id}" method="POST" modelAttribute="aSingleItemObject">
        
    <p>
        <form:label path="name">Name </form:label>
        <!-- <form:errors path="name"/> -->
        <form:input path="name" />
    </p>
    <p>
        <form:label path="code">Code </form:label>
        <!-- <form:errors path="code"/> -->
        <form:input path="code" />
    </p>
    <p>
        <form:label path="weight">Weight </form:label>
        <!-- <form:errors path="weight"/> -->
        <form:input path="weight" />
    </p>
    <p>- Location -</p>
    <p>
        <form:label path="TKO">TKO </form:label>
        <form:input path="TKO" />
    </p>
    <p>
        <form:label path="CWB">CWB </form:label>
        <form:input path="CWB" />
    </p>
    <p>
        <form:label path="TSW">TSW </form:label>
        <form:input path="TSW" />
    </p>
        <input type="submit" value="Transfer"/>
    </form:form>
    <br>
    <form action="/remove/${aSingleItemObject.id}" method="POST">
        <input type="submit" value="delete"/>
    </form>
    <br>
    <a href="/">Home Page</a>

</body>
</html>