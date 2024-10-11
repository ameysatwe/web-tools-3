<%--
  Created by IntelliJ IDEA.
  User: ameysatwe
  Date: 11/10/24
  Time: 5:57 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Books</title>
</head>
<body>
<h1>Add Books</h1>

<form method="post">
  <label for="numberOfBooks">Number of books to add:</label>
  <input type="number" id="numberOfBooks" name="numberOfBooks" min="1" required>
  <input type="submit" value="Generate Forms">
  <input type="hidden" name="action" value="numBooks">
</form>
</body>
</html>

