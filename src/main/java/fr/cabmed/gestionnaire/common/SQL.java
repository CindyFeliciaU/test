package fr.cabmed.gestionnaire.common;

import fr.cabmed.gestionnaire.structs.RDV;
import fr.cabmed.gestionnaire.structs.User;

import java.security.SecureRandom;
import java.sql.*;
import java.time.LocalDate;

public class SQL {

	static private String db_url = Strings.DB_URL;

	static private String db_user = Strings.DB_USER;

	static private String db_pass = Strings.DB_PASS;

	static public ResultSet exec(String cmd) throws SQLException {
		ResultSet resultSet = null;

		Connection connection = DriverManager.getConnection(db_url, db_user, db_pass);
		PreparedStatement statement = connection.prepareStatement(cmd);
		resultSet = statement.executeQuery();
		return resultSet;
	}

	static public boolean exec(String cmd, RDV rdv) throws SQLException {
		boolean result = false;

		Connection connection = DriverManager.getConnection(db_url, db_user, db_pass);
		PreparedStatement statement = connection.prepareStatement(cmd);

		statement.setDate(1, Date.valueOf(rdv.getDebut()));
		statement.setDate(2, Date.valueOf(rdv.getFin()));
		statement.setString(3, rdv.getMedecin());
		statement.setString(4, rdv.getPatient());
		statement.setString(5, rdv.getId());

		result = statement.execute();
		return result;
	}

	static public boolean exec(String cmd, User user) throws SQLException {
		boolean result = false;

		Connection connection = DriverManager.getConnection(db_url, db_user, db_pass);
		PreparedStatement statement = connection.prepareStatement(cmd);

		statement.setString(1, (user.getId()));
		statement.setString(2, (user.getEmail()));
		statement.setString(3, (user.getName()));
		String passwordEncrypted = new Md5(user.getPassword()).codeGet();
		statement.setString(4, (passwordEncrypted));
		result = statement.execute();
		return result;
	}
}
