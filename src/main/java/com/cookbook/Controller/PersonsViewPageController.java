package com.cookbook.Controller;

import com.cookbook.Service.PersonService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonsViewPageController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/personsViewPage")
    public String index(HttpServletRequest request, Model m) {
        m.addAttribute("personService", personService);

        return "personsViewPage.jsp";
    }

}
