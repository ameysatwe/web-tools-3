<%--
  Created by IntelliJ IDEA.
  User: ameysatwe
  Date: 08/10/24
  Time: 7:20 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@ taglib prefix = "x"
           uri = "http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix = "fn"
           uri = "http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>User List</h2>

<c:set var="message" value="Hello, JSTL World!" />
<p>Message: <c:out value="${message}" /></p>

<!-- c:if for conditional rendering -->
<c:if test="${message != null}">
    <p>The message is not null!</p>
</c:if>

<!-- c:forEach to iterate over a list -->
<c:set var="items" value="${['Item 1', 'Item 2', 'Item 3']}" />
<ul>
    <c:forEach var="item" items="${items}">
        <li>${item}</li>
    </c:forEach>
</ul>


<h2>Formatting Tag Library</h2>

<!-- fmt:formatNumber to format a number -->
<p>Formatted Number: <fmt:formatNumber value="1234567.89" type="currency" /></p>

<!-- fmt:formatDate to format a date -->
<c:set var="currentDate" value="<%= new java.util.Date() %>" scope="page"/>

<!-- fmt:formatDate to format a date -->
<p>Formatted Date: <fmt:formatDate value="${currentDate}" pattern="dd MMM yyyy" /></p>


<!-- fmt:message for localization (example with key) -->
<fmt:setLocale value="en_US" />
<fmt:bundle basename="messages">
    <p><fmt:message key="welcome.message" /></p>
</fmt:bundle>

<sql:setDataSource var="ds" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/students"
                   user="amey" password="7507"/>

<sql:query dataSource="${ds}" var="rs">
    SELECT * FROM student_details;
</sql:query>
<c:forEach var="student" items="${rs.rows}">
    ${student.Student_Id} ${student.first_name}<br>
</c:forEach>

<sql:update dataSource="${ds}" var="rs">
    INSERT INTO student_details (first_name) VALUES(?);
    <sql:param>Karan</sql:param>
</sql:update>

<sql:query dataSource="${ds}" var="rs">
    SELECT * FROM student_details;
</sql:query>
<c:forEach var="student" items="${rs.rows}">
    ${student.Student_Id} ${student.first_name}<br>
</c:forEach>

<h3>Books Info:</h3>

<c:set var = "xmltext">
    <books>
        <book>
            <name>Padam History</name>
            <author>ZARA</author>
            <price>100</price>
        </book>

        <book>
            <name>Great Mistry</name>
            <author>NUHA</author>
            <price>2000</price>
        </book>
    </books>
</c:set>

<x:parse xml = "${xmltext}" var = "output"/>

<ul class = "list">
    <x:forEach select = "$output/books/book/name" var = "item">
        <li>Book Name: <x:out select = "$item" /></li>
    </x:forEach>
</ul>
<c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "${fn:split(string1, ' ')}" />
<c:set var = "string3" value = "${fn:join(string2, '-')}" />
<p>Final String : ${string3}</p>

<c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "${fn:substringBefore(string1, 'first')}" />
<p>Final sub string : ${string2}</p>
</body>
</html>
