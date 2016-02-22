package com.cookbook.Controller;

import com.cookbook.DAO.KontoViewDAO;
import com.cookbook.Service.KontoService;
//import com.cookbook.Other.Loger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @Autowired
    private KontoService kontoService;


    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request,Model m) {
        m.addAttribute("kontoService", kontoService);
        m.addAttribute("pas", "przeslanie");
        return "index.jsp";
    }

    
}

