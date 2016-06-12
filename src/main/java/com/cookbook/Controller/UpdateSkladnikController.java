package com.cookbook.Controller;

import com.cookbook.DAO.SkladnikiDAO;
import com.cookbook.DTO.SkladnikiDTO;
import com.cookbook.ENGINE.EngineSkladniki;
import com.cookbook.Service.SkladnikiService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpdateSkladnikController {
    
    @Autowired
    SkladnikiDAO skladnikiDAO; 
    @Autowired
    LayoutController layout;
    @Autowired
    SkladnikiService skladniki_service;
    
    @RequestMapping(value = "/updateSkladnik")
    public String index(HttpServletRequest request, Model m) {
        System.out.println("Update skladnik controller");
        String o=request.getParameter("co");
        String nazwa = request.getParameter("nazwa");
        String opis = request.getParameter("opis");
        String jednostka = request.getParameter("jednostka");
        String zdjecie="skladniki/"+nazwa+".jpg";
        System.out.println("Nazwa="+nazwa);
        EngineSkladniki e=new EngineSkladniki(nazwa, opis, zdjecie,jednostka);
        String old=request.getParameter("old");
        layout.addServices(m);
        m.addAttribute("skladnikiService", skladniki_service);
        SkladnikiDTO s = null;
        int co = 0;
        if(o!=null){
        if(o.matches("^-?\\d+$"))
        co = Integer.parseInt(o);
        }
        
        System.out.println("co="+co);
        if (co == 1)//dodajemy
        {
            if(skladnikiDAO.czyNazwaSkladnikaWolna(nazwa)==0)
            skladnikiDAO.addSkladnik(e);
            else
            skladnikiDAO.updateSkladnik(e, e.getNazwa());    
        } else if (co == 2)//edytujemy
        {
            skladnikiDAO.updateSkladnik(e, old);
        }

        return "skladniki";
    }
}
