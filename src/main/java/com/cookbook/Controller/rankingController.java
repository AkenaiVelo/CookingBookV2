package com.cookbook.Controller;

import com.cookbook.Service.OcenaService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class rankingController {
    
    @Autowired
    private LayoutController layout;
    @Autowired
    private OcenaService osenaService;
    
    @RequestMapping(value = "/ranking")
    public String index(HttpServletRequest request, Model m) {
        layout.addServices(m);
        m.addAttribute("ocenaService", osenaService);
        return "ranking";
    }
}
