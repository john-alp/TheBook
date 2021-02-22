<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Please select an action:</h2>
<br><br>

<form:form action="selectBook" modelAttribute="selectBook">


    Book search: <form:select path="department">
    <form:options items="${selectBook.departments}"/>
    </form:select>
    <br><br><br>
<%--    Which car do you want?--%>
<%--    <form:radiobuttons path="carBrand" items="${friend.carBrands}"/>--%>
<%--    <br><br>--%>
<%--    What languages do you want to know?--%>
<%--    <form:checkboxes path="languages" items="${friend.languageList}"/>--%>
<%--    <br><br>--%>
    <input type="submit" value="OK!">
</form:form>
</body>
</html>