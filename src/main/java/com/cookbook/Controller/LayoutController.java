package com.cookbook.Controller;

import com.cookbook.Service.KategoriaDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class LayoutController {
    @Autowired 
    private KategoriaDanService kategoriaDanService;
    
    public  void addServices(Model m) {
        m.addAttribute("kategoriaDanService", kategoriaDanService);
    } 
}