package fiap.biblioteca.models.repositores;

import fiap.biblioteca.infrastructure.database.DataBaseConfig;
import fiap.biblioteca.models.Email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmailRepositories {

    public List<Email> findAll() throws SQLException{
        var email = new ArrayList<Email>();
        var sql = "SELECT * FROM T_PS_EMAIL_CLIENTE";

        try(var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql);
            var results = statement.executeQuery()
        ){
            while (results.next()){
                email.add(new Email(
                        results.getInt("ID_EMAIL"),
                        results.getInt("ID_CLIENTE"),
                        results.getString("DS_EMAIL"),
                        results.getString("ST_EMAIL")
                ));
            }
        }
        return email;
    }

    public  void add(Email email) throws SQLException{
        var sql = "INSERT INTO T_PS_EMAIL_CLIENTE (id_email, id_cliente, ds_email, st_email)" +
                "VALUES (?, ?, ?, ?)";
        try {
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, email.getId_email());
            statement.setInt(2, email.getId_cliente());
            statement.setString(3, email.getDs_email());
            statement.setString(4, email.getSt_email());
            statement.executeUpdate();
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public Optional<Email>find(int id) throws SQLException{
        var sql = "SELECT * FROM T_PS_EMAIL_CLIENTE WHERE id_email = ?";
        var email = new Email();
        try {
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            try {
                ResultSet rs = statement.executeQuery();
                if (rs.next())
                    email = new Email(
                            rs.getInt("id_email"),
                            rs.getInt("id_cliente"),
                            rs.getString("ds_email"),
                            rs.getString("st_email")
                    );

            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e){
            throw  new SQLException(e);
        }
        return Optional.ofNullable(email);
    }

    public void update(Email email){
        var sql = "UPDATE T_PS_EMAIL_CLIENTE SET id_cliente = ?, ds_email = ?, st_email = ? WHERE id_email = ? ";
        try {
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql);

            statement.setInt(1, email.getId_cliente());
            statement.setString(2, email.getDs_email());
            statement.setString(3, email.getSt_email());
            statement.setInt(4, email.getId_email());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }



    }


    public void delete(int id_email){
        String sql = "DELETE FROM T_PS_EMAIL_CLIENTE WHERE id_email = ?";

        try {
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, id_email);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
