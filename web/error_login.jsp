<%-- 
    Document   : errorlogin
    Created on : 22/03/2013, 04:41:15 PM
    Author     : Max
--%>

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link type="text/css" href="calendario/css/jquery-ui.css" rel="stylesheet" />    
<link type="text/css" href="css/general.css" rel="stylesheet" />  
<link type="text/css" href="css/panelEmergente.css" rel="stylesheet" /> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> JSP Page</title>
    </head>
    <body>
     
        <%
            if ((!(request.getParameter("usuario").equals(null))
                 && !(request.getParameter("usuario").equals("")))
             && (!request.getParameter("clave").equals(null)
                 && !(request.getParameter("clave").equals(""))))
            {
        %>
        <jsp:forward page="index.jsp" />
        <% } 
             
        else {%>
        <jsp:include page="index.jsp">
            <jsp:param name = "mensaje" value = " Usuario y password tienen que tener un valor..."/>    
        </jsp:include>
        
        <% } %>
       <script> 
                alert ("Ingresa el Usuario y Clave"); 
       </script> 
       </body>
</html>
