package fr.cabmed.gestionnaire.pages;

import fr.cabmed.gestionnaire.common.Page;
import fr.cabmed.gestionnaire.common.SQL;
import fr.cabmed.gestionnaire.common.Strings;
import fr.cabmed.gestionnaire.structs.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

@Controller
public class CreationUser extends Page {

    @GetMapping("/creation_user")
    @Override
    public String init(Model model) {
        super.init(model);
        git remote show origin        return "Inscription";
    }

    @PostMapping("/creation_user")
    @ResponseBody
    public String creationUser(@RequestParam("user") String creation_user) {
        String r = creation_user;
        String[] champs = creation_user.split("&");

        HashMap<String, String> objet = new HashMap<>();

        for (String champ : champs) {
            var kv = champ.split("=");
            objet.put(kv[0], kv[1]);
        }

       var name= objet.get("name");
       var email = objet.get("email");
       var password = objet.get("password");

       /* var fin = LocalDate.parse(objet.get("fin"), format);
        var medecin = objet.get("medecin");

        if (fin.compareTo(debut) < 0) {
            return "Impossible de créer le rdv, les dates doivent être mélangées.";
        }

        if (debut.getDayOfYear() != fin.getDayOfYear()) {
            return "Impossible de créer le rdv, il s'étale sur trop de jours.";
        }
*/
       User user = new User(UUID.randomUUID().toString(),email,name, password);

        try {
          SQL.exec(Strings.DB_INSERT_PATIENT, user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "Impossible d'ajouter le patient...";
        }

        return "Bien joué !";
    }


}
