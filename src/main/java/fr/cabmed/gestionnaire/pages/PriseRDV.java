package fr.cabmed.gestionnaire.pages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PriseRDV extends Page {

	List<RDV> rdv = new ArrayList<>();

	@PostMapping("/prise_rdv")
	@ResponseBody
	public String prise_rdv(@RequestParam("rdv") String info_rdv) {
		// Il faut implémenter la logique métier ici, vérifier que le rdv n'est pas pris, changer les variables des tables, etc.
		System.out.println(info_rdv);
		return "Bien joué !";
	}

	@GetMapping("/prise_rdv")
	@Override
	public String init(Model model) {
		super.init(model);
		rdv.clear();

		getRDV();

		ObjectMapper om = new ObjectMapper();
		try {
			model.addAttribute(Strings.MODEL_RDV, om.writeValueAsString(rdv));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "PriseRDV";
	}

	private void getRDV() {
		try {
			ResultSet res = SQL.exec(Strings.DB_GET_ALL_RDV);

			while (res.next()) {
				rdv.add(new RDV(res));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
