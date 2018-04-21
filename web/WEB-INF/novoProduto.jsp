<%@page import="java.util.List"%>
<%@page import="dcc192.ufjf.Produtos"%>
<%@include file="../jspf/cabecalho.jspf" %>
<link rel="stylesheet" href="css/colour.css">
<link rel="stylesheet" href="css/template.css">

<h3>Edição de Produtos</h3>
<div class="grid_16">
    <div class="grid_4">
        <form method="post">    
            <%
            if(!"-1".equals(request.getParameter("id"))){
                Produtos p;
                p = (Produtos)request.getAttribute("produtos");        
            %>   
                <label>Descrição <input type="text" name="descricao" value="<%=p.getDescricao() %>" /> </label>
                <br>
                <label>Valor Unitário <input type="text" name="vlrUnit" value="<%=p.getVlrUunitario() %>" /> </label>
            <%
            }else{
            %>
                <label>Descrição <input type="text" name="descricao" value="" /> </label>
                <br>
                <label>Valor Unitário <input type="text" name="vlrUnit" value="" /> </label>
            <%
            }
            %>   
            <input type="submit" value="Gavar" />  
        </form>
    </div>
</div>
    
 <%@include file="../jspf/footer.jspf" %>    
