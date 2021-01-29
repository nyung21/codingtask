<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> -->
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
                <h1>Upload CSV File</h1>
                <form action="/upload" method="POST" enctype="multipart/form-data">
                    <input type="file" name="file" />
                  </form>

                <!-- <form method="POST" th:action="@{/upload}" enctype="multipart/form-data">
                    <div class="form-group mt-3">
                        <label for="file">Select a CSV file</label>
                        <input type="file" name="file" class="form-control-file" id="file" accept=".csv">
                    </div>
                    <button type="submit" class="btn btn-primary">Import csv</button>
                </form> -->
                <!-- <div class="upload-container">
                    <div class="upload-content">
                        <div class="single-upload">
                            <h3>Upload the CSV File </h3>
                            <form id="singleUploadForm" name="singleUploadForm">
                                <input id="singleFileUploadInput" type="file" name="file" class="file-input" required />
                                <button type="submit" class="primary submit-btn">Submit</button>
                            </form>
                            <div class="upload-response">
                                <div id="singleFileUploadError"></div>
                                <div id="singleFileUploadSuccess"></div>
                            </div>
                        </div>

                    </div>
                </div> -->
                <a href="/">Home Page</a>
            </body>

            </html>