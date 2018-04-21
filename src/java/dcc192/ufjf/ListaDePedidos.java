package dcc192.ufjf;


import java.util.ArrayList;
import java.util.List;


public class ListaDePedidos {
    private static List<Pedido> pedidos;
    
    
    public static List<Pedido> getInstance(){
        if(pedidos == null){
            pedidos = new ArrayList<>();
            pedidos.add(new Pedido("0001", "21/04/2018", (float) 40.00, ListaDeMesas.getInstance().get(0), "Ronaldo S."));                  
            pedidos.add(new Pedido("0002", "21/04/2018", (float) 90.00, ListaDeMesas.getInstance().get(1), "Raquel F."));                  
            pedidos.add(new Pedido("0003", "21/04/2018", (float) 58.00, ListaDeMesas.getInstance().get(2), "Vania B."));                  
           
            pedidos.get(0).getMovimento().add(ListaDeMoviPedidos.getInstance().get(0));
            pedidos.get(0).getMovimento().add(ListaDeMoviPedidos.getInstance().get(1));
            
            pedidos.get(1).getMovimento().add(ListaDeMoviPedidos.getInstance().get(2));
            pedidos.get(1).getMovimento().add(ListaDeMoviPedidos.getInstance().get(3));
            
            pedidos.get(2).getMovimento().add(ListaDeMoviPedidos.getInstance().get(4));
            pedidos.get(2).getMovimento().add(ListaDeMoviPedidos.getInstance().get(5));
            
        }
        return pedidos;
    }
}
