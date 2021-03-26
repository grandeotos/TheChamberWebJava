package mx.tec.TheChamberWeb.applicant.dao;

import mx.tec.TheChamberWeb.applicant.model.Applicant;

public interface IApplicantDao {
    Applicant register(String gamerID, String firstName, String lastName, String password, String email, String curp);
}
