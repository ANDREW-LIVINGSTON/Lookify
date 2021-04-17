<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Song</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.rtl.min.css" integrity="sha384-trxYGD5BY4TyBTvU5H23FalSCYwpLA0vWEvXXGm5eytyztxb+97WzzY+IWDOSbav" crossorigin="anonymous">
</head>
<body>
	<div class="d-flex justify-content-end"><a href="/dashboard">Dashboard</a></div>
	<br>
	<br>
	<h1><c:out value="${song.name}"/></h1>
<p>Artist: <c:out value="${song.artist}"/></p>
<p>rating: <c:out value="${song.rating}"/></p>
<form action="/songs/${song.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>