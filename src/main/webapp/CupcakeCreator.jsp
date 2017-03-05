<%@page import="com.Entity.Toppings"%>
<%@page import="com.Entity.Bottoms"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Creator of cupcake's, what do you wish to make</h3>

        What do you like to order <%=session.getAttribute("username")%><br>
        <form name="CreateCupcake" action="CreateCupcake" method="POST">
            <%! ArrayList<Bottoms> list = new ArrayList<>();%>
            <% list = (ArrayList<Bottoms>) session.getAttribute("bottom");%>
            <%! ArrayList<Toppings> list2 = new ArrayList<>();%>
            <% list2 = (ArrayList<Toppings>) session.getAttribute("topping");%>
            <input type="hidden" name="hdnbt"/>
            <div id="bottom">
            <h3> Bottoms </h3>
            <table>
                <%for (int i = 0; i < list.size(); i++)
            {%>
                <tr>
                    <td id="<%="bottomname"+i%>">
                        <%=list.get(i).getBottom()%>
                        <% session.setAttribute("bottomname" + i, list.get(i).getBottom());%>
                    </td>
                    <td id="<%="bottomprice"+i%>">
                        <%=list.get(i).getPrice()%>
                        <% session.setAttribute("bottomprice" + i, list.get(i).getPrice());%>
                    </td>  
                    <td>
                        <input type="button" id="<%="bottombutton"+i%>" value="Choose" <!-- onclick="{document.CreateCupcake.hdnbt.value=this.value;document.CreateCupcake.submit();}" --></input> 
                    </td>
                </tr>
                <%}%>
                </table></div>
            <br>
            
            <h3> Toppings </h3>
            <div id="topping"><table>
                <%for (int i = 0; i < list2.size(); i++)
            {%>
                <tr>
                    <td id="<%="toppingname"+i%>">
                        <%=list2.get(i).getTopping()%>
                        <% session.setAttribute("toppingname" + i, list2.get(i).getTopping());%>
                    </td>
                    <td id d="<%="toppingprice"+i%>">
                        <%=list2.get(i).getPrice()%>
                        <% session.setAttribute("toppingprice" + i, list2.get(i).getPrice());%>
                    </td>  
                    <td>
                        <input type="button" id="<%="toppingbutton"+i%>" value="Choose" <!--onclick="{document.CreateCupcake.hdnbt.value=this.value;document.CreateCupcake.submit();}"--></input> 
                    </td>
                </tr>
                <%}%>
                </table></div>
        </c:forEach>
        <br>
        <br>
        <button type="submit" name="order" value="Order">Order</button>
        <br>
        <text name="status"> <%= session.getAttribute("cupcakestatus")%> </text>
    </form>
</body>

<script src="Main.js" type="text/javascript"></script>

</html>
