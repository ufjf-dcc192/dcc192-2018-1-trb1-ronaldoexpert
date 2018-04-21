<%@page import="java.util.List"%>
<%@page import="dcc192.ufjf.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../jspf/cabecalho.jspf" %>
<link rel="stylesheet" href="css/colour.css">
<link rel="stylesheet" href="css/template.css">

        <label><h3>Mesas Abertas</h3></label>
        <div class="grid_16">
            <table>
                <thead> 
                    <th>Mesa</th>
                    <th>Cliente</th>
                    <th>Total</th>
                    <th colspan="1" width="10%">Ações</th>
                </thead> 
                <tbody>
                    <%
                        for(Pedido pedidos : (List<Pedido>) request.getAttribute("pedidos")) {
                    %>
                    <tr>
                       <td><%=pedidos.getIdMesa() %></td>
                       <td><%=pedidos.getResponsavel() %></td>
                       <td><%=pedidos.getTotal() %></td>
                       <td><a href="#" class="edit">Editar</a><a href="#" class="delete">Fechar</a></td>  
                    </tr>
                    <%
                    }            
                    %> 
                </tbody>
            </table>
            
        </div>
    </body>
</html>
