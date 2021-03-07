package fr.cabmed.gestionnaire.common;

public class Strings {
	static public final String MODEL_TITLE = "cabinet";
	static public final String MODEL_RDV = "rdv";
	static public final String MODEL_NAME = "personne";

	static public final String PERSON_ID = "ID";
	static public final String PERSON_FIRST_NAME = "FIRST_NAME";
	static public final String PERSON_LAST_NAME = "LAST_NAME";

	static public final String RDV_DEBUT = "debut";
	static public final String RDV_FIN = "fin";
	static public final String RDV_MEDECIN = "medecin";
	public static final String RDV_PATIENT = "patient";
	public static final String RDV_ID = "id";
	public static final String USER_ID = "id_user";
	public static final String USER_NAME = "user_name";
	public static final String USER_EMAIL = "user_email";
	public static final String USER_PASSWORD= "user_password";




	static public final String DB_GET_ALL_PERSONS = "SELECT * FROM person";
	static public final String DB_GET_ALL_RDV = "SELECT * FROM rdv";
	static public final String DB_INSERT_RDV = "INSERT INTO rdv (debut, fin, medecin, patient, id) VALUES (?, ?, ?, ?, ?)";
	static public final String DB_INSERT_PATIENT = "INSERT INTO patient (id, email, name, password) VALUES (?, ?, ?, ?)";

	static public final String DB_URL = "jdbc:mysql://localhost:3306/cabinet?serverTimezone=UTC";
	static public final String DB_USER = "root";
	static public final String DB_PASS = "password";

}
