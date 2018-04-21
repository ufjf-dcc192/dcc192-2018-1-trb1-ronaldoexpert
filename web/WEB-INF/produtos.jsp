<%@page import="java.util.List"%>
<%@page import="dcc192.ufjf.Produtos"%>
<%@include file="../jspf/cabecalho.jspf" %>
    <h1>Lista de Produtos</h1>
        <table border = 1>
            <th>Código</th>
            <th>Descrição</th>
            <th>Vlr Unitário</th>
            <%
                int i = 0;
                for(Produtos produtos : (List<Produtos>) request.getAttribute("produtos")) {
            %>   
            <tr>
                <td><%=produtos.getCodigo()%></td>
                <td><%=produtos.getDescricao()%></td>
                <td><%=produtos.getVlrUunitario() %></td>
                <td><a href='edita.html?id=<%=i%>'>Editar</a> <a href='excluir.html?id=<%=i%>'>Excluir</a></td>                
            </tr>
            <%
                i++;
            }            
            %>
        </table>
    </body>
</html>
