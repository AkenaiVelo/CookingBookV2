package com.cookbook.Controller;

import com.cookbook.DTO.SkladnikiDTO;
import com.cookbook.Service.SkladnikiService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EdytujSkladnikController {

    @Autowired
    LayoutController layout;
    @Autowired
    SkladnikiService skladniki_service;
    

    @RequestMapping(value = "/edytujSkladnik")
    public String index(HttpServletRequest request, Model m) {
        System.out.println("Controler edytuj/usun skladnik");
        String button1 = request.getParameter("dodaj");
        String button2 = request.getParameter("delete");
        String nazwa=request.getParameter("nazwa");
        if(nazwa!=null)
        {
        SkladnikiDTO s=skladniki_service.findSkladnikByName(nazwa);
        m.addAttribute("Skladnik", s);
        }
        layout.addServices(m);
        m.addAttribute("skladnikiService", skladniki_service);
        if(button2!=null)
        {
            skladniki_service.deleteSkladnikByName(nazwa);
            System.out.println("Usuwamy "+nazwa);
            return "skladniki";     
        }

        if(button1!=null)
        {
            System.out.println("Dodajemy nowy");
            m.addAttribute("co", 1);
            return "edytujSkladnik";
        }
        System.out.println("Edytujemy");
        m.addAttribute("co",2);
        return "edytujSkladnik";
    }
}
