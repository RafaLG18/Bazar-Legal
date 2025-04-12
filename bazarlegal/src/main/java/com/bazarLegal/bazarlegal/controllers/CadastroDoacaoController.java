package com.bazarLegal.bazarlegal.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bazarLegal.bazarlegal.model.entidades.Lote;
import com.bazarLegal.bazarlegal.model.repositorios.RepositorioGeral;

@Controller
@RequestMapping("/CadastroDoacao")
public class CadastroDoacaoController {
    
    @GetMapping
    public String principal(Model m) throws SQLException {
        
        m.addAttribute("lote", new Lote());
        m.addAttribute("fiscalizadores", RepositorioGeral.getCurrentInstance().readAllFiscalizadors());
        m.addAttribute("donatarios", RepositorioGeral.getCurrentInstance().readAllDonatarios());
        m.addAttribute("produtos", RepositorioGeral.getCurrentInstance().readAllProduto());
        return "cadastro/Doacao";
    }
    
    @PostMapping
    public String cadastro(@ModelAttribute("lote") Lote lote) throws SQLException {
        RepositorioGeral.getCurrentInstance().create(lote);
        return "redirect:/";
    }
}
