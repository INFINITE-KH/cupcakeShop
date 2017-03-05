<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    
    <body>
        
        <h3>Welcome customer</h3>
        
            <form name="ControlLogin" action="ControlLogin" method="POST">
                
                <input type="text" name="username" /><br>
                
                <input type="password" name="password" /><br>
                
                <input type="hidden" name="hdnbt"/>
                
                <input type="submit" id="loginknap" value="Login" onclick="{document.ControlLogin.hdnbt.value=this.value;document.ControlLogin.submit();}" />
                
            </form>   
        
            <form name="SignUp.jsp" action="SignUp.jsp" method="POST">
                
                <br><input type="submit" value="Sign up"/>
            
            </form>  
        
    </body>
    
</html>
