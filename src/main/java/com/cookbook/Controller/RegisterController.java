package com.cookbook.Controller;

import com.cookbook.DTO.AccountDTO;
import com.cookbook.Service.AccountService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    
    String status="Niesprawdzono";
    String login,password;
    @Autowired
    AccountService baza;

    @RequestMapping(value = "/register")
    public String index(HttpServletRequest request,Model m) {
        String komunikat="";
         String button1 = request.getParameter("statusCheck");
         String button2 = request.getParameter("LogIn");
         login=request.getParameter("LoginField");
         password=request.getParameter("PasswordField");
         m.addAttribute("login", login);
          m.addAttribute("status", status);
         if (button1!= null)
         {
             logInCheck();
             m.addAttribute("status", status);
             m.addAttribute("komunikat", komunikat);
             return "register.jsp";
         }else if(button2!=null)
         {
             if(logInCheck())
             {
                if(baza.registerNewAccount(new AccountDTO(login, password)))
                {
                    komunikat="Rejestracja udana. Mozesz terz dokonac logowania.";
                }else
                {
                    komunikat="Rejestracja nie udana. Spróbój ponownie póżniej.";
                }
             }
             m.addAttribute("komunikat", komunikat);
             m.addAttribute("status", status);
             return "register.jsp";
         }
       
        return "register.jsp";
    }
    
    private boolean logInCheck()
    {
        if(baza.checkLogin(login))
             {
                 status="Login poprawny ";
                 return true;
             }else{
                 status="Login niepoprawny (zajęty)";
                 return false;
             }
    }
}