package com.cookbook.Controller;

import com.cookbook.Service.SkladnikiService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkladnikiController {
    @Autowired
    private LayoutController layout;
    @Autowired
    private SkladnikiService skladnikiService;
    
    @RequestMapping(value = "/skladniki")
    public String index(HttpServletRequest request, Model m) {
        System.out.println("Skladniki controler");
        layout.addServices(m);
        m.addAttribute("skladnikiService", skladnikiService);
        return "skladniki";
    }
}
