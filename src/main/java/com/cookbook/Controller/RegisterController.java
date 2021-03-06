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

    String status = "Niesprawdzono";
    String login, haslo, email;
    @Autowired
    KontoService baza;
    @Autowired
    private LayoutController layout;

    @RequestMapping(value = "/register")
    public String index(HttpServletRequest request, Model m) {
        System.out.println("Register controler");
        String komunikat = "";
        String button1 = request.getParameter("statusCheck");
        String button2 = request.getParameter("LogIn");
        login = request.getParameter("LoginField");
        haslo = request.getParameter("PasswordField");
        email = request.getParameter("Email");
        m.addAttribute("login", login);
        m.addAttribute("email", email);
        m.addAttribute("status", status);
        System.out.println("Login "+login+" \n email "+email);
        layout.addServices(m);
        if (button1 != null) {
            logInCheck();
            m.addAttribute("status", status);
            m.addAttribute("komunikat", komunikat);
            return "register";
        } else if (button2 != null) {
            if (logInCheck()) {
                if (emailCheck()) {
                    if (baza.registerNewAccount(new KontoDTO(login, MD5Hash.getmd5(haslo), email, 0))) {
                        komunikat = "Rejestracja udana. Mozesz terz dokonac logowania.";
                    } else {
                        komunikat = "Rejestracja nie udana. Spróbój ponownie póżniej.";
                    }
                }else{
                    komunikat="Email został juz wykorzystany.";
                }
            }else
            {
                komunikat="Login zajety.";
            }
            m.addAttribute("komunikat", komunikat);
            m.addAttribute("status", status);
            return "register";
        }

        return "register";
    }

    private boolean logInCheck() {
        if (baza.checkLogin(login)) {
            status = "Login poprawny ";
            return true;
        } else {
            status = "Login niepoprawny (zajęty)";
            return false;
        }
    }

    private boolean emailCheck() {
        return baza.isEmailValid(email);
    }
}
