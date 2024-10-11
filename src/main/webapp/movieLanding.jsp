<%--
  Created by IntelliJ IDEA.
  User: ameysatwe
  Date: 11/10/24
  Time: 12:08 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Tuition Waiver Form</title>
  <style>
    /* Basic Styling */
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
  </style>
</head>
<body>
<div>
  <form action="handleMovieLanding" method="post">
    <h2>Movies DB</h2>

    <label for="action">Select action:</label>
    <select id="action" name="action" required>
      <option value="browse">Browse Movies</option>
      <option value="search">Search Movies</option>
      <option value="addNewMovie">Add Movies</option>
    </select>

    <!-- Submit Button -->
    <input type="submit" value="Submit" />
  </form>
</div>
</body>
</html>
