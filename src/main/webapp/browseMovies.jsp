<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: ameysatwe
  Date: 10/10/24
  Time: 7:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.assignment3.model.Movie" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Browse Movies</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h1>Movies List</h1>
<%--  <a href="movies/new" class="btn btn-primary mb-3">Add New Movie</a>--%>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>Title</th>
      <th>Genre</th>
      <th>Director</th>
      <th>Release Year</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="movie" items="${listMovies}">
      <tr>
        <td>${movie.title}</td>
        <td>${movie.genre}</td>
        <td>${movie.director}</td>
        <td>${movie.releaseYear}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

