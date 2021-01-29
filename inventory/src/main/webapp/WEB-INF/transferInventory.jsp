<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@page isErrorPage="true" %>

                <!DOCTYPE html>

                <head>
                    <title>Transfer Inventory</title>
                </head>

                <body>
                    <h1>Edit Item</h1>
                    <p>
                        <form:errors path="aSingleItemObject.*" />
                    </p>
                    <!-- The difference between a new register and update is to get object.id, instead of object. -->
                    <form:form action="/transferInventory/${aSingleItemObject.id}" method="POST"
                        modelAttribute="aSingleItemObject">

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
                        <input type="submit" value="Edit" />
                    </form:form>
                    <br>
                    <form action="/remove/${aSingleItemObject.id}" method="POST">
                        <input type="submit" value="delete" />
                    </form>
                    <br>
                    <h1>Transfer Inventory</h1>
                    <form action="/transferInventory" method="POST">
                        <input type="hidden" name="id" value="${id}" />
                        <div>
                            <label>Qty:</label> 
                            <input type="text" name="qty" placeholder="qty" />
                        </div>
                        <div style="margin-top: 10px;">
                            <label>From:</label>
                            <select name="locationFrom" style="margin-right: 8px;">
                                <option></option>
                                <option value="TKO">TKO</option>
                                <option value="CWB">CWB</option>
                                <option value="TSW">TSW</option>
                            </select>
                            <label>to</label>
                            <select name="locationTo" style="margin-left: 8px;">
                                <option></option>
                                <option value="TKO">TKO</option>
                                <option value="CWB">CWB</option>
                                <option value="TSW">TSW</option>
                            </select>
                        </div>
                        <input type="submit" value="Transfer" style="margin-top: 10px;" />
                    </form>
                    <br><br>
                    <a href="/">Home Page</a>

                </body>

                </html>