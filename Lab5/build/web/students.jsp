<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Web - laboratorium 5</title>
    </head>
    <body>
        <h1>Witamy w JSP!</h1>
        
        <form action='/Lab5/StudentServlet' method='post'>
             Studencie, dodaj się ! 
            <br>  
            Imie:<input type='text' name='firstName'>
            <br>
            Nazwisko: <input type='text' name='lastName'>
            <br>
            Email: <input type='text' name='email'>
            <br>
            <input type='submit'>
        </form>

        <table border="1">
            <c:forEach items="${sessionScope.Lista_osob}" var="person">
                <tr>  

                    <td> ${person.firstName}</td>
                    <td> ${person.lastName}</td>
                    <td> ${person.email}</td>

                </tr>
            </c:forEach>
        </table>
        
        <p>licznik: ${sessionScope.licznik}</p>
        
        
        
        
        
        
    </body>
</html>