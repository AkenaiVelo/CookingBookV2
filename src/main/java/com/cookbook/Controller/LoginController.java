package com.cookbook.Controller;

import com.cookbook.Other.Loger;
import com.cookbook.Service.KontoService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    KontoService kontoService;
    @Autowired
    private LayoutController layout;

    @RequestMapping(value = "/login")
    public String index(HttpServletRequest request, Model m) {
        System.out.println("Login controler");
        m.addAttribute("kontoService", kontoService);
        layout.addServices(m);
        Loger.logger.error("LoginController");
        return "login";
    }
}
