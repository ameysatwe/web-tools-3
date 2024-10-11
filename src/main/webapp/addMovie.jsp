<%--
  Created by IntelliJ IDEA.
  User: ameysatwe
  Date: 10/10/24
  Time: 7:16 pm
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Movie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Add New Movie</h1>
    <form method="post">
        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" name="title" class="form-control" id="title" required>
        </div>
        <div class="mb-3">
            <label for="genre" class="form-label">Genre</label>
            <input type="text" name="genre" class="form-control" id="genre" required>
        </div>
        <div class="mb-3">
            <label for="director" class="form-label">Director</label>
            <input type="text" name="director" class="form-control" id="director" required>
        </div>
        <div class="mb-3">
            <label for="release_year" class="form-label">Release Year</label>
            <input type="number" name="release_year" id="release_year" class="form-control" required>
        </div>
        <input type="hidden" name="action" value="add" >
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
