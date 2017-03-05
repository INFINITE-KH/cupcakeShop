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
        
        <h2>Welcome to CupCaLicious</h2>
        
        <h4>Our motto is:</h4>
        <h4>Cup to the cake, you know how we roll</h4>
        
        Hello <%=session.getAttribute("username") %><br>
        Wallet: <%=session.getAttribute("balance") %>
        
        <form name="CupcakeCreator" action="CupcakeCreator.jsp" method="POST">
           
            <br>Like to create you'r cupcake press on the buttom below<br>
            <input type="submit" value="Order" />
             
        </form> 
        
        <form name="AddWallet" action="Wallet.jsp" method="POST">
            
        <br>Add money to wallet<br>

            <input type="submit" value="Click on me to add" />
        
        </form>
        
    </body>
</html>
