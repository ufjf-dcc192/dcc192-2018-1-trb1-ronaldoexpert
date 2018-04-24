package dcc192.ufjf;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PedidosServlet", urlPatterns = {"/PedidosServlet.html", "/mesas.html", "/produtos.html", 
    "/principal.html", "/editaPedido.html", "/novoProduto.html", "/excluiProduto.html", "/novaMesa.html", 
    "/excluiMesa.html", "/novoPedido.html","/fechaPedido.html"})
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
         }else if("/excluiProduto.html".equals(request.getServletPath())){
             excluiProduto(request, response);
         }else if("/novaMesa.html".equals(request.getServletPath())){
             novaMesa(request, response);
         }else if("/excluiMesa.html".equals(request.getServletPath())){
             excluiMesa(request, response);
         }else if("/novoPedido.html".equals(request.getServletPath())){
             novoPedido(request, response);
         }else if("/fechaPedido.html".equals(request.getServletPath())){
             fechaPedido(request, response);
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
        int i = Integer.parseInt(request.getParameter("id"));
        if (i >= 0){
            List<Produtos> produtos = new ListaDeProdutos().getInstance();
            request.setAttribute("produtos", produtos.get(i));    
        }
        
        
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novoProduto.jsp");
        despachante.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/novoProduto.html".equals(req.getServletPath())){
            String descricao = req.getParameter("descricao");
            float vlrUnitario = Float.parseFloat(req.getParameter("vlrUnit"));
            Produtos p = new Produtos(descricao, vlrUnitario);
            
            if ("-1".equals(req.getParameter("id"))){                
                ListaDeProdutos.getInstance().add(p);    
            }else{
                ListaDeProdutos.getInstance().set(Integer.parseInt(req.getParameter("id")), p);
            }
            resp.sendRedirect("produtos.html"); 
            
        }else if ("/novaMesa.html".equals(req.getServletPath())){
            String codigo = req.getParameter("codigo");
            String descricao = req.getParameter("descricao");
            Mesas m = new Mesas(Integer.parseInt(codigo), descricao);
            
            if ("-1".equals(req.getParameter("id"))){                
                ListaDeMesas.getInstance().add(m);    
            }else{
                ListaDeMesas.getInstance().set(Integer.parseInt(req.getParameter("id")), m);
            }
            resp.sendRedirect("mesas.html"); 
            
        }else if ("/novoPedido.html".equals(req.getServletPath())){
            int num = 0;
            List<Pedido> lstPedidos = new ListaDePedidos().getInstance();
            for (Pedido lstPedido : lstPedidos) {
               num++; 
            }
            
            Date dt = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String data = formatador.format(dt) + "";
            
            GregorianCalendar hr = new GregorianCalendar();
            SimpleDateFormat hr2 = new SimpleDateFormat("HH:mm");
            String hora = hr2.format(hr.getTime()) + "";
            
            String mesa = req.getParameter("idMesa");
            List<Mesas> m = new ListaDeMesas().getInstance();
            
            String produto = req.getParameter("produtos");
            String[] produtosSeparado = produto.split(",");    

            String descricao = produtosSeparado[0];
            float vlrUnit = Float.parseFloat(produtosSeparado[1]);
            int quantidade = Integer.parseInt(req.getParameter("quantidade"));            
            float total = vlrUnit * quantidade; 
            String responsavel = req.getParameter("responsavel");

            Pedido pedido = new Pedido(numero, data, total, m.get(Integer.parseInt(mesa)), responsavel, hora);
            ListaDePedidos.getInstance().add(pedido);
            
            Produtos prod  = new Produtos(descricao, vlrUnit);
            
            MoviPedidos mp = new MoviPedidos(pedido, prod, quantidade, vlrUnit, total);
            pedido.getMovimento().add(mp);
            ListaDeMoviPedidos.getInstance().add(mp);
            
            
            resp.sendRedirect("principal.html"); 
        }         
    }

    private void excluiProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean achouProduto = false;
        List<Produtos> p = new ListaDeProdutos().getInstance();
        request.setAttribute("produtos", p);                  
        
        List<MoviPedidos> mPedidos = new ListaDeMoviPedidos().getInstance();
        for(int i = 0; i < mPedidos.size(); i++){
            if(mPedidos.get(i).verificaProduto(p.get(Integer.parseInt(request.getParameter("id"))))){
                achouProduto = true;
            }
        }
        
        if (achouProduto == false){
            ListaDeProdutos.getInstance().remove(p.get(Integer.parseInt(request.getParameter("id"))));   
        }
        
        RequestDispatcher despachante = request.getRequestDispatcher("produtos.html");        
        despachante.forward(request, response);               
    }

    private void novaMesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i = Integer.parseInt(request.getParameter("id"));
        if (i >= 0){
            List<Mesas> mesas = new ListaDeMesas().getInstance();
            request.setAttribute("mesas", mesas.get(i));    
        }        
        
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novaMesa.jsp");
        despachante.forward(request, response);
    }

    private void excluiMesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean achouMesa = false;
        List<Mesas> m = new ListaDeMesas().getInstance();
        request.setAttribute("mesas", m);                  
        
        List<Pedido> Pedidos = new ListaDePedidos().getInstance();
        for(int i = 0; i < Pedidos.size(); i++){
            if(Pedidos.get(i).VerificaMesa(m.get(Integer.parseInt(request.getParameter("id"))))){
                achouMesa = true;
            }
        }
         
        if (achouMesa == false){
            ListaDeMesas.getInstance().remove(m.get(Integer.parseInt(request.getParameter("id"))));   
        }
        
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/mesas.jsp");        
        despachante.forward(request, response);
    }

    private void novoPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pedido> pedidos = new ListaDePedidos().getInstance();        
        request.setAttribute("pedidos", pedidos);  
        
        int i = Integer.parseInt(request.getParameter("idMesa"));
        List<Mesas> mesas = new ListaDeMesas().getInstance();
        request.setAttribute("mesas", mesas.get(i));

        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novoPedido.jsp");
        despachante.forward(request, response);
    }

    private void fechaPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GregorianCalendar hr = new GregorianCalendar();
        SimpleDateFormat hr2 = new SimpleDateFormat("HH:mm");
        String hora = hr2.format(hr.getTime()) + "";
        
        List<Pedido> pedidos = new ListaDePedidos().getInstance();
        int i = Integer.parseInt(request.getParameter("id"));
        pedidos.get(i).setHrFechamento(hora);       
        
        request.setAttribute("pedidos", pedidos.get(i));             
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/fechaPedido.jsp");
        despachante.forward(request, response);
    }
    
}
