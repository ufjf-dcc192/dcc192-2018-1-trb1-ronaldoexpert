package dcc192.ufjf;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PedidosServlet", urlPatterns = {"/PedidosServlet.html", "/mesas.html", "/produtos.html", 
    "/principal.html", "/editaPedido.html", "/novoProduto.html"})
public class PedidosServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         if("/mesas.html".equals(request.getServletPath())){
             listarMesas(request, response);
         }else if("/produtos.html".equals(request.getServletPath())){
             listarProdutos(request, response);
         }else if("/principal.html".equals(request.getServletPath())){
             listarPedidos(request, response);
         }else if("/editaPedido.html".equals(request.getServletPath())){
             editaPedido(request, response);
         }else if("/novoProduto.html".equals(request.getServletPath())){
             novoProduto(request, response);
         }
    }

    private void listarMesas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Mesas> mesas = new ListaDeMesas().getInstance();
        request.setAttribute("mesas", mesas);

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/mesas.jsp");
        despachante.forward(request, response);
    }

    private void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produtos> produtos = new ListaDeProdutos().getInstance();
        request.setAttribute("produtos", produtos);

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/produtos.jsp");
        despachante.forward(request, response);
    }

    private void listarPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pedido> pedidos = new ListaDePedidos().getInstance();
        request.setAttribute("pedidos", pedidos);
        
        List<Mesas> mesas = new ListaDeMesas().getInstance();
        request.setAttribute("mesas", mesas);

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/principal.jsp");
        despachante.forward(request, response);
    }

    private void editaPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pedido> pedidos = new ListaDePedidos().getInstance();
        int i = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("pedidos", pedidos.get(i));

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/editaPedido.jsp");
        despachante.forward(request, response);
    }

    private void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*List<Pedido> pedidos = new ListaDePedidos().getInstance();
        int i = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("pedidos", pedidos.get(i));*/

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novoProduto.jsp");
        despachante.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/novoProduto.html".equals(req.getServletPath())){
            String descricao = req.getParameter("descricao");
            float vlrUnitario = Float.parseFloat(req.getParameter("vlrUnit"));
            Produtos p = new Produtos(descricao, vlrUnitario);
            ListaDeProdutos.getInstance().add(p);              
        }
        resp.sendRedirect("produtos.html"); 
    }
    
}
