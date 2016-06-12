package com.cookbook.Controller;

import com.cookbook.DAO.KomentarzChangeDAO;
import com.cookbook.Service.OcenaService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KomentarzEdytujController {

    @Autowired
    private LayoutController layout;
    @Autowired
    private KomentarzChangeDAO komentarz_change_dao;
    @Autowired
    private OcenaService ocenaService;

    @RequestMapping(value = "/komentarzEdytuj")
    public String index(HttpServletRequest request, Model m) {
        System.out.println("Komentarz edytuj Controller");
        layout.addServices(m);
        m.addAttribute("ocenaService", ocenaService);
        String idk = request.getParameter("idKom");
        String tresc = request.getParameter("tresc");
        komentarz_change_dao.updateKomentarz(idk, tresc);
        return "komentarzEdytuj";
    }
}
