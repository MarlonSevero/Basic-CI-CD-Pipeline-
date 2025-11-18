package br.com.fiap.wallet.dao;

import br.com.fiap.wallet.exception.EntityNotFound;
import br.com.fiap.wallet.factory.ConnectionFactory;
import br.com.fiap.wallet.model.user.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {
    private final Connection connection;

    public AddressDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    
    public int save(Address address) throws SQLException {
        String sql = "INSERT INTO address (cidade, rua, bairro, numero, complemento) " +
                     "VALUES (?, ?, ?, ?, ?) RETURNING id_address";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {

            stm.setString(1, address.getCidade());
            stm.setString(2, address.getRua());
            stm.setString(3, address.getBairro());
            stm.setString(4, address.getNumero());
            stm.setString(5, address.getComplemento());

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_address");  // retorna o ID
                } else {
                    throw new SQLException("Falha ao obter ID do endereço.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar endereço: " + e.getMessage(), e);
        }
    }


    private Address parseAddress(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id_address");
        String cidade = resultSet.getString("cidade");
        String rua = resultSet.getString("rua");
        String bairro = resultSet.getString("bairro");
        String numero = resultSet.getString("numero");
        String complemento = resultSet.getString("complemento");
        return new Address(id, cidade, rua, bairro, numero, complemento);
    }

    public List<Address> getAllAddress() throws SQLException, EntityNotFound {
        List<Address> listAddr = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ADDRESS");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listAddr.add(parseAddress(resultSet));
            }
            if (listAddr.isEmpty()) {
                throw new EntityNotFound("Nenhum endereco encontrado no banco de dados.");
            }
            return listAddr;
        } catch (SQLException e) {
            System.err.println("Erro ao listar enderecos: " + e.getMessage());
            throw e;
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
