package com.cookbook.Controller;

import com.cookbook.Service.DanieService;
import com.cookbook.Service.GaleriaDanService;
import com.cookbook.Service.KomentarzService;
import com.cookbook.Service.OcenaService;
import com.cookbook.Service.SkladnikiService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LikeController {
    @Autowired
    private LayoutController layout;
    @Autowired
    private OcenaService ocenaService;
    @Autowired
    private DanieService danieService;
    @Autowired
    private SkladnikiService skladnikiService;
    @Autowired
    private GaleriaDanService galeriaDanService;
    @Autowired
    private KomentarzService komentarzService;
    
    @RequestMapping(value = "/ocena")
    public String index(HttpServletRequest request, Model m) {
        System.out.println("Controler ocena");
        String button1 = request.getParameter("like");
        String button2 = request.getParameter("dlike");
        String nazwa=request.getParameter("nazwa");
        m.addAttribute("danieService", danieService);
        m.addAttribute("skladnikiService", skladnikiService);
        m.addAttribute("galeriaDanService", galeriaDanService);
        m.addAttribute("komentarzService", komentarzService);
        m.addAttribute("ocenaService", ocenaService);
        m.addAttribute("nazwa", nazwa);
        Object l = request.getSession().getAttribute("login");
            String login;
            if (l != null) {
                login = l.toString();
            } else {
                login = null;
            }
        
        layout.addServices(m);
        
        if(button1!=null)
        {
            System.out.println("Lubie "+nazwa);
            ocenaService.addOcena(login, nazwa, 1);
        }else if(button2!=null)
        {
           System.out.println("Nie lubie "+nazwa);
           ocenaService.addOcena(login, nazwa, -1);
        }
        return "refer";
    }
}