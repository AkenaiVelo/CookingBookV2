package com.cookbook.Controller;

import com.cookbook.Service.DanieService;
import com.cookbook.Service.GaleriaDanService;
import com.cookbook.Service.KomentarzService;
import com.cookbook.Service.KontoService;
import com.cookbook.Service.SkladnikiService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private KontoService kontoService;
    @Autowired
    private KomentarzService komentarzService;
    @Autowired
    private DanieService danieService;
    @Autowired
    private GaleriaDanService galeriaService;
    @Autowired
    private LayoutController layout;
    @Autowired
    private SkladnikiService skladnikiService;

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model m) {
       
        System.out.println("Index controler");
        m.addAttribute("kontoService", kontoService);
        m.addAttribute("komentarzService", komentarzService);
        m.addAttribute("danieService", danieService);
        m.addAttribute("galeriaService", galeriaService);
        m.addAttribute("skladnikiService", skladnikiService);
        layout.addServices(m);
        m.addAttribute("pas", "przeslanie");
        return "index";
    }
}
