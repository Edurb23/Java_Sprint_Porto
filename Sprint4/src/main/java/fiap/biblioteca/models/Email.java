package fiap.biblioteca.models;

public class Email {
    private int id_email;

    private int id_cliente;

    private String ds_email;

    private String  st_email;

    public Email() {
    }

    public Email(int id_email, int id_cliente, String ds_email, String st_email) {
        this.id_email = id_email;
        this.id_cliente = id_cliente;
        this.ds_email = ds_email;
        this.st_email = st_email;
    }

    public int getId_email() {
        return id_email;
    }

    public void setId_email(int id_email) {
        this.id_email = id_email;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDs_email() {
        return ds_email;
    }

    public void setDs_email(String ds_email) {
        this.ds_email = ds_email;
    }

    public String getSt_email() {
        return st_email;
    }

    public void setSt_email(String st_email) {
        this.st_email = st_email;
    }
}
