package dcc192.ufjf;

public class Produtos {
    private String descricao;
    private float vlrUunitario;

    public Produtos() {
    }

    public Produtos(String descricao, float vlrUunitario) {
        this.descricao = descricao;
        this.vlrUunitario = vlrUunitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getVlrUunitario() {
        return vlrUunitario;
    }

    public void setVlrUunitario(float vlrUunitario) {
        this.vlrUunitario = vlrUunitario;
    }

    @Override
    public String toString() {
        return  descricao + " - " + vlrUunitario;
    }
    
    
}
