<%--
  Created by IntelliJ IDEA.
  User: ameysatwe
  Date: 11/10/24
  Time: 4:04 pm
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

        input[type="text"],
        input[type="password"],
        select,
        textarea {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .radio-group,
        .checkbox-group {
            display: flex;
            gap: 20px; /* Space between items */
            margin-top: 5px;
        }

        .radio-group label,
        .checkbox-group label {
            font-weight: normal;
            display: flex;
            align-items: center;
        }

        .radio-group input,
        .checkbox-group input {
            margin-right: 5px;
        }

        input[type="file"] {
            margin-top: 5px;
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
<div>
    <form method="post">
        <h2>Tuition Waiver Form</h2>

        <label for="name">Search query:</label>
        <input type="text" id="name" name="keyword" required />

        <label for="type">Search type:</label>
        <select id="type" name="category" required>
            <option value="title">Title</option>
            <option value="director">Director</option>
            <option value="genre">Genre</option>
        </select>

        <input type="hidden" name="action" value="src" >

        <!-- Submit Button -->
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>
