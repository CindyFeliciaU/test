package fr.cabmed.gestionnaire.pages;

import fr.cabmed.gestionnaire.common.Page;
import fr.cabmed.gestionnaire.common.SQL;
import fr.cabmed.gestionnaire.common.Strings;
import fr.cabmed.gestionnaire.structs.RDV;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Controller
public class CreationRDV extends Page {

	@PostMapping("/creation_rdv")
	@ResponseBody
	public String creationRDV(@RequestParam("rdv") String creation_rdv) {
		String r = creation_rdv.replace("%2F", "/").replace('+', ' ');
		String[] champs = r.split("&");
		HashMap<String, String> objet = new HashMap<>();

		for (String champ : champs) {
			var kv = champ.split("=");
			objet.put(kv[0], kv[1]);
		}

		var format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		var debut = LocalDate.parse(objet.get("debut"), format);
		var fin = LocalDate.parse(objet.get("fin"), format);
		var medecin = objet.get("medecin");

		if (fin.compareTo(debut) < 0) {
			return "Impossible de créer le rdv, les dates doivent être mélangées.";
		}

		if (debut.getDayOfYear() != fin.getDayOfYear()) {
			return "Impossible de créer le rdv, il s'étale sur trop de jours.";
		}

		RDV rdv = new RDV(debut, fin, medecin, UUID.randomUUID().toString());

		try {
			SQL.exec(Strings.DB_INSERT_RDV, rdv);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return "Impossible d'ajouter le rdv...";
		}

		return "Bien joué !";
	}

	@GetMapping("/creation_rdv")
	@Override
	public String init(Model model) {
		super.init(model);

		return "CreationRDV";
	}
}
