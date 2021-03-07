package fr.cabmed.gestionnaire.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

public class Page {

	@Value("${" + Strings.MODEL_TITLE + "}")
	private String cabinet;

	public String init(Model model) {
		model.addAttribute(Strings.MODEL_TITLE, this.cabinet);
		return "";
	}
}
