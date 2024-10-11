<%--
  Created by IntelliJ IDEA.
  User: ameysatwe
  Date: 11/10/24
  Time: 7:13 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://example.com/tags" prefix="custom" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CSV File Upload</title>
</head>
<body>
<h1>Enter the CSV file name</h1>
<form method="GET">
    <label for="csvFileName">CSV File Name:</label>
    <input type="text" id="csvFileName" name="csvFileName"/>
    <input type="submit" value="Submit"/>
</form>

<%
    String fileName = request.getParameter("csvFileName");
    if (fileName != null) {
        // Use custom tag to display CSV data
%>
<custom:csvTable csvFileName="<%= fileName %>"/>
<%
    }
%>
</body>
</html>
