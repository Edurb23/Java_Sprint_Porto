package fiap.biblioteca.models.repositores;

import fiap.biblioteca.infrastructure.database.DataBaseConfig;
import fiap.biblioteca.models.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.Optional;

public class TelefoneRepositories {


    public List<Telefone> findAll() throws SQLException{
        var telefone = new ArrayList<Telefone>();
        var sql = "SELECT * FROM T_PS_TELEFONE_CLIENTE";

        try(var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql);
            var results = statement.executeQuery()
        ){
            while (results.next()){
                telefone.add(new Telefone(
                        results.getInt("id_telefone"),
                        results.getInt("id_cliente"),
                        results.getLong("nr_telefone"),
                        results.getInt("nr_ddd"),
                        results.getInt("nr_ddi"),
                        results.getString("nm_operadora")

                ));
            }
        }
       return telefone;
    }

    public void add(Telefone telefone) throws SQLException{
        var sql = "INSERT INTO T_PS_TELEFONE_CLIENTE(ID_TELEFONE,ID_CLIENTE,NR_TELEFONE,NR_DDD,NR_DDI,NM_OPERADORA) " +
                "VALUES(?,?,?,?,?,?)";
        try {
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, telefone.getId_telfone());
            statement.setInt(2, telefone.getId_cliente());
            statement.setLong(3, telefone.getNr_telefone());
            statement.setInt(4, telefone.getNr_ddd());
            statement.setInt(5, telefone.getNr_ddi());
            statement.setString(6, telefone.getNm_operadora());

            statement.executeUpdate();
        }catch (SQLException e)
        {
            throw  new SQLException(e);

        }
    }
    public Optional<Telefone> find(int id) throws SQLException{
        var sql = "SELECT * FROM T_PS_TELEFONE_CLIENTE WHERE ID_TELEFONE = ? ";
        var telefone = new Telefone();
        try {
            Connection conn = DataBaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            try {
                ResultSet rs = statement.executeQuery();
                if (rs.next())
                    telefone = new Telefone(
                            rs.getInt("id_telefone"),
                            rs.getInt("id_cliente"),
                            rs.getLong("NR_TELEFONE"),
                            rs.getInt("nr_ddd"),
                            rs.getInt("nr_ddi"),
                            rs.getString("nm_operadora")

                    );
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.ofNullable(telefone);
    }

    public void update(Telefone telefone){
        var sql = "UPDATE T_PS_TELEFONE_CLIENTE  SET ID_CLIENTE = ? , NR_TELEFONE = ? , NR_DDD = ? , NR_DDI = ? , NM_OPERADORA = ? WHERE ID_TELEFONE = ?";
        try {
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql);

            statement.setInt(1, telefone.getId_cliente());
            statement.setLong(2, telefone.getNr_telefone());
            statement.setInt(3,telefone.getNr_ddd());
            statement.setInt(4, telefone.getNr_ddi());
            statement.setString(5, telefone.getNm_operadora());
            statement.setInt(6, telefone.getId_telfone());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(int id_telefone){
        String sql = "DELETE FROM T_PS_TELEFONE_CLIENTE  WHERE ID_TELEFONE = ? ";
        try {
            var conn = DataBaseConfig.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, id_telefone);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
