<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Person Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
Persons
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
               Name
            </label>
        </td> 
    
    <td></td>
        
        <td>
           <label>
               Country
            </label>
        </td> 
    
   
    </tr>
    <c:forEach items="${persons}" var="person">
    <tr>
      
        <td>
            <label >
           ${person.id}
            </label>
        </td> 
    

   <td></td>
        
        <td>
           <label>
                ${person.name}
            </label>
        </td> 
    
    <td></td>
        
        <td>
           <label>
                ${person.country}
            </label>
        </td> 
    

    </tr>
    </c:forEach>
</table>  
</form:form>
</body>
</html>