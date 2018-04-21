<%@page import="java.util.List"%>
<%@page import="dcc192.ufjf.Produtos"%>
<%@include file="../jspf/cabecalho.jspf" %>
<link rel="stylesheet" href="css/colour.css">
<link rel="stylesheet" href="css/template.css">

    <h3>Lista de Produtos</h3>
    <div class="grid_16">
        <table>
            <thead>
                <th>C�digo</th>
                <th>Descri��o</th>
                <th>Vlr Unit�rio</th>
                <th colspan="2" width="10%">A��es</th>
            </thead>
            <tbody>
                <%
                    for(Produtos produtos : (List<Produtos>) request.getAttribute("produtos")) {
                %>   
                <tr>
                    <td><%=produtos.getCodigo()%></td>
                    <td><%=produtos.getDescricao()%></td>
                    <td><%=produtos.getVlrUunitario() %></td>
                    <td><a href="#" class="edit">Editar</a><a href="#" class="delete">Deletar</a></td>               
                </tr>
                <%
                }            
                %>
            </tbody>
        </table>
    </div>
    </body>
</html>
