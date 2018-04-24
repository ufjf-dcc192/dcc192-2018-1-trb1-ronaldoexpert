    
<%@page import="dcc192.ufjf.ListaDeProdutos"%>
<%@page import="dcc192.ufjf.ListaDePedidos"%>
<%@page import="dcc192.ufjf.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="dcc192.ufjf.Produtos"%>
<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.string"%>
<%@include file="../jspf/cabecalho.jspf" %>
<link rel="stylesheet" href="css/colour.css">
<link rel="stylesheet" href="css/template.css">

<div class="grid_16">
    <%Pedido pedidos = ListaDePedidos.getInstance().get(Integer.parseInt(request.getParameter("id")));%>
    <h3>
        Fechamento de Mesa 
        <label>Pedido: <%=pedidos.getNumero() %> </label> 
        <label>Data / Hora:  <%=pedidos.getData() %> - <%=pedidos.getHora() %> </label>
        <label>Mesa: <%=pedidos.getIdMesa().getDescricao() %> </label>
        <label>Responsável: <%=pedidos.getResponsavel() %> </label>
        <label>Hora Fechamento: <%=pedidos.getHrFechamento() %> </label>
    </h3>
    
    <table>
        <thead>
            <tr>
                <th>Descrição</th>
                <th>Valor Unitário</th>
                <th>Quantidade</th>
                <th>Total</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <%
                float vTotal = 0;
                                
                for(int i = 0; i < pedidos.getMovimento().size(); i++) {
            %>
            <tr class="alt">
                <td><%=pedidos.getMovimento().get(i).getCodProduto().getDescricao() %></td>
                <td>R$ <%=pedidos.getMovimento().get(i).getVlrUnitario() %></td>
                <td><%=pedidos.getMovimento().get(i).getQuatidade() %></td>
                <td>R$ <%=pedidos.getMovimento().get(i).getVlrTotal() %></td>
                <td><a href="excluiProdPed.html?id=<%=i%>" class="delete">Excluir</a></td>
            </tr>
            <%
                    vTotal = vTotal + pedidos.getMovimento().get(i).getVlrTotal();
                }            
            %> 
            <tr>
                <td></td>
                <td></td>                
                <td><b>Total Geral Mesa: </b></td>
                <td><b>R$ <%=vTotal %></b></td>
                <td></td>
            </tr>
            
        </tbody>
    </table>
</div>
            
 <%@include file="../jspf/footer.jspf" %>            