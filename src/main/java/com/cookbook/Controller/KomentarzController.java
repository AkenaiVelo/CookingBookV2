package com.cookbook.Controller;

import com.cookbook.DTO.KomentarzDTO;
import com.cookbook.Service.KomentarzService;
import com.cookbook.Service.OcenaService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KomentarzController {

    @Autowired
    private LayoutController layout;
    @Autowired
    private KomentarzService komentarzService;
    @Autowired
    private OcenaService ocenaService;

    @RequestMapping(value = "/komentarz")
    public String index(HttpServletRequest request, Model m) {
        System.out.println("Komentarze controler");
        layout.addServices(m);
        m.addAttribute("ocenaService", ocenaService);
        String autor = "";
        String nazwadania = "";
        String opis = request.getParameter("opis");
        Date data = new Date();

        Object d = request.getSession().getAttribute("danie");
        if (d != null) {
            nazwadania = d.toString();
        }

        Object o = request.getSession().getAttribute("login");
        if (o != null) {
            autor = o.toString();
        }
        
        KomentarzDTO komentarz=new KomentarzDTO(data, opis);
        komentarz.setAutor(autor);
        komentarz.setDanie(nazwadania);
        komentarzService.addKomentarz(komentarz);
        return "komentarz";
    }
}
