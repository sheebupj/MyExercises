<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Person Page</title>
  
</head>
<body>
<h1>
Project
</h1>
 

 
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
               Project Name
            </label>
        </td> 
    
    <td></td>
        
        <td>
           <label>
               Project description
            </label>
        </td> 
    
   
    </tr>
    <c:forEach items="${projects}" var="project">
    <tr>
      
        <td>
            <label >
           ${project.id}
            </label>
        </td> 
    

   <td></td>
        
        <td>
           <label>
                ${project.projectName}
            </label>
        </td> 
    
    <td></td>
        
        <td>
           <label>
                ${project.projectDiscription}
            </label>
        </td> 
    

    </tr>
    </c:forEach>
</table>  
</form:form>
</body>
</html>