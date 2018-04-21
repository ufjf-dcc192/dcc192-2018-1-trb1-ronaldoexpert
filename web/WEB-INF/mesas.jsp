    
<%@page import="java.util.List"%>
<%@page import="dcc192.ufjf.Mesas"%>
<%@include file="../jspf/cabecalho.jspf" %>
    <h1>Lista de Mesas</h1>
        <table border = 1>
            <th>Código</th>
            <th>Descrição</th>
            <%
                int i = 0;
                for(Mesas mesas : (List<Mesas>) request.getAttribute("mesas")) {
            %>   
            <tr>
                <td><%=mesas.getCodigo()%></td>
                <td><%=mesas.getDescricao()%></td>
                <td><a href='edita.html?id=<%=i%>'>Editar</a> <a href='excluir.html?id=<%=i%>'>Excluir</a></td>                
            </tr>
            <%
                i++;
            }            
            %>  
        
    </body>
</html>
