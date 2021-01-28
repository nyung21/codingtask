<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>
        <head>
            <style>
                table, th, td {
                border: 1px solid black;
                }
                th, td {
                padding: 10px;
                }
            </style>
        </head>

    <body>

        <!-- <h1>Springboot</h1>
        <c:out value = "${itemList.get(0).id}" />
        <c:out value = "${itemList.get(0).name}" /> -->
        <!-- <p>My first paragraph.</p> -->

        <h1> Inventory System </h1>

        <h3>
            <a href="/create">Create new item</a>
        </h3>
        <h3>
            <a href="/item">Item List</a>
        </h3>

    </body>

    </html>