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

import java.lang.invoke.ConstantBootstraps;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Calendrier extends Page {

	List<RDV> rdv = new ArrayList<>();

	@GetMapping("/calendrier")
	@Override
	public String init(Model model) {
		rdv.clear();
		super.init(model);

		getRDV();

		ObjectMapper om = new ObjectMapper();
		try {
			model.addAttribute(Strings.MODEL_RDV, om.writeValueAsString(rdv));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "Calendrier";
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
