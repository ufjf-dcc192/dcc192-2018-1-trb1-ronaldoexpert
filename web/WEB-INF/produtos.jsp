<%@page import="java.util.List"%>
<%@page import="dcc192.ufjf.Produtos"%>
<%@include file="../jspf/cabecalho.jspf" %>
<link rel="stylesheet" href="css/colour.css">
<link rel="stylesheet" href="css/template.css">

    <h3>Lista de Produtos</h3>
    <div class="grid_16">
        <table>
            <thead>
                <th>Código</th>
                <th>Descrição</th>
                <th>Vlr Unitário</th>
                <th colspan="2" width="10%">Ações</th>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    for(Produtos produtos : (List<Produtos>) request.getAttribute("produtos")) {
                %>   
                <tr>
                    <td><%=i %></td>
                    <td><%=produtos.getDescricao()%></td>
                    <td><%=produtos.getVlrUunitario() %></td>
                    <td><a href="#" class="edit">Editar</a><a href="#" class="delete">Deletar</a></td>               
                </tr>
                <%
                    i++;
                }            
                %>
            </tbody>            
        </table>
            <a href="novoProduto.html" class="edit">Novo</a>
    </div>
    
 <%@include file="../jspf/footer.jspf" %>

