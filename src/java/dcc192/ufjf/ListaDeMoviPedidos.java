package dcc192.ufjf;


import java.util.ArrayList;
import java.util.List;


public class ListaDeMoviPedidos {
    private static List<MoviPedidos> moviPedido;
    
    public static List<MoviPedidos> getInstance(){
        if(moviPedido == null){
            moviPedido = new ArrayList<>();
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(0), ListaDeProdutos.getInstance().get(0), 1, ListaDeProdutos.getInstance().get(0).getVlrUunitario(), ListaDeProdutos.getInstance().get(0).getVlrUunitario() * 1));                  
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(0), ListaDeProdutos.getInstance().get(1), 5, ListaDeProdutos.getInstance().get(1).getVlrUunitario(), ListaDeProdutos.getInstance().get(1).getVlrUunitario() * 5));                  
            
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(1), ListaDeProdutos.getInstance().get(2), 10, ListaDeProdutos.getInstance().get(2).getVlrUunitario(), ListaDeProdutos.getInstance().get(2).getVlrUunitario() * 10));                  
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(1), ListaDeProdutos.getInstance().get(3), 1, ListaDeProdutos.getInstance().get(3).getVlrUunitario(), ListaDeProdutos.getInstance().get(3).getVlrUunitario() * 1));                  
            
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(2), ListaDeProdutos.getInstance().get(4), 1, ListaDeProdutos.getInstance().get(4).getVlrUunitario(), ListaDeProdutos.getInstance().get(4).getVlrUunitario() * 1));                  
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(2), ListaDeProdutos.getInstance().get(2), 4, ListaDeProdutos.getInstance().get(2).getVlrUunitario(), ListaDeProdutos.getInstance().get(2).getVlrUunitario() * 4));                  
       }
        return moviPedido;
    }
}
