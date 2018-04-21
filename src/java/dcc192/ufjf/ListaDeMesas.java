package dcc192.ufjf;


import java.util.ArrayList;
import java.util.List;


public class ListaDeMesas {
    private static List<Mesas> tarefas;
    
    public static List<Mesas> getInstance(){
        if(tarefas == null){
            tarefas = new ArrayList<>();
            tarefas.add(new Mesas(1, "Mesa 001"));
            tarefas.add(new Mesas(2, "Mesa 002"));
            tarefas.add(new Mesas(3, "Mesa 003"));                    
            tarefas.add(new Mesas(4, "Mesa 004"));                    
            tarefas.add(new Mesas(5, "Mesa 005"));                    
        }
        return tarefas;
    }
}
