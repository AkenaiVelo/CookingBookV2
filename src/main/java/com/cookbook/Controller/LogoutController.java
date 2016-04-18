/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookbook.Controller;

import com.cookbook.Other.Loger;
import com.cookbook.Service.KontoService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
     @Autowired
    private LayoutController layout;
     @Autowired
    KontoService kontoService;
    @RequestMapping(value = "/logout")
    public String index(HttpServletRequest request, Model m) {
        System.out.println("Logout controler");
        m.addAttribute("kontoService", kontoService);
        layout.addServices(m);
        Loger.logger.error("LoginController");
        return "logout";
    }
    
}
