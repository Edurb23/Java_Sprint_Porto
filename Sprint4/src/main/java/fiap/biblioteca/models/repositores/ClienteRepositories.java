package fiap.biblioteca.models.repositores;

import fiap.biblioteca.infrastructure.database.DataBaseConfig;
import fiap.biblioteca.models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class ClienteRepositories {



        public List<Cliente> findAll() throws SQLException {
            var cliente = new ArrayList<Cliente>();
            var sql = "SELECT * FROM T_PS_CLIENTE";

            try(var conn = DataBaseConfig.getConnection();
                var statement = conn.prepareStatement(sql);
                var results = statement.executeQuery()
            ){
                while (results.next()) {
                    cliente.add(new Cliente(
                            results.getInt("id_cliente"),
                            results.getString("NM_CLIENTE"),
                            results.getDate("DT_DATA_NASCIMENTO").toLocalDate(),
                            results.getString("NR_CNH"),
                            results.getString("NR_CPF"),
                            results.getString("NR_RG"),
                            results.getDate("DT_CADASTRO").toLocalDate()
                    ));
                }
            }
            return cliente;
        }

        public  void  add(Cliente cliente) throws SQLException{
            var sql = "INSERT INTO T_PS_Cliente (id_cliente, NM_Cliente, Dt_Data_Nascimento, NR_CNH, NR_CPF, NR_RG, DT_CADASTRO) " +
                    "VALUES(?,?,?,?,?,?,?)";
            try {
                var conn = DataBaseConfig.getConnection();
                var statement = conn.prepareStatement(sql);
                statement.setInt(1, cliente.getId_cliente());
                statement.setString(2, cliente.getNm_cliente());
                statement.setDate(3, Date.valueOf(cliente.getDt_data_nascimento().toString()));
                statement.setString(4, cliente.getNr_cnh());
                statement.setString(5, cliente.getNr_cpf());
                statement.setString(6, cliente.getNr_rg());
                statement.setDate(7, Date.valueOf(cliente.getDt_cadastro().toString()));
                statement.executeUpdate();


            }catch (SQLException e)
            {
                throw new SQLException(e);
            }

        }

       public Optional<Cliente> find(int id) throws SQLException{
            var sql = "SELECT * FROM T_PS_Cliente WHERE id_cliente = ?";
            var cliente = new Cliente();

            try {
                Connection conn = DataBaseConfig.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, id);
                try {
                    ResultSet rs = statement.executeQuery();
                    if (rs.next())
                        cliente = new Cliente(
                                rs.getInt("id_cliente"),
                                rs.getString("nm_cliente"),
                                rs.getDate("dt_data_nascimento").toLocalDate(),
                                rs.getString("nr_cnh"),
                                rs.getString("nr_cpf"),
                                rs.getString("nr_rg"),
                                rs.getDate("dt_cadastro").toLocalDate()
                        );



                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }catch (SQLException e)
            {
                throw new SQLException(e);
            }
           return Optional.ofNullable(cliente);



       }

       public void update(Cliente cliente){
            var sql = "UPDATE T_PS_Cliente SET NM_CLIENTE = ? , DT_DATA_NASCIMENTO = ? , NR_CNH = ? , NR_CPF = ?, NR_RG = ?, DT_CADASTRO =  ? WHERE id_cliente = ? ";
            try {
                var conn = DataBaseConfig.getConnection();
                var statement = conn.prepareStatement(sql);

                statement.setString(1, cliente.getNm_cliente());
                statement.setDate(2, Date.valueOf(cliente.getDt_data_nascimento().toString()));
                statement.setString(3, cliente.getNr_cnh());
                statement.setString(4, cliente.getNr_cpf());
                statement.setString(5, cliente.getNr_rg());
                statement.setDate(6, Date.valueOf(cliente.getDt_cadastro().toString()));
                statement.setInt(7,  cliente.getId_cliente());
                statement.executeUpdate();

            }catch (SQLException e){
                throw new RuntimeException(e);
            }
       }

       public void delete(int id_cliente){
            String sql = "DELETE FROM T_PS_Cliente WHERE id_cliente = ?";

            try {
                var conn = DataBaseConfig.getConnection();
                var statement = conn.prepareStatement(sql);
                statement.setInt(1, id_cliente);
                statement.executeUpdate();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
       }




}
