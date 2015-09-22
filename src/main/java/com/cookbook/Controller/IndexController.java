package com.cookbook.Controller;

import com.cookbook.DAO.AccountViewDAO;
import com.cookbook.DAO.AddressViewDAO;
import com.cookbook.DAO.PersonViewDAO;
//import com.cookbook.Other.Loger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

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
        m.addAttribute("pas", "przeslanie");
       
        String button1 = request.getParameter("button");
        if (button1 != null) {
            return "/register.jsp";
        }
        //Loger.logger.error("Index Controler");
        /*
         String name = request.getParameter("name");
         if (name != null)
         guestDao.persist(new Guest(name));
         */
      
        return "index.jsp";
    }

    
}

