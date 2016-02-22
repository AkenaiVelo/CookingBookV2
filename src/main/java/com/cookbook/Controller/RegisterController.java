package com.cookbook.Controller;

import com.cookbook.DTO.KontoDTO;
import com.cookbook.Other.MD5Hash;
import com.cookbook.Service.KontoService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    
    String status="Niesprawdzono";
    String login,haslo;
    @Autowired
    KontoService baza;

    @RequestMapping(value = "/register")
    public String index(HttpServletRequest request,Model m) {
        String komunikat="";
         String button1 = request.getParameter("statusCheck");
         String button2 = request.getParameter("LogIn");
         login=request.getParameter("LoginField");
         haslo=request.getParameter("PasswordField");
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
                if(baza.registerNewAccount(new KontoDTO(login, MD5Hash.getmd5(haslo))))
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