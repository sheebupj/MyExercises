
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>employeee</title>
   
</head>
<body>
<h1>
    Add an Employee
</h1>
 
<c:url var="addAction" value="/saveEmployee" ></c:url>
 
<form:form action="${addAction}" modelAttribute="employeeDTO">
<table>
    
    <tr>
        <td>
            <label >
               Name
            </label>
        </td>
        <td>
            <form:input path="firstName"  size="30" />
           
        </td> 
    </tr>

    <tr>
        <td>
             <label >
               Address
            </label>
        </td>
        <td>
            <form:input path="address" size="30" />
        </td> 
    </tr>
    <tr>
        <td>
             <label >
              Project
            </label>
        </td>
        <td>
            <form:select path="project" items="${projects}"  />
        </td> 
    </tr>
    
    <tr>
        <td colspan="2">
            
            
                <input type="submit"
                    value="<spring:message text="Add Employee"/>" />
            
        </td>
    </tr>
    </table>
</form:form>
<form:form >
<table >
<tr>
        <td>
            <label>
            ID
            </label>
        </td> 
    
<td></td>
   
        
        <td>
           <label>
               Emplyee Name
            </label>
        </td> 
    
    <td></td>
        
        <td>
           <label>
               Employee address
            </label>
        </td> 
        
       <td></td>
        
        <td>
           <label>
              project id
            </label>
        </td> 
    
   
    </tr>
    <c:forEach items="${employeeDTOs}" var="employeedto">
    <tr>
      
        <td>
            <label >
           ${employeedto.id}
            </label>
        </td> 
    

   <td></td>
        
        <td>
           <label>
                ${employeedto.firstName}
            </label>
        </td> 
    
    <td></td>
        
        <td>
           <label>
                ${employeedto.address}
            </label>
        </td> 
      <td></td>
        
        <td>
           <label>
                ${employeedto.projectName}
            </label>
        </td> 
    

    </tr>
    </c:forEach>
</table>  
</form:form>
</body>
</html>