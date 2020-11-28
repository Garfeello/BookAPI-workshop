<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>Add Book</title>
</head>
<body style="background-color: lightblue;">
<div class="card-body d-flex justify-content-center">
    <div class="shadow p-3 mb-5 bg-white rounded w-25 p-10">
        <h1 style="text-align: center" class="display-4">Dodaj książkę</h1>
        <form method="post" action="/books/addBook">
            <div class="form-group">
                <label for="isbn">ISBN</label>
                <input type="text" name="isbn" class="form-control" id="isbn" placeholder="ISBN">
            </div>
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" name="title" class="form-control" id="title" placeholder="Title">
            </div>
            <div class="form-group">
                <label for="author">Author</label>
                <input type="text" name="author" class="form-control" id="author" placeholder="Author">
            </div>
            <div class="form-group">
                <label for="publisher">Publisher</label>
                <input type="text" name="publisher" class="form-control" id="publisher" placeholder="publisher">
            </div>
            <div class="form-group">
                <label for="type">Type</label>
                <input type="text" name="type" class="form-control" id="type" placeholder="type">
            </div>
            <button type="submit" class="btn btn-success">Send</button>
        </form>
    </div>
</div>
</body>
</html>
