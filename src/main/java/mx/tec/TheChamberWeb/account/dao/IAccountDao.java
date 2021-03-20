package mx.tec.TheChamberWeb.account.dao;

import mx.tec.TheChamberWeb.account.model.Account;

public interface IAccountDao {
    public Account auth(String user, String password);
}
