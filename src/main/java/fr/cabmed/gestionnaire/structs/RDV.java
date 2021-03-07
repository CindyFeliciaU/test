package fr.cabmed.gestionnaire.structs;

import fr.cabmed.gestionnaire.common.Strings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class RDV {

	private LocalDate debut;
	private LocalDate fin;
	private String medecin;
	private String patient;
	private String id;

	public RDV(ResultSet res) {
		try {
			this.debut = res.getDate(Strings.RDV_DEBUT).toLocalDate();
			this.fin = res.getDate(Strings.RDV_FIN).toLocalDate();
			this.medecin = res.getString(Strings.RDV_MEDECIN);
			this.patient = res.getString(Strings.RDV_PATIENT);
			this.id = res.getString(Strings.RDV_ID);
		} catch (SQLException e) {
			e.printStackTrace();
			this.debut = LocalDate.now();
			this.fin = LocalDate.now();
			this.medecin = "";
			this.patient = "";
			this.id = "";
		}
	}

	public RDV(LocalDate debut, LocalDate fin, String medecin, String patient, String id) {
		this.debut = debut;
		this.fin = fin;
		this.medecin = medecin;
		this.patient = patient;
		this.id = id;
	}

	public RDV(LocalDate debut, LocalDate fin, String medecin) {
		this.debut = debut;
		this.fin = fin;
		this.medecin = medecin;
		this.patient = null;
		this.id = "";
	}

	public RDV(LocalDate debut, LocalDate fin, String medecin, String id) {
		this.debut = debut;
		this.fin = fin;
		this.medecin = medecin;
		this.patient = null;
		this.id = id;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public String getMedecin() {
		return medecin;
	}

	public void setMedecin(String medecin) {
		this.medecin = medecin;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
