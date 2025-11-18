package br.com.fiap.wallet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.wallet.factory.ConnectionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.fiap.wallet.exception.EntityNotFound;
import br.com.fiap.wallet.model.user.Account;

public class AccountDao {

    private final Connection connection;
    private final BCryptPasswordEncoder encoder;

    public AccountDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
        encoder = new BCryptPasswordEncoder(); // instância do encoder
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed())
            connection.close();
    }

    public Account parseAccount(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("nome");
        String email = resultSet.getString("email");
        String password = resultSet.getString("senha");
        String cpf = resultSet.getString("cpf");
        Double renda = resultSet.getDouble("renda");
        LocalDate dt_nascimento = resultSet.getDate("dt_nascimento").toLocalDate();
        int id_endereco = resultSet.getInt("id_address");
        return new Account(name, dt_nascimento, renda, cpf, email, password, id_endereco);
    }

    public void create(Account account) throws SQLException {
        String sql = "INSERT INTO users (nome, dt_nascimento, renda, cpf, email, senha, id_address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            String hashedPassword = encoder.encode(account.getPassword()); // hash da senha

            statement.setString(1, account.getName());
            statement.setDate(2, Date.valueOf(account.getDt_birth()));
            statement.setDouble(3, account.getRenda());
            statement.setString(4, account.getCpf());
            statement.setString(5, account.getEmail());
            statement.setString(6, hashedPassword);
            statement.setInt(7, account.getId_address());

            statement.executeUpdate();
        }
    }

    //este metodo nao deveria estar aqui, analisar trocar para sair de DAO e entrar como Userservice.
    public Account login(String email, String enteredPassword) throws SQLException, EntityNotFound {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS WHERE email = ?")) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String storedHash = resultSet.getString("senha");
                if (encoder.matches(enteredPassword, storedHash)) {
                    return parseAccount(resultSet);
                } else {
                    throw new SQLException("Credenciais inválidas.");
                }
            } else {
                throw new EntityNotFound("Usuário ou senha não localizado");
            }
        }
    }

    public List<Account> getAllUsers() throws SQLException, EntityNotFound {
        List<Account> listUsers = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listUsers.add(parseAccount(resultSet));
            }
            if (listUsers.isEmpty()) {
                throw new EntityNotFound("Nenhum usuário encontrado no banco de dados.");
            }
            return listUsers;
        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
            throw e;
        }
    }
}