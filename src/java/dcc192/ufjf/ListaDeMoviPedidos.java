package dcc192.ufjf;


import java.util.ArrayList;
import java.util.List;


public class ListaDeMoviPedidos {
    private static List<MoviPedidos> moviPedido;
    
    public static List<MoviPedidos> getInstance(){
        if(moviPedido == null){
            moviPedido = new ArrayList<>();
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(0), ListaDeProdutos.getInstance().get(0), 5, ListaDeProdutos.getInstance().get(0).getVlrUunitario(), ListaDeProdutos.getInstance().get(0).getVlrUunitario() * 5));                  
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(0), ListaDeProdutos.getInstance().get(1), 5, ListaDeProdutos.getInstance().get(0).getVlrUunitario(), ListaDeProdutos.getInstance().get(0).getVlrUunitario() * 5));                  
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(0), ListaDeProdutos.getInstance().get(2), 5, ListaDeProdutos.getInstance().get(0).getVlrUunitario(), ListaDeProdutos.getInstance().get(0).getVlrUunitario() * 5));                  
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(0), ListaDeProdutos.getInstance().get(3), 5, ListaDeProdutos.getInstance().get(0).getVlrUunitario(), ListaDeProdutos.getInstance().get(0).getVlrUunitario() * 5));                  
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(0), ListaDeProdutos.getInstance().get(4), 5, ListaDeProdutos.getInstance().get(0).getVlrUunitario(), ListaDeProdutos.getInstance().get(0).getVlrUunitario() * 5));                  
            moviPedido.add(new MoviPedidos(ListaDePedidos.getInstance().get(0), ListaDeProdutos.getInstance().get(4), 5, ListaDeProdutos.getInstance().get(0).getVlrUunitario(), ListaDeProdutos.getInstance().get(0).getVlrUunitario() * 5));                  
       }
        return moviPedido;
    }
}
