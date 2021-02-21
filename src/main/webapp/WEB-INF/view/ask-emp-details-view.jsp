<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>The Book</h2>
<p>english please</p>
<br><br>
<form:form action="showDetails" modelAttribute="friend">
    Author: <br><form:input path="author"/>
    <form:errors path="author"/>
    <br><br>
    Book title: <br><form:input path="nameBook"/>
    <form:errors path="nameBook"/>
    <br><br>
    Book rating: <br><form:input path="rating"/>
    <form:errors path="rating"/>
    <br><br>
<%--    Phone number<br><form:input path="phoneNumber"/>--%>
<%--    <form:errors path="phoneNumber"/>--%>
<%--    <br><br>--%>
    Book search: <form:select path="department">
    <form:options items="${friend.departments}"/>
    </form:select>
    <br><br><br>
    Which car do you want?
    <form:radiobuttons path="carBrand" items="${friend.carBrands}"/>
    <br><br>
    What languages do you want to know?
    <form:checkboxes path="languages" items="${friend.languageList}"/>
    <br><br>
    <%--setters will work here--%>
    <input type="submit" value="OK!">
</form:form>
</body>
</html>