<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP - Hello World</title>
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        /* Card Styles */
        .card {
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            margin: 20px auto;
            max-width: 600px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* List Styles */
        ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        ul li {
            padding: 10px;
            margin: 10px 0;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            transition: box-shadow 0.3s ease;
            display: flex;
            align-items: center;
        }

        ul li:hover {
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
        }

        ul li a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
            margin-left: 10px;
        }

        ul li a:hover {
            text-decoration: underline;
        }

        /* Icon Styles (Font Awesome) */
        ul li .icon {
            font-size: 18px;
            color: #007bff;
        }
    </style>

    <!-- Font Awesome CDN for Icons -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>

<h1>Hello World!</h1>

<div class="card">
    <ul>
        <li>
            <span class="icon"><i class="fas fa-check-circle"></i></span>
            <a href="welcome.jsp">JSTL Demo</a>
        </li>
        <li>
            <span class="icon"><i class="fas fa-film"></i></span>
            <a href="movieLanding.jsp">Movies</a>
        </li>
        <li>
            <span class="icon"><i class="fas fa-book"></i></span>
            <a href="books">Books</a>
        </li>
        <li>
            <span class="icon"><i class="fas fa-tags"></i></span>
            <a href="customTag.jsp">Custom JSP</a>
        </li>
    </ul>
</div>

</body>
</html>
