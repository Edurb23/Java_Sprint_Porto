package fiap.biblioteca.models;

public class Telefone {
    private int id_telfone;

    private int id_cliente;

    private long nr_telefone;
    private int nr_ddd;
    private int nr_ddi;
    private String nm_operadora;

    public Telefone() {
    }

    public Telefone(int id_telfone, int id_cliente, long nr_telefone, int nr_ddd, int nr_ddi, String nm_operadora) {
        this.id_telfone = id_telfone;
        this.id_cliente = id_cliente;
        this.nr_telefone = nr_telefone;
        this.nr_ddd = nr_ddd;
        this.nr_ddi = nr_ddi;
        this.nm_operadora = nm_operadora;
    }

    public int getId_telfone() {
        return id_telfone;
    }

    public void setId_telfone(int id_telfone) {
        this.id_telfone = id_telfone;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public long getNr_telefone() {
        return nr_telefone;
    }

    public void setNr_telefone(long nr_telefone) {
        this.nr_telefone = nr_telefone;
    }

    public int getNr_ddd() {
        return nr_ddd;
    }

    public void setNr_ddd(int nr_ddd) {
        this.nr_ddd = nr_ddd;
    }

    public int getNr_ddi() {
        return nr_ddi;
    }

    public void setNr_ddi(int nr_ddi) {
        this.nr_ddi = nr_ddi;
    }

    public String getNm_operadora() {
        return nm_operadora;
    }

    public void setNm_operadora(String nm_operadora) {
        this.nm_operadora = nm_operadora;
    }
}