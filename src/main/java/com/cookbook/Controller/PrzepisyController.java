/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookbook.Controller;

import com.cookbook.Service.DanieService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrzepisyController {

    @Autowired
    private LayoutController layout;
    @Autowired
    private DanieService danieService;

    @RequestMapping(value = "/przepisy/{kat}")
    public String index(@PathVariable String kat, HttpServletRequest request, Model m) {
        layout.addServices(m);
        m.addAttribute("kat", kat);
        m.addAttribute("danieService", danieService);
        return "przepisy";
    }
}