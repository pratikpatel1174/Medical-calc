<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Prevalence Rate Formula Calculator</h1>

	<div align="center">
        <form:form action="../prevalenceRate" method="post" modelAttribute="subCatForm">
            <table border="0">
  
                <tr>
                    <td>New and pre-existing cases of disease:</td>
                    <td><form:input path="param1" /></td>
					 
                </tr>
                <tr>
                    <td>Population size</td>
                    <td><form:input path="param2" /></td>
					
                </tr>
					<form:hidden path="subCategoryId" value="${medicalSubCategory.subCategoryId}" />
					<form:hidden path="subCategoryName" value="${medicalSubCategory.subCategory}" />
                <tr>
					<td><input type="submit" name="submit" value="Calculate"></td>
					<td><input type="button" name="reset" value="Reset"></td>
                </tr>
            </table>
        </form:form>
    </div>

<c:if test="${isSubCategoryResult}">
	
	<c:forEach items="${resultMap}" var="entry">
       <span> <h3>${entry.key}</h3> : ${entry.value} </span>
    </c:forEach>
	
</c:if>

	

</body>
</html>