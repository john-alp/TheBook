<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Please delete the book by selecting the author</h2>
<br><br>
<form:form action="deleteBook" modelAttribute="delBookAttribute">
    Author: <br><form:input path="author"/>
    <form:errors path="author"/>
    <br><br>

    Book title: <br><form:input path="bookName"/>
    <form:errors path="bookName"/>
    <br><br>

    Book rating: <br><form:input path="rating"/>
    <form:errors path="rating"/>
    <br><br>

    <input type="submit" value="OK!">
</form:form>
</body>
</html>