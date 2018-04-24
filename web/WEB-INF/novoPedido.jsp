    
<%@page import="dcc192.ufjf.ListaDeMesas"%>
<%@page import="dcc192.ufjf.Mesas"%>
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
    <%Mesas mesa = ListaDeMesas.getInstance().get(Integer.parseInt(request.getParameter("idMesa")));%>
    <h3>
        Edita Pedido 
        <label>Mesa: <%=mesa.getDescricao() %> </label>
    </h3>
    
    <form method="post"> 
        <label>Produto 
            <select name="produtos">
                <%
                    List<Produtos> produtos = new ListaDeProdutos().getInstance();
                    for(int i = 0; i < produtos.size(); i++) {
                %> 
                <option value="<%=produtos.get(i)%>">
                    <%=produtos.get(i).getDescricao() %> - R$ <%=produtos.get(i).getVlrUunitario() %>  
                </option>
                <%
                }            
                %>
                
                
            </select>
        </label>  
            
        <label>Quantidade <input type="text" name="quantidade" value="0" /> </label>

        <label>Responsável <input type="text" name="responsavel" value="" /> </label>
 
        <input type="submit" value="Inserir" />  
    </form>
    
    <table>
        <thead>
            <tr>
                <th>Descrição</th>
                <th>Valor Unitário</th>
                <th>Quantidade</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody>
            <tr class="alt">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td><b>Total Geral Mesa: </b></td>
                <td><b>R$ 0</b></td>
            </tr>
        </tbody>
    </table>
</div>
            
 <%@include file="../jspf/footer.jspf" %>            