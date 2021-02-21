<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>Our library</h2>
<br><br><br>
<%--Your name: ${friend.author}--%>
<%--<br>--%>
<%--Your surname: ${friend.nameBook}--%>
<%--<br>--%>
<%--Your salary: ${friend.rating}--%>
<%--<br>--%>
<%--Your department: ${friend.department}--%>
<%--<br>--%>
<%--Your car: ${friend.carBrand}--%>
<br>
Our books:
<br>
Your book: ${testAuthor}
<br>
<%--<ul>--%>
<%--    <c:forEach var="lang" items="${friend.bookList}">--%>
<%--        <li> ${lang} </li>--%>
<%--    </c:forEach>--%>
<%--    <br>--%>
<%--</ul>--%>
<ul>
    <c:forEach var="lang" items="${list}">
        <li> ${lang} </li>
    </c:forEach>
    <br>
</ul>
<%--<br>--%>
<%--Phone number: ${friend.phoneNumber}--%>
<%--<br>--%>
</body>
</html>