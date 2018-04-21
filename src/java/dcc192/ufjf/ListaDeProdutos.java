package dcc192.ufjf;


import java.util.ArrayList;
import java.util.List;


public class ListaDeProdutos {
    private static List<Produtos> prod;
    
    public static List<Produtos> getInstance(){
        if(prod == null){
            prod = new ArrayList<>();
            prod.add(new Produtos("Coca Cola 2lt", 10));                  
            prod.add(new Produtos("Kaizer 600ML", 6));                  
            prod.add(new Produtos("Brahma 600ML", (float) 7.50));                  
            prod.add(new Produtos("Porção de Batata", 15));                  
            prod.add(new Produtos("Porção de Carne", 28));                  
        }
        return prod;
    }
}
