    
<%@page import="java.util.List"%>
<%@page import="dcc192.ufjf.Mesas"%>
<%@include file="../jspf/cabecalho.jspf" %>
<link rel="stylesheet" href="css/colour.css">
<link rel="stylesheet" href="css/template.css">

    <h3>Lista de Mesas</h3>
        <div class="grid_16">
            <table>
                <thead>    
                    <th>Código</th>
                    <th>Descrição</th>
                    <th colspan="2" width="10%">Ações</th>
                </thead>
                <tbody>
                    <%
                        for(Mesas mesas : (List<Mesas>) request.getAttribute("mesas")) {
                    %>   
                    <tr>
                        <td><%=mesas.getCodigo()%></td>
                        <td><%=mesas.getDescricao()%></td>
                        <td><a href="#" class="edit">Editar</a><a href="#" class="delete">Deletar</a></td>               
                    </tr>
                    <%
                    }            
                    %>  
                </tbody>
            </table>
        </div>
                
 <%@include file="../jspf/footer.jspf" %>                