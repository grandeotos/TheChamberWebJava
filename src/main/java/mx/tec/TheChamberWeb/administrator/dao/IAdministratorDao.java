package mx.tec.TheChamberWeb.administrator.dao;

import mx.tec.TheChamberWeb.administrator.model.Administrator;

public interface IAdministratorDao {
    public Administrator auth(String user, String password);
}
