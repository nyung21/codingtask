<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

            <!DOCTYPE html>
            <html>

            <head>
                <style>
                    table,
                    th,
                    td {
                        border: 1px solid black;
                    }

                    th,
                    td {
                        padding: 10px;
                    }
                </style>
            </head>

            <body>
                <h1>Create Item</h1>

                <p>
                    <form:errors path="itemObject.*" />
                </p>
                <form:form action="/create" method="POST" modelAttribute="itemObject">
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
                    <input type="submit" value="Create Item" />
                </form:form>
                <br>
                <a href="/">Home Page</a>

            </body>

            </html>