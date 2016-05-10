/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookbook.Controller;

import com.cookbook.Service.DanieService;
import com.cookbook.Service.GaleriaDanService;
import com.cookbook.Service.SkladnikiService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrzepisController {
    @Autowired
    private LayoutController layout;
    @Autowired
    private DanieService danieService;
    @Autowired
    private SkladnikiService skladnikiService;
    @Autowired
    private GaleriaDanService galeriaDanService;
    
    @RequestMapping(value = "/przepisy/{kat}/{nazwa}")
    public String index(@PathVariable String kat,@PathVariable String nazwa, HttpServletRequest request, Model m) {
        System.out.println("Przepis Controler " + kat+" nazwa "+nazwa);
        layout.addServices(m);
        m.addAttribute("kat", kat);
        m.addAttribute("nazwa", nazwa);
        m.addAttribute("danieService", danieService);
        m.addAttribute("skladnikiService", skladnikiService);
        m.addAttribute("galeriaDanService", galeriaDanService);
        return "przepis";
    }
}
