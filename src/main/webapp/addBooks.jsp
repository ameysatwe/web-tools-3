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
  <style>
  body {
  font-family: Arial, sans-serif;
  margin: 20px;
  background-color: #f4f4f4;
  }

  form {
  max-width: 1000px;
  margin: auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  label {
  display: block;
  margin-top: 15px;
  font-weight: bold;
  }
  select,
  textarea {
  width: 100%;
  padding: 8px;
  margin-top: 5px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 4px;
  }

  input[type="submit"] {
    margin-top: 20px;
    padding: 10px 20px;
    background-color: #28a745;
    border: none;
    color: #fff;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
  }

  input[type="submit"]:hover {
    background-color: #218838;
  }
  table,
  th,
  td {
    border: 1px solid black;
    border-collapse: collapse;
  }
  </style>
</head>
<body>


<form method="post">
  <h1>Add Books</h1>
  <label for="numberOfBooks">Number of books to add:</label>
  <input type="number" id="numberOfBooks" name="numberOfBooks" min="1" required>
  <input type="submit" value="Generate Forms">
  <input type="hidden" name="action" value="numBooks">
</form>
</body>
</html>

