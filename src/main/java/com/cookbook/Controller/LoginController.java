package com.cookbook.Controller;

import com.cookbook.DTO.AccountDTO;
import com.cookbook.Other.Loger;
import com.cookbook.Service.AccountService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
   
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/login")
    public String index(HttpServletRequest request,Model m) {
       m.addAttribute("accountService", accountService);
       Loger.logger.error("LoginController");
        return "login.jsp";
    }
    
   
}