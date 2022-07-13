<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zadatak 5</title>
    </head>
    <body style="text-align: center; margin-top: 1em;">
        <form action="iis05">
            <input type="text" name="grad"/>  
            <input type="submit" value="Search"/>  

        </form>
        <div style="margin-top: 1em; text-align: center;">  
        <h2>Temperature is:</h2>
        <h1> <c:out value="${temperatura != null ? temperatura : 'no temperatura found'}"/></h1>
        </div>
    </body>


</body>
</html>
