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

<h1>False Positive Rate Calculator</h1>

	<div align="center">
        <form:form action="../calculateFormula" method="post" modelAttribute="subCatForm">
            <table border="0">
  
                <tr>
                    <td>Prevalence:</td>
                    <td><form:input path="param1" /></td>
					 <td><form:select class="form-control" path="param1_drop">
							<option value="1" selected="">fraction</option>
							<option value="0.01">%</option>
							<option value="1">ratio</option>
							</form:select>
					</td>
                </tr>
                <tr>
                    <td>Specificity</td>
                    <td><form:input path="param2" /></td>
					<td><form:select class="form-control" path="param2_drop">
							<option value="1" selected="">fraction</option>
							<option value="0.01">%</option>
							<option value="1">ratio</option>
							</form:select></td>
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