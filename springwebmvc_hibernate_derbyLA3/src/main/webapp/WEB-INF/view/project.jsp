<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Project</title>
    
</head>
<body>
<h1>
    Add a Project
</h1>
 
<c:url var="addAction" value="/saveProject" ></c:url>
 
<form:form action="${addAction}" modelAttribute="project">
<table>
    
    <tr>
        <td>
            <label >
               Project Name
            </label>
        </td>
        <td>
            <form:input path="projectName"  size="30" />
           
        </td> 
    </tr>

    <tr>
        <td>
             <label >
               Project Description
            </label>
        </td>
        <td>
            <form:input path="projectDiscription" size="30" />
        </td> 
    </tr>
    
    <tr>
        <td colspan="2">
            
            
                <input type="submit"
                    value="<spring:message text="Add Project"/>" />
            
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