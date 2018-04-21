package dcc192.ufjf;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PedidosServlet", urlPatterns = {"/PedidosServlet.html", "/mesas.html", "/produtos.html"})
public class PedidosServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         if("/mesas.html".equals(request.getServletPath())){
             listarMesas(request, response);
         }else if("/produtos.html".equals(request.getServletPath())){
             listarProdutos(request, response);
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
    
}
