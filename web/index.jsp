<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Pedidos</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <h1>Controle de Pedidos</h1>
        
        <nav id="menu">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="produtos.html">Produtos</a></li>
                <li><a href="mesas.html">Mesas</a></li>
            </ul>
        </nav>
        <label><h3>Mesas Abertas</h3></label>
        <div>
            <table border = 1>
                <th>Mesa</th>
                <th>Cliente</th>
                <th>Total</th>
                <tr>
                   <td>001</td>
                   <td>Ronaldo</td>
                   <td>R$ 20,00</td>
                   <td><a href="">Add Itens</a></td>
                   <td><a href="">Fechar Mesa</a></td>
                </tr>
            </table>
        </div>
    </body>
</html>
