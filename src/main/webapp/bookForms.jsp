<%--
  Created by IntelliJ IDEA.
  User: ameysatwe
  Date: 11/10/24
  Time: 6:02 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Books</title>
</head>
<body>
<h1>Add Books</h1>
<form method="post" action="SubmitBooksServlet">
  <table border="1">
    <tr>
      <th>ISBN</th>
      <th>Title</th>
      <th>Author</th>
      <th>Price</th>
    </tr>
    <%
      // Retrieve the number of books and loop to create the input fields
      Integer numberOfBooks = (Integer) request.getAttribute("numberOfBooks");
      for (int i = 0; i < numberOfBooks; i++) {
    %>
    <tr>
      <td><input type="text" name="isbn<%= i %>" required></td>
      <td><input type="text" name="title<%= i %>" required></td>
      <td><input type="text" name="author<%= i %>" required></td>
      <td><input type="number" name="price<%= i %>" step="0.01" required></td>
    </tr>
    <%
      }
    %>
  </table>
  <input type="submit" value="Submit Books">
</form>
</body>
</html>

