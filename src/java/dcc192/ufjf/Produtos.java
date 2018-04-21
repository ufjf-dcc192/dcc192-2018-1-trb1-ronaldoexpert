package dcc192.ufjf;

public class Produtos {
    private static int codigo = 0;
    private String descricao;
    private float vlrUunitario;

    public Produtos() {
    }

    public Produtos(String descricao, float vlrUunitario) {
        this.codigo = this.codigo + 1;
        this.descricao = descricao;
        this.vlrUunitario = vlrUunitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return  codigo + " - " + descricao + " - " + vlrUunitario;
    }
    
    
}
