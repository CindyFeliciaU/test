package fr.cabmed.gestionnaire.pages;

import fr.cabmed.gestionnaire.common.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Accueil extends Page {

	@GetMapping("/")
	@Override
	public String init(Model model) {
		super.init(model);

		return "index";
	}
}
