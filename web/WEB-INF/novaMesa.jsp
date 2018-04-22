<%@page import="dcc192.ufjf.Mesas"%>
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
                Mesas m;
                m = (Mesas)request.getAttribute("mesas");        
            %>   
                <label>Código <input type="text" name="codigo" value="<%=m.getCodigo() %>" /> </label>
                <br>
                <label>Descrição <input type="text" name="descricao" value="<%=m.getDescricao() %>" /> </label>
            <%
            }else{
            %>
                <label>Código <input type="text" name="codigo" value="" /> </label>
                <br>
                <label>VDescrição <input type="text" name="descricao" value="" /> </label>
            <%
            }
            %>   
            <input type="submit" value="Gravar" />  
        </form>
    </div>
</div>
    
 <%@include file="../jspf/footer.jspf" %>    
