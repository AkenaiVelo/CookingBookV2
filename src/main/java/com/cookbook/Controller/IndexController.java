package com.cookbook.Controller;

import com.cookbook.DAO.AccountViewDAO;
import com.cookbook.DAO.AddressViewDAO;
import com.cookbook.DAO.PersonViewDAO;
import com.cookbook.Service.AccountService;
import com.cookbook.Service.AddressService;
import com.cookbook.Service.PersonService;
//import com.cookbook.Other.Loger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @Autowired
    private PersonService personService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AddressService addressService;

    @Autowired
    private PersonViewDAO personViewDAO;
    @Autowired
    private AddressViewDAO addressViewDAO;
    @Autowired
    private AccountViewDAO accountViewDAO;

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request,Model m) {
          
        m.addAttribute("personViewDAO", personViewDAO);
        m.addAttribute("addressViewDAO", addressViewDAO);
        m.addAttribute("accountViewDAO", accountViewDAO);
        m.addAttribute("personService", personService);
        m.addAttribute("accountService", accountService);
        m.addAttribute("addressService", addressService);
        m.addAttribute("pas", "przeslanie");
      
        return "index.jsp";
    }

    
}

