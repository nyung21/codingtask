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
                <h1>Item List</h1>

                <form action="/item" method="GET">
                    <p>
                        Search item: <br/>
                         <label>Code</label>
                         <input type="text" name="code"  value="<c:out value='${code}' />" />   
                        <input type="submit" value="Search" />
                    </p>

                    <table>
                        <thead>
                            <tr>
                                <th> ID </th>
                                <th> Name </th>
                                <th> Code </th>
                                <th> Weight </th>
                                <th> TKO </th>
                                <th> CWB </th>
                                <th> TSW </th>
                                <th> Update </th>
                                <!-- <th> Delete </th> -->
                            </tr>
                        </thead>

                        <tbody>
                           <c:choose>
                            <c:when test="${empty code}">
                                <c:forEach items="${listOfItems}" var="item">
                                    <tr>
                                        <td>
                                            <c:out value="${item.id}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.name}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.code}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.weight}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.TKO}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.CWB}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.TSW}" />
                                        </td>
                                        <td> <a href="/transferInventory/${item.id}">Edit</a></td>
                                        <!-- <td>
                                <form action="/remove/${aSingleItemObject.id}" method="POST">
                                    <input type="submit" value="delete" />
                                </form>
                            </td> -->
                                    </tr>
                                </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${not empty item}">
                                    <tr>
                                        <td>
                                            <c:out value="${item.id}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.name}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.code}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.weight}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.TKO}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.CWB}" />
                                        </td>
                                        <td>
                                            <c:out value="${item.TSW}" />
                                        </td>
                                        <td> <a href="/transferInventory/${item.id}">Edit</a></td>
                                    </tr>
                                </c:if>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                    </form>
                    <a href="/">Home Page</a>
            </body>

            </html>