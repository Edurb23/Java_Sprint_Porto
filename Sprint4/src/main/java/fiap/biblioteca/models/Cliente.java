package fiap.biblioteca.models;

import java.time.LocalDate;



public class Cliente {
    private int id_cliente;

    private String nm_cliente;

    private LocalDate dt_data_nascimento;

    private String  nr_cnh;

    private  String nr_cpf;

    private String  nr_rg;

    private LocalDate  dt_cadastro;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nm_cliente, LocalDate dt_data_nascimento, String nr_cnh, String nr_cpf, String nr_rg, LocalDate dt_cadastro) {
        this.id_cliente = id_cliente;
        this.nm_cliente = nm_cliente;
        this.dt_data_nascimento = dt_data_nascimento;
        this.nr_cnh = nr_cnh;
        this.nr_cpf = nr_cpf;
        this.nr_rg = nr_rg;
        this.dt_cadastro = dt_cadastro;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public LocalDate getDt_data_nascimento() {
        return dt_data_nascimento;
    }

    public void setDt_data_nascimento(LocalDate dt_data_nascimento) {
        this.dt_data_nascimento = dt_data_nascimento;
    }

    public String getNr_cnh() {
        return nr_cnh;
    }

    public void setNr_cnh(String nr_cnh) {
        this.nr_cnh = nr_cnh;
    }

    public String getNr_cpf() {
        return nr_cpf;
    }

    public void setNr_cpf(String nr_cpf) {
        this.nr_cpf = nr_cpf;
    }

    public String getNr_rg() {
        return nr_rg;
    }

    public void setNr_rg(String nr_rg) {
        this.nr_rg = nr_rg;
    }

    public LocalDate getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(LocalDate dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nm_cliente='" + nm_cliente + '\'' +
                ", dt_data_nascimento=" + dt_data_nascimento +
                ", nr_cnh='" + nr_cnh + '\'' +
                ", nr_cpf='" + nr_cpf + '\'' +
                ", nr_rg='" + nr_rg + '\'' +
                ", dt_cadastro=" + dt_cadastro +
                '}';
    }
}
