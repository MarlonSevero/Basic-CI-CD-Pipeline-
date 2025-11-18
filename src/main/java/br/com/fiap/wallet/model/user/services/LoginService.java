package br.com.fiap.wallet.model.user.services;
import br.com.fiap.wallet.dao.AccountDao;
import br.com.fiap.wallet.exception.EntityNotFound;
import br.com.fiap.wallet.model.user.Account;
import java.sql.SQLException;

public class LoginService {

    private final AccountDao accountDao;

    public LoginService(AccountDao dao){
        this.accountDao = dao;
    }

    public boolean auth(String email, String password) throws SQLException, EntityNotFound {
        try{
        Account account = accountDao.login(email, password);
        return account != null;
        } catch (EntityNotFound e) {
            throw new EntityNotFound("Erro ao realizar login!");
        }
    }
}
