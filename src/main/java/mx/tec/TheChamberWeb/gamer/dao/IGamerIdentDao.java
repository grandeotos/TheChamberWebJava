package mx.tec.TheChamberWeb.gamer.dao;

import mx.tec.TheChamberWeb.gamer.model.Gamer;

public interface IGamerIdentDao {
    Gamer register(String gamerID, String firstName, String lastName, String password, String email, String curp);
}
